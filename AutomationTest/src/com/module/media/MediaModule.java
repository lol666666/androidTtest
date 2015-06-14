
package com.module.media;

import java.io.File;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.module.common.CommonModule;
import com.sonyericsson.test.acceptancetest.AcceptanceTestCase;

import android.content.ComponentName;
import android.graphics.Rect;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;

public class MediaModule implements IMedia{
    AcceptanceTestCase testCase;

    CommonModule commonModule;

    String TAG = "Reliability";

    public MediaModule(AcceptanceTestCase testCase){
        this.testCase = testCase;
        this.commonModule = new CommonModule(testCase);
    }

	@Override
	public void launchRadioPlayer() {
		commonModule.backOutToHomeScreen();
		testCase.launchApp("com.sonyericsson.fmradio",
				"com.sonyericsson.fmradio.ui.FmRadioActivity");
		commonModule.wait(2);
		if(!commonModule.isResourceId("com.sonyericsson.fmradio:id/frequency_text_indicator")){
		    commonModule.waitForResourceId("com.sonyericsson.fmradio:id/frequency_text_indicator", 10*1000);
		}
//		Assert.assertTrue("Please insert headset first before test.",
//				isHeadsetConnectedAPI());
	}

    public void launchYouTube() throws UiObjectNotFoundException {
        testCase.launchApp("com.google.android.youtube",
                "com.google.android.apps.youtube.app.WatchWhileActivity");
        commonModule.wait(5);

        if (commonModule.isTextExists("Not now")) {
            commonModule.clickText("Not now");
            commonModule.wait(2);
        }

        if (commonModule.isTextExists("Sign in")) {
            commonModule.clickResourceId("android:id/home");
            commonModule.wait(2);
        }

        for (int i = 0; i < 20; i++) {
            if (commonModule.isResourceId("com.google.android.youtube:id/load_progress")) {
                commonModule.wait(3);
            } else if (commonModule.isResourceId("android:id/action_bar_title")
                    && commonModule.isResourceId("com.google.android.youtube:id/card")) {
                break;
            } else if (i == 19) {
                testCase.failTest("Poor network!");
            } else if (commonModule
                    .isTextExists("There's no network connection right now. Try again later.")) {
                testCase.failTest("No network connect!");
            }
        }

        AcceptanceTestCase.assertTrue("Launch YouTube failed.",
                commonModule.waitForDescription("Search", 3000));
    }

    @Override
    public boolean isHeadsetConnectedAPI() {
        AudioManager audioManager = null;
        return audioManager.isWiredHeadsetOn();

    }

	@Override
	public void playRadioOnBackground() {
		launchRadioPlayer();
		testCase.pressKey(KeyEvent.KEYCODE_HOME);
	}

	@Override
	public void stopRadio() throws UiObjectNotFoundException {
	    commonModule.backOutToHomeScreen();
		testCase.openNotification();
		commonModule.clickText("Notifications");
		if(testCase.isViewWithIdPresent("shutDown")){
		testCase.clickId("shutDown");
		}
		commonModule.backOutToHomeScreen();
	}

	public void launchVideoPlayer() {
		commonModule.backOutToHomeScreen();
		testCase.launchApp("com.sonyericsson.video",
				"com.sonyericsson.video.browser.BrowserActivity");
		commonModule.wait(2);
		}

	public void playVideo(String videoName) {
        if (testCase.isViewWithIdPresent("button2")){
        	testCase.clickId("button2");
        }
        commonModule.wait(2);
        if (testCase.isViewWithIdPresent("more_text")) {
            testCase.clickId("more_text");
        }
        commonModule.wait(2);
        boolean ishas = false;
        for(int i = 0; i<14; i++){
            if(testCase.isViewWithTextPresent(videoName)){
            	testCase.click(videoName);
                ishas = true;
                break;
            }
            commonModule.wait(1);
            testCase.scrollDown();
            commonModule.wait(1);
        }
        if (!ishas) {
        	commonModule.backOutToHomeScreen();
        	AcceptanceTestCase.assertTrue(false);
        }

        commonModule.wait(2);
        if (testCase.isViewWithTextPresent("Cannot play video.")) {
        	testCase.click("OK");
        	commonModule.wait(2);
        	commonModule.backOutToHomeScreen();
        	AcceptanceTestCase.assertTrue(false);
        }
        extendFullScreen();
	}

