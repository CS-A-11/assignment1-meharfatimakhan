function [ subtractedImg ] = Subtraction( J1,J2 )
% J1=imread('AT3_1m4_04.tif');
% J2=imread('AT3_1m4_08.tif');
% figure,imshow(J1);
% figure,imshow(J2);
x = size(J1,1);
y = size(J1,2);
z = size(J1,3);
threshold=50;
subtractedImg=zeros(x,y,z);
for i=1:1:x
    for j=1:1:y
            subtractedImg(i,j,:)=J1(i,j,:)-J2(i,j,:);
            if (subtractedImg(i,j,:) < 0)
                subtractedImg(i,j,:)=0;
            end
%             if (subtractedImg(i,j,:) >= threshold)
%                 subtractedImg(i,j,:)=1;
%             else
%                 subtractedImg(i,j,:)=0;
%             end
    end
end
subtractedImg= uint8(subtractedImg);
figure,imshow(subtractedImg,[]);

