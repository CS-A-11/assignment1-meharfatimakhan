function [ Arr] = NOT_Operation( A )
% A=imread('cameraman.tif');
Arr=zeros(size(A,1),size(A,2),size(A,3));

if (size(A,3)==1)
    rowSize=1;
end
if (size(A,3)==3)
    rowSize=3;
end

for i=1:size(A,1)
    for j=1:size(A,2)
        binary=de2bi(A(i,j,:),8);
        for brow=1:rowSize
            for bcol=1:8
                if (binary(brow,bcol) == 1)
                  binary(brow,bcol) = 0;
                else
                  binary(brow,bcol) = 1;
                end
            end
        end
        Arr(i,j,:)=bi2de(binary);
    end
end
Arr=uint8(Arr);
figure,imshow(Arr,[]);

