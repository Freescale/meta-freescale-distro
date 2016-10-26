# Copyright (C) 2014, 2016 Freescale Semiconductor
# Copyright (C) 2015, 2016 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "Package group used by FSL Community to provide graphic packages used \
to test the several hardware accelerated graphics APIs including packages not \
provided by Freescale."
SUMMARY = "FSL Community Package group - tools/gpu/external"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

SOC_GPU_TOOLS_X11 = ""
SOC_GPU_TOOLS_X11_imxgpu2d = " mesa-demos glmark2 gtkperf"
SOC_GPU_TOOLS_X11_append_imxgpu3d = " eglinfo-x11 glcompbench"

SOC_GPU_TOOLS_FB = ""
SOC_GPU_TOOLS_FB_imxgpu3d  = "eglinfo-fb"

SOC_GPU_TOOLS_WAYLAND = ""
SOC_GPU_TOOLS_WAYLAND_imxgpu2d = "mesa-demos"
SOC_GPU_TOOLS_WAYLAND_append_imxgpu3d = " glmark2"

SOC_GPU_TOOLS_XWAYLAND = ""
SOC_GPU_TOOLS_XWAYLAND_imxgpu2d = "mesa-demos gtkperf"
SOC_GPU_TOOLS_XWAYLAND_append_imxgpu3d = " glmark2"

RDEPENDS_${PN} = " \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11 wayland", "${SOC_GPU_TOOLS_XWAYLAND}", \
       bb.utils.contains("DISTRO_FEATURES",     "wayland", "${SOC_GPU_TOOLS_WAYLAND}", \
       bb.utils.contains("DISTRO_FEATURES",         "x11", "${SOC_GPU_TOOLS_X11}", \
                                                           "${SOC_GPU_TOOLS_FB}", d), d), d)} \
"
