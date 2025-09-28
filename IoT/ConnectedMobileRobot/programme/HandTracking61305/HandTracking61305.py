from cvzone.HandTrackingModule import HandDetector
import cv2

# Activates the camera by default.
cap = cv2.VideoCapture(0)

# Detector is the object that recognises the structure of a hand in an image or video stream.
detector = HandDetector(staticMode=False,
                        maxHands=1, # Determines the number of fingers to be detected.
                        modelComplexity=1,
                        detectionCon=0.5,
                        minTrackCon=0.5)

while True:
    success, img = cap.read()
    hands, img = detector.findHands(img, draw=True, flipType=True)

    # Variable that stores the position of the hand.
    handPosition = "incorrect movement"

    if hands:
        hand1 = hands[0]
        lmList1 = hand1["lmList"]
        bbox1 = hand1["bbox"]

        # Variable that stores in an array of integers which finger is up or down, zero for down 1 for up.
        fingers1 = detector.fingersUp(hand1)

        # Creation of a variable for the state of each finger.
        thumb = fingers1[0]
        index = fingers1[1]
        middle = fingers1[2]
        ring = fingers1[3]
        oricular = fingers1[4]

        # Variable which has the spatial coordinates of the tip of the index.
        tipOfIndexFinger = lmList1[8][0:2]
        # Variable which has the spatial coordinates of the tip of the middle.
        tipOfMiddleFinger = lmList1[12][0:2]

        # Used to measure the distance between the tip of the index and middle fingers.
        length, info, img = detector.findDistance(tipOfIndexFinger, tipOfMiddleFinger, img, color=(255, 0, 0),
                                                  scale=10)

        # Count the number of fingers raised.
        numberOfFingers = fingers1.count(1)

        # Lines 49 to 65 determine the position of the hand with the number of fingers raised,
        # the distance between certain fingers and which finger is raised.
        if numberOfFingers == 5:
            handPosition = "PAUSE"

        elif numberOfFingers == 2 and index == 1 and middle == 1:
            handPosition = "UP" if length < 50 else "DOWN"

        elif numberOfFingers == 1:
            if oricular == 1:
                handPosition = "RIGHT"
            elif thumb == 1:
                handPosition = "LEFT"

        elif numberOfFingers == 3 and ring == 0:
            if oricular == 0:
                handPosition = "UL" if length < 50 else "DL"
            else:
                handPosition = "UR" if length < 50 else "DR"

        # Writes the position of the hand on the screen.
        cv2.putText(img, ": " + handPosition, (bbox1[0] + 70, bbox1[1] - 30), cv2.FONT_HERSHEY_PLAIN,
                    2, (255, 0, 255), 2)

    # Writes the hand position to a file.
    with open('data.txt', 'r') as fichier:
        contenu_actuel = fichier.readlines()
    with open('data.txt', 'w') as fichier:
        fichier.write(handPosition + "\n")
        for ligne in contenu_actuel:
            fichier.write(ligne)

    # Opens a window with the camera video.
    cv2.imshow("Image", img)

    # Press the 'q' key to exit the programme.
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break
