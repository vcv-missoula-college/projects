import os
import random
import shutil
import string

teamNumbers = list(range(1, 7))
sideNames = ['a', 'b']


def submissionDirectory(teamNumber, sideName):
    return os.path.join(
        os.getcwd(),
        'g{}{}-round3-submission'.format(teamNumber, sideName)
    )

def assignmentDirectory(teamNumber, sideName):
    return os.path.join(
        os.getcwd(),
        'g{}{}-round4-assignment'.format(teamNumber, sideName)
    )

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


# start by creating assignment directories
for teamNumber in teamNumbers:
    for sideName in sideNames:
        dirName = assignmentDirectory(teamNumber, sideName)
        if not os.path.exists(dirName):
            os.mkdir(dirName)


# copy all the tampered files into the assignment directory
for teamNumber in teamNumbers:
    for sideName in sideNames:
        otherTeamNumbers = teamNumbers.copy()
        otherTeamNumbers.remove(teamNumber)

        for otherTeamNumber in otherTeamNumbers:
            dirName = os.path.join(
                submissionDirectory(teamNumber, sideName),
                'g{}{}'.format(otherTeamNumber, sideName)
            )
            submittedFiles = os.listdir(dirName)
            if(len(submittedFiles) >= 1):
                copyWithRandomFilename(
                    os.path.join(
                        dirName, submittedFiles[random.randint(0, len(submittedFiles) - 1)]
                    ),
                    os.path.join(
                        os.getcwd(),
                        'g{}{}-round4-assignment'.format(otherTeamNumber, sideName)
                    )
                )

# now copy the original file into the assignment directory
for teamNumber in teamNumbers:
    for sideName in sideNames:
        otherSideName = sideNames[sideNames.index(sideName) - 1]
        originalMessageDirectory = os.path.join(
            os.getcwd(),
            'g{}{}-round2-submission'.format(teamNumber, otherSideName)
        )
        originalFiles = os.listdir(originalMessageDirectory)
        for fileName in originalFiles:
            copyWithRandomFilename(
                os.path.join(originalMessageDirectory, fileName),
                'g{}{}-round4-assignment'.format(teamNumber, sideName)
            )

