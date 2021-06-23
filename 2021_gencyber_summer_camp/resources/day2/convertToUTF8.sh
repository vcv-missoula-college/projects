for f in ${1}/*
do 
	echo "Translating $f"
	iconv -f iso-8859-1 -t utf-8//transl $f > ${f}tr
	mv ${f}tr $f
done
