from gpiozero import DistanceSensor
from time import sleep

dSensor = DistanceSensor(echo=24, trigger=23)
try:
    while True:
        print(dSensor.distance)
        sleep(.5)
finally:
    dSensor.close()

