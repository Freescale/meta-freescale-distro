include recipes-core/images/core-image-base.bb

# Add extra image features
IMAGE_FEATURES += " \
    nfs-server \
    tools-debug \
    tools-profile \
    tools-testapps \
"

# Tools used for benchmark
BENCHMARK_TOOLS = " \
    lmbench \
    bonnie++ \
    cpuburn-neon \
    dbench \
    fio \
    iozone3 \
    iperf \
    memtester \
    nbench-byte \
    netperf \
    tiobench \
"

# Test applicationsx
TEST_TOOLS = " \
    i2c-tools \
    imx-test \
"

IMAGE_INSTALL += " \
    ${BENCHMARK_TOOLS} \
    ${TEST_TOOLS} \
    task-fsl-gstreamer \
"

export IMAGE_BASENAME = "fsl-test-image"
