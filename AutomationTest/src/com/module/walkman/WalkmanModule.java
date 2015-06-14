
package com.module.walkman;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.module.common.CommonModule;
import com.parser.data.ModuleDataParser;
import com.parser.module.PropertyNotFoundException;
import com.sonyericsson.test.acceptancetest.AcceptanceTestCase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.media.AudioManager;

public class WalkmanModule implements IWalkman {
    AcceptanceTestCase testCase;

    CommonModule commonModule;

    HashMap<String, String> moduleData;

    String TAG = "Reliability";

    public WalkmanModule(AcceptanceTestCase testCase)  throws PropertyNotFoundException {
        this.testCase = testCase;
        this.commonModule = new CommonModule(testCase);

        moduleData = ModuleDataParser.getModuleData("walkman");
    }

    public void playMusic(String musicName) throws UiObjectNotFoundException {
        launchWALKMANPlayer();
//        if (testCase.isViewWithIdPresent("alertTitle")) {
//            if (testCase.isViewWithIdPresent("never_show_dialog_checkbox")) {
//                if (!testCase.isCheckboxChecked("never_show_dialog_checkbox")) {
//                    testCase.clickId("never_show_dialog_checkbox");
//                }
//            }
//            testCase.clickId("button1");
//        }

        if (commonModule.isResourceId(moduleData.get("Menu_Button_Id"))) {
            commonModule.clickResourceId(moduleData.get("Menu_Button_Id"));
        } else {
            AcceptanceTestCase.assertTrue("Walkman Menu is not opened, can't select music", false);
        }


        if (testCase.isViewWithTextPresent("Songs")) {
            testCase.click("Songs");
        } else if (testCase.isViewWithTextPresent("My Library")){
            testCase.click("My Library");
            commonModule.wait(2);
            //scroll to Songs tab
            testCase.scrollRight();
            testCase.scrollRight();
        } else{
            testCase.click("Tracks");
        }
        commonModule.wait(1);

        commonModule.scrollFindText(musicName);
        commonModule.wait(3);

        if (commonModule.isResourceId(moduleData.get("Mini_Player_Layout_Id"))) {
            commonModule.clickResourceId(moduleData.get("Mini_Player_Layout_Id"));
        }
    	testCase.clickPoint(commonModule.getX(89,1080),
    			commonModule.getY(1687,1776));
       // testCase.clickPoint(commonModule.getX(89),commonModule.getY(1687));

        if(commonModule.isResourceId(moduleData.get("Player_Play_Pause_Button_Id"))){
        	commonModule.clickResourceId(moduleData.get("Player_Play_Pause_Button_Id"));
        }
    }


    public void stopMusicWithWALKMAN() throws UiObjectNotFoundException {

        commonModule.backOutToHomeScreen();
        launchWALKMANPlayer();
        commonModule.wait(2);
        if (testCase.isViewWithTextPresent("Get more album art")
                || testCase.isViewWithTextPresent("OK")) {
            testCase.click("OK");
            commonModule.wait(1);
        }
        testCase.click("My music");
        commonModule.wait(1);
        testCase.click("Tracks");
        commonModule.wait(1);
        testCase.clickItemWithText("Working Life");
        commonModule.wait(5);
        testCase.pressKey(KeyEvent.KEYCODE_MENU);
        if (!testCase.isViewWithTextPresent("Repeat mode")) {
            testCase.pressKey(KeyEvent.KEYCODE_BACK);
            commonModule.wait(3);
            testCase.clickPoint(commonModule.getX(210), commonModule.getY(650));
            commonModule.wait(3);
            testCase.clickPoint(commonModule.getX(630), commonModule.getY(810));
            commonModule.wait(3);
        } else {
            testCase.pressKey(KeyEvent.KEYCODE_BACK);
        }
        commonModule.clickResourceId(moduleData.get("Player_Play_Pause_Button_Id"));
        commonModule.wait(3);
        commonModule.backOutToHomeScreen();

    }

