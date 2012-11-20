include recipes-core/images/core-image-base.bb

IMAGE_FEATURES += "debug-tweaks"

SOC_EXTRA_IMAGE_FEATURES ?= "tools-testapps"

# mesa-demos is currently broken when building with other GL library
# so we avoid it by now and tools-testapps includes it.
SOC_EXTRA_IMAGE_FEATURES_mx6 = ""

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    ${SOC_EXTRA_IMAGE_FEATURES} \
    nfs-server \
    tools-debug \
    tools-profile \
"

IMAGE_INSTALL += " \
    packagegroup-fsl-gstreamer \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
"

export IMAGE_BASENAME = "fsl-image-test"
