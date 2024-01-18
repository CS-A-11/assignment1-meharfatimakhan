function [zeroOrder] = ZeroOrder(I,p,k,zoomfactor,width,height)
% p=1;
% k=1;
% zoomfactor=1;
setk=k;
%I=imread('pogo.jpeg');
x=width-p;
y=height-k;

J = rgb2gray(I); %make it into 2D matrix
%figure,imshow(J);
resolution=zeros(2*x-1,2*y-1);
for i=1:2:2*x-1
    k=setk;
    for j=1:2:2*y-1
        if (p<(size(I,1)+1) && k<(size(I,2)+1))
            resolution(i,j)=J(p,k);
            k=k+1;   
        end     
    end
    if (p<(size(I,1)+1))
     p=p+1;
    end
end

zeroOrder=resolution;
for i=1:2:2*x-1
    j=1;
    for j=1:2:2*y-1
        if (i+1<2*x-1 && j+1<2*y-1)
            zeroOrder(i,j+1)=resolution(i,j);
            zeroOrder(i+1,j)=resolution(i,j);
            zeroOrder(i+1,j+1)=resolution(i,j);
        end
    end
end

p=1;
k=1;
zoomf=zeros(zoomfactor*(size(zeroOrder,1)-p),zoomfactor*(size(zeroOrder,2)-k));
for i=1:zoomfactor:size(zoomf,1)+1
    k=1;
    for j=1:zoomfactor:size(zoomf,2)+1
        if (p<size(zeroOrder,1)+1 && k<size(zeroOrder,2)+1)
            zoomf(i,j)=zeroOrder(p,k);
            k=k+1;   
        end   
    end
    if (p<size(zeroOrder,1)+1)
        p=p+1;
    end
end


zooming=zoomf;
p=1;
k=1;
for i=1:zoomfactor:size(zoomf,1)+1
    j=1;
    p=1;
    for j=1:zoomfactor:size(zoomf,2)+1
        p=1;
        if (i+1<size(zoomf,2)+1 && j+1<size(zoomf,2)+1)
            while(p<zoomfactor)
                zooming(i,j+p)=zoomf(i,j);
                zooming(i+p,j)=zoomf(i,j);
                zooming(i+p,j+p)=zoomf(i,j);
                k=1;
                while(k<zoomfactor)
                    zooming(i+p,j+k)=zoomf(i,j);
                    zooming(i+k,j+p)=zoomf(i,j);
                    k=k+1;
                end
                
                p=p+1;
            end
        end
    end
end

figure,imshow(zooming,[]);
zeroOrder = uint8(zooming);

  

