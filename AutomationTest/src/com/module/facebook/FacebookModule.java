
package com.module.facebook;

import android.graphics.Rect;
import android.util.Log;
import android.view.KeyEvent;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.module.common.CommonModule;
import com.parser.data.ModuleDataParser;
import com.sonyericsson.test.acceptancetest.AcceptanceTestCase;

import android.widget.CheckBox;

import java.util.HashMap;

import org.dom4j.Comment;

public class FacebookModule implements IFacebook {
    AcceptanceTestCase testCase;

    CommonModule commonModule;

    HashMap<String, String> moduleData = new HashMap<String, String>();

    String TAG = "Reliability";

    public FacebookModule(AcceptanceTestCase testCase) {
        this.testCase = testCase;
        this.commonModule = new CommonModule(testCase);

        moduleData = ModuleDataParser.getModuleData("facebook");
        //System.out.println("module data:" + moduleData.values());
    }

    public void launchFacebook(String account, String password) throws UiObjectNotFoundException {
        testCase.launchApp("com.facebook.katana", "com.facebook.katana.LoginActivity");

        if (commonModule.waitForResourceId(moduleData.get("Login_Button"), 10 * 1000)) {

            if (!commonModule.isTextExists(account)) {

                commonModule.emptyEditorByInstance(0);
                testCase.enterText(account);
            }

            // maybe the pass word editor is covered, so tap twice.
            commonModule.clickResourceId(moduleData.get("Password_Editor"));
            commonModule.clickResourceId(moduleData.get("Password_Editor"));
            testCase.enterText(password);

            commonModule.clickResourceId(moduleData.get("Login_Button"));
        }
        AcceptanceTestCase.assertTrue("Launch facebook failed.",
                commonModule.waitForDescription("Search", 10 * 1000)
                        && commonModule.waitForDescription("Contacts", 10 * 1000));
    }

    public void addFacebookAccount(String account, String password) throws UiObjectNotFoundException {
        // launchSettings
        testCase.launchApp("com.android.settings", "com.android.settings.Settings");
        commonModule.waitForText("Settings", 2000);

        commonModule.scrollFindTextNotClick("Add account");
        if (commonModule.isTextExists("Facebook")) {
            return;
        }
        commonModule.clickText("Add account");
        commonModule.waitForText("Add an account", 2000);

        commonModule.clickText("Facebook");
        commonModule.waitForResourceId(moduleData.get("Login_Button"), 15 * 1000);

        commonModule.emptyEditorByInstance(0);
        testCase.enterText(account);
        commonModule.pressKey(KeyEvent.KEYCODE_ENTER);

        commonModule.wait(2);
        commonModule.clickResourceId(moduleData.get("Password_Editor"));
        testCase.enterText(password);

        commonModule.clickResourceId(moduleData.get("Login_Button"));

        AcceptanceTestCase.assertTrue(
                "Add Facebook account failed.",
                        commonModule.waitForText("Add account", 5* 60 * 1000)
                        && commonModule.waitForText("Facebook", 5* 60 * 1000));
    }

    public void addXperiaFacebookAccount(String account, String password) throws UiObjectNotFoundException {
        // launchSettings
        testCase.launchApp("com.android.settings", "com.android.settings.Settings");
        commonModule.waitForText("Settings", 2000);

        commonModule.scrollFindTextNotClick("Add account");
        if (commonModule.isTextExists("Xperia™ with Facebook")) {
           return;
        }
        commonModule.clickText("Add account");
        commonModule.waitForText("Add an account", 2000);

        commonModule.clickText("Xperia™ with Facebook");
        commonModule.waitForResourceId(moduleData.get("Login_Button"), 15 * 1000);

        commonModule.emptyEditorByInstance(0);
        testCase.enterText(account);
        commonModule.wait(2);
        testCase.enterText("\n");

        commonModule.clickResourceId(moduleData.get("Password_Editor"));
        testCase.enterText(password);

        commonModule.clickResourceId(moduleData.get("Login_Button"));
        commonModule.waitForResourceId(moduleData.get("Login_FB_Logo"), 60 * 1000);
        if (commonModule.waitForText("OK", 30 * 1000)) {
            commonModule.clickText("OK");
        }
        commonModule.waitForText("Like Sony Mobile", 20 * 1000);

        commonModule.clickText("OK");
        AcceptanceTestCase.assertTrue(
                "Add Facebook account failed.",
                commonModule.waitForText("Xperia™ with Facebook", 30 * 1000)
                        && commonModule.waitForText("Add account", 30 * 1000)
                        && commonModule.waitForText("Facebook", 30 * 1000));
    }

