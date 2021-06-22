import RPi.GPIO as GPIO
from mfrc522 import SimpleMFRC522
import lcd_i2c

reader = SimpleMFRC522()
try:
    lcd_i2c.lcd_init()
    while True:
        id, text = reader.read()
        print("Card read, see LCD")
        #print("id=",id)
        #print("text=",text)
        lcd_i2c.lcd_string(str(id), lcd_i2c.LCD_LINE_1)
        lcd_i2c.lcd_string(str(text), lcd_i2c.LCD_LINE_2)
finally:
    print("Cleaning up...")
    GPIO.cleanup()
    lcd_i2c.lcd_byte(0x01, lcd_i2c.LCD_CMD)
