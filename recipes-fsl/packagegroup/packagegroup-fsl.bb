# Copyright (C) 2012 Freescale Semiconductor
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
    ${PN}-tools-testapps \
    ${PN}-tools-benchmark \
"

MACHINE_GSTREAMER_PLUGIN ?= ""

RDEPENDS_${PN}-gstreamer = " \
    gst-meta-audio \
    gst-meta-video \
    ${MACHINE_GSTREAMER_PLUGIN} \
"


SOC_TOOLS_TESTAPPS = ""
SOC_TOOLS_TESTAPPS_mx5 = " \
    amd-gpu-x11-bin-mx51 \
    gst-fsl-plugin-gplay \
"

SOC_TOOLS_TESTAPPS_mx6 = " \
    gpu-viv-bin-mx6q \
    gst-fsl-plugin-gplay \
"

RDEPENDS_${PN}-tools-testapps = " \
    ${SOC_TOOLS_TESTAPPS} \
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
    python-subprocess \
    python-datetime \
    python-json \
    v4l-utils \
    ethtool \
"

RDEPENDS_${PN}-tools-benchmark = " \
    lmbench \
    bonnie++ \
    dbench \
    fio \
    iozone3 \
    iperf \
    memtester \
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
