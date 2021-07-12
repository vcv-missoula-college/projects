#! /bin/bash

# Installing required package for RFID card reader
sudo pip3 install mfrc522

GITFILE=.git
mkdir ~/projects
cd ~/projects
if test -e "$GITFILE"
then
	echo "$GITFILE exists. Pulling the latest version."
	git pull ~/projects
else
	echo "$GITFILE does not exist. Cloning the repository from github"
	git clone https://github.com/vcv-missoula-college/projects ~/projects
fi

chmod +x ~/projects/2021_gencyber_summer_camp/resources/day2/ciphor.py
sudo ln -s ~/projects/2021_gencyber_summer_camp/resources/day2/ciphor.py /usr/bin/ciphor.py
chmod +x ~/projects/2021_gencyber_summer_camp/resources/day5/maze.py
sudo ln -s ~/projects/2021_gencyber_summer_camp/resources/day5/maze.py /usr/bin/maze.py
# copy Wiring pictures to desktop
cp -r ~/projects/2021_gencyber_summer_camp/resources/wiring/ ~/Desktop

# install diceware
pip install diceware

# install testdisk
sudo apt install testdisk

# Deploying pacman ghosts
cp ~/projects/2021_gencyber_summer_camp/resources/day1/.pacman/g1 ~/Desktop/8linky.txt
cp ~/projects/2021_gencyber_summer_camp/resources/day1/.pacman/g2 ~/Desktop/PiNkY.txt
cp ~/projects/2021_gencyber_summer_camp/resources/day1/.pacman/g3 ~/Templates/1nky.txt
cp ~/projects/2021_gencyber_summer_camp/resources/day1/.pacman/g4 ~/Downloads/CLYDE.txt
cp ~/projects/2021_gencyber_summer_camp/resources/day1/.pacman/g5 ~/Documents/sp00ky.txt
cp ~/projects/2021_gencyber_summer_camp/resources/day1/.pacman/g6 ~/Documents/funky.txt
cp ~/projects/2021_gencyber_summer_camp/resources/day1/.pacman/g7 ~/Music/sue.txt


# Setting up scavenger hunt
echo Initiating scavanger.
cd ~/projects/2021_gencyber_summer_camp/resources/day1/scavenger-hunt
python2 generate_clues.py 42
