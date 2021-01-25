require conf/distro/include/fslc-base.inc

DISTRO = "fsl-base"
DISTRO_NAME = "FSL Distro Base"
SDK_VENDOR = "-fslsdk"

MAINTAINER = "Freescale Semiconductors <lauren.post@nxp.com>"

TARGET_VENDOR = "-fsl"

DISTROOVERRIDES = "fsl"

# Use NXP BSP for default
IMX_DEFAULT_BSP = "nxp"

# The following set the providers to components supported by NXP
# Use i.MX Kernel, U-Boot and Gstreamer 1.0 providers
PREFERRED_PROVIDER_u-boot_mx6dl = "u-boot-imx"
PREFERRED_PROVIDER_u-boot_mx6q = "u-boot-imx"
PREFERRED_PROVIDER_u-boot_mx6sl = "u-boot-imx"
PREFERRED_PROVIDER_u-boot_mx6sx = "u-boot-imx"
PREFERRED_PROVIDER_u-boot_mx6ul = "u-boot-imx"
PREFERRED_PROVIDER_u-boot_mx6ull = "u-boot-imx"
PREFERRED_PROVIDER_u-boot_mx7d = "u-boot-imx"
PREFERRED_PROVIDER_u-boot_mx7ulp = "u-boot-imx"
PREFERRED_PROVIDER_u-boot_mx8mq = "u-boot-imx"
PREFERRED_PROVIDER_u-boot_mx8mm = "u-boot-imx"
PREFERRED_PROVIDER_u-boot_mx8mn = "u-boot-imx"
PREFERRED_PROVIDER_u-boot_mx8qxp = "u-boot-imx"
PREFERRED_PROVIDER_u-boot_mx8qm = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx6dl = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx6q = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx6sl = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx6sx = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx6ul = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx6ull = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx7d = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx7ulp = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx8mq = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx8mm = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx8mn = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx8qxp = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx8qm = "u-boot-imx"
# u-boot-imx does not use a SPL, override machine configs
UBOOT_MAKE_TARGET = "u-boot.imx"
UBOOT_SUFFIX = "imx"
SPL_BINARY = ""
WKS_FILE = "imx-uboot-bootpart.wks.in"

PREFERRED_PROVIDER_virtual/kernel_mx6dl = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx6q = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx6sl = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx6sx = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx6ul = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx6ull = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx7d = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx7ulp = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx8mq = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx8mm = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx8mn = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx8qxp = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx8qm = "linux-imx"

MACHINE_GSTREAMER_1_0_PLUGIN_mx6dl = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6q = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6sl = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6sx = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6ul = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6ull = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx7d = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx7ulp = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx8mm = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx8mn = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx8mp = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx8mq = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx8qxp = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx8qm = "imx-gst1.0-plugin"

# Use i.MX Gstreamer Version
PREFERRED_VERSION_gstreamer1.0 = "1.16.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-base = "1.16.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-good = "1.16.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-bad = "1.16.imx"

# Enable allow-autospawn-for-root as default
PACKAGECONFIG_append_pn-pulseaudio = " autospawn-for-root"
