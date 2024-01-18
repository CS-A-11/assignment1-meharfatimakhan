function [translateImg] = Translation(J,p,k)
%     p=100;
%     k=-100;
%     I=imread('peppers.png');
%     J = rgb2gray(I); %make it into 2D matrix
x = size(J,1);
y = size(J,2);
z = size(J,3);
translateImg=zeros(x,y,z);
%figure,imshow(J);
for i=1:1:x
    for j=1:1:y
        if (0<(i+p) && 0< (j+k) && (i+p)<x && (j+k)<y)
            r=i+p;
            c=j+k;
            translateImg(i,j,:)=J(r,c,:);
        end
    end
end
%figure,imshow(translateImg,[]);
translateImg = uint8(translateImg);

