package com.youku.phone.adv;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import com.youku.phone.common.ManageApp;
import com.youku.phone.common.ChannelActivityRes;
import com.youku.phone.common.DetailActivityRes;


public class AdvSkippingTest extends UiAutomatorTestCase{
	
	//启动App
	protected void youkuSetUp() throws UiObjectNotFoundException{
		ManageApp.launchYoukuApp();
	}
	//退出App
	protected void youkuTearDown(){
		UiObject Applications = new UiObject(new UiSelector().description("应用程序"));
		while(!Applications.exists()){
			getUiDevice().pressBack();
		}
	}
	
	public void testClickFrontAdv() throws UiObjectNotFoundException{
		
		youkuSetUp();
		//去掉弹窗
		sleep(6000);
//		getUiDevice().pressBack();
		//点击频道分类
		UiObject enterChannel = new UiObject(new UiSelector().text(ChannelActivityRes.channelCategoryName));
		enterChannel.click();
		//点击电视剧
		UiObject channel = new UiObject(new UiSelector().resourceId(ChannelActivityRes.channelCategoryId));
		UiObject channelItem = channel.getChild(new UiSelector().index(1));
		channelItem.clickAndWaitForNewWindow();
		//点击电视剧频道第一个视频
		UiObject channelTV = new UiObject(new UiSelector().resourceId(ChannelActivityRes.channelTotalId));
		UiObject channelTVItem = channelTV.getChild(new UiSelector().index(0));
		channelTVItem.clickAndWaitForNewWindow();
		//点击全屏广告
//		UiObject adv = new UiObject(new UiSelector().resourceId(DetailActivityRes.fullScreenAdvId));
//		adv.waitForExists(10000);
//		adv.clickAndWaitForNewWindow();
		//浏览器返回客户端
//		getUiDevice().pressBack();
		youkuTearDown();
	}
}
