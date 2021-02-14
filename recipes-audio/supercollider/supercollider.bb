SUMMARY = "Programming language for audio synthesis and algorithmic composition"
HOMEPAGE = "http://supercollider.github.io/"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = " \
    gitsm://github.com/supercollider/supercollider.git \
    file://0001-server-supernova-utilities-time_tag.hpp-Adding-stati.patch \
    file://0002-Workaround-build-errors-on-musl-libc.patch \
"
SRCREV = "834c036d3519337d409277d13f15f321759c5756"
PV = "3.10.2"
S = "${WORKDIR}/git/"

inherit cmake distro_features_check mime

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    eudev \
    fftw \
    jack \
    jack-setup \
    libsndfile1 \
    alsa-lib \
    libxt \
"

SIMD_OPTIONS ??= " \
    -DSSE=OFF \
    -DSSE2=OFF \
"

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE=Release \
    -DSUPERNOVA=OFF \
    -DSC_ED=OFF \
    -DSC_EL=OFF \
    -DSC_VIM=ON \
    -DSC_IDE=OFF \
    -DNO_X11=ON \
    -DSC_QT=OFF \
    ${SIMD_OPTIONS} \
"

FILES_${PN} += " \
    ${datadir}/mime \
    ${datadir}/SuperCollider \
    ${libdir}/SuperCollider/plugins/*.so \
"
INSANE_SKIP_${PN} = "useless-rpaths"
