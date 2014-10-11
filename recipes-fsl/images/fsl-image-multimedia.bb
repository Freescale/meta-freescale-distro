DESCRIPTION = "A console-only image that includes gstreamer packages and \
Freescale's multimedia packages (VPU and GPU) when available for the specific \
machine."

IMAGE_FEATURES += "\
    ${@base_contains('DISTRO_FEATURES', 'x11', 'x11-base', '', d)} \
"

LICENSE = "MIT"

inherit core-image

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-fsl-gstreamer \
    packagegroup-fsl-tools-gpu \
    packagegroup-fslc-gstreamer1.0 \
    ${@base_contains('DISTRO_FEATURES', 'directfb', 'packagegroup-core-directfb', '', d)} \
    ${@base_contains('DISTRO_FEATURES', 'x11', '', \
                      base_contains('DISTRO_FEATURES', 'wayland', \
                                    'weston weston-init weston-examples \
                                         gtk+3-demo clutter-1.0-examples', '', d), d)} \
"
