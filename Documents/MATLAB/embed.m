x0=0;
x1=1;
tolerance=1e-2;

for i=1:10
    x=x0;
    f=x.^3-7*x.^2+14*x-6;
    df=3*x.^2-14*x+14;
     if (df~=0)  
        x1=x-(f/df);
        disp(x1)
        x0=x1;
    else
        f0=x.^3-7*x.^2+14*x-6;
        x=x1;
        f1=x.^3-7*x.^2+14*x-6;
        x2=x1-(f1*(x1-x0))/(f1-f0);
        disp(x2)
        x0=x1;
        x1=x2;
        x=x2;
     end
    error=abs(x.^3-7*x.^2+14*x-6);
    
    if(error<tolerance)
        break;
    end
end

