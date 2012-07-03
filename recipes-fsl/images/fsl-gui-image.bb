include recipes-sato/images/core-image-sato.bb

DISTRO_FEATURES += "pulseaudio"
WEB = "web-webkit"

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    nfs-server \
    tools-debug \
    tools-profile \
    tools-testapps \
    qt4-pkgs \
"

IMAGE_INSTALL += " \
    task-fsl-gstreamer \
    task-fsl-tools-testapps \
    task-fsl-tools-benchmark \
    qt4-plugin-phonon-backend-gstreamer \
    "

export IMAGE_BASENAME = "fsl-gui-image"
