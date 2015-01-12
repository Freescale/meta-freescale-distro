DESCRIPTION = "Package group used by FSL Community to provide all GStreamer plugins from the \
base, good, and bad packages, as well as the ugly and libav ones if commercial packages \
are whitelisted, and plugins for the required hardware acceleration (if supported by the SoC)."
SUMMARY = "FSL Community package group - full set of all GStreamer 1.0 plugins"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

RDEPENDS_${PN} = " \
    packagegroup-fslc-gstreamer1.0 \
    ${@base_contains('LICENSE_FLAGS_WHITELIST', 'commercial', 'packagegroup-fslc-gstreamer1.0-commercial', '', d)} \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    gstreamer1.0-plugins-bad-meta \
    ${@base_contains('LICENSE_FLAGS_WHITELIST', 'commercial', 'gstreamer1.0-plugins-ugly-meta', '', d)} \
"
