function [rotateTransImg] = TranslateRotate(J,angle,p,k)
% angle=90;
%I=imread('peppers.png');
x = size(J,1);
y = size(J,2);
z = size(J,3);
%J = rgb2gray(I); %make it into 2D matrix
rotateImg=zeros(x,y,z);
%figure,imshow(J);
medianR=ceil((x+1)/2);
medianC=ceil((y+1)/2);
for i=1:x
    for j=1:y  
        r=round(medianR +((i-medianR)*cosd(angle)-((j-medianC)*sind(angle))));
        c=round(medianC +((i-medianR)*sind(angle))-((j-medianC)*cosd(angle)));
        if (r>0  && c>0 && c<y && r<x)
            rotateImg(i,j,:) = J(r,c,:);
        end
    end
end

rotateTransImg=zeros(x,y,z);
for i=1:1:x
    for j=1:1:y
        if (0<(i+p) && 0< (j+k) && (i+p)<x && (j+k)<y)
            r=i+p;
            c=j+k;
            rotateTransImg(i,j,:)=rotateImg(r,c,:);
        end
    end
end

rotateTransImg = uint8(rotateTransImg);
%figure,imshow(rotateTransImg,[]);

