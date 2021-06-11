#! /bin/bash

GITFILE=~/projects/.git
cd ~
if test -f "$GITFILE"; then
	echo "$GITFILE exists. Pulling the latest version."
	git pull ~/projects
else
	echo "$GITFILE does not exist. Cloning the repository from github"
	git clone https://github.com/vcv-missoula-college/projects ~/projects
fi

# Deploying pacman ghosts
cp ~/projects/2021_gencyber_summer_camp/resources/day1/pman/g1 ~/Desktop/8linky.txt
cp ~/projects/2021_gencyber_summer_camp/resources/day1/pman/g2 ~/Desktop/PiNkY.txt
cp ~/projects/2021_gencyber_summer_camp/resources/day1/pman/g3 ~/Templates/1nky.txt
cp ~/projects/2021_gencyber_summer_camp/resources/day1/pman/g4 ~/python_games/CLYDE.txt
cp ~/projects/2021_gencyber_summer_camp/resources/day1/pman/g5 ~/Documents/sp00ky.txt
cp ~/projects/2021_gencyber_summer_camp/resources/day1/pman/g6 ~/Documents/funky.txt
cp ~/projects/2021_gencyber_summer_camp/resources/day1/pman/g7 ~/Music/sue.txt

clear

# Setting up scavenger hunt
echo Initiating scavanger.
cd ~/projects/2021_gencyber_summer_camp/resources/day1/scavenger-hunt
python2 generate_clues.py
python2 ~/projects/2021_gencyber_summer_camp/resources/day1/scavenger-hunt/generate_clues.py 42
