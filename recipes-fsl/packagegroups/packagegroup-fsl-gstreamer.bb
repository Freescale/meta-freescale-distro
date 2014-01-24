# Copyright (C) 2012-2014 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale package group - gstreamer"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

PACKAGES += " \
    ${PN}-streamer \
"

MACHINE_GSTREAMER_PLUGIN ?= ""

RDEPENDS_${PN} = " \
    gst-meta-audio \
    gst-meta-video \
    gst-meta-debug \
    gst-plugins-good-meta \
    ${MACHINE_GSTREAMER_PLUGIN} \
"

RDEPENDS_${PN}-streamer = " \
    ${PN} \
    gst-plugins-good-udp \
    gst-plugins-good-rtp \
    gst-plugins-good-rtpmanager \
    gst-plugins-good-rtsp \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
