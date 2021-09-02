DESCRIPTION = "A library to control Raspberry Pi GPIO channels"
HOMEPAGE = "https://projects.drogon.net/raspberry-pi/wiringpi/"
SECTION = "devel/libs"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRCREV = "7f8fe26e4f775abfced43c07657a353f03ddb2d0"

S = "${WORKDIR}/git"

SRC_URI = "\
          git://github.com/WiringPi/WiringPi \
"
DEPENDS += " \
     libxcrypt \
"

COMPATIBLE_MACHINE = "raspberrypi"

CFLAGS_prepend = "-I${S}/wiringPi -I${S}/devLib"

EXTRA_OEMAKE += "'INCLUDE_DIR=${D}${includedir}' 'LIB_DIR=${D}${libdir}'"
EXTRA_OEMAKE += "'DESTDIR=${D}/usr' 'PREFIX=""'"

do_compile() {
    oe_runmake -C wiringPi
    oe_runmake -C wiringPi install
    oe_runmake -C devLib
    oe_runmake -C devLib install
    oe_runmake -C gpio 'LDFLAGS=${LDFLAGS} -L${S}/wiringPi -L${S}/devLib'
    oe_runmake -C gpio install
}

do_install() {
    oe_runmake -C devLib install
    oe_runmake -C wiringPi install
    oe_runmake -C gpio install
}


INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"
