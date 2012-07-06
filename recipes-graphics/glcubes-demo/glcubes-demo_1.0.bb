DESCRIPTION = "OpenGL ES 2.0 demo."
DEPENDS = "amd-gpu-x11-bin-mx51"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://src/glutils.h;endline=19;md5=ef278430dad04019580420bc61a1661d"
PR = "r1"

SRC_URI  = "git://github.com/andreluizeng/cubes-demo-yocto.git;protocol=git" 
SRC_URI += "file://glcubes-demo.desktop \
            file://glcubes-ico.png \ 
           "
SRCREV = "d7d93379198b4c5c40f70cc458e8437d84acef95"

S = "${WORKDIR}/git"

inherit autotools

EXTRA_OEMAKE = "EGL_FLAVOR=x11 BINDIR=${bindir} DATADIR=${datadir}/${PN}"

do_install_append () {
    install -d ${D}/${datadir}/pixmaps
    install -d ${D}/${datadir}/applications
    install -m 0644 ${WORKDIR}/glcubes-ico.png ${D}/${datadir}/pixmaps
    install -m 0644 ${WORKDIR}/glcubes-demo.desktop ${D}/${datadir}/applications
}

COMPATIBLE_MACHINE = "(mx5)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
