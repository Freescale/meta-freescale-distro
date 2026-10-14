#!/bin/sh
# Run oelint-adv over this layer. Requires oelint-adv on PATH.
#
# All linter configuration is declarative and lives at the layer root, so this
# script only has to enumerate the files (oelint-adv does not recurse into
# directories). The layer's own conf/**/*.conf are included, and '--mode all'
# set below, so the machine, distro and layer.conf rules run too:
#   * .oelint.cfg           - sets '--release' and any layer-wide suppression;
#                             auto-loaded from the working directory
#   * oelint.constants.json - the layer constant-DB additions, auto-loaded by
#                             oelint-adv from the layer root (no --constantmods).
#                             The lookup walks up from each file's path, so it
#                             needs './'-prefixed or absolute paths, which
#                             'find .' gives; a bare 'recipes-x/x.bb' skips it.
#
# Exceptions stay inline as '# nooelint: <rule.id>' comments next to the finding,
# so new recipes are always fully linted and each exception is documented in place
# (and flagged by oelint.file.inlinesuppress_na once stale). The only layer-wide
# suppression normally justified is oelint.var.bbclassextend for target-only
# layers (set it in .oelint.cfg, not here).
set -eu

# Neutralise CDPATH so 'cd' below can't print or jump to an unexpected dir.
unset CDPATH
# A personal $OELINT_CONFIG is read BEFORE ./.oelint.cfg and replaces it, so the
# result would depend on who runs the script.
unset OELINT_CONFIG

here=$(cd -- "$(dirname -- "$0")" && pwd)
layer=$(cd -- "$here/../.." && pwd)

# Run from the layer root so '.oelint.cfg' (probed in the working directory) and
# 'oelint.constants.json' (probed in the file's layer root) are both picked up.
cd -- "$layer"

# oelint-adv ignores a lone *.inc and lints it through the recipes that require
# it; listing them is harmless.
files=$(find . \
    \( -name '*.bb' -o -name '*.bbappend' -o -name '*.bbclass' -o -name '*.inc' \
       -o \( -path './conf/*' -name '*.conf' \) \) \
    | sort)

# Run serially: older oelint-adv releases emitted false "unknown variable/override"
# findings in parallel runs (9.11.2 loads the constants before forking and has
# not). Serial is cheap insurance. Pass '--jobs N' to override.
#
# '--mode all': the default 'fast' mode lints conf/machine/*.conf and
# conf/distro/*.conf not at all (core.py group_files collects them only in 'all'
# mode) and evaluates each conditional on its true side only, so every
# 'branch:false' finding is missing. Pass '--mode fast' to override.
# shellcheck disable=SC2086
exec oelint-adv --jobs 1 --mode all "$@" $files
