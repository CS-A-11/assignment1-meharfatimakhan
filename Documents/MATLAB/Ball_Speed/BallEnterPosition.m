function [ flag ] = BallEnterPosition(F)
flag=0;
trow=size(F,1);
count=trow;
count2=0;
%figure(), imshow(F);
for i=1:trow
  if F(i,size(F,2))==0
   count2=count2+1;
  end
    
end
%disp(count2);
%disp(count);
if count2==count
 flag=1;
end

end