    public void addEventsFromFacebook() throws UiObjectNotFoundException {
        commonModule.clickDescription("More");
        commonModule.waitForText("Events", 10 * 1000);

        commonModule.clickText("Events");
        if(commonModule.waitForText(moduleData.get("Create_Event_Button"), 10 * 1000)){
            commonModule.clickResourceId(moduleData.get("Create_Event_Button"));
        } else if(commonModule.waitForDescription("Create Event", 10*1000)) {
            commonModule.clickDescription("Create Event");
        }
        commonModule.waitForText("Create Event", 2000);

        commonModule.clickResourceId(moduleData.get("Event_Name_Editor"));
        testCase.enterText("Test for RT");

        commonModule.clickResourceId(moduleData.get("Start_Time"));
        commonModule.waitForText("OK", 2000);

        commonModule.clickText("OK");
        commonModule.waitForResourceId(moduleData.get("End_Date"), 2000);

        commonModule.clickResourceId(moduleData.get("End_Date"));
        commonModule.waitForText("OK", 2000);

        commonModule.clickText("OK");
        commonModule.waitForResourceId(moduleData.get("Privacy_Picker"), 2000);

        commonModule.clickResourceId(moduleData.get("Privacy_Picker"));
        commonModule.waitForText("Public", 2000);

        commonModule.clickText("Public");
        commonModule.waitForDescription("Done", 2000);

        commonModule.clickDescription("Done");
        for (int i = 0; i < 10; i++) {
            if (commonModule.isTextContains("Processing")) {
                commonModule.wait(3);
            } else {
                break;
            }
        }
        AcceptanceTestCase.assertTrue(
                "Add event from facebook failed.",
                commonModule.waitForDescription("Search", 10 * 1000)
                        && commonModule.waitForText("Test for RT", 10 * 1000));
    }

    public void selectSyncCalendar() throws UiObjectNotFoundException {
        // launchSettings
        testCase.launchApp("com.android.settings", "com.android.settings.Settings");
        commonModule.waitForText("Settings", 2000);

        commonModule.scrollFindText("Xperia™ with Facebook");
        commonModule.waitForText("Application control settings", 2000);

        commonModule.clickText("Application control settings");
        commonModule.waitForText("Calendar", 2000);

        UiObject checkbox = new UiObject(new UiSelector().resourceId("android:id/checkbox"));
        if (!checkbox.isChecked()) {
            checkbox.click();
        }
        AcceptanceTestCase.assertTrue("Select sync Calendar failed.", checkbox.isChecked());
    }

    public void checkCalendarData() {
        for (int i = 0; i < 5; i++) {
            commonModule.backOutToHomeScreen();
            testCase.launchApp("com.android.calendar", "com.android.calendar.LaunchActivity");
            commonModule.waitForDescription("New event", 5 * 1000);

            if (commonModule.isTextExists("Test for RT")) {
                break;
            }
        }
    }

