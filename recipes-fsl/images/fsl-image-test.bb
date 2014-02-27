include recipes-core/images/core-image-base.bb

IMAGE_FEATURES += "debug-tweaks"

SOC_EXTRA_IMAGE_FEATURES ?= "tools-testapps"

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    ${SOC_EXTRA_IMAGE_FEATURES} \
    nfs-server \
    tools-debug \
    tools-profile \
"

IMAGE_INSTALL += " \
    packagegroup-fsl-gstreamer \
    gst-plugins-good-meta \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
"

export IMAGE_BASENAME = "fsl-image-test"
