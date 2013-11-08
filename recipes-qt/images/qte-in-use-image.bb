require qt-in-use-common.inc

QT_NAME = "qt4-embedded"

TOUCH = ' ${@base_contains("MACHINE_FEATURES", "touchscreen", "tslib tslib-calibrate tslib-tests qt4-embedded-plugin-mousedriver-tslib", "",d)}'

IMAGE_INSTALL = " \
    ${COMMON_INSTALL} \
    \
    ${QT_DEMOS} \
    qt-in-industrial-embedded-smarthome-e \
    pciutils \
    usbutils \
    alsa-utils \
    ${TOUCH} \
"
