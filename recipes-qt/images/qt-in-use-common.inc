SYSTEMD_INSTALL = " \
    systemd \
    systemd-compat-units \
    systemd-speed-hacks \
    udev-systemd \
    rsyslog-systemd \
"

SYSV_INSTALL = " \
    udev \
    sysvinit \
    initscripts \
    tinylogin \
"

COMMON_INSTALL = " \
    base-files \
    base-passwd \
    busybox \
    ${@base_contains("MACHINE_FEATURES", "systemd", "${SYSTEMD_INSTALL}", "${SYSV_INSTALL}", d)} \
"

ROOTFS = "${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.ext3"
SDIMG_SIZE = "256"
IMAGE_FSTYPES = "ext3"

MACHINE_IMAGE_CLASS ?= "image"
MACHINE_IMAGE_CLASS_imx53qsb = "sdcard_image"

do_rootfs[depends] += "virtual/kernel:do_populate_sysroot"

inherit ${MACHINE_IMAGE_CLASS}
