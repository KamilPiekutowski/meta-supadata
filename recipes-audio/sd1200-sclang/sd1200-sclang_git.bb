# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://github.com/KamilPiekutowski/SD1200_SCLANG.git;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "1c0850ac86ff06a786149fefb38c19481341e2ae"

S = "${WORKDIR}/git"

prefix="/usr/share/SuperCollider/"

# NOTE: no Makefile found, unable to determine what needs to be done

do_install () {
    install -d 0755 ${D}/usr/share/SuperCollider/Extensions
    install -d 0755 ${D}/usr/share/SuperCollider/Examples
    install -m 0755 ${S}/Extensions/* ${D}/usr/share/SuperCollider/Extensions
    install -m 0755 ${S}/Examples/* ${D}/usr/share/SuperCollider/Examples
}

INSANE_SKIP_${PN} += "ldflags"

DEPENDS += "\
    supercollider \
"

FILES_${PN} = " \
  /usr/share/SuperCollider/Extensions/* \
  /usr/share/SuperCollider/Examples/* \
"
