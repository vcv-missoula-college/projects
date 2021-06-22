import gpiozero
import time

led = gpiozero.LED(26)
button = gpiozero.Button(19)
pir = gpiozero.MotionSensor(13)


pir.when_activated = led.on
pir.when_deactivated = led.off

try:
    while True:
        time.sleep(1)
finally:
    led.close()
    button.close()
    pir.close()
