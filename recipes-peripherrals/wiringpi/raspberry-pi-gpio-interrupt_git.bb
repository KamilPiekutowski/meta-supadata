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

SRC_URI = "git://github.com/phil-lavin/raspberry-pi-gpio-interrupt.git;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "e936342284f6446b58ddbcaaf8ec87052a564bab"

S = "${WORKDIR}/git"

DEPENDS += "\
    wiringpi-2.60 \
"

do_compile () {
	oe_runmake
}

do_install () {
	install -d 0775 ${D}/usr/bin
	install -m 0755 ${S}/gpio-interrupt ${D}/usr/bin
}

INSANE_SKIP_${PN} += "ldflags"
