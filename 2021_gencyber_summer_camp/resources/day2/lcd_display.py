import lcd_i2c
import time

try:
    lcd_i2c.lcd_init()
    while True:
        lcd_i2c.lcd_screen("User String 1", lcd_i2c.LCD_LINE_1)
        lcd_i2c.lcd_screen("User String 2", lcd_i2c.LCD_LINE_2)
        time.sleep(1)
finally:
    lcd_i2c.lcd_byte(0x01, lcd_i2c.LCD_CMD)
