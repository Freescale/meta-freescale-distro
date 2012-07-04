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
    task-qt-in-use-demos \
    qt4-plugin-phonon-backend-gstreamer \
    qt4-demos \
    qt4-examples \
    fsl-gui-extrafiles \
    glcubes-demo \
    "

export IMAGE_BASENAME = "fsl-gui-image"
