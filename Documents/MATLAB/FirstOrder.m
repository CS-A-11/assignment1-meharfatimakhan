function [firstOrder] = FirstOrder(I,p,k,zoomfactor,width,height)
setk=k;
%I=imread('peppers.png');
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

firstOrder=resolution;
for i=1:2:2*x-1
    j=1;
    for j=1:2:2*y-1
        if (i+2<2*x-1 && j+2<2*y-1)
            firstOrder(i,j+1)=(resolution(i,j)+resolution(i,j+2))/2;
            firstOrder(i+1,j)=(resolution(i,j)+resolution(i+2,j))/2;
            firstOrder(i+1,j+1)=(resolution(i,j)+resolution(i+2,j+2))/2;
        end
    end
end

startZoom=2;
flag=0;
if (zoomfactor>2)
    flag=1;
    while(startZoom<zoomfactor)
        zoomedImg=zeros(startZoom*2*x-1,startZoom*2*y-1);
        p=1;k=1;
        for i=1:2:size(zoomedImg,1)
            k=setk;
            for j=1:2:size(zoomedImg,2)
                if (p<(size(firstOrder,1)+1) && k<(size(firstOrder,2)+1))
                    zoomedImg(i,j)=firstOrder(p,k);
                    k=k+1;   
                end     
            end
            if (p<(size(firstOrder,1)+1))
             p=p+1;
            end
        end
        
        zoomEffect=zoomedImg;
        for i=1:2:size(zoomedImg,1)
            j=1;
            for j=1:2:size(zoomedImg,2)
                if (i+2<size(zoomedImg,1) && j+2<size(zoomedImg,2))
                    zoomEffect(i,j+1)=(zoomedImg(i,j)+zoomedImg(i,j+2))/2;
                    zoomEffect(i+1,j)=(zoomedImg(i,j)+zoomedImg(i+2,j))/2;
                    zoomEffect(i+1,j+1)=(zoomedImg(i,j)+zoomedImg(i+2,j+2))/2;
                end
            end
        end
        startZoom=startZoom+1;
    end
end

if (flag==1)   
    firstOrder=zoomEffect;
    figure,imshow(firstOrder,[]);
    firstOrder = uint8(firstOrder);
else
    figure,imshow(firstOrder,[]);
    firstOrder = uint8(firstOrder);
end


  