    @Override
    public void launchWALKMANPlayer() {
//        commonModule.backOutToHomeScreen();
        testCase.launchApp("com.sonyericsson.music", "com.sonyericsson.music.PlayerActivity");
        commonModule.wait(2);
        if (testCase.isViewWithTextPresent("OK")) {
            testCase.clickItemWithText("OK");
            Log.d(TAG, "[launchMusicPlayer]:" + "Cannot launch music player");
        }
        if (testCase.isViewWithTextPresent("Accept")) {
            testCase.clickItemWithText("Accept");
            commonModule.wait(2);
        }

        if (testCase.isViewWithTextPresent("Home")) {
            testCase.clickItemWithText("Home");
        }
    }

    @Override
    public void playMusicOnBackground() throws UiObjectNotFoundException {
        playMusicUI();
        commonModule.wait(5);
        testCase.pressKey(KeyEvent.KEYCODE_HOME);
    }

    @Override
    public void stopMusicFromStatusBar() throws UiObjectNotFoundException {
        testCase.openNotification();
        commonModule.wait(2);

        if (commonModule.isResourceId(moduleData.get("Pause_Button_Id"))) {
            commonModule.clickResourceId(moduleData.get("Pause_Button_Id"));
        }
        commonModule.backOutToHomeScreen();
    }

    public void launchMusicUrl(String musicFolder) throws UiObjectNotFoundException {

        String dir = Environment.getExternalStorageDirectory().getPath() + "/" + musicFolder + "/";
        Log.i(TAG, "Play music: " + dir);
        File testFolder = new File(dir);
        String[] testMusic = testFolder.list();
        Log.i(TAG, "Play music: " + testMusic.length);
        if (testMusic.length > 0) {
            for (int i = 0; i < testMusic.length; i++) {
                playMusicURL(dir, testMusic[i]);
                commonModule.wait(5);
                isMusicSupported();
            }
        } else {
            AcceptanceTestCase.assertTrue("The given music folder is empty, please help to check",
                    false);
        }
    }

    public void setRepeatOne() throws UiObjectNotFoundException {
        if (testCase.isViewWithDescriptionPresent("Set repeat off")){
            return;
        }

        for (int i = 0; i < 5; i++) {
        			commonModule.clickResourceId(moduleData.get("Player_Repeat_Button_Id"));
            if (testCase.isViewWithDescriptionPresent("Set repeat off")) {
                break;
            } else if (i == 4) {
                Log.w(TAG, "Cannot set the music player to repeat one");
            }
        }
    }

    public void playNextMusic() throws UiObjectNotFoundException {
    			commonModule.clickResourceId(moduleData.get("Player_Next_Button_Id"));
    }

    public void playPreviousMusic() throws UiObjectNotFoundException {

		commonModule.clickResourceId(moduleData.get("Player_Previous_Id"));
}

    public void verifyMusicPlaying() {
        AudioManager audioManager = (AudioManager)testCase.getInstrumentation().getContext()
                .getSystemService(Context.AUDIO_SERVICE);
        AcceptanceTestCase.assertTrue(audioManager.isMusicActive());
    }

    public void playMusic() throws UiObjectNotFoundException {
        AudioManager audioManager = (AudioManager)testCase.getInstrumentation().getContext()
                .getSystemService(Context.AUDIO_SERVICE);
        launchWALKMANPlayer();
        if (commonModule.waitForDescription("Pause", 3000)) {
            return;
        }

        commonModule.clickDescription("Play");
        AcceptanceTestCase.assertTrue("Play music failed.", audioManager.isMusicActive()
                || commonModule.waitForDescription("Pause", 3000));
    }

    public void setPlayMode(String playMode) throws UiObjectNotFoundException {

    	if (!testCase.isViewWithIdPresent("player_next_button")){
    		commonModule.backOutToHomeScreen();
    		launchWALKMANPlayer();
            if (commonModule.isResourceId(moduleData.get("Mini_Player_Layout_Id"))) {
                commonModule.clickResourceId(moduleData.get("Mini_Player_Layout_Id"));
            }
        	testCase.clickPoint(commonModule.getX(89,1080),
        			commonModule.getY(1687,1776));

    	}

        if (playMode.equalsIgnoreCase("shuffle on")) {
        			setShuffle(true);
        } else if (playMode.equalsIgnoreCase("shuffle off")) {
        			setShuffle(false);
        } else if (playMode.equalsIgnoreCase("repeat all")) {
            setRepeatMode("Set repeat one");
        } else if (playMode.equalsIgnoreCase("repeat one")) {
            setRepeatMode("Set repeat off");
        } else if (playMode.equalsIgnoreCase("repeat off")) {
            setRepeatMode("Set repeat all");
        } else {
            AcceptanceTestCase.assertTrue("Set play mode failed", false);
        }
    }

