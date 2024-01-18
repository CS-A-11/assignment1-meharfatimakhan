function [interpolate2] = LinearInterpolation(I,sRow,sCol,width,height,kFactor)
% sRow=1;
% sCol=1;
% I=imread('peppers.png');
x=width-sRow;
% x=size(I,1);
% y=size(I,2);
y=height-sCol;
% z = size(I,3);
I=rgb2gray(I);
% kfactor=3;
kfactor=kFactor;
interpolate=zeros(x,y);
j=1;i=1;
while(j<y)
    i=1;
     while (i<x)
        if (i+1<size(I,1) && j<size(I,2))
            interpolate(i,j)=I(i,j);
            startIndex=i;
            val = abs(I(i,j) - I(i+1,j));
            factorr = ceil(val/kfactor); 
            valueCount = kfactor - 1;
            p=1;
            while(valueCount >= p) 
                i=i+1;
                if (i<size(I,1))
                    interpolate(i,j) = I(startIndex,j) + (p*factorr); %disp(i); disp(interpolate(i,j));
                end
                p=p+1;
            end
        end
        i=i+1;
     end
     j=j+1;
end
interpolate2=interpolate;
while(i<x)
    while(j<y)
        
        if (j+1<size(I,2) && i<size(I,1))
            interpolate2(i,j)=interpolate(i,j);
            startIndex=j;
            val = abs(interpolate(i,j) - interpolate(i,j+1));
            factorr = ceil(val/kfactor); 
            valueCount = kfactor - 1;
            p=1;
            while(valueCount >= p)
                j=j+1;
                if (j<size(I,2))
                    interpolate2(i,j) = interpolate(i,startIndex) + (p*factorr);
                    p=p+1;
                end
            end
        end
        j=j+1;
    end
    i=i+1;
end


interpolate2 = uint8(interpolate2);
figure,imshow(interpolate2,[]);

