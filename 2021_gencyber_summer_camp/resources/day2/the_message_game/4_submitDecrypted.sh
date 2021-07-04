#! /bin/bash

if [ $# -eq 2 ] 
then
	scp ./4_decrypted/* $2@$1:~/decrypted/
else
	echo "Usage: ./4_submitDecrypted.sh ip_address groupWithSide"
fi
