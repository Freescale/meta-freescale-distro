FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://profile"

do_install:append() {
    if [ "${@bb.utils.filter('DISTROOVERRIDES', 'fsl fslc', d)}" != "" ]; then
        install -Dm0755 ${WORKDIR}/profile ${D}${sysconfdir}/profile.d/weston.sh
    fi
}

WATCHDOG_SEC = "40"
WATCHDOG_SEC:mx8ulp = "240"
replace_setting() {
    if ! grep -q "$1" $3; then
        bbwarn "Setting to replace '$1' not found in file $3"
    fi
    sed -i -e "s,$1,$2," $3
}
# NOTE: This is for fsl distro only
do_install:append:fsl() {
    replace_setting "WatchdogSec=.*" "WatchdogSec=${WATCHDOG_SEC}" ${D}${systemd_system_unitdir}/weston.service
}
