# Copyright (C) 2012-2014 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Package group used by FSL Community to provide a set of benchmark applications."
SUMMARY = "FSL Communtiy package group - tools/benchmark"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = " \
    lmbench \
    bonnie++ \
    dbench \
    fio \
    iozone3 \
    iperf \
    nbench-byte \
    tiobench \
    ${@bb.utils.contains('TUNE_FEATURES', 'neon', 'cpuburn-neon', '', d)} \
"
