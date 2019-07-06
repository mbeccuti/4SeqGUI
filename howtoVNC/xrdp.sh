#!/bin/sh

echo "Running vncserver"

sudo systemctl start xrdp

sudo touch /etc/resolv.conf
