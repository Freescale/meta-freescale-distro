SUMMARY = "Vivante GPU SDK Samples"
DESCRIPTION = "Set of sample applications compatible with Vivante GPU"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=b3ed4253a63ac8555ccab7c4c0aa29a1"
DEPENDS = "virtual/libgles1"

inherit fsl-eula-unpack

SRC_URI = "${FSL_MIRROR}/${PN}-${PV}.bin;fsl-eula=true \
	file://0001-Fix-compilation-of-the-GLES1.1-X11-Samples-in-Yocto.patch \
	file://0002-Don-t-build-missing-GLES1.1-samples-in-X11-Makefile.patch"

SRC_URI[md5sum] = "344c9a260b46a00f86eb5cb73bf729e0"
SRC_URI[sha256sum] = "0f0a576ce1a08719ee1018832ae808ee723fad27a534c9739b5feec6d7435c57"

S = "${WORKDIR}/${PN}-${PV}"
# TODO: Support for building GLES1.1 is ready, GLES2.0 and OpenVG is not ready yet
SUPPORTED_APIS = "GLES1.1"

do_compile () {
	for API in "${SUPPORTED_APIS}"; do
		cd "${S}/Samples/${API}"
		oe_runmake -f Makefile.x11
	done
}

do_install () {
	for API in "${SUPPORTED_APIS}"; do
		cd "${S}/Samples/${API}"
		install -d "${D}/opt/${PN}"
		oe_runmake -f Makefile.x11 install
		cp -r bin/ "${D}/opt/${PN}"
	done
}

FILES_${PN} += "/opt/${PN}"
FILES_${PN}-dbg += "/opt/${PN}/*/*/.debug"