    public void openAFacebookPhoto(int folderIndex, boolean landscapeView)
            throws UiObjectNotFoundException {
        testCase.launchApp("com.sonyericsson.album", "com.sonyericsson.album.MainActivity");
        commonModule.wait(2);
        // Album Home page
        testCase.clickId("up");
        commonModule.wait(2);
        testCase.click("Facebook");
        if (commonModule.isTextExists("OK")) {
            commonModule.clickText("OK");
        }
        if (commonModule.isTextExists("Done")) {
            commonModule.clickText("Done");
        }
        commonModule.wait(30);
        AcceptanceTestCase.assertTrue("Facebook is not opened",
                commonModule.waitForDescription("Facebook, Open navigation drawer", 5000));

				    if(folderIndex==1){
				    	testCase.clickPoint(commonModule.getX(500), commonModule.getY(300));
				    }else if(folderIndex==2){
				    	testCase.clickPoint(commonModule.getX(500), commonModule.getY(450));
					   }else if(folderIndex==3){
						   testCase.clickPoint(commonModule.getX(500), commonModule.getY(600));
					   }else if(folderIndex==4){
						   testCase.clickPoint(commonModule.getX(500), commonModule.getY(750));
					    }
			    commonModule.wait(2);
			    AcceptanceTestCase.assertFalse("Facebook Album loading failed, or no photo exist in this facebook account",commonModule.isDescriptionExists("Facebook, Open navigation drawer"));
			    testCase.clickPoint(commonModule.getX(250), commonModule.getY(550));
			    if(landscapeView){
			    	commonModule.setOrientationLandscape();
			    }

			    for(int j=0;j<4;j++){
			    					commonModule.wait(2);

			    					if(commonModule.isResourceId(moduleData.get("Photo_Like_Button_Id"))){
			    						  break;
			    					}else{
			    						testCase.clickPoint(commonModule.getX(800,1080), commonModule.getY(480,1776));
			    					}
			    }
			    boolean flag = false;
			    commonModule.wait(2);
			    for(int i=0;i<10;i++){
						    if(commonModule.isTextExists("-")){
						    			commonModule.wait(3);
						    }else{
						    			flag = true;
						    			break;
						    }
			    }
			    //Open like list
			    String likeNumber = new UiObject(
						new UiSelector().resourceId(moduleData.get("Photo_Like_Button_Id"))).getText();
			    commonModule.clickResourceId(moduleData.get("Photo_Like_Button_Id"));
			    commonModule.wait(2);
			    AcceptanceTestCase.assertTrue("Who like the photos cannot displays",commonModule.isResourceId(moduleData.get("Photo_Like_Grid_Id")));
			    if(flag){
						    if(Integer.parseInt(likeNumber)!=0){
						    		AcceptanceTestCase.assertTrue("The username who like photo cannot display", commonModule.isResourceId(moduleData.get("Photo_Like_Profile_Image_Id"))&&commonModule.isResourceId(moduleData.get("Photo_Like_Username_Id")));
						    	}
			    }

			    	testCase.pressKey(KeyEvent.KEYCODE_BACK);
				    String commentNumber = new UiObject(
							new UiSelector().resourceId(moduleData.get("Photo_Comment_Button_Id"))).getText();
			    	if(Integer.parseInt(commentNumber)==0){
			    		Log.i(TAG,"Nobody add comment for this photo");
			    	}else if(Integer.parseInt(commentNumber)>0){
			    		Log.i(TAG,Integer.parseInt(commentNumber)+"people added comments for this photo");
			    	}else{
			    		AcceptanceTestCase.assertTrue("Comment number cannot display", false);
			    	}
			    	if(landscapeView){
			    		commonModule.setOrientationPortrait();
				    }
			    }

    public void addCommentForPhoto() throws UiObjectNotFoundException {
        commonModule.wait(2);
        commonModule.clickResourceId(moduleData.get("Photo_Comment_Button_Id"));
        commonModule.clickResourceId(moduleData.get("Comment_Editor_Text_Id"));
        testCase.enterText("It's nice!");
        commonModule.clickText("Post");
        AcceptanceTestCase.assertTrue("Post comment failed",
                commonModule.waitForText("It's nice!", 3000));

    }

    public void enterFacebookAlbums() throws UiObjectNotFoundException {
        commonModule.clickDescription("More");
        if (!commonModule.waitForText("Photos", 2000)) {
            commonModule.scrollToBegin();
        }
        commonModule.waitForText("FAVORITES", 10 * 1000);

        commonModule.scrollFindText("Photos");
        commonModule.waitForText("Albums", 2000);

        commonModule.clickText("Albums");
        commonModule.waitForText("Create Album", 5 * 1000);
    }

    public void checkAllPhotosInFacebookAlbum() throws UiObjectNotFoundException {
        if (!commonModule.isTextExists("Create Album")) {
            enterFacebookAlbums();
        }

        for (int i = 0; i < 40; i++) {
            if (commonModule.isResourceId(moduleData.get("Album_Image_Id"))) {
                break;
            } else {
                commonModule.wait(3);
            }
            if (i == 39) {
                testCase.failTest("Poor network, the photos can't be load.");
            }
        }
    }

    @Override
    public void createNewFacebookAlbum(String name, String desc, String loc) throws UiObjectNotFoundException {
        if (!commonModule.isTextExists("Create Album")) {
            enterFacebookAlbums();
        }
        commonModule.clickText("Create Album");
        commonModule.waitForText("Create new album", 2000);

        commonModule.clickResourceId(moduleData.get("Album_Name_Id"));
        testCase.enterText(name);

        commonModule.clickResourceId(moduleData.get("Album_Description_Id"));
        testCase.enterText(desc);

        commonModule.clickResourceId(moduleData.get("Album_Location_Id"));
        testCase.enterText(loc);

        commonModule.clickDescription("Done");
        AcceptanceTestCase.assertTrue("Create new facebook album failed.",
                commonModule.waitForResourceId(moduleData.get("Album_Image_Id"), 10 * 1000)
                        && commonModule.waitForText(name, 10 * 1000));
    }

