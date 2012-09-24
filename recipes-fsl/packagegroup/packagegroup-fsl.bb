# Copyright (C) 2012 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale package group"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
    ${PN} \
    ${PN}-dbg \
    ${PN}-dev \
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

RDEPENDS_${PN}-tools-testapps = " \
    dosfstools \
    evtest \
    e2fsprogs-mke2fs \
    fsl-rc-local \
    gst-plugins-base-tcp \
    i2c-tools \
    iproute2 \
    python-subprocess \
    python-datetime \
    python-json \
"

RRECOMMENDS_${PN}-tools-testapps_mx5 = " \
    gst-fsl-plugin-gplay \
    imx-test \
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
    netperf \
    tiobench \
    "
# Disabled as it has CRC problems in denzil branch
#    cpuburn-neon

ALLOW_EMPTY = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"
