DESCRIPTION = "A console-only image that includes gstreamer packages, \
Freescale's multimedia packages (VPU and GPU) when available, and \
test and benchmark applications."

IMAGE_FEATURES += " \
    ${@base_contains('DISTRO_FEATURES', 'x11', 'x11-base', '', d)} \
    debug-tweaks \
    tools-testapps \
    tools-profile \
"

LICENSE = "MIT"

inherit core-image

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-fsl-gstreamer \
    packagegroup-fsl-gstreamer-full \
    packagegroup-fslc-gstreamer1.0 \
    packagegroup-fslc-gstreamer1.0-full \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    ${@base_contains('DISTRO_FEATURES', 'directfb', 'packagegroup-core-directfb', '', d)} \
    ${@base_contains('DISTRO_FEATURES', 'x11', '', \
                      base_contains('DISTRO_FEATURES', 'wayland', 'weston-init', \
                                    '', d), d)} \
"