    public void uploadANewPhotoViaTakePhoto(String albumName) throws UiObjectNotFoundException {
        if (!commonModule.isTextExists("Create Album")) {
            enterFacebookAlbums();
        }
        commonModule.scrollFindText(albumName);
        commonModule.waitForText("Add Photos", 2000);

        commonModule.clickText("Add Photos");
        commonModule.waitForResourceId(moduleData.get("Open_Camera_Button_Id"), 2000);

        commonModule.clickResourceId(moduleData.get("Open_Camera_Button_Id"));
        commonModule.waitForResourceId(moduleData.get("Camera_Button_Id"), 2000);

        commonModule.clickResourceId(moduleData.get("Camera_Button_Id"));
        commonModule.wait(2);// Wait for take photo.

        testCase.pressKey(KeyEvent.KEYCODE_BACK);// Back to images view.
        commonModule.waitForResourceId(moduleData.get("Select_Photo_Icon_Id"), 2000);

        commonModule.clickIdWithInstance(moduleData.get("Select_Photo_Icon_Id"), 0);
        commonModule.wait(1);

        commonModule.clickResourceId(moduleData.get("Post_Photo_Button_Id"));
        commonModule.waitForDescription("Post", 2000);

        commonModule.clickDescription("Post");
        commonModule.wait(2);

        testCase.openNotification();
        for (int i = 0; i < 10; i++) {
            if (commonModule.isTextExists("Facebook upload complete")) {
                commonModule.clickText("Facebook upload complete");
                break;
            } else {
                commonModule.wait(3);
            }

            if (i == 9) {
                testCase.failTest("Poor netwok, the photo upload failed.");
            }
        }
        testCase.pressKey(KeyEvent.KEYCODE_BACK);// Back to add photos view.
        commonModule.wait(1);

        for (int i = 0; i < 40; i++) {
            if (commonModule.isTextExists("Add Photos")
                    && commonModule.isResourceId(moduleData.get("Album_Image_Id"))) {
                break;
            } else {
                testCase.pressKey(KeyEvent.KEYCODE_BACK);// Back to albums view.
                commonModule.clickResourceId(moduleData.get("Album_Image_Id"));

                commonModule.wait(3);
            }

            if (i == 39) {
                testCase.failTest("Poor netwok, the photo upload failed.");
            }
        }
    }

    public void sharePhotoToContact(String albumName) throws UiObjectNotFoundException {
        if (!commonModule.isTextExists("Add Photos")) {

            enterFacebookAlbums();

            commonModule.scrollFindText(albumName);
            commonModule.waitForText("Add Photos", 2000);
        } else if (commonModule.isTextExists("Create Album")) {

            commonModule.scrollFindText(albumName);
            commonModule.waitForText("Add Photos", 2000);
        }

        commonModule.clickResourceId(moduleData.get("Album_Image_Id"));
        commonModule.waitForDescription("Tag", 10*1000);
        for (int i = 0; i < 10; i++) {
            if (commonModule.isDescriptionExists("Tag")) {
                break;
            } else {
                testCase.pressKey(KeyEvent.KEYCODE_BACK);

                commonModule.clickResourceId(moduleData.get("Album_Image_Id"));
                commonModule.wait(3);
            }
        }

        commonModule.clickDescription("More");
        for (int i = 0; i < 10; i++) {
            if (commonModule.isTextExists("Share")) {
                break;
            } else {
                // Back to add photos view.
                for (int j = 0; i < 3; i++) {
                    testCase.pressKey(KeyEvent.KEYCODE_BACK);
                    if (commonModule.waitForText("Add Photos", 2000))
                        ;
                }
                commonModule.clickResourceId(moduleData.get("Album_Image_Id"));

                testCase.getUiDevice().pressMenu();
                commonModule.wait(3);
            }
            if (i == 9 && !commonModule.isTextExists("Share")
                    && commonModule.isTextExists("Report photo")) {
                testCase.failTest("Poor network, share item not display yet.");
            }
        }

        commonModule.clickText("Share");
        commonModule.waitForText("Facebook", 2000);

        commonModule.clickText("Facebook");
        commonModule.waitForResourceId(moduleData.get("Add_Contact_Icon_Id"), 2000);

        commonModule.clickResourceId(moduleData.get("Add_Contact_Icon_Id"));
        commonModule.waitForResourceId(moduleData.get("Contact_Checkbox_Id"), 2000);

        commonModule.clickIdWithInstance(moduleData.get("Contact_Checkbox_Id"), 0);
        commonModule.wait(1);

        commonModule.clickDescription("Done");
        AcceptanceTestCase.assertTrue("Add Contact for share photo failed.",
                commonModule.waitForTextContains(" — with ", 3000));

        commonModule.clickDescription("Post");
        commonModule.waitForDescription("More", 2000);

        testCase.pressKey(KeyEvent.KEYCODE_BACK);// Back to add photos view.
        commonModule.waitForText("Add Photos", 2000);
    }

