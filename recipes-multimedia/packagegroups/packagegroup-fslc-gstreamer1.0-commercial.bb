DESCRIPTION = "Freescale package group which provides audio and video plugins \
 that are subject to retricted licensing and/or royalties and thus require \
 the 'commercial' license whitelist flag"
SUMMARY = "Freescale package group - set of GStreamer 1.0 plugins with commercial licence flag"
LICENSE = "MIT"
LICENSE_FLAGS = "commercial"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

RDEPENDS_${PN} = " \
    packagegroup-fslc-gstreamer1.0 \
"

# Plugins from the -ugly collection which require the "commercial" flag in LICENSE_FLAGS_WHITELIST to be set
RDEPENDS_${PN} = " \
    gstreamer1.0-plugins-ugly-mpg123 \
    gstreamer1.0-plugins-ugly-asfdemux \
"
