#! /bin/bash

if [ $# -eq 2 ] 
then
	scp ./2_submission/* $2@$1:~/submission
else
	echo "Usage: ./2_submitEncrypted.sh ip_address groupWithSide"
fi
