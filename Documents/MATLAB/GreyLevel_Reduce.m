function [ Arr ] = GreyLevel_Reduce( A,glevel,position)
% A=imread('puma.jpg');
% glevel=3;
% position=1;
%position=1 refers to begining that is low level
%position=2 refers to middle that is avg level
%position=3 refers to end that is high level

m=glevel;
if (mod(m,2) == 1)
    glevel=glevel+1;
end

S=size(A);
row=S(1);
col=S(2);
Arr=zeros(row,col);
val_reduce=256/glevel;
val_miduse=val_reduce/2;
val_reduce=log2(val_reduce);
mask_arr=de2bi(255,8);
b3=de2bi(255,8);
if position==1
    
    for k=1:val_reduce
    mask_arr(k)=0;
    end
    
end
if position==2
   for k=1:val_reduce
    mask_arr(k)=0;
    end
    decimal_val=bi2de(mask_arr);
    decimal_val=255-decimal_val;
    mask_arr=de2bi(decimal_val,8);
    
end
if position==3
    for k=1:val_reduce
    mask_arr(k)=0;
    end
    decimal_val=bi2de(mask_arr);
    decimal_val=255-decimal_val;
    mask_arr=de2bi(decimal_val,8);
    
end



for i=1:row
  for j=1:col      
  b1=de2bi(A(i,j),8);
  b1=double(b1);
  if position==1
  for k=1:8
  if b1(k)==1 && mask_arr(k)==1
      b3(k)=1;
  end
  if b1(k)==1 && mask_arr(k)==0
      b3(k)=0;
  end
  if b1(k)==0 && mask_arr(k)==1
      b3(k)=0;
  end
  if b1(k)==0 && mask_arr(k)==0
      b3(k)=0;
  end
  %b3=bitand(b1,mask_arr);
  end  
  end
  if position==2
  
    for k=1:8
  if b1(k)==1 && mask_arr(k)==1
      b3(k)=1;
  end
  if b1(k)==1 && mask_arr(k)==0
      b3(k)=1;
  end
  if b1(k)==0 && mask_arr(k)==1
      b3(k)=1;
  end
  if b1(k)==0 && mask_arr(k)==0
      b3(k)=0;
  end
  
   end
   ans_val=bi2de(b3);
   ans_val=ans_val-val_miduse;
   b3=de2bi(ans_val);
  end   
  if position==3
  for k=1:8
  if b1(k)==1 && mask_arr(k)==1
      b3(k)=1;
  end
  if b1(k)==1 && mask_arr(k)==0
      b3(k)=1;
  end
  if b1(k)==0 && mask_arr(k)==1
      b3(k)=1;
  end
  if b1(k)==0 && mask_arr(k)==0
      b3(k)=0;
  end
  
  end
  %b3=bitor(b1,mask_arr);
  end
  
  Arr(i,j)=bi2de(b3);
  end
end

%Arr=uint8(Arr);
figure,imshow(Arr,[]);
image(Arr);

%M=mask_arr;
