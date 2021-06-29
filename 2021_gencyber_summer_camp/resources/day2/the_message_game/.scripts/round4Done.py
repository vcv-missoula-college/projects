import os
import ciphor
from pprint import pprint

teamNumbers = list(range(1, 7))
sideNames = ['a', 'b']
signaturesByTeamSide = {}
tamperedSigsByTeamSide = {}

# get signatures of non-tampered files
# for teamSide 1a, this means looking at round 2 submissions from teamSide 1b
for teamNumber in teamNumbers:
    for sideName in sideNames:
        otherSide = sideNames[sideNames.index(sideName) - 1]
        otherTeamSide = '{}{}'.format(teamNumber, otherSide)
        signaturesByTeamSide[otherTeamSide] = []
        originalDir = os.path.join(
            os.getcwd(),
            'g{}{}-round2-submission'.format(teamNumber, sideName)
        )
        originalFiles = os.listdir(originalDir)
        for fileName in originalFiles:
            with open(os.path.join(originalDir, fileName), 'r') as fd:
                contents = fd.read()
            signaturesByTeamSide[otherTeamSide].append(ciphor.get_signature(contents))
print("original signatures")
pprint(signaturesByTeamSide)

# get signatures of tampered files
# for teamSide 1a, this means looking at round3 submissions to them from 2a, 3a, 4a, 5a, and 6a
# also, we should verify that the signatures aren't just the original file
for teamNumber in teamNumbers:
    teamIndex = teamNumbers.index(teamNumber)
    otherTeamNumbers = teamNumbers[:teamIndex] + teamNumbers[teamIndex + 1:]
    for sideName in sideNames:
        teamSide = '{}{}'.format(teamNumber, sideName)
print("tampered signatures")
pprint(tamperedSigsByTeamSide)

