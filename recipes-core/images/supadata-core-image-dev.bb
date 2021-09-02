# Based on core-image-base
require recipes-core/images/core-image-base.bb

# Only raspberry pi machines
COMPATIBLE_MACHINE = "^rpi$"

# Qt5 SDK
inherit populate_sdk_qt5

# rasync
IMAGE_INSTALL_append = " \
    rsync \
"

# Rpi pin-header connectivity
ENABLE_UART = "1"
ENABLE_I2C = "1"
ENABLE_I2S = "1"
ENABLE_SPI_BUS = "1"

# System utils
IMAGE_INSTALL_append = " \
    dpkg \
    htop \
    bash \
    vim \
    i2c-tools \
    arduipi-ssd1306 \
    oled-test \
    wiringpi-2.60 \
    raspberry-pi-gpio-interrupt \
    spidev-example \
"
# System audio
IMAGE_INSTALL_append = " \
    liblo \
    libjack \
    jack-server \
    supercollider \
    sd1200-sclang \
    jack-setup \
    alsa-state \
    alsastate-setup \
    alsa-utils \
"

# Networking
IMAGE_INSTALL_append = " \
    networkmanager \
    networkmanager-nmtui \
    networkmanager-bash-completion \
"
# SSH
IMAGE_FEATURES_append = " \
    ssh-server-dropbear \
"

# QT modules
IMAGE_INSTALL_append = " \
    qtquickcontrols \
    qtquickcontrols2 \
    qtgraphicaleffects \
    qtbase-plugins \
    qtbase-tools \
    qtdeclarative \
    qtdeclarative-plugins \
    qtdeclarative-tools \
    qtdeclarative-qmlplugins \
    qtmultimedia \
    qtmultimedia-plugins \
    qtmultimedia-qmlplugins \
    qtimageformats-plugins \
    qtsystems \
    qtsystems-tools \
    qtsystems-qmlplugins \
    qtscript \
    qt3d \
    qt3d-qmlplugins \
    qt3d-tools \
    qtconnectivity-dev \
    qtconnectivity-mkspecs \
    qtconnectivity-qmlplugins \
    qtlocation-plugins \
    qtlocation-qmlplugins \
    qtquickcontrols-qmlplugins \
"
