import lcd_i2c
import time


line1 = "User String 1"
line2 = "User String 2asdfasdf"
scrollDelay = 1      # 1 second per refresh

# Padding the strings
stringLength = max(len(line1), len(line2))
if(stringLength > 16):
    stringLength += 8   #add some additional spaces to either side

line1 = line1.center(stringLength)
line2 = line2.center(stringLength)

print("Press CTRL+c to quit")
try:
    lcd_i2c.lcd_init()
    i = 0
    while True:
        if(stringLength <= 16):
            lcd_i2c.lcd_string(line1, lcd_i2c.LCD_LINE_1)
            lcd_i2c.lcd_string(line2, lcd_i2c.LCD_LINE_2)
        else:
            lcd_i2c.lcd_string(line1[i:i+16], lcd_i2c.LCD_LINE_1)
            lcd_i2c.lcd_string(line2[i:i+16], lcd_i2c.LCD_LINE_2)
            if i+16 >= stringLength:
                i = 0
            else:
                i += 1
        time.sleep(scrollDelay)
finally:
    print("Cleaning up...")
    lcd_i2c.lcd_byte(0x01, lcd_i2c.LCD_CMD)
