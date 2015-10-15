# Copyright (C) 2012-2014 Freescale Semiconductor
# Copyright (C) 2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Packagegroup used by FSL Community to provide a set of packages and utilities \
for hardware test."
SUMMARY = "FSL Community packagegroup - tools/testapps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

SOC_TOOLS_TEST = ""
SOC_TOOLS_TEST_vf  = "imx-test"
SOC_TOOLS_TEST_mx6 = "imx-test"
SOC_TOOLS_TEST_append_mx6q  = " imx-gpu-viv-demos"
SOC_TOOLS_TEST_append_mx6dl = " imx-gpu-viv-demos"
SOC_TOOLS_TEST_append_mx6sx = " imx-gpu-viv-demos"
SOC_TOOLS_TEST_append_mx6sl = " imx-gpu-viv-demos"

RDEPENDS_${PN} = " \
    alsa-utils \
    alsa-tools \
    dosfstools \
    evtest \
    e2fsprogs-mke2fs \
    fsl-rc-local \
    fbset \
    i2c-tools \
    iproute2 \
    memtester \
    python-subprocess \
    python-datetime \
    python-json \
    ${@base_contains('DISTRO_FEATURES', 'x11', 'v4l-utils', '', d)} \
    ethtool \
    mtd-utils \
    mtd-utils-ubifs \
    ${@base_contains('DISTRO_FEATURES', 'x11', 'gtk+3-demo', \
                      base_contains('DISTRO_FEATURES', 'wayland', \
                                    'weston weston-examples \
                                     clutter-1.0-examples', '', d), d)} \
    ${SOC_TOOLS_TEST} \
"

# FIXME: i.MX6SL cannot use mesa for Graphics and it lacks GL support,
#        so for now we skip it.
RDEPENDS_${PN}_remove_mx6sl = "clutter-1.0-examples"
