do_deploy_append() {
    echo "dtoverlay=audioinjector-wm8731-audio" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
}
