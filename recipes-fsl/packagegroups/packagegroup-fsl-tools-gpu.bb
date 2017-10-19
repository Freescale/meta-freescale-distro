# Copyright (C) 2012-2014, 2016 Freescale Semiconductor
# Copyright (C) 2015, 2016 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Package group used by FSL Community to add the packages which provide GPU support."
SUMMARY = "FSL Community package group - tools/gpu"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

SOC_TOOLS_GPU = ""

# i.MX6 SoloLite does not support apitrace because of its dependency on gles2.
SOC_TOOLS_GPU_imxgpu2d = " \
    imx-gpu-sdk \
    imx-gpu-viv-tools \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'xserver-xorg-extension-viv-autohdmi', \
                                                       '', d), d)} \
"

SOC_TOOLS_GPU_append_imxgpu3d = " \
    imx-gpu-apitrace \
    imx-gpu-apitrace-bin \
"

RDEPENDS_${PN} = " \
    ${SOC_TOOLS_GPU} \
"
