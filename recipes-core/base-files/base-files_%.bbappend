do_install_append() {
    echo ""  >> ${D}${sysconfdir}/fstab
    echo "/dev/mmcblk0p1    /boot                vfat       errors=remount-ro,auto,exec,rw,user 0  0"  >> ${D}${sysconfdir}/fstab
}