	public void playVideoURL(File dir,String videoName) {
        Log.i(TAG,"Play video: "+videoName);
        File videoFile = new File(dir, videoName);
        Intent launchIntent = new Intent(Intent.ACTION_VIEW);
        launchIntent.setComponent(new ComponentName("com.sonyericsson.video",
                "com.sonyericsson.video.player.PlayerActivity"));
        launchIntent.setDataAndType(Uri.fromFile(videoFile), "video/*");
        launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        testCase.getInstrumentation().getContext().startActivity(launchIntent);

	       //Check video playing normal
	         if (!testCase.isViewWithIdPresent("video_surface_view") && !testCase.isViewWithIdPresent("video_view")) {
	         	commonModule.backOutToHomeScreen();
	         	AcceptanceTestCase.assertTrue("Video cannot play",false);
	         	}
	}

	public void fastForwardAndRewind(String videoName){

		int[] screen = testCase.getScreenSize();

		commonModule.wait(10);
		//Fast foward
		testCase.clickPoint(commonModule.getX(500),commonModule.getY(500));
		commonModule.wait(1);
		testCase.clickPoint((int)(screen[0] * 0.8),commonModule.getY(1100));
		commonModule.wait(10);

		//Rewind
		testCase.clickPoint(commonModule.getX(500),commonModule.getY(500));
		commonModule.wait(1);
		testCase.clickPoint((int)(screen[0] * 0.4),commonModule.getY(1100));

		//Check video playing normal
    if (!testCase.isViewWithIdPresent("video_surface_view") && !testCase.isViewWithIdPresent("video_view")) {
    	commonModule.backOutToHomeScreen();
    	AcceptanceTestCase.assertTrue("Video cannot play",false);
    }else if(testCase.isViewWithTextPresent("Watch Next")){
    	playVideo(videoName);
    }
	}

	public void extendFullScreen(){
		testCase.clickPoint(commonModule.getX(300),commonModule.getY(200));
	}

	public void waitVideoPlaying() throws UiObjectNotFoundException{
		commonModule.wait(3);
		//Get the video time
		testCase.clickPoint(commonModule.getX(500),commonModule.getY(500));
		testCase.clickPoint(commonModule.getX(100),commonModule.getY(1100));
		String videoTime = new UiObject(
                new UiSelector().resourceId("com.sonyericsson.video:id/video_timing_info")).getText();

		String[] subTime = videoTime.split("/")[1].split(":");

		int Times=0;
		if(subTime.length==2){
			int minute0=(int)(Integer.valueOf(subTime[0].trim())) * 60;
			int second0=(int)(Integer.valueOf(subTime[1].trim()));
			Times=minute0 + second0;
		}else if(subTime.length==3){
			int hour1=(int)(Integer.valueOf(subTime[0].trim())) * 3600;
			int minute1=(int)(Integer.valueOf(subTime[1].trim())) * 60;
			int second1=(int)(Integer.valueOf(subTime[2].trim()));
			Times=hour1 + minute1 + second1;
		}else{
			AcceptanceTestCase.assertTrue(false);
		}
		testCase.clickId("video_play_button");
		commonModule.wait(Times);
		Log.i(TAG,"Waiting for "+Times+" second");

	}

	public void searchChannel() throws UiObjectNotFoundException{
	    if(!commonModule.isTextExists("STEREO")){
	        commonModule.clickResourceId("com.sonyericsson.fmradio:id/menu_toggle_power");
	        commonModule.waitForText("STEREO", 3000);
	    }
	    commonModule.clickDescription("More options");
	    commonModule.waitForText("Search for channels", 3000);

	    commonModule.clickText("Search for channels");
	    commonModule.wait(10);
	}

    public void setFavorChannel(int channelNum) throws UiObjectNotFoundException {
        commonModule.waitForResourceId("com.sonyericsson.fmradio:id/btn_favorite", 3000);

        commonModule.clickResourceId("com.sonyericsson.fmradio:id/btn_favorite");
        commonModule.waitForText("Save", 2000);

        testCase.enterText("Channel" + channelNum);
        commonModule.clickResourceId("com.sonyericsson.fmradio:id/color_3");

        commonModule.clickText("Save");
        commonModule.wait(2);
    }

