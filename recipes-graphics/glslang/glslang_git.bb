SUMMARY = "An OpenGL and OpenGL ES shader front end and validator."
DESCRIPTION = "Glslang is the official reference compiler front end \
               for the OpenGL ES and OpenGL shading languages. It \
               implements a strict interpretation of the specifications \
               for these languages. It is open and free for anyone to use, \
               either from a command line or programmatically."
SECTION = "graphics"
HOMEPAGE = "https://www.khronos.org/opengles/sdk/tools/Reference-Compiler"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "\
    file://LICENSE.txt;beginline=22;endline=62;md5=36be65b9171c641a6c9a007bb0ba7b90 \
    file://LICENSE.txt;beginline=62;endline=108;md5=d6589da7fd36ed28016a697e610c41bd \
"

PV = "8.13.3743+git${SRCPV}"
SRC_URI = "git://github.com/KhronosGroup/glslang;protocol=https;branch=master"
SRCREV = "bcf6a2430e99e8fc24f9f266e99316905e6d5134"
S = "${WORKDIR}/git"

inherit cmake

BBCLASSEXTEND = "native nativesdk"
