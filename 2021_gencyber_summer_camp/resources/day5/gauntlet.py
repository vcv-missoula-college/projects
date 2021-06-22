import gpiozero
import time


def main():
    button = gpiozero.Button(19)
    led = gpiozero.LED(26)
    pir = gpiozero.MotionSensor(13)

    button.when_pressed = led.on
    pir.when_activated = led.off

    led.on()

    try:
        while True:
            time.sleep(1)
    finally:
        led.close()
        pir.close()
        button.close()

if __name__ == "__main__":
    main()
