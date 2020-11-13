SUMMARY = "OpenGL Image Library"
DESCRIPTION = "OpenGL Image (GLI) is a header only C++ \
image library for graphics software."
HOMEPAGE = "http://gli.g-truc.net"
BUGTRACKER = "https://github.com/g-truc/gli/issues"

SECTION = "libs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://readme.md;beginline=19;endline=20;md5=ab03b667ee630c1abb1add70365a50fb"

SRC_URI = " \
    git://github.com/g-truc/gli;branch=0.8.2 \
    file://0001-Set-C-standard-through-CMake-standard-options.patch \
"
SRCREV = "30808550a20ca53a255e6e1e77070493eda7b736"
S = "${WORKDIR}/git"

inherit cmake

# This is a header-only library, so the main package will be empty.
ALLOW_EMPTY_${PN} = "1"

BBCLASSEXTEND = "native"
