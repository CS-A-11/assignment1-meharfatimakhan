function [rotateImg] = Rotatation(J,angle)
%I=imread('peppers.png');
x = size(J,1);
y = size(J,2);
z = size(J,3);
% J = rgb2gray(I); %make it into 2D matrix
rotateImg=zeros(size(J));
%figure,imshow(I);
medianR=ceil((x+1)/2);
medianC=ceil((y+1)/2);
for i=1:x
    for j=1:y  
        r = round(medianR +( (i-medianR)*cosd(angle)- ((j-medianC)*sind(angle))));
        c = round(medianC +((i-medianR)*sind(angle))+((j-medianC)*cosd(angle)));
        if (r>0  && c>0 && c<y && r<x)
            rotateImg(i,j,:)=J(r,c,:);
        end
    end
end

rotateImg = uint8(rotateImg);
%figure,imshow(rotateImg);