    public void editFavorChannel() throws UiObjectNotFoundException {
        commonModule.clickResourceId("com.sonyericsson.fmradio:id/btn_favorite");
        commonModule.waitForText("Save", 2000);

        testCase.enterText("New");
        commonModule.clickText("Save");
        AcceptanceTestCase.assertTrue("Edit favorite Channel failed.",
                commonModule.waitForResourceId(
                        "com.sonyericsson.fmradio:id/frequency_text_indicator", 2000)
                        && commonModule.waitForText("New", 2000));
    }

    public void deleteFavorChannel() throws UiObjectNotFoundException{
        commonModule.waitForResourceId("com.sonyericsson.fmradio:id/btn_favorite", 3000);

        commonModule.clickResourceId("com.sonyericsson.fmradio:id/btn_favorite");
        commonModule.waitForText("Delete", 2000);

        commonModule.clickText("Delete");
    }

    public void markSeveralChannelsAsFavorites(int Num) throws UiObjectNotFoundException{
        for (int i = 0; i < Num; i++) {
            testCase.scrollLeft();
            setFavorChannel(i);
        }
    }

    public void checkFavoriteChannels(int Num) throws UiObjectNotFoundException {
        commonModule.clickResourceId("com.sonyericsson.fmradio:id/menu_favorites");
        for (int i = 0; i < Num; i++) {
            AcceptanceTestCase.assertTrue("Channel " + i + " set failed.",
                    commonModule.waitForTextContains("Channel" + i, 3000));
            System.out.println("Channel" + i);
        }
        testCase.pressKey(KeyEvent.KEYCODE_BACK);
    }

    public void TurnOnOrOffSpeaker(String flag) throws UiObjectNotFoundException{
        if (flag.equals("ON")) {
            if (commonModule.isDescriptionExists("Play in speaker")) {
                commonModule.clickDescription("Play in speaker");
            }
            AcceptanceTestCase.assertTrue("Turn on Speaker failed.",
                    commonModule.waitForDescription("Play in headphones", 2000));
        } else if (flag.equals("OFF")) {
            if (commonModule.isDescriptionExists("Play in headphones")) {
                commonModule.clickDescription("Play in headphones");
            }
            AcceptanceTestCase.assertTrue("Turn off Speaker failed.",
                    commonModule.waitForDescription("Play in speaker", 2000));
        }
    }

    public void selectAllFavoriteChannels(int Num) throws UiObjectNotFoundException {
        for (int i = 0; i < Num; i++) {
            commonModule.clickResourceId("com.sonyericsson.fmradio:id/menu_favorites");
            commonModule.waitForTextContains("Channel" + i, 2000);

            commonModule.clickTextContains("Channel" + i);
            AcceptanceTestCase.assertTrue("Channel " + i + " select failed.",
                    commonModule.waitForResourceId(
                            "com.sonyericsson.fmradio:id/frequency_text_indicator", 2000)
                            && commonModule.waitForText("Channel" + i, 3000));
        }
    }

    public void launchVideoPlayerOneByOne(String videoFolder) throws UiObjectNotFoundException {
        String dir = Environment.getExternalStorageDirectory().getPath() + "/" + videoFolder + "/";
        File testFolder = new File(dir);
        String[] testVideos = testFolder.list();
        Log.i(TAG, "Play video: " + testVideos.length);

        for (int i = 0; i < testVideos.length; i++) {
            playVideoURL(testFolder, testVideos[i]);
            waitVideoPlaying();

            commonModule.backOutToHomeScreen();
            commonModule.wait(5);
        }
    }

    public void verifyVideoPlayerState() {
        // Check video finish play
        testCase.assertTextPresent("Watch Next");
    }

    public void launchTrackID() {
        commonModule.backOutToHomeScreen();
        testCase.launchApp("com.sonyericsson.trackid",
                "com.sonyericsson.trackid.activity.tracker.TrackerActivity");
        if (testCase.isViewWithTextPresent("Terms and Conditions")) {
            testCase.clickId("chkbox");
            testCase.clickId("button1");

        }
    }

	public void searchSongs(String searchMusic) {
		boolean success =false;
		
		for (int i=0; i<3; i++){
			if(testCase.isViewWithTextPresent("Push button to find out!")){
				testCase.clickId("tracker_button_recording");
			}
			
			boolean searchResult = commonModule.waitForTextGone(
					"Recording", 30 * 1000);
			
			if (searchResult) {
				if (testCase.isViewWithTextPresent(searchMusic)) {
					success = true;
					break;
				}
				else if(testCase.isViewWithIdPresent("dialog_error_title")){
					testCase.clickId("tracker_button_recording");
				}
			}
			
		}
		
		AcceptanceTestCase.assertTrue(
				"Could not find a match music.", success);

	}
	
