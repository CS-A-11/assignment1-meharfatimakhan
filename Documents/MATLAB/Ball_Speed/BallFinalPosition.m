function [ flag] = BallFinalPosition(F)


flag=0;
trow=size(F,1);

for i=1:trow
  if F(i,1)==1
   flag=1;
   break;
  end
    
end



end

