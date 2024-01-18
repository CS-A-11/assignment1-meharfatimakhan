function [ flag] = CheckBallFirstEnter(F)

end_col=size(F,2);
flag=0;
trow=size(F,1);

for i=1:trow
  if F(i,end_col)==1
   flag=1;
   break;
  end
    
end

end




