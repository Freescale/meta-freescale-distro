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
"
