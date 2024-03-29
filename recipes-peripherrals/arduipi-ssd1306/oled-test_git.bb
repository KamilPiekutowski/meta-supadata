# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c2f7519471c49aebd6646cc1f67eac68"

SRC_URI = "git://github.com/KamilPiekutowski/oled_test.git;protocol=https;branch=main \
"
# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "da07d25ae8024a37a1d45a33111781e9bbca7146"

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

do_install () {
    install -d 0755 ${D}/usr/bin
    install -m 0755 ${S}/ssd1306_demo ${D}/usr/bin
    install -m 0755 ${S}/spidev_test ${D}/usr/bin
}

INSANE_SKIP_${PN} += "ldflags"

DEPENDS += "\
    arduipi-ssd1306 \
    i2c-tools \
"

RDEPENDS_${NP} = " \
    libssd1306.so.1.0 \
"

FILES_${NP} = " \
    /usr/bin \
    /usr/bin/ssd1306_demo \
    /usr/bin/spidev_test \
"

INSANE_SKIP_${PN} += "arduipi-ssd1306-dev"
