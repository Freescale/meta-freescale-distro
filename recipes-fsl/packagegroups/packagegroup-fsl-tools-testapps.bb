# Copyright (C) 2012-2014, 2016 Freescale Semiconductor
# Copyright (C) 2015, 2016 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Packagegroup used by FSL Community to provide a set of packages and utilities \
for hardware test."
SUMMARY = "FSL Community packagegroup - tools/testapps"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

SOC_TOOLS_TEST = ""
SOC_TOOLS_TEST_imxpxp  = "imx-test"
SOC_TOOLS_TEST_imxgpu2d  = "imx-test imx-gpu-viv-demos"

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
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'v4l-utils', '', d)} \
    ethtool \
    mtd-utils \
    mtd-utils-ubifs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'gtk+3-demo', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', \
                         'weston-examples clutter-1.0-examples', '', d)} \
    ${SOC_TOOLS_TEST} \
"

# FIXME: i.MX6SL cannot use mesa for Graphics and it lacks GL support,
#        so for now we skip it.
RDEPENDS_IMX_TO_REMOVE = ""
RDEPENDS_IMX_TO_REMOVE_imxgpu2d = "clutter-1.0-examples"
RDEPENDS_IMX_TO_REMOVE_imxgpu3d = ""

RDEPENDS_${PN}_remove = "${RDEPENDS_IMX_TO_REMOVE}"
