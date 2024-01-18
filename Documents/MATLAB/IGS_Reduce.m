function [ Arr ] = IGS_Reduce(A,glevel)
%glevel is level of reduction 8,16 etc
m=glevel;
if (mod(m,2) == 1)
    glevel=glevel+1;
end

disp(glevel);
S=size(A);
row=S(1);
col=S(2);
val_reduce=256/glevel;
for i=1:row
    for j=1:col
    random_val=randi([0,val_reduce],1,1);    
    A(i,j)=A(i,j)+random_val(1);
    end

end
Arr=GreyLevel_Reduce(A,glevel,1);