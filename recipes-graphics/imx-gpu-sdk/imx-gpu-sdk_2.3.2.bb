SUMMARY = "i.MX GPU SDK Samples"
DESCRIPTION = "Set of sample applications for i.MX GPU"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=d4f548f93b5fe0ee2bc86758c344412d"
DEPENDS = "${X11_DEPENDS} ${WL_DEPENDS} assimp devil gstreamer1.0 gstreamer1.0-plugins-base"
DEPENDS_append_imxgpu2d = " virtual/libopenvg"
DEPENDS_append_imxgpu3d = " virtual/libgles2"

X11_DEPENDS = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xrandr', '', d)}"
WL_DEPENDS = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)}"

inherit fsl-eula-unpack

# For backwards compatibility
RPROVIDES_${PN} = "fsl-gpu-sdk"
RREPLACES_${PN} = "fsl-gpu-sdk"
RCONFLICTS_${PN} = "fsl-gpu-sdk"

SRC_URI = "${FSL_MIRROR}/${PN}-${PV}.bin;fsl-eula=true"

SRC_URI[md5sum] = "b9d6da385fcc51f1c72a7ddcf10b5150"
SRC_URI[sha256sum] = "ddeab8c297d17159b14be58d3690158e6fac3f12b2180610218ef6b46b4ff53a"

SRC_URI += "file://Add-missing-cmath-include.patch"

BACKEND = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'X11', \
                    bb.utils.contains('DISTRO_FEATURES', 'wayland', 'Wayland', 'FB', d), d)}"

IMXGPU = "2d"
IMXGPU_imxgpu3d = "3d"

do_compile () {
    export FSL_GRAPHICS_SDK=${S}
    export FSL_PLATFORM_NAME=Yocto
    export ROOTFS=${STAGING_DIR_HOST}
    if [ "${IMXGPU}" = "3d" ]; then
        ./build.sh -f GNUmakefile_Yocto EGLBackend=${BACKEND} install
    else
        ./build_OpenVG.sh -f GNUmakefile_Yocto EGLBackend=${BACKEND} install
    fi
}

do_install () {
    install -d "${D}/opt/${PN}"
    cp -r bin/* "${D}/opt/${PN}"

    rm -rf ${D}/opt/${PN}/GLES2/S05_PrecompiledShader
    rm -rf ${D}/opt/${PN}/GLES3/S05_PrecompiledShader
    rm -rf ${D}/opt/${PN}/GLES2/DeBayer
    rm -rf ${D}/opt/${PN}/GLES2/DirectMultiSamplingVideoYUV
    rm -rf ${D}/opt/${PN}/GLES3/DirectMultiSamplingVideoYUV
}

FILES_${PN} += "/opt/${PN}"
FILES_${PN}-dbg += "/opt/${PN}/*/*/.debug /usr/src/debug"
INSANE_SKIP_${PN} += "already-stripped rpaths"

COMPATIBLE_MACHINE = "(mx6)"
