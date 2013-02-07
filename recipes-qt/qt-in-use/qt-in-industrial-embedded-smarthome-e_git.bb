require qt-in-industrial-embedded-common.inc

LICENSE = "LGPLv2.1+ & GFDL-1.2"
LIC_FILES_CHKSUM = "file://COPYING.DOC;md5=ad1419ecc56e060eccf8184a87c4285f \
                    file://COPYING.LIB;md5=2d5025d4aa3495befef8f17206a5b0a1"

DEMO = "smarthome"

RDEPENDS_${PN} += "${QT_BASE_NAME}-fonts"
RCONFLICTS_${PN} = "qt-in-industrial-embedded-smarthome"

inherit qt4e

EXTRA_OEMAKE += "INSTALL_ROOT=${D}"
