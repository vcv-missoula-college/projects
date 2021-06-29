import random
import os
import string
import sys
import shutil

numTeams = 6
sideNames = ('a', 'b')

sourceDirectories = {}
teamNumbers = list(range(1, numTeams + 1))
teamSides = []
for sideName in sideNames:
    for teamNumber in teamNumbers:
        teamSides.append('{}{}'.format(teamNumber, sideName))

for teamSide in teamSides:
    sourceDirectories[teamSide] = os.path.join(
        os.getcwd(),
        "g{}-round2-submission".format(teamSide)
    )


# create a random string 10 characters long
def randomFileName():
    return ''.join(random.choice(string.ascii_letters) for _ in range(10))


# copies a file to the target directory with a random file name
def copyWithRandomFilename(sourceFile, targetDir):
    targetFileName = os.path.join(targetDir, randomFileName())

    # ensure the filename doesn't exist
    while os.path.exists(targetFileName):
        targetFileName = os.path.join(targetDir, randomFileName())
    print("copying {} to {}".format(sourceFile, targetFileName))
    shutil.copy(sourceFile, targetFileName)


def targetDirectoryName(teamSide):
    return 'g{}-round3-assignment'.format(teamSide)


print(teamSides)
# create target directories
for teamSide in teamSides:
    targetDirectory = os.path.join(os.getcwd(), targetDirectoryName(teamSide))
    if not os.path.exists(targetDirectory):
        os.mkdir(targetDirectory)

for currentTeamNum in teamNumbers:
    # copy the files to the other teams until we run out of files
    currentTeamIndex = teamNumbers.index(currentTeamNum)
    otherTeams = teamNumbers[currentTeamIndex + 1:] + teamNumbers[:currentTeamIndex] 

    # print("for teamSide {}, otherTeams is {}".format(teamSide, otherTeams))

    for sideName in sideNames:
        otherTeamSides = []
        for otherTeamNumber in otherTeams:
            otherTeamSides.append('{}{}'.format(otherTeamNumber, sideName))

        teamSide = '{}{}'.format(currentTeamNum, sideName)
        # print("For side {}, the 'other teams' are: {}, sourceDir: {}".format(
        #     teamSide, otherTeamSides, sourceDirectories[teamSide]))
        filenames = sorted(os.listdir(sourceDirectories[teamSide]))
        # print(filenames)
        print("Distributing files for side {}".format(teamSide))
        for i in range(len(filenames)):
            targetSide = otherTeamSides[i % len(otherTeamSides)]
            print("{} goes to {}".format(filenames[i], targetSide))
            
            targetDirectory = os.path.join(
                os.getcwd(),
                targetDirectoryName(targetSide),
                "g" + str(teamSide)
            )
            if not os.path.exists(targetDirectory):
                os.mkdir(targetDirectory)
            
            copyWithRandomFilename(
                os.path.join(os.getcwd(), sourceDirectories[teamSide], filenames[i]),
                targetDirectory
            )




