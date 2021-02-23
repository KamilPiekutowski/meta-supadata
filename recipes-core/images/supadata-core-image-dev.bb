# Based on core-image-base
require recipes-core/images/core-image-base.bb

# Only raspberry pi machines
COMPATIBLE_MACHINE = "^rpi$"

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
"
# System audio
IMAGE_INSTALL_append = " \
    libjack \
    jack-server \
    supercollider \
    jack-setup \
    alsa-state \
    alsastate-setup \
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
