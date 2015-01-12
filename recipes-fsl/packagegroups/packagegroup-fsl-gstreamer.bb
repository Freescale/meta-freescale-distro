# Copyright (C) 2012-2014 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Package group used by FSL Community to provide audio, video, and debug \
GStreamer's plugins with the required hardware acceleration (if supported by the SoC)."
SUMMARY = "FSL Community package group - GStreamer"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES += " \
    ${PN}-base \
    ${PN}-x11-base \
    ${PN}-audio \
    ${PN}-video \
    ${PN}-debug \
    ${PN}-streamer \
"

MACHINE_GSTREAMER_PLUGIN ?= ""

RDEPENDS_${PN} = " \
    ${PN}-audio \
    ${PN}-video \
    ${PN}-debug \
    ${MACHINE_GSTREAMER_PLUGIN} \
    ${@base_contains("MACHINE_GSTREAMER_PLUGIN", "gst-fsl-plugin", "gst-fsl-plugin-gplay", "", d)} \
"

RDEPENDS_${PN}-base = " \
    ${@base_contains('DISTRO_FEATURES', 'x11', '${PN}-x11-base', '', d)} \
    gstreamer \
    gst-plugins-base-playbin \
    gst-plugins-base-decodebin \
    gst-plugins-base-decodebin2 \
    gst-plugins-base-gio \
    gst-plugins-base-alsa \
    gst-plugins-base-volume \
    gst-plugins-base-audioconvert \
    gst-plugins-base-audioresample \
    gst-plugins-base-typefindfunctions \
    gst-plugins-base-videoscale \
    gst-plugins-base-ffmpegcolorspace \
    gst-plugins-good-autodetect \
    gst-plugins-good-souphttpsrc \
"

RDEPENDS_${PN}-x11-base = " \
    gst-plugins-base-ximagesink \
    gst-plugins-base-xvimagesink \
"

RDEPENDS_${PN}-audio = " \
    ${PN}-base \
    gst-plugins-base-vorbis \
    gst-plugins-base-ogg \
    gst-plugins-good-wavparse \
    gst-plugins-good-flac \
    ${COMMERCIAL_AUDIO_PLUGINS} \
"

RDEPENDS_${PN}-video = " \
    ${PN}-base \
    gst-plugins-good-avi \
    gst-plugins-good-matroska \
    gst-plugins-base-theora \
    ${COMMERCIAL_VIDEO_PLUGINS} \
"

RRECOMMENDS_${PN}-video = " \
    ${PN}-audio \
"

RDEPENDS_${PN}-debug = " \
    ${PN}-base \
    gst-plugins-good-debug \
    gst-plugins-base-audiotestsrc \
    gst-plugins-base-videotestsrc \
"

RDEPENDS_${PN}-streamer = " \
    ${PN}-base \
    gst-plugins-good-udp \
    gst-plugins-good-rtp \
    gst-plugins-good-rtpmanager \
    gst-plugins-good-rtsp \
"
