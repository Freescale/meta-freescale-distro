# Copyright (C) 2020 Jens Rehsack <sno@netbsd.org>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Package group used by FSL Community to add the packages which provide (QorIQ) networking support."
SUMMARY = "FSL Community package group - networking"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

NETWORK_TOOLS = "\
	ethtool \
	tcpdump \
"

NETWORK_TOOLS_append_qoriq = " \
	ceetm \
	dpdk \
	ovs-dpdk \
	pktgen-dpdk \
	tsntool \
"

# Data Place Acceleration Architecture
NETWORK_TOOLS_append_fsl-lsch2 = "\
	eth-config \
"

# 2nd generation Data Place Acceleration Architecture
NETWORK_TOOLS_append_ls1088a = "\
	aiopsl \
	gpp-aioptool \
	ofp \
"

NETWORK_TOOLS_append_ls2088a = "\
	aiopsl \
	gpp-aioptool \
	ofp \
"

NETWORK_TOOLS_append_fsl-lsch3 = "\
	dce \
	restool \
	spc \
"

RDEPENDS_${PN} = " \
    ${NETWORK_TOOLS} \
"
