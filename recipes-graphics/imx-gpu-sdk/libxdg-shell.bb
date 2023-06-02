SUMMARY = "Provides XDG shell header and glue code library"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/License.md;md5=9d58a2573275ce8c35d79576835dbeb8"

DEPENDS = "wayland-native wayland wayland-protocols"

require imx-gpu-sdk-src.inc

S = "${WORKDIR}/git/ThirdParty/Recipe/xdg-shell"

inherit cmake pkgconfig

EXTRA_OECMAKE = " \
    -DWAYLAND_SCANNER=${STAGING_BINDIR_NATIVE}/wayland-scanner \
    -DWAYLAND_PROTOCOLS_DIR=${STAGING_DATADIR}/wayland-protocols \
"

ALLOW_EMPTY:${PN} = "1"
RDEPENDS:${PN}-dev = "${PN}-staticdev"
