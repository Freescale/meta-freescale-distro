FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://profile"

do_install_append() {
    if [ "${@bb.utils.filter('DISTROOVERRIDES', 'fsl fslc', d)}" != "" ]; then
        install -Dm0755 ${WORKDIR}/profile ${D}${sysconfdir}/profile.d/weston.sh
    fi
}
