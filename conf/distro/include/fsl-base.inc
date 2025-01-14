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

PREFERRED_VERSION_ffmpeg                    = "4.4.1"

# GStreamer forked recipes
PREFERRED_VERSION_gstreamer1.0:mx8-nxp-bsp              ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-bad:mx8-nxp-bsp  ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-base:mx8-nxp-bsp ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-good:mx8-nxp-bsp ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0:mx9-nxp-bsp              ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-bad:mx9-nxp-bsp  ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-base:mx9-nxp-bsp ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-good:mx9-nxp-bsp ??= "1.24.0.imx"

# GStreamer copied recipes
PREFERRED_VERSION_gst-devtools:mx8-nxp-bsp              ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-libav:mx8-nxp-bsp        ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-ugly:mx8-nxp-bsp ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-python:mx8-nxp-bsp       ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-rtsp-server:mx8-nxp-bsp  ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-vaapi:mx8-nxp-bsp        ??= "1.24.0.imx"
PREFERRED_VERSION_gst-devtools:mx9-nxp-bsp              ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-libav:mx9-nxp-bsp        ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-ugly:mx9-nxp-bsp ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-python:mx9-nxp-bsp       ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-rtsp-server:mx9-nxp-bsp  ??= "1.24.0.imx"
PREFERRED_VERSION_gstreamer1.0-vaapi:mx9-nxp-bsp        ??= "1.24.0.imx"

# Enable allow-autospawn-for-root as default
PACKAGECONFIG:append:pn-pulseaudio = " autospawn-for-root"