	public boolean searchSongsWithoutName() {
			commonModule.wait(2);
			if(commonModule.isResourceId("com.sonyericsson.trackid:id/dialog_error_title")){
				commonModule.pressKey(KeyEvent.KEYCODE_BACK);
			}
  		testCase.clickId("tracker_button_recording");

			
			boolean searchResult = commonModule.waitForTextGone(
					"Recording", 60 * 1000);
			
			if (searchResult) {
				if (testCase.isViewWithIdPresent("track_details_title")) {
							return true;
				}	else if(testCase.isViewWithIdPresent("dialog_error_title")){
							return false;
				}
			}

		return false;

	}

			public void repeatSearchSongs(int times) throws UiObjectNotFoundException{
				for(int j=0;j<times;j++){
					if(searchSongsWithoutName()){
						break;
					}else{
						commonModule.openNotificationBar();
						testCase.clickItemWithId("next");
						commonModule.pressKey(KeyEvent.KEYCODE_BACK);
					}
				}
			}
    public void clearSearchHistory() throws UiObjectNotFoundException {
        commonModule.pressMoreOption();
        commonModule.waitForText("Settings", 2000);

        commonModule.clickText("Settings");
        commonModule.waitForText("Search", 2000);

        commonModule.clickText("Search");
        commonModule.waitForText("Clear search history", 2000);

        commonModule.clickText("Clear search history");
        if (commonModule.isTextExists("Clear search history?")) {
            commonModule.clickText("OK");
        }

        for (int i = 0; i < 3; i++) {
            if (commonModule.waitForDescription("Search", 2000)) {
                break;
            }
            testCase.pressKey(KeyEvent.KEYCODE_BACK);
        }
    }

    public void chooseOneVideoToPlay() throws UiObjectNotFoundException {
        if (commonModule.isResourceId("com.google.android.youtube:id/video_item")) {
            commonModule.clickResourceId("com.google.android.youtube:id/video_item");
        } else if (commonModule.isResourceId("com.google.android.youtube:id/thumbnail")) {
            commonModule.clickResourceId("com.google.android.youtube:id/thumbnail");
        }
        commonModule.waitForResourceId("com.google.android.youtube:id/player_loading_view", 2000);
    }

    public void playerControl() throws UiObjectNotFoundException {
    			int nbrOfTimeOuts = 0;
        while (commonModule.isResourceId("com.google.android.youtube:id/player_loading_view") && nbrOfTimeOuts < 5) {
            nbrOfTimeOuts++;
            commonModule.wait(3);
        }
        for(int j=0;j<20;j++){
						if (!commonModule
								.isResourceId("com.google.android.youtube:id/player_loading_view")) {

						// Pause video
        	for(int i=0;i<5;i++){
				    	//commonModule.clickResourceId("com.google.android.youtube:id/controls_layout");
				    	/*testCase.clickPoint(commonModule.getX(350, 720), commonModule.getX(250, 1184));*/
        		testCase.clickPoint(350,250);
        		testCase.clickId("player_control_play_pause_replay_button");
        		commonModule.wait(3);
           if (commonModule.isDescriptionExists("Play video")) {
                	break;
            }

        	}
        	break;

        }else{
        	commonModule.wait(5);
        if(j==19){
            testCase.failTest("Poor network!!");
            }
        }

        }
        commonModule.wait(2);
        // Forward and backward.
        UiObject timebar = new UiObject(
                new UiSelector().resourceId("com.google.android.youtube:id/time_bar"));
        Rect mRect = timebar.getVisibleBounds();
        testCase.clickPoint(mRect.centerX(), mRect.centerY());// Forward.
        commonModule.wait(2);

        testCase.clickPoint(mRect.centerX() - 100, mRect.centerY());// Backward.
        commonModule.wait(2);

        // Full screen.
        if (commonModule.isDescriptionExists("Enter fullscreen")) {
            commonModule.clickDescription("Enter fullscreen");
        } else {
            commonModule.clickResourceId("com.google.android.youtube:id/fullscreen_button");
        }
        commonModule.wait(1);

        if (commonModule.isDescriptionExists("Enter fullscreen")) {
            commonModule.clickDescription("Enter fullscreen");
        } else {
            commonModule.clickResourceId("com.google.android.youtube:id/fullscreen_button");
        }
        if (commonModule.waitForText("Got it", 2000)) {
            commonModule.clickText("Got it");
            commonModule.waitForTextGone("Got it", 2000);
        }

        testCase.setOrientationPortrait();
        commonModule.wait(2);
        UiObject player = new UiObject(
                new UiSelector().resourceId("com.google.android.youtube:id/watch_player"));
        Rect pRect = player.getVisibleBounds();
        testCase.dragViewBetweenTwoPosition(pRect.centerX(), pRect.top, pRect.centerX(),
                pRect.top - 1000, 30);

        // Play video.
        for (int i = 0; i < 30; i++) {
            if (commonModule.isResourceId("com.google.android.youtube:id/player_loading_view")) {
                commonModule.wait(1);
            } else {
                break;
            }
        }
        commonModule.clickDescription("Play video");
        commonModule.waitForDescription("Replay video", 20 * 60 * 1000);

        // Replay video.
        commonModule.clickDescription("Replay video");
        commonModule.waitForResourceId("com.google.android.youtube:id/player_loading_view", 2000);

        commonModule.clickResourceId("com.google.android.youtube:id/player_collapse_button");
        commonModule.waitForResourceId("com.google.android.youtube:id/menu_search", 2000);
    }

