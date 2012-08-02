DESCRIPTION = "Demos from the industrial embedded segment"

inherit autotools

PV = "0.0+gitr${SRCPV}"
SRCREV = "4b10cbfd32391c83251bbc61520eeab03461db0a"
SRC_URI = "git://gitorious.org/qt-in-use/qt-in-industrial-embedded.git"

PR = "r2"

S = "${WORKDIR}/git/${DEMO}"

do_configure_prepend() {
	# fix qmake ugly deployment support
	find ${S} -type f -exec sed -i 's,/usr/local,/usr,g' '{}' ';'
}

FILES_${PN} += "${datadir}/${DEMO} ${datadir}/icons"
RDEPENDS_${PN} += " \
    ${QT_BASE_NAME}-qml-plugins \
    ${QT_BASE_NAME}-plugin-imageformat-svg \
"
