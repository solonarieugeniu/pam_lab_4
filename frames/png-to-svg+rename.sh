ext=.png
cd frames/png
rm -r ../../svg-converted/$ext
mkdir ../../svg-converted/$ext
for file in *$ext
do
	echo Processing file $file ...
	file_renamed=`basename $file $ext`
	file=`basename $file $ext`
	magick convert $file$ext $file_renamed.pnm
	potrace -s -o ../../svg-converted2/$ext/$file_renamed.svg $file_renamed.pnm
	rm $file_renamed.pnm
	#magick convert $file svg-converted/${file/_delay-0.05s$(ext)/.svg};
	#read -n1 -r -p "Press any key to continue..." key
done
