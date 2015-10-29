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

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

SOC_GPU_TOOLS_X11 = " \
    mesa-demos \
    glmark2 \
"

SOC_GPU_TOOLS_X11_append_mx6q  = " eglinfo-x11 gtkperf glcompbench"
SOC_GPU_TOOLS_X11_append_mx6dl = " eglinfo-x11 gtkperf glcompbench"
SOC_GPU_TOOLS_X11_append_mx6sx = " eglinfo-x11 gtkperf glcompbench"
SOC_GPU_TOOLS_X11_append_mx6sl = " gtkperf"

SOC_GPU_TOOLS_FB = ""
SOC_GPU_TOOLS_FB_mx6q  = "eglinfo-fb"
SOC_GPU_TOOLS_FB_mx6dl = "eglinfo-fb"
SOC_GPU_TOOLS_FB_mx6sx = "eglinfo-fb"

SOC_GPU_TOOLS_WAYLAND = ""
SOC_GPU_TOOLS_WAYLAND_mx6q  = "glmark2"
SOC_GPU_TOOLS_WAYLAND_mx6dl = "glmark2"
SOC_GPU_TOOLS_WAYLAND_mx6sx = "glmark2"

RDEPENDS_${PN} = " \
    opencv-apps \
    opencv-samples \
    ${@base_contains("DISTRO_FEATURES", "x11", "${SOC_GPU_TOOLS_X11}", \
        base_contains("DISTRO_FEATURES", "wayland", "${SOC_GPU_TOOLS_WAYLAND}", \
                 "${SOC_GPU_TOOLS_FB}", d), d)} \
"
