DESCRIPTION = "Add packages for opencv i.MX build"

inherit packagegroup

OPENCV_PKGS    ?= ""
OPENCV_PKGS_mx8 = " \
    opencv-apps \
    opencv-samples \
    python3-opencv \
"
RDEPENDS_${PN} = " \
    ${OPENCV_PKGS} \
"
