import RPi.GPIO as GPIO
from mfrc522 import SimpleMFRC522

mfrc = SimpleMFRC522()
userText = input("Enter a string to store: ")
print("Ok, now tap your RFID card to write the data")
try:
    mfrc.write(userText)
    print("The data has been written, tap again to read the data.")
    id, text = mfrc.read()
    print("ID = {}".format(id))
    print("text = {}".format(text))
finally:
    GPIO.cleanup()

