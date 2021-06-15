import RPi.GPIO as GPIO
from mfrc522 import SimpleMFRC522
import lcd_i2c
import csv
import time


RED = 21
YELLOW = 20
GREEN = 16


def logAccess(id, status):
    with open ("log.txt", 'a') as logfile:
        logfile.write("{} id={}, {}\n".format(time.strftime("%Y-%m-%d %H:%m:%S", time.gmtime()), id, status))

with open ("validcards.txt", 'r')  as cardfile:
    filelines = cardfile.readlines()
    validcards = []
    for line in filelines:
        try:
            validcards.append(int(line))
        except:
            print("Error in validcards.txt, couldn't convert '{}'".format(line[:-1]))

print(validcards)
    
GPIO.setmode(GPIO.BCM)
GPIO.setup(RED, GPIO.OUT)
GPIO.output(RED, 0)
GPIO.setup(YELLOW, GPIO.OUT)
GPIO.output(YELLOW, 0)
GPIO.setup(GREEN, GPIO.OUT)
GPIO.output(GREEN, 0)


reader = SimpleMFRC522()
try:
    lcd_i2c.lcd_init()
    while True:
        GPIO.output(RED, 0)
        GPIO.output(GREEN, 0)
        GPIO.output(YELLOW, 1)
        lcd_i2c.lcd_string(" Please present", lcd_i2c.LCD_LINE_1)
        lcd_i2c.lcd_string('    RFID card', lcd_i2c.LCD_LINE_2)
        id, text = reader.read()
        print("card swiped, id=", type(id) ,id)
        if id in validcards:
            GPIO.output(YELLOW, 0)
            GPIO.output(GREEN, 1)
            logAccess(id, "Access Granted")
            lcd_i2c.lcd_string("Access Granted", lcd_i2c.LCD_LINE_1)
            lcd_i2c.lcd_string(str(id), lcd_i2c.LCD_LINE_2)
            time.sleep(5)
        else:
            GPIO.output(YELLOW, 0)
            GPIO.output(RED, 1)
            logAccess(id, "Access Denied")
            lcd_i2c.lcd_string("Access Denied", lcd_i2c.LCD_LINE_1)
            lcd_i2c.lcd_string(str(id), lcd_i2c.LCD_LINE_2)
            time.sleep(5)


            
finally:
    print("Cleaning up...")
    GPIO.cleanup()
    lcd_i2c.lcd_byte(0x01, lcd_i2c.LCD_CMD)
