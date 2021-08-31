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

SRC_URI = "git://github.com/wargio/spidev.git;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "90ea8395545f08182cd668b234be61b4fcc147a7"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = " \
   'CC=${CC}' \
   'AR=${AR}' \
   'CFLAGS=${CFLAGS}' \
   'CXXFLAGS=”${CXXFLAGS}' \
   'INC=${STAGING_INCDIR}/include' \
   'SO=${STAGING_LIBDIR}' \
   'LIBDIR=${IMAGE_ROOTFS}' \
"


do_compile () {
	oe_runmake
}

do_install () {
	install -d 0755 ${D}/usr/bin
	install -m 0755 ${S}/spidev-example ${D}/usr/bin
	install -m 0755 ${S}/fast-spidev  ${D}/usr/bin
}

INSANE_SKIP_${PN} += "ldflags"

FILES_${NP} = " \
	/usr/bin/* \
"
