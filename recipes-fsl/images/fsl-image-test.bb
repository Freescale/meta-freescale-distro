include recipes-core/images/core-image-base.bb

IMAGE_FEATURES += "debug-tweaks"

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    nfs-server \
    tools-debug \
    tools-profile \
    tools-testapps \
"

IMAGE_INSTALL += " \
    task-fsl-gstreamer \
    task-fsl-tools-testapps \
    task-fsl-tools-benchmark \
"

export IMAGE_BASENAME = "fsl-test-image"