    public void searchVideo() throws UiObjectNotFoundException {
        commonModule.clickResourceId("com.google.android.youtube:id/menu_search");
        commonModule.waitForResourceId("android:id/search_bar", 2000);

        commonModule.clickResourceId("android:id/search_bar");
        testCase.enterText("popular");
        testCase.enterText("\n");
        AcceptanceTestCase.assertTrue(
                "Maybe poor network, search result not display yet.",
                commonModule.waitForResourceId("com.google.android.youtube:id/search_type",
                        20 * 1000) && commonModule.waitForTextContains("popular", 20 * 1000));

    }

    public void playingVideoOneByOne(String videoFolder, int duration) throws UiObjectNotFoundException {
        String dir = Environment.getExternalStorageDirectory().getPath() + "/" + videoFolder + "/";
        File testFolder = new File(dir);
        String[] testVideos = testFolder.list();
        Log.i(TAG, "Play video: " + testVideos.length);
        long startTime = System.currentTimeMillis();

        	for (int i = 0; i < testVideos.length; i++) {
            if(!testCase.isViewWithIdPresent("video_surface_view") && !testCase.isViewWithIdPresent("video_view")){
            	playVideoURL(testFolder, testVideos[i]);
            }else{
            	commonModule.wait(10*60);
            }
            while(System.currentTimeMillis() - startTime > duration * 1000){
            	commonModule.backOutToHomeScreen();
            	return;
        	}
        }


    }

	@Override
	public void setVideoPlayBackgroundSetting(String option)
			throws UiObjectNotFoundException {
		launchVideoPlayer();
		testCase.clickItemWithDescription("More options");

		testCase.click("Settings");

		if(option=="on"){
			if (!testCase.isCheckboxChecked("checkbox", 0)){
				testCase.click("Background playback");
			}
		}
		if(option=="off"){
			if (testCase.isCheckboxChecked("checkbox", 0)){
				testCase.click("Background playback");
			}
		}

	}

    public void checkFmRadioMmi() {
        AcceptanceTestCase.assertTrue("No on/off button.",
                commonModule.isResourceId("com.sonyericsson.fmradio:id/menu_toggle_power"));
        AcceptanceTestCase.assertTrue("No favorite button.",
                commonModule.isResourceId("com.sonyericsson.fmradio:id/btn_favorite"));
        AcceptanceTestCase.assertTrue("No next/previous button.",
                commonModule.isResourceId("com.sonyericsson.fmradio:id/scale_previous")
                        && commonModule.waitForResourceId("com.sonyericsson.fmradio:id/scale_next", 2000));
        AcceptanceTestCase.assertTrue("No Radio dial",
                commonModule.isResourceId("com.sonyericsson.fmradio:id/frequency_scale"));
    }

