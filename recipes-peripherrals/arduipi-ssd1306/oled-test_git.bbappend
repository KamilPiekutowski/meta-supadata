FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-set-demo-to-run-I2C-as-default-and-added-.gitignore.patch \
            file://0001-removed-unnecessary-printf-statement.patch \
            file://0001-added-spidev_test.patch \
            file://0001-updated-.gitignore.patch \
            "

