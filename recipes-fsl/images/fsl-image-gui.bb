include recipes-sato/images/core-image-sato.bb

IMAGE_FEATURES += "debug-tweaks"
DISTRO_FEATURES += "pulseaudio"
WEB = "web-webkit"

SOC_EXTRA_IMAGE_FEATURES ?= "tools-testapps"

# mesa-demos is currently broken when building with other GL library
# so we avoid it by now and tools-testapps includes it.
SOC_EXTRA_IMAGE_FEATURES_mx5 = ""
SOC_EXTRA_IMAGE_FEATURES_mx6 = ""

# Add extra image features
EXTRA_IMAGE_FEATURES += " \
    ${SOC_EXTRA_IMAGE_FEATURES} \
    nfs-server \
    tools-debug \
    tools-profile \
    qt4-pkgs \
"

SOC_IMAGE_INSTALL = ""
SOC_IMAGE_INSTALL_mx5 = "glcubes-demo"

IMAGE_INSTALL += " \
    ${SOC_IMAGE_INSTALL} \
    cpufrequtils \
    nano \
    packagegroup-fsl-gstreamer \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    packagegroup-qt-in-use-demos \
    qt4-plugin-phonon-backend-gstreamer \
    qt4-demos \
    qt4-examples \
    fsl-gui-extrafiles \
    "

export IMAGE_BASENAME = "fsl-image-gui"
