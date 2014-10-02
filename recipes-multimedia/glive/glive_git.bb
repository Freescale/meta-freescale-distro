# Copyright (C) 2013 Avnet Electronics Marketing

DESCRIPTION = "Gstreamer Live Example (GLIVE) Server and Client Application"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/johnweber/glive.git;branch=master"
SRCREV = "d7263f6dc685efb06cbd0f70b12c12193cec480a"

inherit autotools-brokensep pkgconfig

S = "${WORKDIR}/git"

# Depends on Gstreamer
DEPENDS = "gstreamer glib-2.0 "
RDEPENDS_${PN} = "gstreamer \
                  gst-plugins-good-rtp \
                  gst-plugins-good-udp \
                  gst-plugins-good-rtpmanager \
                  gst-plugins-good-video4linux2 \
                  gst-fsl-plugin \
                  glib-2.0 \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
