package com.youku.phone.common;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class ManageApp extends UiAutomatorTestCase{
	
	public static void launchYoukuApp() throws UiObjectNotFoundException{
		UiObject Applications = new UiObject(new UiSelector().description("应用程序"));
		Applications.clickAndWaitForNewWindow();
		UiScrollable ListOfapplications = new UiScrollable(new UiSelector().scrollable(true));
		UiScrollable MoveList = ListOfapplications.setAsHorizontalList();
		UiObject Youku = ListOfapplications.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"优酷");
		Youku.clickAndWaitForNewWindow();
	}
	
	public void exitYoukuApp() throws UiObjectNotFoundException{
		UiObject Applications = new UiObject(new UiSelector().description("应用程序"));
		while(!Applications.exists()){
			getUiDevice().pressBack();
		}
	}
	/*
	 * 进入频道页的全部分类
	 */
	public static void enterChannelCategory(String channelName) throws UiObjectNotFoundException{
		
		UiObject enterChannel;//首页频道分类
		UiObject channelCategory;//各种频道分类对象
		UiObject channelItem;	//具体频道类型	
		UiScrollable scrollChannelView;//被滑动对象
		UiObject totalCategory;
		
		enterChannel = new UiObject(new UiSelector().text(ChannelActivityRes.channelCategoryName));
		enterChannel.click();
		//点击电视剧频道
		channelCategory = new UiObject(new UiSelector().resourceId(ChannelActivityRes.channelCategoryId));
		//设置滑动对象
		scrollChannelView = new UiScrollable(new UiSelector().resourceId(ChannelActivityRes.channelScrollView));
		scrollChannelView.setAsVerticalList();
		//根据滑动对象查找字段
//		channelItem = scrollChannelView.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()), channelName);
		channelItem = scrollChannelView.getChildByText(new UiSelector().text(channelName),channelName,true);
//		channelItem = channelCategory.getChild(new UiSelector().text(channelName));
		//进入频道页
		channelItem.clickAndWaitForNewWindow();
		//点击全部分类
		assertNotNull("未显示全部字段",ChannelActivityRes.channelTotalId);
		totalCategory = new UiObject(new UiSelector().text("全部"));
		totalCategory.clickAndWaitForNewWindow();
	}

}
