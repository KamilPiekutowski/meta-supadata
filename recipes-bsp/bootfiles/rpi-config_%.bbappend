do_deploy_append() {
    echo "dtoverlay=audioinjector-wm8731-audio" >>$CONFIG
    echo "dtoverlay=dtoverlay=i2c-mux,pca9548"  >>$CONFIG
}
