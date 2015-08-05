# Copyright (C) 2012-2014 Freescale Semiconductor
# Copyright (C) 2015 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Package group used by FSL Community to add the packages which provide GPU support."
SUMMARY = "FSL Community package group - tools/gpu"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

SOC_TOOLS_GPU = ""

SOC_TOOLS_GPU_IMX6QDLSX = " \
    imx-gpu-viv-g2d \
    fsl-gpu-sdk \
    imx-gpu-viv-tools \
    imx-gpu-viv-tools-apitrace \
    ${@base_contains('DISTRO_FEATURES', 'x11', \
                     'xserver-xorg-extension-viv-autohdmi', '', d)} \
"
SOC_TOOLS_GPU_mx6q  = "${SOC_TOOLS_GPU_IMX6QDLSX}"
SOC_TOOLS_GPU_mx6dl = "${SOC_TOOLS_GPU_IMX6QDLSX}"
SOC_TOOLS_GPU_mx6sx = "${SOC_TOOLS_GPU_IMX6QDLSX}"

# FIXME: fsl-gpu-sdk is not supported for i.MX6 SoloLite due to lack of
# OpenVG support and is intended to add in future release. 
# i.MX6 SoloLite do not support apitrace because of its dependency on gles2.
SOC_TOOLS_GPU_mx6sl = " \
    imx-gpu-viv-g2d \
    imx-gpu-viv-tools \
    ${@base_contains('DISTRO_FEATURES', 'x11', \
                     'xserver-xorg-extension-viv-autohdmi', '', d)} \
"

RDEPENDS_${PN} = " \
    ${SOC_TOOLS_GPU} \
"
