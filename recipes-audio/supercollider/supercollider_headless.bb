SUMMARY = "Programming language for audio synthesis and algorithmic composition"
HOMEPAGE = "http://supercollider.github.io/"
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "gitsm://github.com/supercollider/supercollider.git;branch=develop"
SRCREV = "206f24d865efa37264a0b42594f536ed834c1493"

PV = "3.11.2"
S = "${WORKDIR}/git/"

inherit cmake mime

DEPENDS += " \
    udev \
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
    -DSC_IDE=OFF \
    -DNO_X11=OFF \
    -DSC_QT=OFF \
    ${SIMD_OPTIONS} \
"

FILES_${PN} += " \
    ${datadir}/mime \
    ${datadir}/SuperCollider \
    ${libdir}/SuperCollider/plugins/*.so \
"
INSANE_SKIP_${PN} = "useless-rpaths"
