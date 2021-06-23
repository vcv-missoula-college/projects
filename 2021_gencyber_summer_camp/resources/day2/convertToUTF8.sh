for F in `find the_message_game -type f`
do 
	echo "Translating $F"
	iconv -f iso-8859-1 -t utf-8//transl $F > ${F}tr
	mv ${F}tr $F
done
