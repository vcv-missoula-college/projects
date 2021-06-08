import os

quarantine_dir = os.path.expanduser("~") + "/quarantine"
if not os.path.exists(quarantine_dir):
    print("Your quarantine directory does not yet exist\n" +
          "Navigate to your home directory (cd ~)\n" +
          "Make a quarantine directory (mkdir quarantine)\n" +
          "Then, you can start moving the ghosts there")
    quit()

filenames = os.listdir(quarantine_dir)


treasure = {"cherry":100,
            "strawberry": 300,
            "peach": 500,
            "apple": 700,
            "grapes": 1000,
            "galaxian boss": 2000,
            "bell": 3000,
            "key": 5000}

totalscore = 0
for filename in filenames:
    with open(quarantine_dir + "/" + filename) as file:
        lines = file.readlines()
        for line in lines:
            totalscore += treasure.get(line.strip(), 0)
print("Your total score is {} points".format(totalscore))

if totalscore == 0:
    print("Place your ghosts in the quarantine directory to count your treasure")
elif 0 < totalscore <= 10000:
    print("This is a good start - there are still more ghosts out there")
elif 10000< totalscore <= 20000:
    print("Keep going, there's still more")
elif 20000 < totalscore < 28000:
    print("You've almost caught them all!")
elif totalscore == 28000:
    print("Congratulations! You've caught them all and achieved the highest possible score!")
elif totalscore > 28000:
    print("Somehow you got a greater score than is possible. Perhaps you have multiple copies of some of your ghosts")
