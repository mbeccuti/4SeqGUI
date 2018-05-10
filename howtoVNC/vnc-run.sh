#!/bin/sh

echo "Running vncserver"
#su user
#HOME=/home/user
#export HOME
sleep 5
vncserver :1 -geometry 800x600 -depth 24 &
vncserver :2 -geometry 1024x768 -depth 24 &
vncserver :3 -geometry 1280x800 -depth 24 &
vncserver :4 -geometry 1280x1024 -depth 24 & 
#to create resolv.conf
sudo touch /etc/resolv.conf
