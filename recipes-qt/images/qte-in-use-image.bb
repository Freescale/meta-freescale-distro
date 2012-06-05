require qt-in-use-common.inc

QT_NAME = "qt4-embedded"

IMAGE_INSTALL = " \
    ${COMMON_INSTALL} \
    \
    ${QT_DEMOS} \
    qt-in-industrial-embedded-smarthome-e \
    pciutils \
    usbutils \
    alsa-utils \
"
