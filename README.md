# OpenEmbedded/Yocto Project Distro Layer for NXP's Platforms

This layer provides the Freescale (`fsl-*`) and Freescale Community (`fslc-*`)
distro configurations for use with OpenEmbedded and/or the Yocto Project,
together with [meta-freescale](https://github.com/Freescale/meta-freescale).

This is a backward-compatibility layer. The recipes, packagegroups and
demonstration images it previously carried have moved to meta-freescale, which
is now the single home for that content. `meta-freescale-distro` keeps only the
distro definitions for the wrynose LTS lifetime and is no longer used for recipe
development.

## Distros

Each distro builds on Poky and combines a BSP flavour with a graphics backend:

| Distro | BSP | Graphics | Init manager |
| --- | --- | --- | --- |
| `fslc-framebuffer` | mainline (linux-fslc, u-boot-fslc) | framebuffer | sysvinit (Poky default) |
| `fslc-wayland` | mainline (linux-fslc, u-boot-fslc) | Wayland | systemd |
| `fslc-x11` | mainline (linux-fslc, u-boot-fslc) | X11 | sysvinit (Poky default) |
| `fslc-xwayland` | mainline (linux-fslc, u-boot-fslc) | Wayland with XWayland | systemd |
| `fsl-framebuffer` | NXP | framebuffer | sysvinit (Poky default) |
| `fsl-wayland` | NXP | Wayland | systemd |
| `fsl-xwayland` | NXP | Wayland with XWayland | systemd |

The BSP and graphics settings come from meta-freescale's configuration
fragments (`conf/fragments/bsp/*.conf` and `conf/fragments/graphics/*.conf`).
On top of them, the distros set `TARGET_VENDOR`, `SDK_VENDOR` and the `fsl` or
`fslc` override, use a common ARMv7-A tune for 32-bit machines, and enable
buildhistory.

### Moving to the fragments

New builds can use Poky and enable the same fragments directly instead of one
of these distros, for example:

```sh
bitbake-config-build enable-fragment freescale-layer/bsp/fslc
bitbake-config-build enable-fragment freescale-layer/graphics/wayland
bitbake-config-build enable-fragment freescale-layer/init/systemd
```

That leaves out the vendor strings, the override and the tune listed above.

## Dependencies

This layer depends on:

- URI: https://git.openembedded.org/openembedded-core
  - Branch: master
- URI: https://git.yoctoproject.org/meta-yocto (`meta-poky`)
  - Branch: master
- URI: https://github.com/Freescale/meta-freescale
  - Branch: master

## Quick Start

With the [FSL Community BSP](https://github.com/Freescale/fsl-community-bsp-platform),
pick a machine and a distro when setting up the build directory:

```sh
MACHINE=imx6qdlsabresd DISTRO=fslc-wayland source setup-environment build
bitbake core-image-weston
```

Without it, add the layers to an existing build directory and set `DISTRO` in
`conf/local.conf`:

```sh
bitbake-layers add-layer ../meta-yocto/meta-poky ../meta-freescale ../meta-freescale-distro
echo 'DISTRO = "fslc-wayland"' >> conf/local.conf
```

i.MX 8 and i.MX 9 machines also need the NXP EULA accepted; see
[meta-freescale's EULA section](https://github.com/Freescale/meta-freescale#nxp-end-user-license-agreement).

## Branches

- **master:** Development branch, following the latest Yocto Project release.
- **wrynose:** Associated with Yocto Project 6.0 (LTS).

The layer follows the
[meta-freescale maintenance policy](https://github.com/Freescale/meta-freescale#maintenance-policy).

## Contributing

Please submit any patches against the `meta-freescale-distro` layer by using
the GitHub pull-request feature. Fork the repo, create a branch, do the work,
rebase from upstream, and then create the pull request.

Follow the
[Yocto Project Contributor Guide](https://docs.yoctoproject.org/contributor-guide/submit-changes.html)
for commit messages: prefix the subject with the file or component name and add
a `Signed-off-by` line.

## Communication

- **GitHub Issues:** [meta-freescale-distro issues](https://github.com/Freescale/meta-freescale-distro/issues)
- **Pull Requests:** [meta-freescale-distro pull requests](https://github.com/Freescale/meta-freescale-distro/pulls)
- **Mailing list:** [meta-freescale](https://lists.yoctoproject.org/g/meta-freescale)

## Security

See [SECURITY.md](SECURITY.md) for how to report vulnerabilities.

## License

The layer's distro configuration metadata is licensed under the MIT license;
see [LICENSE](LICENSE).

## Maintainer

Otavio Salvador <otavio.salvador@ossystems.com.br>