    private void setRepeatMode(String repeatMode) throws UiObjectNotFoundException {
        for (int i = 0; i < 5; i++) {
        			commonModule.clickResourceId(moduleData.get("Player_Repeat_Button_Id"));
            if (testCase.isViewWithDescriptionPresent(repeatMode)) {
                break;
            } else if (i == 4) {
                testCase.failTest("Cannot set the music player to " + repeatMode);
            }
        }
    }

    public void isMusicSupported() {
        if (testCase.isViewWithIdPresent("alertTitle")) {
            Log.i(TAG, "This format is not supported");
            testCase.clickItemWithId("button1");
        } else {
            Log.i(TAG, "Music is playing");
        }
    }

    public void waitPlayingMusic() throws UiObjectNotFoundException {
        commonModule.wait(1);
        // Get the music time
        String musicTime = new UiObject(
                new UiSelector().resourceId(moduleData.get("Player_Track_Text_Id")))
                .getText();

        String[] subTime = musicTime.split("/")[1].split(":");

        int Times = 0;
        if (subTime.length == 2) {
            int minute0 = (int)(Integer.valueOf(subTime[0].trim())) * 60;
            int second0 = (int)(Integer.valueOf(subTime[1].trim()));
            Times = minute0 + second0;
        } else if (subTime.length == 3) {
            int hour1 = (int)(Integer.valueOf(subTime[0].trim())) * 3600;
            int minute1 = (int)(Integer.valueOf(subTime[1].trim())) * 60;
            int second1 = (int)(Integer.valueOf(subTime[2].trim()));
            Times = hour1 + minute1 + second1;
        } else {
            AcceptanceTestCase.assertTrue(false);
        }
        commonModule.wait(Times);
        Log.i(TAG, "Music play finish, TOTAL TIME: " + Times);

    }

    public void verifyAlbumStateWhenMusicPlaying(String musicName, boolean verifyMusicNameOnly) throws UiObjectNotFoundException{
        if(verifyMusicNameOnly){
            testCase.assertTextPresent(musicName);
            return;
        }else{
            commonModule.clickResourceId(moduleData.get("Album_Flick_Component_Icon_Id"));
            commonModule.wait(5);
            boolean addToIcon = commonModule.isResourceId(moduleData.get("Player_Add_To_Playlist_Button_Id"));
            boolean favoriteIcon = commonModule.isResourceId(moduleData.get("Player_Favourite_Button_Id"));
            boolean infiniteIcon = commonModule.isResourceId(moduleData.get("Player_Infinite_Button_Id"));
            boolean shuffleIcon = commonModule.isResourceId(moduleData.get("Play_Shuffle_Button_Id"));
            boolean repeatIcon = commonModule.isResourceId(moduleData.get("Player_Repeat_Button_Id"));

            TestCase.assertTrue("addToIcon or favoriteIcon or infiniteIcon or shuffleIcon or repeatIcon didn't exist on album state", addToIcon & favoriteIcon & infiniteIcon & shuffleIcon & repeatIcon);
        }
	}

	public void playMusicURL(String dir, String musicName){
		Log.i(TAG,"Play music: "+musicName);
	    File audioFile = new File(dir, musicName);
	    Intent launchIntent = new Intent(Intent.ACTION_VIEW);
	    launchIntent.setComponent(new ComponentName("com.sonyericsson.music", "com.sonyericsson.music.PlayerActivity"));
	    launchIntent.setDataAndType(Uri.fromFile(audioFile), "audio/*");
	    launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    testCase.getInstrumentation().getContext().startActivity(launchIntent);
	}

    public String getCurrentSongName() throws UiObjectNotFoundException{
        UiObject object = new UiObject(new UiSelector().resourceId(moduleData.get("Player_Track_Title_Id")));
        String title = null;

        title = object.getText();

        return title;
    }

