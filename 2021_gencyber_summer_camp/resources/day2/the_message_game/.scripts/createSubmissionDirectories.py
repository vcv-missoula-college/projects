import sys
import os

numGroups = 6
sideNames = ['a', 'b']

submissionRounds = [2, 3, 4]


dummyData = 'dummy' in sys.argv

for groupNum in range(1, numGroups + 1):
    for sideName in sideNames:
        for submissionRound in submissionRounds:
            dirName = os.path.join(os.getcwd(), 'g{}{}-round{}-submission'.format(
                groupNum,
                sideName,
                submissionRound
            ))
            if not os.path.exists(dirName):
                os.mkdir(dirName)

            if submissionRound == 2:
                assignmentName = os.path.join(os.getcwd(), 'g{}{}-round{}-assignment'.format(
                    groupNum,
                    sideName,
                    submissionRound
                ))
                if not os.path.exists(assignmentName):
                    os.mkdir(assignmentName)

            if dummyData and (submissionRound == 2):
                for i in range(1, numGroups):
                    filename = os.path.join(
                        dirName,
                        'g{}{}-file{}'.format(groupNum, sideName, i)
                    )
                    with open(filename, 'w') as file:
                        file.write("nontampered message {} from g{}{}".format(i, groupNum, sideName))
                    filename = os.path.join(
                        assignmentName,
                        'g{}{}-file{}'.format(groupNum, sideName, i)
                    )
                    with open(filename, 'w') as file:
                        file.write("nontampered message {} from g{}{}".format(i, groupNum, sideName))

            if submissionRound == 3:
                # create directories for each group
                for senderGroupNum in range(1, numGroups + 1):
                    if senderGroupNum != groupNum:
                        subDirectory = 'g{}{}'.format(senderGroupNum, sideName)
                        senderDirName = os.path.join(dirName, subDirectory)
                        if not os.path.exists(senderDirName):
                            os.mkdir(senderDirName)
                        if dummyData:
                            filename = os.path.join(
                                dirName,
                                subDirectory,
                                'g{}{}-file{}'.format(groupNum, sideName, i)
                            )
                            with open(filename, 'w') as file:
                                file.write("tampered message from g{}{} to g{}{}".format(groupNum, sideName, senderGroupNum, sideName))
            if submissionRound == 4:
                # create directories for each group
                for senderGroupNum in range(1, numGroups + 1):
                    if senderGroupNum != groupNum:
                        senderSide = sideName
                    else:
                        senderSide = sideNames[sideNames.index(sideName) - 1]

                    senderDirName = os.path.join(dirName, 'g{}{}'
                                                 .format(senderGroupNum, senderSide))
                    if not os.path.exists(senderDirName):
                        os.mkdir(senderDirName)
