DESCRIPTION = "Package group used by FSL Community to provide audio, video, networking and debug \
GStreamer plugins with the required hardware acceleration (if supported by the SoC)."
SUMMARY = "FSL Community package group - set of commonly used GStreamer 1.0 plugins"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES += " \
    ${PN}-base \
    ${PN}-audio \
    ${PN}-video \
    ${PN}-video-bad \
    ${PN}-debug \
    ${PN}-network-base \
    ${PN}-network \
"

MACHINE_GSTREAMER_1_0_PLUGIN ?= ""

RDEPENDS_${PN} = " \
    ${PN}-audio \
    ${PN}-video \
    ${PN}-network-base \
    ${PN}-debug \
    ${MACHINE_GSTREAMER_1_0_PLUGIN} \
"

# List of X11 specific plugins
GST_X11_PACKAGES = " \
    gstreamer1.0-plugins-base-ximagesink \
    gstreamer1.0-plugins-base-xvimagesink \
"

# List of Wayland specific plugins
GST_WAYLAND_PACKAGES = " \
    gstreamer1.0-plugins-bad-waylandsink \
"

# basic plugins required in virtually every pipeline
RDEPENDS_${PN}-base = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base-playback \
    ${@bb.utils.contains('DISTRO_FEATURES', 'alsa', 'gstreamer1.0-plugins-base-alsa', '', d)} \
    gstreamer1.0-plugins-base-audioconvert \
    gstreamer1.0-plugins-base-audioresample \
    gstreamer1.0-plugins-base-gio \
    gstreamer1.0-plugins-base-typefindfunctions \
    gstreamer1.0-plugins-base-videoconvert \
    gstreamer1.0-plugins-base-videoscale \
    gstreamer1.0-plugins-base-volume \
    gstreamer1.0-plugins-good-autodetect \
"

RRECOMMENDS_${PN}-base = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', '${GST_X11_PACKAGES}', \
                          bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                                            '${GST_WAYLAND_PACKAGES}', '', d), d)} \
"

# Basic audio plugins: parsers, demuxers, decoders
RDEPENDS_${PN}-audio = " \
    ${PN}-base \
    gstreamer1.0-plugins-base-ivorbisdec \
    gstreamer1.0-plugins-base-ogg \
    gstreamer1.0-plugins-good-audioparsers \
    gstreamer1.0-plugins-good-flac \
    gstreamer1.0-plugins-good-icydemux \
    gstreamer1.0-plugins-good-id3demux \
    gstreamer1.0-plugins-good-speex \
    gstreamer1.0-plugins-good-wavparse \
"

# Basic video plugins: parsers, demuxers
RDEPENDS_${PN}-video = " \
    ${PN}-base \
    gstreamer1.0-plugins-base-subparse \
    gstreamer1.0-plugins-base-theora \
    gstreamer1.0-plugins-good-avi \
    gstreamer1.0-plugins-good-flv \
    gstreamer1.0-plugins-good-isomp4 \
    gstreamer1.0-plugins-good-matroska \
"

RRECOMMENDS_${PN}-video = " \
    ${PN}-audio \
"

# Additional video plugins from the -bad collection
RDEPENDS_${PN}-video-bad = " \
    ${PN}-video \
    gstreamer1.0-plugins-bad-mpegpsdemux \
    gstreamer1.0-plugins-bad-mpegtsdemux \
    gstreamer1.0-plugins-bad-videoparsersbad \
"

# Plugins used for diagnostics and debugging of pipelines
RDEPENDS_${PN}-debug = " \
    ${PN}-base \
    gstreamer1.0-plugins-base-audiotestsrc \
    gstreamer1.0-plugins-base-videotestsrc \
    gstreamer1.0-plugins-good-debug \
    gstreamer1.0-plugins-good-navigationtest \
"

# Basic networking plugins required by most pipelines that receive and/or send data
RDEPENDS_${PN}-network-base = " \
    gstreamer1.0-plugins-base-tcp \
    gstreamer1.0-plugins-good-souphttpsrc \
    gstreamer1.0-plugins-good-udp \
"

# Additional networking plugins
RDEPENDS_${PN}-network = " \
    ${PN}-network-base \
    gstreamer1.0-plugins-good-rtp \
    gstreamer1.0-plugins-good-rtpmanager \
    gstreamer1.0-plugins-good-rtsp \
"
