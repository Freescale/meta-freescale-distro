# Copyright (C) 2012-2013 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale package group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r5"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES += " \
    ${PN}-gstreamer \
    ${PN}-gstreamer-streamer \
    ${PN}-tools-testapps \
    ${PN}-tools-benchmark \
"

MACHINE_GSTREAMER_PLUGIN ?= ""

RDEPENDS_${PN}-gstreamer = " \
    gst-meta-audio \
    gst-meta-video \
    gst-meta-debug \
    gst-plugins-good-meta \
    ${MACHINE_GSTREAMER_PLUGIN} \
"

RDEPENDS_${PN}-gstreamer-streamer = " \
    ${PN}-gstreamer \
    gst-plugins-good-udp \
    gst-plugins-good-rtp \
    gst-plugins-good-rtpmanager \
    gst-plugins-good-rtsp \
"

SOC_TOOLS_TESTAPPS = ""
SOC_TOOLS_TESTAPPS_mx5 = " \
    amd-gpu-x11-bin-mx51 \
"

SOC_TOOLS_TESTAPPS_mx6 = " \
    gpu-viv-bin-mx6q \
"

RDEPENDS_${PN}-tools-testapps = " \
    ${SOC_TOOLS_TESTAPPS} \
    ${@base_contains("MACHINE_GSTREAMER_PLUGIN", "gst-fsl-plugin", "gst-fsl-plugin-gplay", "", d)} \
    alsa-utils \
    alsa-tools \
    dosfstools \
    evtest \
    e2fsprogs-mke2fs \
    fsl-rc-local \
    gst-plugins-base-tcp \
    i2c-tools \
    imx-test \
    iproute2 \
    memtester \
    python-subprocess \
    python-datetime \
    python-json \
    ${@base_contains('DISTRO_FEATURES', 'x11', 'v4l-utils', '', d)} \
    ethtool \
    mtd-utils \
    mtd-utils-ubifs \
"

RDEPENDS_${PN}-tools-benchmark = " \
    lmbench \
    bonnie++ \
    dbench \
    fio \
    iozone3 \
    iperf \
    nbench-byte \
    tiobench \
    "
# Disabled as it has CRC problems in denzil branch
#    cpuburn-neon

ALLOW_EMPTY_${PN} = "1"
ALLOW_EMPTY_${PN}-gstreamer = "1"
ALLOW_EMPTY_${PN}-tools-testapps = "1"
ALLOW_EMPTY_${PN}-tools-benchmark = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"
