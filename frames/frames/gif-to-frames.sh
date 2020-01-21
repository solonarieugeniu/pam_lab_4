mkdir jpeg
mkdir jpg
mkdir png
mkdir bmp
magick convert Pacman.gif png/xx_%02d.png
magick convert Pacman.gif jpeg/xx_%02d.jpeg
magick convert Pacman.gif jpg/frame_%02d.jpg
magick convert Pacman.gif bmp/frame_%02d.bmp
