# Copyright (C) 2012 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Freescale tasks"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PR = "r2"

inherit task

PROVIDES = "${PACKAGES}"
PACKAGES = " \
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
    i2c-tools \
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

PACKAGE_ARCH = "${MACHINE_ARCH}"
