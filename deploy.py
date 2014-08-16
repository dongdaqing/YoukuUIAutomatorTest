__author__ = 'dongdaqing'

import os

class Deploy(object):
    
    def __init__(self):
       self.project_path = os.getcwd();
       self.single_test_suite_name = "com.youku.phone.adv.AdvSkippingTest"
       self.play_videos_test = "com.youku.phone.player.PlayVideosTest"

    def run_single_test_suite(self):
        os.system("ant build")
        os.system("adb push {0}/bin/YoukuMobileTest.jar /data/local/tmp".format(self.project_path))
        # os.system("adb shell uiautomator runtest YoukuMobileTest.jar -c {0}".format(self.single_test_suite_name))
        os.system("adb shell uiautomator runtest YoukuMobileTest.jar -c {0}".format(self.play_videos_test))
        
if __name__ == '__main__':
    
    obj_deploy = Deploy()
    obj_deploy.run_single_test_suite()
