include recipes-fsl/images/fsl-image-gui.bb

IMAGE_FEATURES += " \
    dev-pkgs \
    tools-sdk \
"
EXTRA_IMAGE_FEATURES += " \
    tools-debug \
    tools-profile \
    tools-testapps \
    debug-tweaks \
"
export IMAGE_BASENAME = "fsl-image-gui-sdk"
