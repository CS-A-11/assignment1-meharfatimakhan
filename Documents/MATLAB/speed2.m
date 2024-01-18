vid=VideoReader('ballSpeed.mp4');
totalFrames=floor(vid.Duration*vid.FrameRate);
%implay('ballSpeed.mp4')
frame1=read(vid,75);
figure,imshow(frame1,[]);
[thresh,frame1]=OTSU(frame1);

% for i=1:totalFrames-1
%     frame1=read(vid,i);
%     [t1,frame1]=OTSU(frame1);
%     frame2=read(vid,i+1);
%     [t2,frame2]=OTSU(frame2);
%     difference = t2-t1;
%     disp (t1); disp(i)
%     if (difference > 4)
%         frameNum1=i+1;
%         %frame2 = im2bw(frame2,0.4);
%         CC = bwconncomp(frame2);
%         computeProps2 = regionprops(CC, {'area', 'centroid'});
%         disp(frameNum1);
%         break;
%     end
% %     subtractedImage=frame2-frame1;
% %     subtractedImage = im2bw(subtractedImage,0.4);
% %     CC = bwconncomp(subtractedImage);
% %     if (CC.NumObjects >= 1)
% %         frameNum1=i;
% %         computeProps1 = regionprops(CC, {'area', 'centroid'});
% %         disp(frameNum1);disp(computeProps1);
% %         break;
% %     end
% end
% 
% for i=frameNum1:totalFrames-1
%     frame1=read(vid,i);
%     t1=graythresh(frame1);
%     frame2=read(vid,i+1);
%     t2=graythresh(frame2);
%     difference = t2-t1;
%     if (difference > 0.1)
%         frameNum2=i;
%         frame1 = im2bw(frame1,0.4);
%         CC1 = bwconncomp(frame1);
%         computeProps2 = regionprops(CC1, {'area', 'centroid'});
%         disp(frameNum2);
%         break;
%     end
% %     frame1=read(vid,i);
% %     frame2=read(vid,i+1);
% %     subtractedImage=frame1-frame2;
% %     subtractedImage = im2bw(subtractedImage,0.4);
% %     CC = bwconncomp(subtractedImage);
% %     if (CC.NumObjects == 0)
% %         frameNum2=i-1;
% %         computeProps2 = regionprops(CC, {'area', 'centroid'});
% %         disp(frameNum2);disp(computeProps2);
% %         break;
% %     end
% end