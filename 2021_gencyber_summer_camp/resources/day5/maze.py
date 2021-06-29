import gpiozero
from time import sleep

resetTime = 15 # blink for this many seconds before turning back on


motionSensorPresent = True
distanceSensorPresent = True

# set the GPIO pins that are used
button = gpiozero.Button(19)
led = gpiozero.LED(26)
if motionSensorPresent:
    pir = gpiozero.MotionSensor(13)
if distanceSensorPresent:
    dSensor = gpiozero.DistanceSensor(echo = 24, trigger = 23)
    dSensor.max_distance = 2 # the max reading for the distance sensor




systemActive = False

def isDistanceSensorTripped():
""" How to tell when the distanceSensor is triggered """
    return dSensor.distance < dSensor.max_distance

def motionTriggerEvent():
""" The even that is called when the motion sensor is activated.
    When the distance sensor is present, it needs to be triggered also in 
    order to trigger the alarm, otherwise it triggers the alarm by itself"""
    if distanceSensorPresent:
        if isDistanceSensorTripped():
            led.off()
    else:
        led.off()

def ignoreEvent():
""" A function that does nothing """
    pass

def main():
    button.when_pressed = reset
    reset()
    while True:
        sleep(.3)
        if not motionSensorPresent:
            if systemActive and isDistanceSensorTripped():
                led.off()

def reset():
""" Disables the alarm for a brief reset period, then arms it again """
    if motionSensorPresent:
        pir.when_activated = ignoreEvent
    global systemActive 
    systemActive = False
    led.blink(.3, .3)
    sleep(resetTime)
    if motionSensorPresent:
        pir.when_activated = motionTriggerEvent
    led.on()
    systemActive = True

if __name__ == "__main__":
    if not (motionSensorPresent or distanceSensorPresent):
        print("You must have either a motion sensor or distance sensor (or both)")
        exit()
    try:
        main()
    finally:
        led.close()
        button.close()
        if motionSensorPresent:
            pir.close()
        if distanceSensorPresent:
            dSensor.close()

