"""Randomize the filenames of every file in the target directory"""

import os
import random
import string
import sys


def main(targetdir):

    filenames = os.listdir(targetdir)

    for filename in filenames:
        randomstring = ''.join(random.choice(string.ascii_letters) for _ in range(10))
        os.rename(targetdir + "/" + filename, targetdir + "/" + randomstring)


if __name__ == "__main__":
    targetdir = "shuffler"
    if len(sys.argv) >= 2:
        targetdir = sys.argv[1]
    main(targetdir)
