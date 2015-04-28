# Copyright (C) 2014 Freescale Semiconductor
# Copyright (C) 2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "Package group used by FSL Community to provide graphic packages used \
to test the several hardware accelerated graphics APIs including packages not \
provided by Freescale."
SUMMARY = "FSL Community Package group - tools/gpu/external"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

SOC_GPU_TOOLS_X11 = " \
    mesa-demos \
    glmark2 \
"
SOC_GPU_TOOLS_X11_append_mx6q  = " eglinfo-x11"
SOC_GPU_TOOLS_X11_append_mx6dl = " eglinfo-x11"
SOC_GPU_TOOLS_X11_append_mx6sx = " eglinfo-x11"

SOC_GPU_TOOLS_FB = ""
SOC_GPU_TOOLS_FB_mx6q  = "eglinfo-fb"
SOC_GPU_TOOLS_FB_mx6dl = "eglinfo-fb"
SOC_GPU_TOOLS_FB_mx6sx = "eglinfo-fb"

RDEPENDS_${PN} = " \
    ${@base_contains("LICENSE_FLAGS_WHITELIST", "commercial", "opencv-samples", "", d)} \
    ${@base_contains("DISTRO_FEATURES", "x11", "${SOC_GPU_TOOLS_X11}", "${SOC_GPU_TOOLS_FB}", d)} \
"
