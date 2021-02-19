FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

LICENSE = "GPL-3.0"

LIC_FILES_CHKSUM = "file://MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += " \
    supercollider \
"

SRC_URI += " \
    file://MIT \
    file://asound.state \
    file://alsa-restore-from-file.service \
"

S = "${WORKDIR}"

inherit systemd allarch

hroot = "/home/root"

do_install_append() {
    install -d 755 ${D}/lib/systemd/system
    install -d 755 ${D}/home/root/.config/alsa

    install -m 755 ${S}/alsa-restore-from-file.service ${D}/lib/systemd/system
    install -m 755 ${S}/asound.state ${D}/home/root/.config/alsa
}

FILES_${PN} = " \
    /lib/systemd/system/alsa-restore-from-file.service \
    /home/root/.config/alsa/asound.state \
"
SYSTEMD_SERVICE_${PN} = "alsa-restore-from-file.service"