    /**
     * this function seems doesn't work well currently
     * @throws UiObjectNotFoundException
     */
    public void fastForwardCurrentSong() throws UiObjectNotFoundException{

    	commonModule.longClickResourceId((moduleData.get("Player_Next_Button_Id")));
    }


    public void fastRewindCurrentSong() throws UiObjectNotFoundException{

    	commonModule.longClickResourceId((moduleData.get("Player_Previous_Id")));
    }

    public void setShuffle(boolean shuffle) throws UiObjectNotFoundException{
        UiObject shuffleOn = new UiObject(new UiSelector().description("Turn off shuffle"));
        UiObject shuffleOff = new UiObject(new UiSelector().description("Turn on shuffle"));
        UiObject shuffleIcon = new UiObject(new UiSelector().resourceId(moduleData.get("Play_Shuffle_Button_Id")));
        for(int i=0;i<5;i++){
		        	if(shuffle){
			            if(shuffleOn.exists()){
			                return;
			            }else{
			               shuffleIcon.click();
			            					}
			        }else{
			        			if(shuffleOff.exists()){
			                return;
			            }else{
			               shuffleIcon.click();
			            					}
			        	}
        }

    }

    public void likeOneMusicAndAddComments(String comments) throws UiObjectNotFoundException{
        commonModule.clickResourceId(moduleData.get("Album_Cover_Id_In_Full_Screen"));
        commonModule.wait(1);
        commonModule.clickResourceId(moduleData.get("Like_Music_Icon"));
        if(commonModule.waitForText("Music makes you happy", 2000)){
            commonModule.clickResourceId(moduleData.get("Check_Box_Id"));
            commonModule.wait(1);

            commonModule.clickText("Accept");
        }
        commonModule.wait(1);
        AcceptanceTestCase.assertTrue("add comments state should be opened", commonModule.waitForText("Like on Facebook", 10*1000));
        commonModule.wait(1);
        testCase.enterText(comments);
        for (int i=0;i<10;i++){

			UiObject obj = new UiObject(new UiSelector().text("Share"));
			if(obj.isEnabled()){
        		break;
        	}else{
        		commonModule.wait(2);
        		}

        }
        testCase.clickItemWithText("Share");

    }

    public void likeFriendsMusic() throws UiObjectNotFoundException{
        launchWALKMANPlayer();

        if (!testCase.isViewWithTextPresent("Home")) {
            testCase.clickId("up");
        }

        testCase.click("Friends' music");

        if(commonModule.waitForText("Connect", 5*1000)){
            commonModule.clickText("Connect");

            //click the check box "I agree to the Sony Mobile  Privacy Policy"
            commonModule.clickResourceId(moduleData.get("Check_Box_Id"));

            commonModule.wait(1);
            commonModule.clickText("Accept");
        }
        commonModule.waitForId(moduleData.get("Picture_Id_In_Front_Of_Friends_Music"), 10*1000);

        commonModule.clickResourceId(moduleData.get("Friends_Music_context_id"));
        //commonModule.clickResourceId(moduleData.get("Friends_Music_context_id"));

        commonModule.waitForText("Comment/Like", 5*1000);

        commonModule.clickText("Comment/Like");
        commonModule.wait(2);

        commonModule.clickResourceId(moduleData.get("Friends_Music_comment_editor_id"));
        commonModule.wait(2);

        testCase.enterText("friends comments");

        commonModule.clickText("Post");
    }

    public void unlikeMusic() throws UiObjectNotFoundException{
        if (!commonModule.isResourceId(moduleData.get("Like_Music_Icon"))){
            commonModule.clickResourceId(moduleData.get("Album_Cover_Id_In_Full_Screen"));
            commonModule.wait(1);
        }

        commonModule.clickResourceId(moduleData.get("Like_Music_Icon"));
        commonModule.wait(1);

        if(testCase.isViewWithTextPresent("Unlike on Facebook")){
            testCase.clickItemWithText("Remove");
        }
    }

	@Override
	public void stopPlayingMusic() {
        AudioManager audioManager = (AudioManager)testCase.getInstrumentation().getContext()
                .getSystemService(Context.AUDIO_SERVICE);
        if (audioManager.isMusicActive()) {
        	testCase.clickPoint(commonModule.getX(445,1080),
        			commonModule.getY(1468,1776));
        	commonModule.wait(1);

        }
	}

