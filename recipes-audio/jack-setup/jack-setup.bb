FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " \
    file://MIT \
    file://limits.conf \
    file://.jackdrc \
 "

S = "${WORKDIR}"

inherit allarch

DEPENDS_appent = " \
    jack \
"
IMAGE_INSTALL_append  = " \
    jack-server \
    jack-utils \
"

etcsecr = "/etc/security" 
hroot = "/home/root"

do_install_append() {
    install -d 755 ${D}${etcsecr}
    install -d 755 ${D}${hroot}

    install -m 755 ${S}/limits.conf ${D}${etcsecr}
    install -m 755 ${S}/.jackdrc ${D}${hroot}
}


FILES_${PN} = " \
    ${etcsecr}/limits.conf \
    ${hroot}/.jackdrc \
"

