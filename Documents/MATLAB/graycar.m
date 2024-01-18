I=imread('peppers.png');

x=ones(size(I,1),size(I,2));
for i=1:size(I,1)
    for j=1:size(I,2)
       r = I(i,j,1);
%        g = I(i,j,2);
%        b = I(i,j,3);
       x(i,j) = (r)/1;
     end
end
imshow(I);