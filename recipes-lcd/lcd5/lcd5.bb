SUMMARY = "Programming language for audio synthesis and algorithmic composition"
HOMEPAGE = "http://supercollider.github.io/"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " \
    gitsm://github.com/goodtft/LCD-show.git \
"

SRCREV = "82667a3dac504bd4afa07f355621c152321ad3b4"

PV = "2.1"

S = "${WORKDIR}/git"

do_compile() {
    ./LCD5-show
}

do_install() {
   install -d ${D}/boot
   install -m 755 ${S}/boot/config-nomal.txt ${D}/boot
}

FILES_${PN} = "${S}/boot/config.txt"