    public void checkRadioDial() {
        AcceptanceTestCase.assertTrue("No scale bakground.",
                commonModule.isResourceId("com.sonyericsson.fmradio:id/scale_background"));
        AcceptanceTestCase.assertTrue("No scale stations.",
                commonModule.isResourceId("com.sonyericsson.fmradio:id/scale_stations_view"));
        AcceptanceTestCase.assertTrue("No scale needle.",
                commonModule.isResourceId("com.sonyericsson.fmradio:id/scale_needle"));
    }

    public void scrollUpOrDownRadioDial() {
        // Scroll Down radio dial.
        for (int i = 0; i < 20; i++) {
            if (commonModule.waitForText("88", 1000)) {
                break;
            }
            testCase.scrollLeft();
        }

        // Scroll Up radio dial.
        for (int i = 0; i < 20; i++) {
            testCase.scrollRight();
            if (commonModule.waitForText("108", 1000)) {
                break;
            }
        }
    }

    public void dragRadioDialSlowly() {
        int height = testCase.getUiDevice().getDisplayHeight();
        int width = testCase.getUiDevice().getDisplayWidth();

        for (int i = 0; i < 10; i++) {
            testCase.dragViewBetweenTwoPosition(width / 2, height / 2, width / 2 - 50, height / 2, 2);
        }
    }

    public void changeVisualizerSetting(String visualizer) throws UiObjectNotFoundException {
        commonModule.pressMoreOption();
        commonModule.waitForText("Visualizer", 1000);

        commonModule.clickText("Visualizer");
        commonModule.wait(1);

        commonModule.scrollFindText(visualizer);
    }

    public void pressRadioVolumeKey() {
        testCase.pressKey(KeyEvent.KEYCODE_VOLUME_DOWN);
    }

    public void longPressRadioVolumeUpKey() {
        testCase.longPressKey(KeyEvent.KEYCODE_VOLUME_UP, 5000);
    }

    public void longPressRadioVolumeDownKey() {
        testCase.longPressKey(KeyEvent.KEYCODE_VOLUME_DOWN, 5000);
    }

    public void pressRadioVolumeMuteKey() {
        testCase.pressKey(KeyEvent.KEYCODE_VOLUME_MUTE);
    }

    public void turnOffFMRadio() throws UiObjectNotFoundException {
        if(commonModule.isResourceId("com.sonyericsson.fmradio:id/audio_output_indicator")) {
            commonModule.clickResourceId("com.sonyericsson.fmradio:id/menu_toggle_power");
            commonModule.wait(2);
        }
    }

    public void turnOnFMRadio() throws UiObjectNotFoundException {
        if(!commonModule.isResourceId("com.sonyericsson.fmradio:id/audio_output_indicator")) {
            commonModule.clickResourceId("com.sonyericsson.fmradio:id/menu_toggle_power");
            commonModule.wait(2);
        }
    }

    public void changeRadioSoundMode(String mode) throws UiObjectNotFoundException {
        if (mode.equals("mono") && !commonModule.isTextExists("MONO")) {
            commonModule.pressMoreOption();
            commonModule.clickText("Force mono sound");
        } else if (mode.equals("stereo") && !commonModule.isTextExists("STEREO")) {
            commonModule.pressMoreOption();
            commonModule.clickText("Enable stereo sound");
        }
    }

    public void checkAllChannelsByTapNextButton() throws UiObjectNotFoundException {
        if (!commonModule.isResourceId("com.sonyericsson.fmradio:id/frequency_indicator")) {
            commonModule.clickResourceId("com.sonyericsson.fmradio:id/scale_next");
        }
        UiObject startChannel = new UiObject(
                new UiSelector().resourceId("com.sonyericsson.fmradio:id/frequency_indicator"));
        String staChannel = startChannel.getText();
        for (int i = 0; i < 50; i++) {
            commonModule.clickResourceId("com.sonyericsson.fmradio:id/scale_next");
            if (!commonModule.isResourceId("com.sonyericsson.fmradio:id/frequency_indicator")) {
                commonModule.clickResourceId("com.sonyericsson.fmradio:id/scale_next");
            }
            UiObject currentChannel = new UiObject(
                    new UiSelector().resourceId("com.sonyericsson.fmradio:id/frequency_indicator"));
            String curChannel = currentChannel.getText();

            System.out.println("startChannel=" + staChannel + ";    currentChannel=" + curChannel);
            if (staChannel.equals(curChannel)) {
                break;
            }
            commonModule.wait(2);
        }
    }
}
