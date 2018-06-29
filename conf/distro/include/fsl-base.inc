require conf/distro/include/fslc-base.inc

DISTRO = "fsl-base"
DISTRO_NAME = "FSL Distro Base"
SDK_VENDOR = "-fslsdk"

MAINTAINER = "Freescale Semiconductors <lauren.post@nxp.com>"

TARGET_VENDOR = "-fsl"

DISTROOVERRIDES = "fsl"

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

UBOOT_SUFFIX_mx6 = "imx"
SPL_BINARY_mx6 = ""
UBOOT_MAKE_TARGET_mx6 = "u-boot.imx"
WKS_FILE = "imx-uboot-bootpart.wks"


PREFERRED_PROVIDER_virtual/bootloader_mx6dl = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx6q = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx6sl = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx6sx = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx6ul = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx6ull = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx7d = "u-boot-imx"
PREFERRED_PROVIDER_virtual/bootloader_mx7ulp = "u-boot-imx"

PREFERRED_PROVIDER_virtual/kernel_mx6dl = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx6q = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx6sl = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx6sx = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx6ul = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx6ull = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx7d = "linux-imx"
PREFERRED_PROVIDER_virtual/kernel_mx7ulp = "linux-imx"

MACHINE_GSTREAMER_1_0_PLUGIN_mx6dl = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6q = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6sl = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6sx = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6ul = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx6ull = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx7d = "imx-gst1.0-plugin"
MACHINE_GSTREAMER_1_0_PLUGIN_mx7ulp = "imx-gst1.0-plugin"

# Use i.MX Gstreamer Version
PREFERRED_VERSION_gstreamer1.0 = "1.12.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-base = "1.12.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-good = "1.12.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-bad = "1.12.imx"

# Use i.MX libdrm Version
PREFERRED_VERSION_libdrm = "2.4.84.imx"
