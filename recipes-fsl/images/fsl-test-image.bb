include recipes-core/images/core-image-base.bb

# Add extra image features
IMAGE_FEATURES += " \
    nfs-server \
    tools-debug \
    tools-profile \
    tools-testapps \
"


# Test applicationsx
TEST_TOOLS = " \
    imx-test \
"

IMAGE_INSTALL += " \
    ${TEST_TOOLS} \
    task-fsl-gstreamer \
"

export IMAGE_BASENAME = "fsl-test-image"
