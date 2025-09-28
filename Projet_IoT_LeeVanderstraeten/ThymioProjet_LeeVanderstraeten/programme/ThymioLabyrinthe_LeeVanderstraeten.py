speed = 0

@onevent
def prox():
    if prox_horizontal[2] < 3500 and prox_horizontal[1] < 3500 and prox_horizontal[3] < 3500: 
        rollForward()
    else:
        maximum = max(prox_horizontal[4], prox_horizontal[0])
        if prox_horizontal[4] == maximum: 
            turnLeft()
        elif prox_horizontal[0] == maximum:
            turnRight()
        else :
            rollBackforward()
            
def rollBackforward():
    global motor_left_target, motor_right_target
    motor_left_target = -speed
    motor_right_target = -speed
def rollForward():
    global motor_left_target, motor_right_target
    motor_left_target = speed
    motor_right_target = speed

def turnLeft():
    global motor_left_target, motor_right_target
    motor_left_target = -speed
    motor_right_target = speed
def turnRight():
    global motor_left_target, motor_right_target
    motor_left_target = speed
    motor_right_target = -speed
    
def max(val1 , val2):
    maximum = val1
    if val2 > val1:
       maximum = val2           
    return maximum

    
@onevent
def button_center():
    global speed
    speed = 0
    
@onevent
def button_forward():
    global speed
    speed = 500
