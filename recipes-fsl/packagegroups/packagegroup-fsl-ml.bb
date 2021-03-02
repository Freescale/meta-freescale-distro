DESCRIPTION = "Add packages for AI/ML build"

inherit packagegroup

ML_PKGS    ?= ""
ML_PKGS_mx8 = " \
    armnn \
    pyarmnn \
    tensorflow-lite \
    onnxruntime \
    pytorch \
    torchvision \
"
RDEPENDS_${PN} = " \
    ${ML_PKGS} \
"
