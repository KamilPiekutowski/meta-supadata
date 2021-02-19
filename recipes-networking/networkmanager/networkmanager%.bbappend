FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "\
    file://static.nmconnection \
"

do_install_append() {
    install -m 0600 ${WORKDIR}/static.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections
}