	@Override
	public void startPlayingMusic() throws UiObjectNotFoundException{
        AudioManager audioManager = (AudioManager)testCase.getInstrumentation().getContext()
                .getSystemService(Context.AUDIO_SERVICE);
        if (!audioManager.isMusicActive()) {
        	commonModule.clickResourceId(moduleData.get("Player_Play_Pause_Button_Id"));
        	commonModule.wait(1);
        }
	}

	public void verifyMusicStateUnderLockScreen(){
	    /*AcceptanceTestCase.assertTrue("Music pause play button should display on the lock screen",
	            commonModule.waitForResourceId(moduleData.get("Pause_PLay_Button_On_Lock_Screen_State"), 5*1000));*/
	    commonModule.waitForResourceId(moduleData.get("Pause_PLay_Button_On_Lock_Screen_State"), 5*1000);
	}

	public void switchToNextSongUnderLockScreenState() throws UiObjectNotFoundException{
	    String preSongString = commonModule.getTextFromResourceId(moduleData.get("Song_Name_id_On_Lock_Screen_State"));

	    commonModule.clickResourceId(moduleData.get("Next_Button_On_Lock_Screen_State"));
	    commonModule.wait(3);

	    String nextSongString = commonModule.getTextFromResourceId(moduleData.get("Next_Button_On_Lock_Screen_State"));

	    AcceptanceTestCase.assertTrue("pre song should different with next song name", !preSongString.equals(nextSongString));
	}

	public void switchToPreSongUnderLockScreenState() throws UiObjectNotFoundException{
        String preSongString = commonModule.getTextFromResourceId(moduleData.get("Song_Name_id_On_Lock_Screen_State"));

        commonModule.clickResourceId(moduleData.get("Next_Button_On_Lock_Screen_State"));
        commonModule.wait(3);

        String nextSongString = commonModule.getTextFromResourceId(moduleData.get("Pre_Button_On_Lock_Screen_State"));

        AcceptanceTestCase.assertTrue("pre song should different with next song name", !preSongString.equals(nextSongString));
    }

	public void checkMusicStatus(String value) {
	    testCase.openNotification();
	    commonModule.wait(2);

        if (value.equals("playing")) {
            AcceptanceTestCase.assertTrue("Music is not playing",
                    commonModule.isResourceId(moduleData.get("Pause_Button_Id")));
        } else if (value.equals("pause")) {
            AcceptanceTestCase.assertTrue("Music is not pause",
                    commonModule.isResourceId(moduleData.get("Play_Button_Id"))
                            || !commonModule.isResourceId(moduleData.get("Pause_Button_Id")));
        }
        testCase.pressKey(KeyEvent.KEYCODE_BACK);
	}

	public void checkSearchKey() throws UiObjectNotFoundException {
	    testCase.pressKey(KeyEvent.KEYCODE_APP_SWITCH);
	    commonModule.waitForDescription("Walkman", 2000);

	    commonModule.clickDescription("Walkman");
	    if(commonModule.isResourceId(moduleData.get("Search_Icon_Id"))) {
	        commonModule.clickResourceId(moduleData.get("Search_Icon_Id"));
	        AcceptanceTestCase.assertTrue("Tap search key failed.",
	                commonModule.waitForResourceId(moduleData.get("Search_Editor"), 2000));

	        // Back to view before search.
	        commonModule.clickResourceId(moduleData.get("Menu_Button_Id"));
	    }
	}

	public void pausePlayMusicAndVerify() throws UiObjectNotFoundException{
	    commonModule.wait(5);

	    commonModule.pressKey(KeyEvent.KEYCODE_MEDIA_PAUSE);
	    commonModule.wait(5);
	    commonModule.openNotificationBar();
	    AcceptanceTestCase.assertTrue("Music paused, there should no mini player on status bar",
                !commonModule.waitForResourceId(moduleData.get("Pause_Button_Id"), 2000));
	    commonModule.pressKey(KeyEvent.KEYCODE_BACK);

	    commonModule.pressKey(KeyEvent.KEYCODE_MEDIA_PLAY);
	    commonModule.openNotificationBar();
        AcceptanceTestCase.assertTrue("Music paused, there should no mini player on status bar",
                commonModule.waitForResourceId(moduleData.get("Pause_Button_Id"), 2000));
        commonModule.pressKey(KeyEvent.KEYCODE_BACK);
	}

