
package com.test.rt.phase1;

import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ProgressBar;
import android.widget.SeekBar;

import com.module.alarm.AlarmFactory;
import com.module.alarm.IAlarm;
import com.module.album.AlbumFactory;
import com.module.album.IAlbum;
import com.module.browser.BrowserFactory;
import com.module.browser.IBrowser;
import com.module.calculator.AbstractCalculatorFactory;
import com.module.calculator.ICalculator;
import com.module.camera.AbstractCameraFactory;
import com.module.camera.ICamera;
import com.module.common.CommonModule;
import com.module.contacts.ContactsFactory;
import com.module.contacts.IContacts;
import com.module.email.EmailFactory;
import com.module.email.IEmail;
import com.module.media.IMedia;
import com.module.media.MediaFactory;
import com.module.messaging.AbstractMessagingFactory;
import com.module.messaging.IMessaging;
import com.module.messaging.MessagingFactory;
import com.module.officesuite.IOfficeSuite;
import com.module.officesuite.OfficeSuiteFactory;
import com.module.settings.AbstractSettingsFactory;
import com.module.settings.ISetting;
import com.module.settings.SettingsFactory;
import com.module.smallApp.ISmallApp;
import com.module.smallApp.SmallAppFactory;
import com.module.smartConnect.ISmartConnect;
import com.module.smartConnect.SmartConnectFactory;
import com.module.telephony.AbstractTelephonyFactory;
import com.module.telephony.ITelephony;
import com.module.telephony.TelephonyFactory;
import com.module.walkman.AbstractWalkmanFactory;
import com.module.walkman.IWalkman;
import com.module.walkman.WalkmanFactory;
import com.module.walkman.WalkmanModule;
import com.parents.GroupFactories;
import com.parser.cases.TestDataExtract;
import com.parser.data.ModuleData;
import com.parser.data.ModuleDataParser;
import com.parser.module.PropertyNotFoundException;
import com.module.email.AbstractEmailFactory;
import com.module.facebook.AbstractFacebookFactory;
import com.module.facebook.IFacebook;
import com.sonyericsson.test.acceptancetest.AcceptanceTestCase;
import com.utils.CommandConstantsUtils;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

public class RTAutomaticModules {

    private AcceptanceTestCase testCase;

    private CommonModule commonModule;

	private String callNumber;

    private static String callNumber2;

    private static String callNumber3;

    private static String emailaccount;

    private static String emailpassword;

    private static String email2account;

    private static String email2password;

    private static String EASaccount;

    private static String EASpassword;

    private static String facebookaccount;

    private static String facebookpassword;

    private static String test_vpnusername;

    private static String test_vpnpassword;

    private static String test_gmailpassword;

    private static String test_gmailaccount;

    private static String test_sipaccount;

    private static String test_sippassword;

    private static String test_partnerskypeaccount;

    private static String test_skypeaccount;

    private static String test_skypepassword;

    private static String partner_sipaccount;

    private static String test_wifi;

    private static String test_wifipassword;

    private IOfficeSuite officeSuite;

    private ITelephony telephonyModule;

    private ICamera camera;

    private IAlarm alarmModule;

    private ISetting settingsModule;

    private IMedia mediaModule;

    private IAlbum albumModule;

    private IMessaging messagingModule;

    private IContacts contactsModule;

    private ISmallApp smallApp;

    private ISmartConnect smartConnect;

    private IEmail emailModule;

	private IWalkman walkman;

	private ICalculator calculator;

	private IFacebook facebook;

	private IBrowser browser;

    public String cameraFilePath = Environment.getExternalStorageDirectory().getPath()
            + "/DCIM/100ANDRO/";

    public String xperiaFilePath = Environment.getExternalStorageDirectory().getPath()
            + "/DCIM/XPERIA/";

    public String testloops;

    public RTAutomaticModules(AcceptanceTestCase testCase) throws PropertyNotFoundException,
            XmlPullParserException, IOException {
        this.testCase = testCase;
        this.commonModule = new CommonModule(testCase);

        ModuleDataParser dataParser = new ModuleDataParser();
        dataParser.parse();

        getAccounts();

        officeSuite = OfficeSuiteFactory.getOfficeSuiteModule(testCase);
        telephonyModule = ((AbstractTelephonyFactory)GroupFactories.createFactory(testCase,
                "telephony")).create();
        alarmModule = AlarmFactory.getCameraModule(testCase);
        settingsModule = ((AbstractSettingsFactory)(GroupFactories.createFactory(testCase,
                "settings"))).getSettingsModule();
        messagingModule = ((AbstractMessagingFactory)GroupFactories.createFactory(testCase, "messaging")).create();
        camera = ((AbstractCameraFactory)GroupFactories.createFactory(testCase, "camera")).create();
        mediaModule = MediaFactory.getMediaModule(testCase);
        albumModule = AlbumFactory.getAlbumModule(testCase);
        contactsModule = ContactsFactory.getContactsModule(testCase);
        smallApp = SmallAppFactory.getSmallAppModule(testCase);
        smartConnect = SmartConnectFactory.getSmartConnectModule(testCase);
        emailModule = ((AbstractEmailFactory)GroupFactories.createFactory(testCase, "email"))
                .create();
        walkman = ((AbstractWalkmanFactory)GroupFactories.createFactory(testCase, "walkman"))
                .create();
        calculator = ((AbstractCalculatorFactory)GroupFactories.createFactory(testCase,
                "calculator")).create();
        facebook = ((AbstractFacebookFactory)GroupFactories.createFactory(testCase, "facebook"))
                .create();
        browser = BrowserFactory.create(testCase);

    }

    public void getAccounts() {
        callNumber = TestDataExtract.callNumber;
        callNumber2 = TestDataExtract.callNumber2;
        callNumber3 = TestDataExtract.callNumber3;

        emailaccount = TestDataExtract.test_emailaccount;
        emailpassword = TestDataExtract.test_emailpassword;
        email2account = TestDataExtract.test_email2account;
        email2password = TestDataExtract.test_email2password;
        EASaccount = TestDataExtract.test_EASaccount;
        EASpassword = TestDataExtract.test_EASpassword;
        facebookaccount = TestDataExtract.test_facebookaccount;
        facebookpassword = TestDataExtract.test_facebookpassword;
        test_vpnusername = TestDataExtract.test_vpnusername;
        test_vpnpassword = TestDataExtract.test_vpnpassword;
        test_gmailaccount = TestDataExtract.test_gmailaccount;
        test_gmailpassword = TestDataExtract.test_gmailpassword;
        test_partnerskypeaccount = TestDataExtract.test_partnerskypeaccount;
        test_skypeaccount = TestDataExtract.test_skypeaccount;
        test_skypepassword = TestDataExtract.test_skypepassword;
        test_sipaccount = TestDataExtract.test_sipaccount;
        test_sippassword = TestDataExtract.test_sippassword;
        partner_sipaccount = TestDataExtract.partner_sipaccount;

        test_wifi = TestDataExtract.test_wifi;
        test_wifipassword = TestDataExtract.test_wifipassword;


    }

