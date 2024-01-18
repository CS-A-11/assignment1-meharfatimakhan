I = imread('aveb.jpg');
figure, imshow(I);
I=rgb2gray(I);
for i=1:1000
   I = medfilt2(I);
end
figure, imshow(I);