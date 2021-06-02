from gpiozero import LED


pinlist = [LED(i) for i in range(2,28)]

try:
    for led in pinlist:
        led.blink(.2, .2)
    input("Press enter to stop")
finally:
    for led in pinlist:
        led.off()
        led.close()
