package com.youku.phone.player;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import com.youku.phone.common.ChannelActivityRes;
import com.youku.phone.common.ManageApp;

public class PlayVideosTest extends UiAutomatorTestCase{
	
	/*
	 * 启动App
	 */
	protected void youkuSetUp() throws UiObjectNotFoundException{
		ManageApp.launchYoukuApp();
	}
	/*
	 * 退出App
	 */
	protected void youkuTearDown(){
		UiObject Applications = new UiObject(new UiSelector().description("应用程序"));
		while(!Applications.exists()){
			getUiDevice().pressBack();
		}
	}
	/*
	 * 播放频道页全部分类视频
	 */
	public void playChannelVideos() throws UiObjectNotFoundException{
		UiObject tvList;//频道视图
        int tvListCount = 0;//当前视图下视频个数
        UiObject singleTv = null;//单个视频
        UiSelector singleTvSelector;
        UiScrollable scrollTvList;//被滑动对象
        boolean isScrollable;
        String videoName = null;//当前播放视频名称
        UiObject textObject;//视频名称的对象
        
		//获取频道id
		tvList = new UiObject(new UiSelector().resourceId(ChannelActivityRes.channelTotalId));
		//获取当前视图频道个数
		tvListCount = tvList.getChildCount();
		System.out.println("当前频道页可见视频："+tvListCount+"个");
		System.out.println("开始播放视频......");
		for (int i=0;i<tvListCount;i++){
			System.out.println("视频播放计数器："+i);
			singleTvSelector = new UiSelector().index(i);
			singleTv = tvList.getChild(singleTvSelector);
			//获取视频标题对象
//			textObject = singleTv.getChild(new UiSelector().index(1)).getChild(new UiSelector().index(0));
//			videoName = textObject.getText();
//			System.out.println("当前播放："+videoName);
			singleTv.clickAndWaitForNewWindow();
			sleep(10000);
			getUiDevice().pressBack();
		}
		//获取被滑动对象
		scrollTvList = new UiScrollable(new UiSelector().resourceId(ChannelActivityRes.channelTotalId));
		scrollTvList.setAsVerticalList();
		//向下滑动
		isScrollable = scrollTvList.scrollForward();
		System.out.println("向下滑动......");
		while(isScrollable){
			System.out.println("继续播放视频......");
			for (int i=0;i<tvListCount;i++){
				System.out.println("视频播放计数器："+i);
				singleTvSelector = new UiSelector().index(i);
				singleTv = tvList.getChild(singleTvSelector);
//				singleTv = tvList.getChild(new UiSelector().index(i));
				//获取视频标题对象
//				textObject = singleTv.getChild(new UiSelector().index(1)).getChild(new UiSelector().index(0));
//				videoName = textObject.getText();
//				System.out.println("当前播放："+videoName);
				singleTv.clickAndWaitForNewWindow();
				sleep(10000);
				getUiDevice().pressBack();
			}
			isScrollable = scrollTvList.scrollForward();
			System.out.println("向下滑动......");
		}   
	}
	/*
	 * 封装测试函数，方便写测试用例
	 */
	public void enterChannelAndPlayVideos(String channelName) throws UiObjectNotFoundException{
		youkuSetUp();
		sleep(6000);
		try{
			ManageApp.enterChannelCategory(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("游戏弹窗！");
			getUiDevice().pressBack();
			ManageApp.enterChannelCategory(channelName);
		}
		playChannelVideos();
		youkuTearDown();
	}
	
	/*
	 * 播放电视剧频道视频
	 */
	public void testPlayTVChannel() throws UiObjectNotFoundException{
		String channelName = "电视剧";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放电影频道视频
	 */
	public void testPlayMovieChannel() throws UiObjectNotFoundException{
		String channelName = "电影";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放综艺频道视频
	 */
	public void testPlayVarietyChannel(){
		String channelName = "综艺";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放动漫频道视频
	 */
	public void testPlayCartoonChannel() throws UiObjectNotFoundException{
		String channelName = "动漫";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放音乐频道视频
	 */
	public void testPlayMusicChannel() throws UiObjectNotFoundException{
		String channelName = "音乐";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放教育频道视频
	 */
	public void testPlayEducationChannel() throws UiObjectNotFoundException{
		String channelName = "教育";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放纪录片频道视频
	 */
	public void testPlayDocumentaryChannel() throws UiObjectNotFoundException{
		String channelName = "纪录片";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放资讯频道视频
	 */
	public void testPlayInformationChannel() throws UiObjectNotFoundException{
		String channelName = "资讯";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放娱乐频道视频
	 */
	public void testPlayEntertainmentChannel() throws UiObjectNotFoundException{
		String channelName = "娱乐";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放原创频道视频
	 */
	public void testPlayOriginalChannel() throws UiObjectNotFoundException{
		String channelName = "原创";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放体育频道视频
	 */
	public void testPlaySportsChannel() throws UiObjectNotFoundException{
		String channelName = "体育";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放汽车频道视频
	 */
	public void testPlayAutomobileChannel() throws UiObjectNotFoundException{
		String channelName = "汽车";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放科技频道视频
	 */
	public void testPlayScienceChannel() throws UiObjectNotFoundException{
		String channelName = "科技";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放生活频道视频
	 */
	public void testPlayLifeChannel() throws UiObjectNotFoundException{
		String channelName = "生活";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放时尚频道视频
	 */
	public void testPlayFashionChannel() throws UiObjectNotFoundException{
		String channelName = "时尚";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放旅游频道视频
	 */
	public void testPlayTravelChannel(){
		String channelName = "旅游";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
	
	/*
	 * 播放广告频道视频
	 */
	public void testPlayAdvertisementChannel() throws UiObjectNotFoundException{
		String channelName = "广告";
		System.out.println("开始播放："+channelName+"频道视频......");
		try{
			enterChannelAndPlayVideos(channelName);
		}catch (UiObjectNotFoundException e){
			System.out.println("播放"+channelName+"频道视频出错！");
			e.printStackTrace();
		}finally{
			youkuTearDown();
		}
	}
}
