# Copyright (C) 2014 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale's package group which provides audio, video, and debug \
gstreamer's plugins (including good and bad ones) with the required hardware \
acceleration (if supported by the SoC)."
SUMMARY = "Freescale package group - gstreamer full"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH_mx6sl = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
    packagegroup-fsl-gstreamer \
    gst-plugins-base-meta \
    gst-plugins-good-meta \
    gst-plugins-bad-meta \
    ${@base_contains('DISTRO_FEATURES', 'opengl', \
                      base_contains('DISTRO_FEATURES', 'x11', \
                                    'gst-plugins-gl', '', d), '', d)} \
"
# FIXME: i.MX6SL cannot use mesa for Graphics and it lacks 3D support,
#        so skip it for now.
RDEPENDS_${PN}_remove_mx6sl = "gst-plugins-gl"