	public void gotoPlaylist() throws UiObjectNotFoundException{
	    launchWALKMANPlayer();

	    commonModule.clickResourceId(moduleData.get("Menu_Button_Id"));
	    commonModule.wait(2);

	    commonModule.clickText("Playlists");
	    commonModule.wait(2);

	    AcceptanceTestCase.assertTrue("Add playlist icon didn't display",
	            commonModule.waitForResourceId(moduleData.get("Create_Playlist_Icon_Id"),5000));
	}

	public void checkDefaultPlaylist(){
	    AcceptanceTestCase.assertTrue("default playlist 'Walkman favorites' didn't exist",
                commonModule.waitForText("Walkman favorites", 2000));

	    AcceptanceTestCase.assertTrue("default playlist 'TrackID™ history' didn't exist",
                commonModule.waitForText("TrackID™ history", 2000));

	    AcceptanceTestCase.assertTrue("default playlist 'Recently played' didn't exist",
                commonModule.waitForText("Recently played", 2000));

	    AcceptanceTestCase.assertTrue("default playlist 'Most played' didn't exist",
                commonModule.waitForText("Most played", 2000));

	    AcceptanceTestCase.assertTrue("default playlist 'Newly added' didn't exist",
                commonModule.waitForText("Newly added", 2000));
	}

	public void createPlaylist(String name, boolean addSong, int addSongNumber) throws UiObjectNotFoundException{

	    commonModule.clickResourceId(moduleData.get("Create_Playlist_Icon_Id"));

	    AcceptanceTestCase.assertTrue("Create new playlist dialog didn't popup",
                commonModule.waitForText("Create new playlist", 2000));

	    testCase.enterText(name);

	    commonModule.clickText("OK");

	    if(addSong){
	        for(int i=0; i<addSongNumber; i++){
	            commonModule.clickResourceIdByInstance("android.widget.CheckBox", i);
	            commonModule.wait(2);
	        }
	    }

	    //save
	    commonModule.clickResourceId(moduleData.get("Save_Playlist_Icon"));
	    commonModule.scrollFindTextNotClick(name);
	    AcceptanceTestCase.assertTrue("Create new playlist dialog didn't popup",
                commonModule.waitForText(name, 5000));
	}

	public void deletePlaylist(String name) throws UiObjectNotFoundException{
	    commonModule.scrollFindTextNotClick(name);

	    commonModule.longClickTextContains(name);
	    AcceptanceTestCase.assertTrue("After long click item 'Delete' should display", commonModule.waitForText("Delete", 5000));

	    commonModule.clickText("Delete");
	    AcceptanceTestCase.assertTrue("Confirm 'Delete' dialog should display", commonModule.waitForText("Cancel", 5000));

	    commonModule.clickText("Delete");
	    AcceptanceTestCase.assertTrue("playlist shouldn't display anymore",
                !commonModule.waitForText(name, 5000));
	}

	public void playMusicUI() {
	    launchWALKMANPlayer();
	    commonModule.pressKey(KeyEvent.KEYCODE_MEDIA_PLAY);
	}
	
    public String getCurrentSongNameFromStatusBar() throws UiObjectNotFoundException{
    			commonModule.openNotificationBar();
    			commonModule.wait(2);
        UiObject object = new UiObject(new UiSelector().resourceId("com.sonyericsson.music:id/title"));
        String title = null;

        title = object.getText();
        
        commonModule.pressKey(KeyEvent.KEYCODE_BACK);
        
        return title;
        
    }
    
	
    public void playNextMusicFromStatusBar() throws UiObjectNotFoundException{
			    	commonModule.openNotificationBar();
						commonModule.wait(2);
						commonModule.clickResourceId("com.sonyericsson.music:id/next");
						commonModule.wait(2);
						commonModule.pressKey(KeyEvent.KEYCODE_BACK);
    }



}
