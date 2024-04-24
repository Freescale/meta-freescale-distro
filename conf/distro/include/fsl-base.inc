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
PREFERRED_PROVIDER_virtual/kernel:mx6-nxp-bsp = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel:mx7-nxp-bsp = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel:mx8-nxp-bsp = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel:mx9-nxp-bsp = "linux-imx"

PREFERRED_PROVIDER_linux-imx-mfgtool = "linux-imx-mfgtool"

MACHINE_GSTREAMER_1_0_PLUGIN:mx6-nxp-bsp = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN:mx7-nxp-bsp = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN:mx8-nxp-bsp = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN:mx9-nxp-bsp = "imx-gst1.0-plugin"

# Use i.MX Gstreamer Version
PREFERRED_VERSION_gstreamer1.0              = "1.22.5.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-base = "1.22.5.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-good = "1.22.5.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-bad  = "1.22.5.imx"
PREFERRED_VERSION_ffmpeg                    = "4.4.1"

# Enable allow-autospawn-for-root as default
PACKAGECONFIG:append:pn-pulseaudio = " autospawn-for-root"
