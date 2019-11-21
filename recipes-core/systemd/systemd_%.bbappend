FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://timesyncd.conf"

do_install_append() {
    install -m 0644 ${WORKDIR}/timesyncd.conf ${D}${sysconfdir}/systemd
}
