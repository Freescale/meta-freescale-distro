require conf/distro/poky.conf

DISTRO = "fslc-base"
DISTRO_NAME = "FSLC Distro Base"
DISTRO_VERSION = "5.0"

SDK_VENDOR = "-fslcsdk"

MAINTAINER = "FSL Community Team <meta-freescale@yoctoproject.org>"

TARGET_VENDOR = "-fslc"

DISTROOVERRIDES = "fslc"

# This function changes the default tune for machines which are based on armv7a
# to use common tune value
def arm_tune_handler(d):
    features = d.getVar('TUNE_FEATURES', True).split()
    if 'armv7a' in features or 'armv7ve' in features:
        tune = 'armv7athf'
        if 'bigendian' in features:
            tune += 'b'
        if 'vfpv3' in features:
            tune += '-vfpv3'
        if 'vfpv3d16' in features:
            tune += '-vfpv3d16'
        if 'neon' in features:
            tune += '-neon'
        if 'vfpv4' in features:
            tune += '-vfpv4'
    else:
        tune = d.getVar('DEFAULTTUNE', True)
    return tune

DEFAULTTUNE:fslc := "${@arm_tune_handler(d)}"

PACKAGECONFIG:remove:pn-xserver-xorg:armv5 = "dri"

# Log information on images and packages
INHERIT += "buildhistory"
BUILDHISTORY_COMMIT ?= "1"
