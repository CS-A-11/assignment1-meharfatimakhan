function [SpeedAns,count2,count3,a3,E_distance,valans,frame1,binary1,frame2,binary2] = BallSpeedFind(v)
%v = VideoReader(vid);
ans1=v.Duration*v.FrameRate;
a1=v.FrameRate;

count=0;
flag=0;

%this loop checks when first the ball appear
for i=5:ans1-1
    frame1 = read(v,i);
    frame1=rgb2gray(frame1);
    f1=im2bw(frame1,0.4);
    flag=CheckBallFirstEnter(f1);
    if flag==1
     count=i;
     break;
    end
    
end

count2=0;
flag2=0;

%this loop checks when whole ball appears first, this frame is what we need
%and it is in count2 variable

for i=count:ans1-1
    frame1 = read(v,i);
    frame1=rgb2gray(frame1);
    f1=im2bw(frame1,0.4);
    flag2=BallEnterPosition(f1);
    if flag2==1
     count2=i;
     break;
    end
    
end

count3=0;
flag3=0;
%This loop checks Ball Final appearance before exiting
%it is saved in count3 variable

for i=count2:ans1-1
    frame1 = read(v,i);
    frame1=rgb2gray(frame1);
    f1=im2bw(frame1,0.4);
    flag3=BallFinalPosition(f1);
    if flag3==1
     count3=i;
    break;
    end
    
end
count3=count3-1;

frame_first = read(v,count2);
frame_first=rgb2gray(frame_first);
f11=im2bw(frame_first,0.4);
    
frame_end = read(v,count3);
frame_end=rgb2gray(frame_end);
f12=im2bw(frame_end,0.4);

CC = bwconncomp(f11);
CA = regionprops(CC, {'area', 'centroid'});
%figure(),imshow(f11);


CC2 = bwconncomp(f12);
CA2 = regionprops(CC2, {'area', 'centroid'});

[maValue,index]=max([CA.Area]);
[maValue2,index2]=max([CA2.Area]);

rc=getfield(CA,{index},'Centroid');
rc2=getfield(CA2,{index2},'Centroid');



rc=round(rc);
rc2=round(rc2);

E_distance=sqrt(((rc(1)-rc2(1))^2)+((rc(2)-rc2(2))^2));% Euclidean Distance Calculated
disp(E_distance);

a2=count3-count2;
a3=a2/a1;
%this is time calculated
disp(a3);

actual_d=0.272;
tex=size(f11,2);

valans=actual_d/tex;

valans=valans*E_distance;

SpeedAns=valans/a3;

disp(SpeedAns);

frame1=read(v,count2);
binary1=im2bw(frame1,0.4);
frame2=read(v,count3);
binary2=im2bw(frame2,0.4);
%disp(count2);%enter position of ball
%disp(count3);%final position of ball

end