    public void RT_COMM_Startup_First_Launch_All_Application(String casename,
            HashMap<String, String> paras) throws Exception {

        try {
        	commonModule.lanchAllAppAndVerify();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            System.out.println("in finally");
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_OfficeSuite_View(String casename, HashMap<String, String> paras)
            throws Exception {

        try {
            officeSuite.openSeveralFileTypeAndDoSomeOperation();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            System.out.println("in finally");
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Dialer_MMT_Call_log_view_and_delete_missed_call(String casename,
            HashMap<String, String> paras) throws Exception {

        try {
            // check the missed call log
            telephonyModule.clearCallLog();

            telephonyModule.receiveMTCallButNotAnswer(callNumber);

            telephonyModule.checkCallLog(callNumber);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Dialer_MMT_Call_log_view_and_delete_answered_call(String casename,
            HashMap<String, String> paras) throws Exception {

        try {
            telephonyModule.clearCallLog();

            // check the busy call log
            telephonyModule.answerMTCall(callNumber);

            telephonyModule.endCall();

            telephonyModule.checkCallLog(callNumber);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            telephonyModule.endCall();
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Dialer_MMT_Call_log_view_and_delete_busy_call(String casename,
            HashMap<String, String> paras) throws Exception {

        try {
            telephonyModule.setCallWaiting("on");

            telephonyModule.clearCallLog();

            // check the busy call log
            telephonyModule.answerMTCall(callNumber);

            commonModule.backOutToHomeScreen();

            telephonyModule.receiveMTCallButNotAnswer(callNumber2);

            telephonyModule.endCall();

            telephonyModule.checkCallLog(callNumber, callNumber2);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Dialer_MMT_Call_log_view_and_delete_invalid_call(String casename,
            HashMap<String, String> paras) throws Exception {

        try {
            telephonyModule.clearCallLog();

            // check the busy call log

            telephonyModule.makeMOCallWithSymbolNumber("#31#+123456789056789012345");

            telephonyModule.endCall();

            telephonyModule.checkCallLog("+123456789056789012345");

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {

            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Dialer_MMT_Call_log_view_and_delete_alarm_coming(String casename,
            HashMap<String, String> paras) throws Exception {

        try {
            telephonyModule.clearCallLog();

            telephonyModule.makeMOCallWithoutAnswered(callNumber);

            telephonyModule.endCall();

            commonModule.backOutToHomeScreen();

            alarmModule.setNewAlarmFewMinuteslater(0,3);

            telephonyModule.checkCallLog(callNumber);

            alarmModule.snoozeAlarm(3 * 60 * 1000);

            telephonyModule.checkCallLog(callNumber);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.unLockScreen();
            alarmModule.deleteAllAlarms();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173408
     * RT_COMM_INTCON_MMS&Data switch on and off
     */
    public void RT_COMM_INTCON_MMS_Data_Switch_On_And_Off_data_off(String casename,
            HashMap<String, String> paras) throws Exception {
        try {
            camera.launchCameraPhotoApplication();
            camera.takePictures(1);

            settingsModule.setDataTraffic("off");

            commonModule.backOutToHomeScreen();

            browser.startChrom();

            browser.loadWebPageWithoutNetwork("www.baidu.com");

            messagingModule.startMessagingFromMenu();

            messagingModule.removeAllMessages();

            messagingModule.sendMMSWithImage("send MMS with data traffic off", callNumber, false);

            commonModule.sendSMSCommand(callNumber, CommandConstantsUtils.COMMAND_MMS);

            messagingModule.checkReceiveSMS("(MMS) Do you like the picture and sound?",
                    2 * 60 * 1000);
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            settingsModule.setDataTraffic("on");
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_INTCON_MMS_Data_Switch_On_And_Off_data_on(String casename,
            HashMap<String, String> paras) throws Exception {
        try {
			camera.launchCameraPhotoApplication();
            camera.takePictures(1);

            settingsModule.setDataTraffic("on");

            settingsModule.changeCallipersRange();

            commonModule.backOutToHomeScreen();

            browser.startChrom();

            browser.loadWebPage("www.baidu.com");

            messagingModule.removeAllMessages();

            messagingModule.sendMMSWithImageWithoutCheck("send MMS with data traffic off",
                    callNumber);

            settingsModule.setDataTraffic("off");

            commonModule.backOutToHomeScreen();

            messagingModule.openConversationByNameOrNumber(callNumber);

            messagingModule.waitMessageSendSuccessfully();
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            settingsModule.setDataTraffic("on");
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173584
     * RT_COMM_CAM_Video_Scences setting
     */
    public void RT_COMM_CAM_Video_Scences_Setting(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            camera.launchCameraPhotoApplication();
            commonModule.wait(3);

            camera.selectOneEffectFromCameraSettings("Manual");

            camera.switchToVideoWithManualMode();

            camera.selectScenesAndRecordVideos("Off","Auto","Portrait","Soft snap","Landscape","Night","Beach","Snow","Sports","Party");

            camera.checkVideos(8);

            camera.recordVideoWithZoom();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.clearData("Camera");
            commonModule.delete(cameraFilePath);
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1178571
     * RT_COMM_Alarm&Clock
     */
    public void RT_COMM_Alarm_Clock_portrait(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();
        String homeCity = "Beijing";
        try {
            alarmModule.startAlarmFromMenu();
            commonModule.wait(3);

            alarmModule.switchAlarmTabs();

            alarmModule.switchAlarmTabByDescription("Alarm");
            alarmModule.setNewAlarmFewMinuteslater(0,3);
            alarmModule.snoozeAlarm(3 * 60 * 1000);
            alarmModule.deleteAllAlarms();

            alarmModule.setHomeTown(homeCity);
            alarmModule.changeTemperatureUnits();
            alarmModule.rearrangeWithWordClock();
            alarmModule.deleteCity(homeCity);

            alarmModule.stopwatchOperation();

            alarmModule.TimerOperation();
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Alarm_Clock_landscape(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            commonModule.setOrientationLandscape();

            alarmModule.setNewAlarmFewMinuteslaterByTap(3);
            alarmModule.deleteAllAlarms();

            alarmModule.TimerOperation();
            alarmModule.stopwatchOperation();
            alarmModule.compareWorldClock();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.setOrientationPortrait();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173568
     * RT_COMM_CAM_Still_Scences setting
     */
    public void RT_COMM_CAM_Still_Scences_Setting(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            camera.launchCameraPhotoApplication();
            commonModule.wait(3);

            camera.selectOneEffectFromCameraSettings("Manual");

            camera.selectAllScenesAndTakePictures();

            camera.checkPictures(18);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.clearData("Camera");
            commonModule.delete(cameraFilePath);
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173585
     * RT_COMM_CAM_Still_GEO Exif
     *
     * @throws Exception
     */
    public void RT_COMM_CAM_Still_GEO_Exif(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
//            commonModule.activeGPSServiceFromSettings();
//
//            camera.activeGeoTagFromCameraSettings();
            camera.launchCameraPhotoApplication();
            commonModule.clearData("Camera");
            commonModule.backOutToHomeScreen();
            commonModule.wait(2);

            camera.launchCameraWithGeoActive();

            camera.takePictures(1);
            commonModule.wait(2);

//            camera.setGeoTaggingOff();
            commonModule.clearData("Camera");
            camera.launchCameraPhotoApplication();

            camera.takePictures(1);
            commonModule.wait(2);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.clearData("Camera");
            commonModule.delete(cameraFilePath);
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173696
     * RT_COMM_Airplane&Restart Mode
     *
     * @throws Exception
     */
    public void RT_COMM_Airplane_Restart_Mode(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            messagingModule.removeAllMessages();

            settingsModule.turnOnFlightMode();

            settingsModule.switchSoundSettings();

            settingsModule.takeScreenshotViaPowerMenu();

            commonModule.bluetoothOnOrOff("ON");

            settingsModule.wifiOnOrOff("ON");
            commonModule.backOutToHomeScreen();

            mediaModule.launchRadioPlayer();
            mediaModule.searchChannel();
            mediaModule.setFavorChannel(1);
            mediaModule.stopRadio();

            telephonyModule.makeMOCallWithFlightMode(callNumber);

            messagingModule.sendSMSWithFlightMode("Hello", callNumber);

            // messagingModule.sendSMSAPI(CommandConstantsUtils.COMMAND_SMS,
            // callNumber);
            // messagingModule.openReceiveMessage(CommandConstantsUtils.SMS_CONTENT_RECEIVE);

            messagingModule.sendMMSWithImageWithFlightMode("Hello", callNumber);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            settingsModule.turnOffFlightMode();
            messagingModule.startMessagingFromMenu();
            messagingModule.removeAllMessages();
            commonModule.clearData("FM radio");
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1178349
     * RT_COMM_Album_Map&Online view
     *
     * @throws Exception
     */
    public void RT_COMM_Album_Map_Online_View(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            camera.launchCameraPhotoApplication();
            camera.takePictures(1);
            commonModule.backOutToHomeScreen();

            albumModule.startAlbum();
            albumModule.openOnePicture();
            albumModule.tagPictureOnMap();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.delete(cameraFilePath);
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173567
     * RT_COMM_CAM_Still_White balance setting
     *
     * @throws Exception
     */
    public void RT_COMM_CAM_Still_White_Balance_Setting(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            commonModule.clearData("Camera");

            camera.launchCameraByMode("Manual");
            camera.changeScenes("Off");

            camera.selectAllWhiteBalanceAndTakePhotos();

            commonModule.backOutToHomeScreen();

            camera.launchCameraPhotoApplication();
            camera.verifyWhiteBalance("Cloudy");

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.clearData("Camera");
            commonModule.delete(cameraFilePath);
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1178605 RT_COMM_CAM_HDR
     *
     * @throws Exception
     */
    public void RT_COMM_CAM_HDR(String casename, HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            camera.setHDROnOrOff("ON");

            camera.changeScenes("Backlight correction HDR");

            camera.takePictures(1);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.clearData("Camera");
            commonModule.delete(cameraFilePath);
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173581
     * RT_COMM_CAM_Video_Video size
     *
     * @throws Exception
     */
    public void RT_COMM_CAM_Video_Video_Size(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();
        int recordingTime = 5 * 60;

        try {
            camera.launchCameraByMode("Manual");
            camera.switchToVideoWithManualMode();

            camera.selectAllResolutionAndRecordVideos(recordingTime);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.clearData("Camera");
            commonModule.delete(cameraFilePath);
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173578
     * RT_COMM_CAM_Still_Zoom
     *
     * @throws Exception
     */
    public void RT_COMM_CAM_Still_Zoom(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            commonModule.clearData("Camera");

            camera.launchCameraByMode("Manual");

            commonModule.setOrientationPortrait();
            camera.shortPressZoomKey();
            camera.takePictures(1);
            camera.longPressZoomKey();

            commonModule.setOrientationLandscape();
            camera.shortPressZoomKey();
            camera.longPressZoomKey();

            commonModule.setOrientationPortrait();
            camera.takePictures(1);

            camera.switchToVideoWithManualMode();

            camera.changeUseVolumeKeyAs("Volume");
            camera.verifyVolumeKeyAsVolume();

            camera.changeUseVolumeKeyAs("Shutter");
            camera.verifyVolumeKeyAsShutter();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.setOrientationPortrait();
            commonModule.clearData("Camera");
            commonModule.delete(cameraFilePath);
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173472 RT_COMM_FM
     * Radio_Favorites
     *
     * @throws Exception
     */
    public void RT_COMM_FM_Radio_Favorites(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            int Num = 3;
            mediaModule.launchRadioPlayer();
            mediaModule.setFavorChannel(0);
            mediaModule.editFavorChannel();
            mediaModule.deleteFavorChannel();

            mediaModule.markSeveralChannelsAsFavorites(Num);
            mediaModule.checkFavoriteChannels(Num);

            mediaModule.TurnOnOrOffSpeaker("ON");
            mediaModule.selectAllFavoriteChannels(Num);
            mediaModule.TurnOnOrOffSpeaker("OFF");

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            mediaModule.stopRadio();
            commonModule.clearData("FM radio");
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173342
     * RT_COMM_PIM_Contacts_Create contact
     *
     * @throws Exception
     */
    public void RT_COMM_PIM_Contacts_Create_Contact(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();
        String contactName = "RT";
        try {
	    	contactsModule.deleteContacts();

            contactsModule.createContact(contactName,callNumber, email2account);

            commonModule.backOutToHomeScreen();

            contactsModule.checkAllNumberType(contactName, callNumber);

            telephonyModule.receiveMTCallAndVerifyCallerInfo(callNumber, contactName);
            telephonyModule.endCall();

            messagingModule.remoteSendMessageToDUT(CommandConstantsUtils.COMMAND_SMS, callNumber);
            messagingModule.checkReceivedMessageInfo(contactName);

            contactsModule.sendSMSToAllValidNumber(contactName);

            contactsModule.deleteContacts();
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            contactsModule.deleteContacts();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_PIM_Contacts_Create_Contact_Email(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        String contactName = "RT";
        try {
			contactsModule.deleteContacts();

            contactsModule.createContact(contactName,callNumber, email2account);

            commonModule.backOutToHomeScreen();

            emailModule.loginEmailSyncAutoServer(emailaccount, emailpassword);
            contactsModule.sendEmailToContact(contactName);

            contactsModule.deleteContacts();
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
            contactsModule.deleteContacts();
        }
    }

    public void RT_COMM_PIM_Contacts_Create_Contact_Remove_All_Info(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        String contactName = "RT";
        try {
            contactsModule.deleteContacts();

            contactsModule.createContact(contactName,callNumber, email2account);

            commonModule.backOutToHomeScreen();

            contactsModule.removeAllFieldsInfoExceptName(contactName);

            contactsModule.saveNumberFormCallLog(contactName, callNumber);

            contactsModule.deleteContacts();
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            contactsModule.deleteContacts();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173345
     * RT_COMM_PIM_Contacts_Search contact list
     *
     * @throws Exception
     */
    public void RT_COMM_PIM_Contacts_Search_Contact_List(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        int count = 2;
        try {
            contactsModule.addContacts(count);

            contactsModule.searchByContactName();

            contactsModule.searchByPhoneNumber();

            contactsModule.searchByOtherCharacters();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            contactsModule.deleteContacts();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173391
     * RT_COMM_PIM_Contacts_Set photo to contact by camera
     *
     * @throws Exception
     */
    public void RT_COMM_PIM_Contacts_Set_Photo_To_Contact_By_Camera(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        String contactName = "RT";
        int count = 1;
        try {
            contactsModule.addContacts(count);
            contactsModule.createContact(contactName,callNumber, email2account);

            commonModule.backOutToHomeScreen();

            contactsModule.setContactPicture();

            contactsModule.changeContactPicture();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            contactsModule.deleteContacts();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173424
     * RT_COMM_PIM_Contacts_Check quick contact function
     *
     * @throws Exception
     */
    public void RT_COMM_PIM_Contacts_Check_Quick_Contact_Function(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        int count = 2;
        try {
            contactsModule.addContacts(count);

            contactsModule.startPhonebook();
            contactsModule.selectCallFromQuickContact();
            contactsModule.selectMessageFromQuickContact();
            contactsModule.selectViewContactFormQuickContact();

            contactsModule.tapEmailIconFormQuickContact();
            contactsModule.tapMapsIconFormQuickContact();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            contactsModule.deleteContacts();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1178665 RT_COMM_Small
     * Application Launcher
     *
     * @throws Exception
     */
    public void RT_COMM_Small_Application_Launcher_with_underlaying_app(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            messagingModule.startMessagingFromMenu();

            smallApp.selectOneSmallApp("Calculator");

            smallApp.moveSmallApp("Calculator");

            smallApp.selectOneSmallApp("Timer");

            smallApp.focusUnderlayingApp();
            messagingModule.openMessageSettings();

            smallApp.closeSmallApps();
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Small_Application_Launcher_add_widget(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            smallApp.addSmallApp("YouTube");
            smallApp.selectOneSmallApp("YouTube");
            smallApp.closeSmallApps();

            smallApp.enterBrowserAndEnterWebPage();
            commonModule.backOutToHomeScreen();

            smallApp.addSmallApp("Walkman");
            smallApp.selectOneSmallApp("Walkman");
            smallApp.moveSmallApp("Walkman");
            smallApp.closeSmallApps();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            smallApp.deleteWidget("YouTube", "Walkman");
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173437
     * RT_COMM_Browser_Add bookmark
     *
     * @throws Exception
     */
    public void RT_COMM_Browser_Add_Bookmark(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            browser.startChrom();
            browser.loadWebPage("www.baidu.com");
            browser.addBookmarkButNotSave();
            browser.addBroswerBookmark("FAVORITE");
            browser.reopenFromHistory("www.baidu.com");
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            browser.deleteBookmark("FAVORITE");
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173477
     * RT_COMM_Messa_Delete Conversations
     *
     * @throws Exception
     */
    public void RT_COMM_Messa_Delete_Conversations_by_number(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            for (int i = 0; i < 2; i++) {
                // Receive sms, and the phone number need set to partner phone
                // number.
                messagingModule.remoteSendMessageToDUT(CommandConstantsUtils.COMMAND_SMS, callNumber);
                messagingModule.openReceiveMessage(CommandConstantsUtils.SMS_CONTENT_RECEIVE);
                commonModule.backOutToHomeScreen();
            }

            messagingModule.startMessagingFromMenu();
            messagingModule.deleteMessageWithNumber(callNumber);
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Messa_Delete_Conversations_mark_conversation(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            for (int i = 0; i < 2; i++) {
                // Receive sms, and the phone number need set to partner phone
                // number.
                messagingModule.remoteSendMessageToDUT(CommandConstantsUtils.COMMAND_SMS, callNumber);
                messagingModule.openReceiveMessage(CommandConstantsUtils.SMS_CONTENT_RECEIVE);
                commonModule.backOutToHomeScreen();
            }

            messagingModule.startMessagingFromMenu();
            messagingModule.deleteConversationByMark(callNumber);
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Messa_Delete_Conversations_delete_message(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            messagingModule.remoteSendMessageToDUT(CommandConstantsUtils.COMMAND_SMS, callNumber);
            messagingModule.openReceiveMessage(CommandConstantsUtils.SMS_CONTENT_RECEIVE);

            messagingModule.deleteMessageWithText(CommandConstantsUtils.SMS_CONTENT_RECEIVE);
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Messa_Delete_Conversations_delete_all_Conversations(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            messagingModule.remoteSendMessageToDUT(CommandConstantsUtils.COMMAND_SMS, callNumber);
            messagingModule.openReceiveMessage(CommandConstantsUtils.SMS_CONTENT_RECEIVE);
            commonModule.backOutToHomeScreen();

            messagingModule.startMessagingFromMenu();
            messagingModule.removeAllMessages();
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Messa_Delete_Conversations_delete_draft_Conversations(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            messagingModule.removeAllMessages();

            messagingModule.startMessagingFromMenu();

            messagingModule.insertOneDraftMessage(CommandConstantsUtils.SMS_CONTENT_RECEIVE);

            messagingModule.deleteConversationsWithName("Draft");
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173480
     * RT_COMM_Messa_MMS_Save attachement
     *
     * @throws Exception
     */
    public void RT_COMM_Messa_MMS_Save_Attachement_picture(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            messagingModule.removeAllMessages();
            camera.launchCameraPhotoApplication();
            camera.takePictures(1);

            messagingModule.sendMMSWithPictureAndSound(CommandConstantsUtils.SMS_CONTENT_LONG_OUT,
                    callNumber);
            commonModule.backOutToHomeScreen();

            messagingModule.openConversationByNameOrNumber(callNumber);
            messagingModule.savePictureInMessage();
            messagingModule.setMessagePictureAsWallpaper();
            commonModule.backOutToHomeScreen();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Messa_MMS_Save_Attachement_sound(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            messagingModule.removeAllMessages();

            if (!commonModule.isTextContains("recording")) {
                camera.launchCameraPhotoApplication();
                camera.takePictures(1);

                messagingModule.sendMMSWithPictureAndSound(
                        CommandConstantsUtils.SMS_CONTENT_LONG_OUT, callNumber);
            }
            commonModule.backOutToHomeScreen();

            messagingModule.openConversationByNameOrNumber(callNumber);
            messagingModule.playSoundInMessage();
            messagingModule.saveSoundInMessage();
            messagingModule.setSoundAsRingtone();
            telephonyModule.receiveMTCallButNotAnswer(callNumber);
            commonModule.backOutToHomeScreen();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Messa_MMS_Save_Attachement_video(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            messagingModule.removeAllMessages();

            messagingModule
                    .sendMMSWithVideo(CommandConstantsUtils.SMS_CONTENT_LONG_OUT, callNumber, 8);
            commonModule.backOutToHomeScreen();

            messagingModule.openConversationByNameOrNumber(callNumber);
            if (!commonModule
                    .isResourceId("com.sonyericsson.conversations:id/mms_slide_video_indicator")) {
                commonModule.scrollToBegin();
                commonModule
                        .scrollFindResourceIdNotClick("com.sonyericsson.conversations:id/mms_slide_video_indicator");
            }
            messagingModule.playVideoInMessage();
            messagingModule.saveVideoInMessage();

            messagingModule.deleteMessageWithText(CommandConstantsUtils.SMS_CONTENT_LONG_OUT);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173423
     * RT_COMM_YouTube_FirstStart
     *
     * @throws Exception
     */
    public void RT_COMM_YouTube_FirstStart_search(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            commonModule.clearData("YouTube");

            mediaModule.launchYouTube();

            mediaModule.clearSearchHistory();

            mediaModule.searchVideo();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_YouTube_FirstStart_playerControl(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            mediaModule.launchYouTube();

            mediaModule.chooseOneVideoToPlay();

            mediaModule.playerControl();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.setOrientationPortrait();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173356
     * RT_COMM_Call_SIGN_GSM_Call waiting
     *
     * @throws Exception
     */
    public void RT_COMM_Call_SIGN_GSM_Call_Waiting_answer_call(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            telephonyModule.setCallWaiting("on");

            commonModule.backOutToHomeScreen();

            telephonyModule.makeMOCallAndAnswered(callNumber);

            telephonyModule.answerMTCall(callNumber2);

            commonModule.wait(5);

            telephonyModule.endCall();

            telephonyModule.endCall();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Call_SIGN_GSM_Call_Waiting_busy_call(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            telephonyModule.setCallWaiting("on");

            commonModule.backOutToHomeScreen();

            telephonyModule.makeMOCallAndAnswered(callNumber);

            telephonyModule.receiveMTCallButNotAnswer(callNumber2);

            telephonyModule.endCall();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Call_SIGN_GSM_Call_Waiting_replace_active_call(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            telephonyModule.setCallWaiting("on");

            commonModule.backOutToHomeScreen();

            telephonyModule.makeMOCallAndAnswered(callNumber);

            telephonyModule.replaceCurrentCall(callNumber2);

            telephonyModule.endCall();

            telephonyModule.setCallWaiting("off");

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1178601 RT_COMM_Reject
     * call with message
     *
     * @throws Exception
     */
    public void RT_COMM_Reject_Call_With_Message_default(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {

            commonModule.sendSMSCommand(callNumber, CommandConstantsUtils.COMMAND_CALL);

            telephonyModule.rejectIncomingCallWithMessage("I'm busy. I'll call you back later.");
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Reject_Call_With_Message_edit_message(String casename,
            HashMap<String, String> paras) throws Exception {

        String newMsg = "I'm busy.";

        commonModule.backOutToHomeScreen();
        try {
            telephonyModule.editMessageToRejectCall(newMsg);

            commonModule.backOutToHomeScreen();

            commonModule.sendSMSCommand(callNumber, CommandConstantsUtils.COMMAND_CALL);

            telephonyModule.rejectIncomingCallWithMessage(newMsg);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1222051 RT_COMM_Answering
     * machine
     *
     * @throws Exception
     */
    public void RT_COMM_Answering_Machine_not_accept_incoming_call(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();

        String greetingName = "First greeting";

        int recordTime1 = 10;

        int pickUpTime = 5;// Time for seconds.

        try {
            telephonyModule.deleteAllVoiceMessageInAnswerMachine();

            telephonyModule.deleteAllGreetings();

            commonModule.backOutToHomeScreen();

            telephonyModule.turnOnAnsweringMachine(greetingName, recordTime1);

            telephonyModule.setPickUpAfter(pickUpTime);

            telephonyModule.checkGreetings(greetingName);

            telephonyModule.recordGreeting(30, "New greeting");

            telephonyModule.selectOneGreeting(greetingName);

            telephonyModule.checkAnswerMachineNotAcceptIncomingCall(callNumber, pickUpTime,
                    greetingName, recordTime1);

            telephonyModule.checkAndPlayVoiceMessageInAnswerMachine(callNumber);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Answering_Machine_accept_incoming_call_during_send_greeting(
            String casename, HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();

        String greetingName = "First greeting";

        int recordTime1 = 10;

        int pickUpTime = 5;// Time for seconds.

        try {
            telephonyModule.deleteAllVoiceMessageInAnswerMachine();

            commonModule.backOutToHomeScreen();

            telephonyModule.turnOnAnsweringMachine(greetingName, recordTime1);

            telephonyModule.checkAnswerMachineAnswerIncomingCall(callNumber, pickUpTime,
                    greetingName);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Answering_Machine_turn_off_answer_machine(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();

        String greetingName = "First greeting";

        int pickUpTime = 5;// Time for seconds.

        try {
            telephonyModule.deleteAllVoiceMessageInAnswerMachine();

            commonModule.backOutToHomeScreen();

            telephonyModule.turnOffAnsweringMachine();

            telephonyModule.checkIncomingCallWithAnswerMachineOff(callNumber, pickUpTime,
                    greetingName);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Answering_Machine_reject_incoming_call_with_answer_machine(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();

        String greetingName = "First greeting";

        int recordTime1 = 10;

        try {
            telephonyModule.clearCallLog();

            telephonyModule.deleteAllVoiceMessageInAnswerMachine();

            telephonyModule.turnOffAnsweringMachine();

            commonModule.backOutToHomeScreen();

            telephonyModule.rejectIncomingCallWithAnswerMachine(callNumber, greetingName,
                    recordTime1);

            commonModule.backOutToHomeScreen();

            telephonyModule.playVoiceMessageInCallLog();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Answering_Machine_accept_incoming_call_during_record_message(
            String casename, HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();

        String greetingName = "First greeting";

        int pickUpTime = 5;// Time for seconds.

        int recordTime1 = 10;

        try {
            telephonyModule.clearCallLog();

            telephonyModule.deleteAllVoiceMessageInAnswerMachine();

            telephonyModule.turnOffAnsweringMachine();

            commonModule.backOutToHomeScreen();

            telephonyModule.enableAnswerMachineFromCallLog(greetingName, recordTime1);

            telephonyModule.acceptIncomingCallDuringRecordMessage(callNumber, pickUpTime,
                    greetingName, recordTime1);

            commonModule.backOutToHomeScreen();

            telephonyModule.playVoiceMessageInCallLog();

            telephonyModule.disableAnswerMachineFromCallLog();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1243070 RT_COMM_EAP_SIM
     *
     * @throws Exception
     */
    public void RT_COMM_EAP_SIM(String casename, HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            settingsModule.connectGTEWifi();

            commonModule.backOutToHomeScreen();

            // mediaModule.startChrom();
            //
            // mediaModule.watchAudioAndVideoInChrom();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1178608 RT_COMM_Smart
     * Connect
     *
     * @throws Exception
     */
    public void RT_COMM_Smart_Connect(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        String eventName = "My event";
        String rename = "New event";
        try {
            smartConnect.launchSmartConnect();

            smartConnect.addNewEvent(eventName);

            smartConnect.renameEvent(eventName, rename);

            smartConnect.editEvent(rename);

            smartConnect.checkEvent(3 * 60 * 1000);

            smartConnect.deleteEvent(rename);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            smartConnect.deleteEvent(rename);
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173350
     * RT_COMM_SECU_SIM_Change PIN code
     *
     * @throws Exception
     */
    public void RT_COMM_SECU_SIM_Change_PIN_Code(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            settingsModule.setSimPinLock("on");
            commonModule.backOutToHomeScreen();

            settingsModule.changeSimPin();
            commonModule.backOutToHomeScreen();

            settingsModule.checkChangeSimPin();
            settingsModule.changeSimPin();
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            settingsModule.setSimPinLock("off");
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173457 RT_COMM_Album_Crop
     * & Rotate & Slideshow
     *
     * @throws Exception
     */
    public void RT_COMM_Album_Crop_Rotate_Slideshow(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            settingsModule.takeScreenshotViaPowerMenu();
            commonModule.backOutToHomeScreen();

            albumModule.openScreenshot();
            albumModule.selectSlideshow();
            commonModule.backOutToHomeScreen();
            albumModule.rotatePicture();
            commonModule.backOutToHomeScreen();
            albumModule.copyToSdcard();
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173460
     * RT_COMM_Messa_Email_Add Attachment
     *
     * @throws Exception
     */
    public void RT_COMM_Messa_Email_Add_Attachment_picture(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            emailModule.loginEmailSyncAutoServer(emailaccount, emailpassword);

            emailModule.sendEmailWithAttachment(email2account, "Picture", "Picture.JPG");

//            emailModule.checkEmailSendSuccessfully("Picture");

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Messa_Email_Add_Attachment_video(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            emailModule.loginEmailSyncAutoServer(emailaccount, emailpassword);

            emailModule.sendEmailWithAttachment(email2account, "Video", "Video.3gp");

//            emailModule.checkEmailSendSuccessfully("Video");

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Messa_Email_Add_Attachment_audio(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            emailModule.loginEmailSyncAutoServer(emailaccount, emailpassword);

            emailModule.sendEmailWithAttachment(email2account, "Audio","MusicAttachment.mp3");

//            emailModule.checkEmailSendSuccessfully("Audio");

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Messa_Email_Add_Attachment_delete_attach(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            emailModule.loginEmailSyncAutoServer(emailaccount, emailpassword);

            emailModule.sendEmailWithAttachment(email2account, "Delete attachment", "MusicAttachment.mp3");

//            emailModule.checkEmailSendSuccessfully("Audio");

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1221622
     * Rhine_RT_Sony United WALKMAN 4.0
     *
     * @throws Exception
     */
    public void RT_COMM_Sony_united_Music_BasicUIandPlayingCheck_repeat_one (String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            //playing music and verify
            String songNameString = "Because Of You";

            walkman.playMusic(songNameString);

            walkman.stopPlayingMusic();

            walkman.verifyAlbumStateWhenMusicPlaying(songNameString, false);

            //verfiy repeat one function
            walkman.setRepeatOne();

            walkman.startPlayingMusic();

            String songname1 = walkman.getCurrentSongName();

            System.out.println("fast forward finished");

            //wait current song playing finished
            commonModule.wait(60*5);

            String songname2 = walkman.getCurrentSongName();

            testCase.assertTrue("set repeat one song failed", songname1.equals(songname2));

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
        	walkman.stopMusicFromStatusBar();
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Sony_united_Music_BasicUIandPlayingCheck_shuffle_on (String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();
        try {

            walkman.playMusic();

            walkman.stopPlayingMusic();

            //verfiy shuffle function
            walkman.setShuffle(true);

            walkman.startPlayingMusic();

            walkman.verifyMusicPlaying();

            String songname1 = walkman.getCurrentSongName();

            //wait current song playing finished
            commonModule.wait(60*5);

            String songname2 = walkman.getCurrentSongName();

            testCase.assertTrue("set repeat one song failed", songname1 !=songname2);
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
        	walkman.stopMusicFromStatusBar();
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Sony_united_Music_BasicUIandPlayingCheck_incoming_call(String casename, HashMap<String, String> paras) throws Exception {
        commonModule.backOutToHomeScreen();

        try {
            walkman.playMusicOnBackground();

            walkman.verifyMusicPlaying();

            telephonyModule.answerMTCall(callNumber);

            telephonyModule.endCall();

            walkman.verifyMusicPlaying();
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
        	walkman.stopMusicFromStatusBar();
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1178663
     * RT_COMM_Blue_Xperia Super Stamina_Notification
     *
     * @throws Exception
     */
    public void RT_COMM_Blue_Xperia_Super_Stamina_Notification_ReceiveMessage_and_Reply(String casename, HashMap<String, String> paras) throws Exception {
        commonModule.backOutToHomeScreen();

        try {
            settingsModule.setStaminaMode("ON");

            //POWER OFF
            testCase.getUiDevice().pressKeyCode(KeyEvent.KEYCODE_POWER);

            commonModule.sendSMSCommand(callNumber, "SMS");

            //Wait for reference phone send sms
            commonModule.wait(10);

            //power on
            testCase.wakeDevice();
            commonModule.unLockScreen();

            messagingModule.checkReceiveSMS("Are you going to the party tonight?", 10);

            messagingModule.startMessagingFromMenu();

            messagingModule.replySMSMessage("reply ok?", callNumber);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            settingsModule.setStaminaMode("OFF");
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Blue_Xperia_Super_Stamina_Notification_ReceiveIncomingCall(String casename, HashMap<String, String> paras) throws Exception {
        commonModule.backOutToHomeScreen();

        try {
            settingsModule.setStaminaMode("ON");

            //POWER OFF
            testCase.getUiDevice().pressKeyCode(KeyEvent.KEYCODE_POWER);

            commonModule.sendSMSCommand(callNumber, "CALL");

            telephonyModule.answerIncomingCall();

            telephonyModule.endCall();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            telephonyModule.endCall();
            commonModule.unLockScreen();
            settingsModule.setStaminaMode("OFF");
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1225149
     * RT_COMM_Rhine_Email Application Upgrade
     *
     * @throws Exception
     */
    public void RT_COMM_Rhine_Email_Application_Upgrade_reply_email(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            emailModule.loginEmailSyncAutoServer(emailaccount, emailpassword);

            emailModule.sortBy("Thread");

            emailModule.replyEmail(false);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Rhine_Email_Application_Upgrade_sync_frequency(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            emailModule.addAccount(email2account, email2password, 3);

            emailModule.addAccount(emailaccount, emailpassword,3);

            emailModule.setSynchronizFrequency(emailaccount, "Every 15 minutes");

            commonModule.backOutToHomeScreen();

            emailModule.setSynchronizFrequency(email2account, "Every 30 minutes");

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173344
     * RT_COMM_PIN_Contacts_Favourites_Add and Remove
     *
     * @throws Exception
     */
    public void RT_COMM_PIN_Contacts_Favourites_Add_And_Remove(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
            contactsModule.deleteContacts();
            contactsModule.startPhonebook();
            contactsModule.importContacts("Internal storage", "PIM00001.vcf");
            contactsModule.addContactWithNumberWithoutName("123456789");

            contactsModule.addAllContactsToFavorite("Common","Image","123456789","No Number But Address","No Image","Qwertyuioplkjhgfdsazxcvbnmqwertyuiopasdfghjklzxcvbnm");

            contactsModule.deleteFavoriteContact("Common");
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173380
     * Rhine_RT_PIM_Calculator_Basic function
     *
     * @throws Exception
     */
    public void Rhine_RT_PIM_Calculator_Basic_Function(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            calculator.launchCalculator();

            calculator.checkInput();

            calculator.checkMathOperator();

            calculator.checkSpecialOperator();
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173599
     * RT_COMM_FBI_Calendar sync
     *
     * @throws Exception
     */
    public void RT_COMM_FBI_Calendar_Sync(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            facebook.addFacebookAccount(facebookaccount, facebookpassword);

            facebook.launchFacebook(facebookaccount, facebookpassword);
            facebook.addEventsFromFacebook();

            facebook.selectSyncCalendar();

            facebook.checkCalendarData();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_FBI_Music_Your_Own_Music(String casename,
            HashMap<String, String> paras) throws Exception {
    	String songNameString = "Because Of You";
        commonModule.backOutToHomeScreen();
        try {
            facebook.addFacebookAccount(facebookaccount, facebookpassword);

            walkman.playMusic(songNameString);

            walkman.likeOneMusicAndAddComments("i like you");

            walkman.unlikeMusic();
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            walkman.stopMusicFromStatusBar();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_FBI_Music_Your_Friends_Music(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            facebook.addFacebookAccount(facebookaccount, facebookpassword);

            walkman.likeFriendsMusic();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            walkman.stopMusicFromStatusBar();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Call_Dialer_Conference_Call_with_PHF(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            telephonyModule.setCallWaiting("on");

            telephonyModule.answerMTCall(callNumber);

            telephonyModule.answerMTCall(callNumber2);

            telephonyModule.mergeCall();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {

            telephonyModule.endCall();
            commonModule.wait(5);
            telephonyModule.endCall();
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1294017
     * RT_COMM_Call settings
     *
     * @throws Exception
     */
    public void RT_COMM_Call_Settings(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            telephonyModule.checkMicrophoneNoiseSuppression(callNumber);

            telephonyModule.checkEqualizer(callNumber);

            telephonyModule.checkSpeakerVoiceEnhancement(callNumber);

            telephonyModule.checkSlowTalk(callNumber);
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

	/**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173598
     * RT_COMM_CAM Fast capturing
     *
     * @throws Exception
     */
    public void RT_COMM_CAM_Fast_Capturing(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            // Lock screen
            commonModule.lockScreen();

            // Press hold Camera HW key and take picture
            camera.holdCameraKey();
            camera.takePictures(1);
            camera.openLatestPictureInCamera();
            commonModule.backOutToHomeScreen();

            //Enable passord for lock screen
            commonModule.enableLockScreenPassword();

            //Lock screen
            commonModule.lockScreen();

            //Press hold Camera HW key and switch capturing mode
            camera.holdCameraKey();
            commonModule.wait(2);
            camera.pressCameraButton();
            camera.selectOneEffectFromCameraSettings("Manual");

            //Unlock the password lock
            commonModule.unlockPasswordLock();
            camera.verifyManualMode();
            commonModule.backOutToHomeScreen();



        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
			commonModule.unlockPasswordLock();
			commonModule.disableLockScreenPassword();
            commonModule.backOutToHomeScreen();
            commonModule.clearData("Camera");
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173599
     * RT_COMM_FBI_Gallery
     *
     * @throws Exception
     */
    public void RT_COMM_FBI_Gallery(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            facebook.addFacebookAccount(facebookaccount, facebookpassword);
            facebook.openAFacebookPhoto(1, false);
            facebook.addCommentForPhoto();
            commonModule.backOutToHomeScreen();

            facebook.openAFacebookPhoto(2, false);
            facebook.addCommentForPhoto();
            commonModule.backOutToHomeScreen();

            facebook.openAFacebookPhoto(3, false);
            facebook.addCommentForPhoto();
            commonModule.backOutToHomeScreen();

            // View photo in landscape
            facebook.openAFacebookPhoto(1, true);
            commonModule.backOutToHomeScreen();

            facebook.openAFacebookPhoto(2, true);
            commonModule.backOutToHomeScreen();

            facebook.openAFacebookPhoto(3, true);
            commonModule.backOutToHomeScreen();

            } catch (Exception ex) {
                commonModule.takeScreenShot(casename);
                throw ex;
            } catch (AssertionFailedError ex) {
                commonModule.takeScreenShot(casename);
                throw ex;
            } catch (Error ex) {
                commonModule.takeScreenShot(casename);
                throw ex;
            } finally {
                commonModule.backOutToHomeScreen();
                commonModule.unLockScreen();
                commonModule.backOutToHomeScreen();
            }
    }

        /**
         * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173452
         * RT_COMM_VPN_Impropriety authentication
         *
         * @throws Exception
         */
        public void RT_COMM_VPN_Impropriety_Authentication_L2TP_RSA(String casename,
                HashMap<String, String> paras) throws Exception {
        			boolean credentials = false;
        			boolean deleteVPN = true;
            commonModule.backOutToHomeScreen();
            try {
            	settingsModule.installCA();
            	credentials=true;
            	settingsModule.openVPNSetting();
            	settingsModule.createL2tpRsaVPN();
            	settingsModule.connectVPNImpropriety(test_vpnusername, test_vpnpassword);
            	settingsModule.verifyVPN();
            	settingsModule.disconnectVPN();
            	settingsModule.deleteVPN();
            	deleteVPN = false;
            	commonModule.backOutToHomeScreen();

            } catch (Exception ex) {
                commonModule.takeScreenShot(casename);
                throw ex;
            } catch (AssertionFailedError ex) {
                commonModule.takeScreenShot(casename);
                throw ex;
            } catch (Error ex) {
                commonModule.takeScreenShot(casename);
                throw ex;
            } finally {
                commonModule.backOutToHomeScreen();
                if(deleteVPN){
                	settingsModule.openVPNSetting();
                	settingsModule.deleteVPN();
                }
                if(credentials){
                	settingsModule.removeCA();
                }
                commonModule.unlockPasswordLock();
                commonModule.disableLockScreenPassword();
                commonModule.unLockScreen();
                commonModule.backOutToHomeScreen();
            }
    }


        /**
         * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173452
         * RT_COMM_VPN_Impropriety authentication
         *
         * @throws Exception
         */
        public void RT_COMM_VPN_Impropriety_Authentication_L2TP_PSK(String casename,
                HashMap<String, String> paras) throws Exception {
        		  boolean deleteVPN = true;
            commonModule.backOutToHomeScreen();
            try {

            	settingsModule.openVPNSetting();
            	settingsModule.createL2tpPskVPN();
            	settingsModule.connectVPNImpropriety(test_vpnusername, test_vpnpassword);
            	settingsModule.verifyVPN();
            	settingsModule.disconnectVPN();
            	settingsModule.deleteVPN();
            	deleteVPN = false;
            	commonModule.backOutToHomeScreen();

            } catch (Exception ex) {
                commonModule.takeScreenShot(casename);
                throw ex;
            } catch (AssertionFailedError ex) {
                commonModule.takeScreenShot(casename);
                throw ex;
            } catch (Error ex) {
                commonModule.takeScreenShot(casename);
                throw ex;
            } finally {
                commonModule.backOutToHomeScreen();
               if(deleteVPN){
               	settingsModule.openVPNSetting();
               	settingsModule.deleteVPN();
               }
                commonModule.backOutToHomeScreen();
				commonModule.unlockPasswordLock();
  				commonModule.disableLockScreenPassword();
                commonModule.unLockScreen();
                commonModule.backOutToHomeScreen();
            }
    }



        /**
         * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173452
         * RT_COMM_VPN_Impropriety authentication
         *
         * @throws Exception
         */
        public void RT_COMM_VPN_Impropriety_Authentication_PPTP(String casename,
                HashMap<String, String> paras) throws Exception {
        			boolean deleteVPN = true;
            commonModule.backOutToHomeScreen();
            try {
            	settingsModule.openVPNSetting();
           	    settingsModule.createPptpVPN();
            	settingsModule.connectVPNImpropriety(test_vpnusername, test_vpnpassword);
            	settingsModule.verifyVPN();
            	commonModule.backOutToHomeScreen();

            	settingsModule.browerInternet("http://www.baidu.com","baidu");
            	commonModule.backOutToHomeScreen();

            	settingsModule.openVPNSetting();
            	settingsModule.disconnectVPN();
            	settingsModule.deleteVPN();
            	deleteVPN = false;
            	commonModule.backOutToHomeScreen();

            } catch (Exception ex) {
                commonModule.takeScreenShot(casename);
                throw ex;
            } catch (AssertionFailedError ex) {
                commonModule.takeScreenShot(casename);
                throw ex;
            } catch (Error ex) {
                commonModule.takeScreenShot(casename);
                throw ex;
            } finally {
                commonModule.backOutToHomeScreen();
               if(deleteVPN){
               	settingsModule.openVPNSetting();
               	settingsModule.deleteVPN();
               }
           	 	commonModule.backOutToHomeScreen();
				commonModule.unlockPasswordLock();
			    commonModule.disableLockScreenPassword();
                commonModule.backOutToHomeScreen();
            }
    }


    public void RT_COMM_Dialer_Save_the_number_of_dialer_text_box_into_contact(String casename, HashMap<String, String> paras)
            throws Exception {

        commonModule.backOutToHomeScreen();

        try {
        	telephonyModule.launchPhone();

        	contactsModule.saveContactFromDialer("","Empty Phone Number");

        	telephonyModule.launchPhone();

        	contactsModule.saveContactFromDialer("*#1234567890","Symbols Phone Number");

        	telephonyModule.launchPhone();

        	contactsModule.saveContactFromDialer(callNumber,"Normal Phone Number");

        	commonModule.sendSMSCommand(callNumber, CommandConstantsUtils.COMMAND_CALL);

        	telephonyModule.answerIncomingCall();

        	telephonyModule.checkOngingCallName("Normal Phone Number");

        	telephonyModule.endCall();

        	telephonyModule.makeMOCallAndAnswered(callNumber);

        	telephonyModule.checkOngingCallName("Normal Phone Number");


        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            telephonyModule.endCall();
            contactsModule.deleteContacts();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173443 RT_COMM_Call_Voice
     * Call Use basic features during an ongoing call
     *
     * @throws Exception
     */
    public void RT_COMM_Call_Voice_Call_Use_Basic_Features_During_An_Ongoing_Call(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            contactsModule.deleteContacts();
            commonModule.backOutToHomeScreen();

            telephonyModule.answerMTCall(callNumber);
            telephonyModule.tapLouderSpeakerIcon();
            telephonyModule.changeVolumeLevel();
            telephonyModule.muteOrUnmuteMicrophone("mute");
            telephonyModule.muteOrUnmuteMicrophone("unmute");
            telephonyModule.checkCallTimer();
            telephonyModule.endCall();
            commonModule.backOutToHomeScreen();

            telephonyModule.saveContactFromCallLog(callNumber, "Anna");
            messagingModule.sendSMS("Send SMS.", callNumber);
            messagingModule.sendMMSWithImage("Send MMS", callNumber, true);
            commonModule.backOutToHomeScreen();

            telephonyModule.makeMOCallWithoutAnswered(callNumber2);
            telephonyModule.endCall();
            telephonyModule.saveContactFromCallLog(callNumber2, "Tom");
            telephonyModule.sendMessageFromCallLog("Tom");
            messagingModule.waitMessageSendSuccessfully();
            telephonyModule.callbackFromCallLog("Tom");
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
        	contactsModule.deleteContacts();
            commonModule.backOutToHomeScreen();
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173400 RT_COMM_Status
     * bar_Message
     *
     * @throws Exception
     */
    public void RT_COMM_Status_Bar_Message_receive_one_sms(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            commonModule.clearNotificationsBar();
            messagingModule.startMessagingFromMenu();
            messagingModule.removeAllMessages();
            commonModule.backOutToHomeScreen();

            messagingModule.remoteSendMessageToDUT(CommandConstantsUtils.COMMAND_SMS, callNumber);
            messagingModule.openReceiveMessage(CommandConstantsUtils.SMS_CONTENT_RECEIVE);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Status_Bar_Message_receive_more_sms(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            commonModule.clearNotificationsBar();
            messagingModule.startMessagingFromMenu();
            messagingModule.removeAllMessages();
            commonModule.backOutToHomeScreen();

            messagingModule.remoteSendMessageToDUT(CommandConstantsUtils.COMMAND_SMS, callNumber);
            messagingModule.remoteSendMessageToDUT(CommandConstantsUtils.COMMAND_SMS, callNumber2);
            messagingModule.checkStatusBarForMoreSMS(2, CommandConstantsUtils.SMS_CONTENT_RECEIVE);

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    public void RT_COMM_Status_Bar_Message_receive_mms(String casename,
            HashMap<String, String> paras) throws Exception {

        commonModule.backOutToHomeScreen();
        try {
            messagingModule.startMessagingFromMenu();
            messagingModule.removeAllMessages();
            commonModule.backOutToHomeScreen();
            messagingModule.receiveMMSWithoutAPN(callNumber, CommandConstantsUtils.MMS_CONTENT_RECEIVE);

            messagingModule.startMessagingFromMenu();
            messagingModule.removeAllMessages();
            commonModule.backOutToHomeScreen();
            messagingModule.reciveMMSWithAPN(callNumber, CommandConstantsUtils.MMS_CONTENT_RECEIVE);
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

/**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173361
     * RT_COMM_Settings_Date & Time Change date format
     *
     * @throws Exception
     */
    public void RT_COMM_Settings_Date_Time_Change_Date_Format(String casename, HashMap<String, String> paras)
            throws Exception {
    			long date = System.currentTimeMillis()+86400000;
        commonModule.backOutToHomeScreen();

        try {
            settingsModule.checkDateTimeSetting();
            settingsModule.setDateFormat();
            settingsModule.setDateManual(date);
            settingsModule.setTimeZoneManual();
            settingsModule.change24HourFormat();
            commonModule.unLockScreen();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1178572
     * RT_COMM_APN usage with IPV6

     *
     * @throws Exception
     */
    public void RT_COMM_APN_Usage_With_IPV6(String casename, HashMap<String, String> paras)
            throws Exception {
        commonModule.backOutToHomeScreen();
        		String apnName=null;
        try {
        			apnName="ipv6";
        			settingsModule.createAndSetAPN(apnName, "gte-ipv6i", "IPv6");
        			settingsModule.browerInternet("http://seldunx10.ipv6.gte.nu","Global Test Environment");
        			commonModule.backOutToHomeScreen();
        			settingsModule.deleteAPN(apnName);

        			apnName="ipv4v6";
        			settingsModule.createAndSetAPN(apnName, "gte-ipv4v6", "IPv4/IPv6");
        			settingsModule.browerInternet("http://seldunx10.ipv6.gte.nu","Global Test Environment");
        			commonModule.backOutToHomeScreen();
        			settingsModule.deleteAPN(apnName);

        			apnName="ipv4";
        			settingsModule.createAndSetAPN(apnName, "gte-internet", "IPv4");
        			emailModule.addGoogleAccount(test_gmailaccount, test_gmailpassword);
        			commonModule.backOutToHomeScreen();
        			settingsModule.deleteAPN(apnName);
        			apnName=null;


        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            if(apnName!=null){
            	settingsModule.deleteAPN(apnName);
            }
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }


    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1173386
     * RT_COMM_PIM_Contacts_Edit number before call
     *
     * @throws Exception
     */
    public void RT_COMM_PIM_Contacts_Edit_Number_Before_Call(String casename, HashMap<String, String> paras)
            throws Exception {
        commonModule.backOutToHomeScreen();
        String contact = "PIMTest_1173386";
        String number = "15699000000";
        boolean flag = false;
        try {
    				contactsModule.createContactsURI(contact, number,"asdfasfad@163.com");
    				contactsModule.startPhonebook();
		        	contactsModule.editContactNumber(contact, number, callNumber);
		        	contactsModule.callContactInContactDetail(contact, callNumber);
		        	flag = true;
		        	telephonyModule.verifyCallAnsweredWithCallNumber(callNumber);
		        	telephonyModule.endCall();
		        	flag = false;
        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
        	if(flag){
            telephonyModule.endCall();
        	}
            commonModule.backOutToHomeScreen();
            contactsModule.deleteContacts();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1217702_1
     * RT_COMM_Call_SIP&VOIP

     *
     * @throws Exception
     */
    public void RT_COMM_Call_SIP_VOIP_sip(String casename, HashMap<String, String> paras)
            throws Exception {
        commonModule.backOutToHomeScreen();

        String callSetting[] = {"Use SIP with network access", "Only to SIP address","Always ask"};

        try {
        	//commonModule.sendSMSCommand(callNumber, CommandConstantsUtils.COMMAND_SIP_INTERNET_ADDRESS);

        	telephonyModule.configSipSetting("ask");
        	telephonyModule.addSipAccount(test_sipaccount, test_sippassword,"192.168.65.6");
        	commonModule.sendSMSCommand(callNumber, CommandConstantsUtils.COMMAND_ANSWER_CALL);
        	telephonyModule.makeMOCallAndAnswered(partner_sipaccount);
        	telephonyModule.verifyCallOngoingWithinSpecifiedTime(10);
        	telephonyModule.endCall();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
        			commonModule.backOutToHomeScreen();
        			//commonModule.sendSMSCommand(callNumber, CommandConstantsUtils.COMMAND_SIP_ADDRESS);
            telephonyModule.configSipSetting("off");
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }

    /**
     * Case in Sony ALM: Domain: PSV Project: PSV ID: 1217702_2
     * RT_COMM_Call_SIP&VOIP

     *
     * @throws Exception
     */
    public void RT_COMM_Call_SIP_VOIP_voip(String casename, HashMap<String, String> paras)
            throws Exception {
        commonModule.backOutToHomeScreen();
        try {

        			telephonyModule.launchSkype();
        			telephonyModule.verifySkypeLaunched(20);
        			telephonyModule.loginSkype(test_skypeaccount, test_skypepassword);
        			telephonyModule.makeSkypeCallAndAnswered(test_partnerskypeaccount);
        			commonModule.wait(10);
        			telephonyModule.endSkypeCall();

        } catch (Exception ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (AssertionFailedError ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } catch (Error ex) {
            commonModule.takeScreenShot(casename);
            throw ex;
        } finally {
            commonModule.backOutToHomeScreen();
            telephonyModule.endCall();
            commonModule.unLockScreen();
            commonModule.backOutToHomeScreen();
        }
    }
    // /**
    // * Case in Sony ALM: Domain: PSV Project: PSV ID: 1221516
    // * RT_COMM_Notification Bar_On & Off Setting
    // *
    // * @throws Exception
    // */
    // public void RT_COMM_Notification_Bar_On_And_Off_Setting(String casename,
    // HashMap<String, String> paras) throws Exception {
    //
    // commonModule.backOutToHomeScreen();
    //
    // try {
    //
    // } catch (Exception ex) {
    // commonModule.takeScreenShot(casename);
    // throw ex;
    // } catch (AssertionFailedError ex) {
    // commonModule.takeScreenShot(casename);
    // throw ex;
    // } catch (Error ex) {
    // commonModule.takeScreenShot(casename);
    // throw ex;
    // } finally {
    // commonModule.unLockScreen();
    // commonModule.backOutToHomeScreen();
    // }
    // }
}
