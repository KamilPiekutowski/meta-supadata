SUMMARY = " \
    Sets up jack for supercollider on raspbery pi \
    based on this giude: \
    https://github.com/supercollider/supercollider/blob/develop/README_RASPBERRY_PI.md \
"
HOMEPAGE = "https://github.com/KamilPiekutowski/meta-supadata/blob/main/README.md"
LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=b97a012949927931feb7793eee5ed924"

SRC_URI += " \
    file://limits.conf \
    file://.jackdrc \
 "

S = "${WORKDIR}"

inherit allarch

do_install() {
    install -d ${D}/etc/security
    install -d ${D}/home/root
    install -m 755 ${WORKDIR}/limits.conf ${D}/etc/security
    install -m 755 ${WORKDIR}/.jackdrc ${D}/home/root
}

FILES_${PN} = " \
    /etc/security \
    /home/root \
    /etc/security/limits.conf \
    /home/root/.jackdrc \
"
