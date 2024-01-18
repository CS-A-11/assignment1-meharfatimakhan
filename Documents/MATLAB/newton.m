
% x0=0;
% x1=1;
% tol=1e-2;
% 
% for i=1:10
%     x=x0;
%     f=x.^3-7*x.^2+14*x-6;
%     x=x1;
%     f1=x.^3-7*x.^2+14*x-6;
%     
%     xn=x1-(((f1)*(x1-x0))/(f1-f));
%     disp(xn)
%     x0=x1;
%     x1=xn;
%     
%     x=xn;
%     error=abs(x.^3-7*x.^2+14*x-6);
%    
%     if(error<tol)                                                                                                                                                                                                                                                                                             
%          break;
%      end
%  end

x0=0;
x=x0;

xold=x;
tol=1e-2;


for i=1:10
    f=x.^3-7*x.^2+14*x-6;
    df=3*x.^2-14*x+14;
    
    x=x-(f/df);
    disp(x)
    error=abs(x-xold)/abs(x);
    xold=x;
    if(error<tol)                                                                                                                                                                                                                                                                                             
        break;
    end
end