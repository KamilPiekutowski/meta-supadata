do_deploy_append() {
    echo "dtoverlay=audioinjector-wm8731-audio" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
    echo "dtoverlay=dtoverlay=i2c-mux,pca9548" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
}
