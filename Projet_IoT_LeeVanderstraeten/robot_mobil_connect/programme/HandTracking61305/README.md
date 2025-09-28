# HandTracking61305

This program detects a hand using your default camera and stores the various hand positions in a 'data.txt' file.

## Table des matières

- [Description](#description)
- [Installation](#installation)
- [Utilisation](#utilisation)
- [Contact](#contact)

## Description

This programme was created as part of the IoT4, connected objects, course at HE2B-ESI. 

This program captures the video
stream from the device's default camera and, in each frame, detects the important points of the hand if there is one in
the image.

The important points of the hand will be treated in such a way as to simplify them into an array of five 
integers. This table of five integers represents the five fingers of the hand. A finger can have two possible states,
open or closed. These two states are represented in the array by the values 1 or 0. 

Using this table and these two states
we can deduce the position of the hand at an instant T and save the position in the 'data.txt' file.

## Installation

1. You must have version py3.8.


2. You need to install the cv2 and cvzone modules. In this case, the version of cvzone is 1.6.1.
    ```shell 
   pip install cvzone
   ```
## Utilisation
Once you have installed python and the necessary modules, you can go to a development environment to launch the program.
to launch the program.

To quit the program, simply press the stop button on the development environment or press the 'q' key on your keyboard. 
or press the 'q' key on your keyboard.
## Contact
If you have any questions, please contact me at 61305@etu.he2b.be.

