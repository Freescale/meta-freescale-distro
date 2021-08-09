require conf/distro/include/fslc-base.inc

DISTRO = "fsl-base"
DISTRO_NAME = "FSL Distro Base"
SDK_VENDOR = "-fslsdk"

MAINTAINER = "Freescale Semiconductors <lauren.post@nxp.com>"

TARGET_VENDOR = "-fsl"

DISTROOVERRIDES = "fsl"

# Use NXP BSP and u-boot for default
IMX_DEFAULT_BSP = "nxp"
IMX_DEFAULT_BOOTLOADER = "u-boot-imx"

# The following set the providers to components supported by NXP
# Use i.MX Kernel and Gstreamer 1.0 providers
PREFERRED_PROVIDER_virtual/kernel:mx6dl = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel:mx6q = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel:mx6sl = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel:mx6sx = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel:mx6ul = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel:mx6ull = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel:mx7d = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel:mx7ulp = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel:mx8 = "linux-imx"

PREFERRED_PROVIDER_linux-imx-mfgtool = "linux-imx-mfgtool"

MACHINE_GSTREAMER_1_0_PLUGIN:mx6dl = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN:mx6q = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN:mx6sl = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN:mx6sx = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN:mx6ul = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN:mx6ull = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN:mx7d = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN:mx7ulp = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN:mx8 = "imx-gst1.0-plugin"

# Use i.MX Gstreamer Version
PREFERRED_VERSION_gstreamer1.0 = "1.16.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-base = "1.16.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-good = "1.16.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-bad = "1.16.imx"

# Enable allow-autospawn-for-root as default
PACKAGECONFIG:append:pn-pulseaudio = " autospawn-for-root"
