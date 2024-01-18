function [firstOrder] = convolution(I)
p=1;
k=1;
setk=k;
%I=imread('peppers.png');
x=size(I,1)-p;
y=size(I,2)-k;
J = rgb2gray(I); %make it into 2D matrix
res=zeros(2*x+1,2*y+1);
for i=2:2:2*x+1
    k=setk;
    for j=2:2:2*y+1  
        if (p<(size(I,1)+1) && k<(size(I,2)+1))
            res(i,j)=J(p,k);
            k=k+1;   
        end     
    end
    if (p<(size(I,1)+1))
     p=p+1;
    end
end
% imshow(res);

mask=[1/4 1/2 1/4;1/2 1 1/2;1/4 1/2 1/4];
firstOrder=res;
i=1;
while(i<2*x)
    j=1;
    while(j<2*y)
        dotProduct=(mask(1,1)*res(i,j)) + (mask(1,2)*res(i,j+1)) + (mask(1,3)*res(i,j+2)) + (mask(2,1)*res(i+1,j)) + (mask(2,2)*res(i+1,j+1)) + (mask(2,3)*res(i+1,j+2)) + (mask(3,1)*res(i+2,j)) + (mask(3,2)*res(i+2,j+1)) + (mask(3,3)*res(i+2,j+2));
        firstOrder(i+1,j+1)=ceil(dotProduct);
        j=j+1;
    end
    i=i+1;
end

figure,imshow(firstOrder,[]);
firstOrder = uint8(firstOrder);
