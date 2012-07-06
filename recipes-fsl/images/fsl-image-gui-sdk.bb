include recipes-fsl/images/fsl-image-gui.bb

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    tools-sdk \
"

export IMAGE_BASENAME = "fsl-gui-image-sdk"
