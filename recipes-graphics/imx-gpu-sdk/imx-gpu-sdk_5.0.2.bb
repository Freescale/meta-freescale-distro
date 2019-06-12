SUMMARY = "i.MX GPU SDK Samples"
DESCRIPTION = "Set of sample applications for i.MX GPU"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://License.md;md5=9d58a2573275ce8c35d79576835dbeb8"

DEPENDS = "assimp devil gstreamer1.0 gstreamer1.0-plugins-base"
DEPENDS_append = \
    "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', ' wayland', \
        bb.utils.contains('DISTRO_FEATURES',     'x11',  ' xrandr', \
                                                                '', d), d)}"
DEPENDS_append_imxgpu2d = " virtual/libg2d virtual/libopenvg"
DEPENDS_append_imxgpu3d = " virtual/libgles2"
DEPENDS_append_mx8      = \
    "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
        bb.utils.contains('DISTRO_FEATURES',     'x11', '', \
                                                        ' vulkan', d), d)}"

SRC_URI = "git://github.com/codeauroraforum/gtec-demo-framework.git;protocol=https"

SRCREV = "d35bac9419895ea516c25e2f36a6084729d9e6ce"

# For backwards compatibility
RPROVIDES_${PN} = "fsl-gpu-sdk"
RREPLACES_${PN} = "fsl-gpu-sdk"
RCONFLICTS_${PN} = "fsl-gpu-sdk"

BACKEND = \
    "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'Wayland', \
        bb.utils.contains('DISTRO_FEATURES',     'x11',     'X11', \
                                                             'FB', d), d)}"

FEATURES                  = "EGL,EarlyAccess,OpenVG"
FEATURES_append_imxgpu2d  = ",G2D"
FEATURES_append_imxgpu3d  = ",OpenGLES2"
FEATURES_append_mx6q      = ",OpenGLES3"
FEATURES_append_mx6dl     = ",OpenGLES3"

# i.MX 8M Mini does not have a support for OpenGLES3.1, therefore the split is done
# here to remove it from feature list. All other derivatives contains this support.
FEATURES_append_mx8mm     = ",OpenGLES3,OpenCL,OpenCL1.1,OpenCL1.2,OpenCV"
FEATURES_append_mx8mq     = ",OpenGLES3,OpenGLES3.1,OpenCL,OpenCL1.1,OpenCL1.2,OpenCV"
FEATURES_append_mx8qm     = ",OpenGLES3,OpenGLES3.1,OpenCL,OpenCL1.1,OpenCL1.2,OpenCV"
FEATURES_append_mx8x      = ",OpenGLES3,OpenGLES3.1,OpenCL,OpenCL1.1,OpenCL1.2,OpenCV"

FEATURES_append_mx8       = \
    "${@bb.utils.contains('DISTRO_FEATURES', 'wayland',        '', \
        bb.utils.contains('DISTRO_FEATURES',     'x11',        '', \
                                                        ',Vulkan', d), d)}"

EXTENSIONS       = ""
EXTENSIONS_mx8mq = "OpenGLES3.1:EXT_geometry_shader,OpenGLES3.1:EXT_tessellation_shader"

S = "${WORKDIR}/git"

inherit python3native

do_compile () {
    export FSL_PLATFORM_NAME=Yocto
    export ROOTFS=${STAGING_DIR_HOST}
    . ./prepare.sh
    FslBuild.py -t sdk --UseFeatures [${FEATURES}] -v --UseExtensions [${EXTENSIONS}] --Variants [WindowSystem=${BACKEND}] --BuildThreads ${BB_NUMBER_THREADS} -- install
}

do_install () {
    install -d "${D}/opt/${PN}"
    cp -r ${S}/bin/* ${D}/opt/${PN}
    rm -rf ${D}/opt/${PN}/GLES2/DirectMultiSamplingVideoYUV
    rm -rf ${D}/opt/${PN}/GLES3/DirectMultiSamplingVideoYUV
    rm -rf ${D}/opt/${PN}/GLES2/DeBayer
}

FILES_${PN} += "/opt/${PN}"
FILES_${PN}-dbg += "/opt/${PN}/*/*/.debug /usr/src/debug"
INSANE_SKIP_${PN} += "already-stripped rpaths"

COMPATIBLE_MACHINE = "(mx6|mx7ulp|mx8)"