    public void uploadANewPhotoFromMemory(String albumName) throws UiObjectNotFoundException {
        if (!commonModule.isTextExists("Add Photos")) {

            enterFacebookAlbums();

            commonModule.scrollFindText(albumName);
            commonModule.waitForText("Add Photos", 2000);
        } else if (commonModule.isTextExists("Create Album")) {

            commonModule.scrollFindText(albumName);
            commonModule.waitForText("Add Photos", 2000);
        }

        commonModule.clickText("Add Photos");
        commonModule.waitForResourceId(moduleData.get("Select_Photo_Icon_Id"), 2000);

        commonModule.clickIdWithInstance(moduleData.get("Select_Photo_Icon_Id"), 0);

        commonModule.clickResourceId(moduleData.get("Post_Photo_Button_Id"));
        commonModule.waitForDescription("Post", 2000);

        commonModule.clickDescription("Post");
        commonModule.wait(2);

        testCase.openNotification();
        for (int i = 0; i < 10; i++) {
            if (commonModule.isTextExists("Facebook upload complete")) {
                commonModule.clickText("Facebook upload complete");
                break;
            } else {
                commonModule.wait(3);
            }

            if (i == 39) {
                testCase.failTest("Poor netwok, the photo upload failed.");
            }
        }
        testCase.pressKey(KeyEvent.KEYCODE_BACK);// Back to add photos view.
        commonModule.wait(1);
        testCase.pressKey(KeyEvent.KEYCODE_BACK);// Back to albums view.

    }

    public void deleteFacebookAlbum(String album) throws UiObjectNotFoundException {
        if (!commonModule.isTextExists("Create Album")) {
            enterFacebookAlbums();
        }
        commonModule.wait(2);
        for (int i = 0; i < 10; i++) {
            if (commonModule.isTextContains(album)) {
                break;
            } else {
                testCase.scrollDown();
            }
            if (i == 9) {
                return;
            }
        }

        UiObject albumName = new UiObject(new UiSelector().text(album));
        Rect albName = albumName.getVisibleBounds();
        UiObject albumMoreMenu = new UiObject(new UiSelector().resourceId(moduleData.get("Album_Options_Id")));
        Rect moreMenu = albumMoreMenu.getVisibleBounds();

        testCase.clickPoint(moreMenu.centerX(), albName.bottom);
        commonModule.waitForText("Delete", 2000);

        commonModule.clickText("Delete");
        commonModule.waitForText("Delete Album?", 2000);

        commonModule.clickText("Delete");
        commonModule.wait(2);
    }
    
    public void syncFacebookInSetting(String account) throws UiObjectNotFoundException{
	     testCase.launchApp("com.android.settings", "com.android.settings.Settings");
	     commonModule.waitForText("Settings", 2000);

	     commonModule.scrollFindText("Facebook");
	     commonModule.clickText(account);
	     commonModule.wait(2);
	     AcceptanceTestCase.assertTrue("Cannot open sync setting", commonModule.isTextExists("Sync Contacts"));
	     commonModule.pressKey(KeyEvent.KEYCODE_MENU);
	     commonModule.clickText("Sync now");
					AcceptanceTestCase.assertTrue(
							"Sync Facebook account failed!",
							commonModule.waitForTextGone("Syncing now…", 120 * 1000)
									&& commonModule
											.waitForIdGone("sync_active", 120 * 1000));
	     

  }
}
