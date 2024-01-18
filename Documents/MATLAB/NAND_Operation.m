function [ Arr ] = NAND_Operation( A,B )
% A=imread('AT3_1m4_04.tif');
% B=imread('AT3_1m4_08.tif');
% figure,imshow(A);
% figure,imshow(B);
row=size(A,1);
col=size(A,2);
if (size(A,3)==1)
    rowSize=1;
end
if (size(A,3)==3)
    rowSize=3;
end
Arr=zeros(row,col,size(A,3));
for i=1:row
  for j=1:col
      b1=de2bi(A(i,j,:),8);
      b2=de2bi(B(i,j,:),8);
      for brow=1:rowSize
          for bcol=1:8
              if ((b1(brow,bcol) == 1 && b2(brow,bcol) == 1))
                  b3(brow,bcol) = 0;
              else
                  b3(brow,bcol) = 1;
              end
          end
      end
      
      Arr(i,j,:)=bi2de(b3);
  end

end
Arr=uint8(Arr);
figure,imshow(Arr,[]);


