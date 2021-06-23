import gpiozero
import time


resetTime = 15

button = gpiozero.Button(19)
led = gpiozero.LED(26)
pir = gpiozero.MotionSensor(13)

def main():
    button.when_pressed = reset
    reset()
    try:
        while True:
            time.sleep(1)
    finally:
        led.close()
        pir.close()
        button.close()

def blinkfast():
    led.blink(.1,.1)

def reset():
    pir.when_activated = None
    led.blink(.3, .3)
    time.sleep(resetTime)
    pir.when_activated = led.off
    led.on()

if __name__ == "__main__":
    main()

