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

SRC_URI = "git://github.com/KamilPiekutowski/ArduiPi_SSD1306.git;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "03f6078cab26a7243d131ec392e2c75797edee63"

S = "${WORKDIR}/git"

DEPEND += " \
    i2c-dev \
    i2c-tools \
"

PREFIX = "/usr"

TARGET_CC_ARCH += "${LDFLAGS}"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}


do_install () {
	# This is a guess; additional arguments may be required
	oe_runmake install 'DESTDIR=${D}'

        install -m 0755 ${S}/libssd1306.so.1.0 ${D}/usr/lib

	lnr ${D}/usr/lib/libssd1306.so.1.0 ${D}/usr/lib/libssd1306.so.1
	lnr ${D}/usr/lib/libssd1306.so.1 ${D}/usr/lib/libssd1306.so
        rm -rf ${S}/lib*
}


FILES_${PN} = " \
	${PREFIX}/include \
	${PREFIX}/include/Adafruit_SSD1306.h \
	${PREFIX}/include/ArduiPi_SSD1306.h \
	${PREFIX}/include/Adafruit_GFX.h \
	${PREFIX}/include/bcm2835.h \
	${PREFIX}/lib/libssd1306.so.1.0 \
	${PREFIX}/lib/libssd1306.so.1 \
"
FILES_${PN}-dev = " \
	${PREFIX}/lib/libssd1306.so \
"
