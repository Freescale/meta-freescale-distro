DESCRIPTION = "Demos from the industrial embedded segment"

inherit autotools-brokensep update-rc.d

PV = "0.0+gitr${SRCPV}"
SRCREV = "4b10cbfd32391c83251bbc61520eeab03461db0a"
SRC_URI = "git://gitorious.org/qt-in-use/qt-in-industrial-embedded.git \
           file://fullscreen.patch;striplevel=2 \
           file://smarthome \
          "

PR = "r3"

S = "${WORKDIR}/git/${DEMO}"

do_configure_prepend() {
	# fix qmake ugly deployment support
	find ${S} -type f -exec sed -i 's,/usr/local,/usr,g' '{}' ';'
}

do_install_append () {
    # Set the correct smarthome binary path
    sed -i -e 's:Exec=.*:Exec=${bindir}/smarthome:g' ${D}${datadir}/applications/smarthome.desktop

    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${WORKDIR}/smarthome ${D}${sysconfdir}/init.d/
    sed -i -e 's:__BINDIR__:${bindir}:g; s:__SYSCONFDIR__:${sysconfdir}:g' ${D}${sysconfdir}/init.d/smarthome
}

FILES_${PN} += "${datadir}/${DEMO} ${datadir}/icons"
RDEPENDS_${PN} += " \
    ${QT_BASE_NAME}-qml-plugins \
    ${QT_BASE_NAME}-plugin-imageformat-svg \
"

INITSCRIPT_NAME = "smarthome"
INITSCRIPT_PARAMS = "defaults"
