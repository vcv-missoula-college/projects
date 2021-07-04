#! /bin/bash

if [ $# -eq 2 ] 
then
	mkdir 3_shared
	mkdir 4_decrypted
	scp $2@$1:/home/shared/* ./3_shared/
else
	echo "Usage: ./3_getEncrypted.sh ip_address groupWithSide"
fi
