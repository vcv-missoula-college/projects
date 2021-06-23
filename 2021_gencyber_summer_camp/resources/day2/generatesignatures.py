"""Randomize the filenames of every file in the target directory"""

import os
import sys
import ciphor


def main(targetdir):

    filenames = os.listdir(targetdir)

    filenames.sort()
    for filename in filenames:
        with open(targetdir + "/" + filename) as file:
            text = file.read()
            print("{}: {}".format(filename, ciphor.get_signature(text)))

if __name__ == "__main__":
    targetdir = "shuffler"
    if len(sys.argv) >= 2:
        targetdir = sys.argv[1]
    main(targetdir)
