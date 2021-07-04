#! /bin/bash

if [ $# -eq 2 ] 
then
	mkdir 1_original
	mkdir 2_submission
	scp $2@$1:~/original/* ./1_original/
else
	echo "Usage: ./1_getOriginal.sh ip_address groupWithSide"
fi
