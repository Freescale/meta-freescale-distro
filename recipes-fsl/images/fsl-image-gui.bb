include recipes-sato/images/core-image-sato.bb

IMAGE_FEATURES += "debug-tweaks"
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

SOC_IMAGE_INSTALL = ""
SOC_IMAGE_INSTALL_mx5 = "glcubes-demo"

IMAGE_INSTALL += " \
    ${SOC_IMAGE_INSTALL} \
    cpufrequtils \
    nano \
    task-fsl-gstreamer \
    task-fsl-tools-testapps \
    task-fsl-tools-benchmark \
    task-qt-in-use-demos \
    qt4-plugin-phonon-backend-gstreamer \
    qt4-demos \
    qt4-examples \
    fsl-gui-extrafiles \
    "

export IMAGE_BASENAME = "fsl-gui-image"
