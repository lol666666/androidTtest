package com.concurrent.scenario;

import java.util.HashMap;

import android.view.KeyEvent;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.module.camera.AbstractCameraFactory;
import com.module.camera.ICamera;
import com.module.common.CommonModule;
import com.parents.GroupFactories;
import com.parser.data.ModuleDataParser;
import com.sonyericsson.test.acceptancetest.AcceptanceTestCase;

public class ScenarioRecordingVideoTimeshiftVideo implements IScenario {
	public static String TAG = "Reliability";
	private Object obj;
	private CommonModule commonModule;
	private ICamera camera;
	private AcceptanceTestCase testCase;
	HashMap<String, String> moduleData;

	public ScenarioRecordingVideoTimeshiftVideo(AcceptanceTestCase testCase) {
		this.testCase = testCase;
		moduleData = ModuleDataParser.getModuleData("camera");
		this.commonModule = new CommonModule(testCase);
		camera = ((AbstractCameraFactory) GroupFactories.createFactory(
				testCase, "camera")).create();

	}

	@Override
	public void doBegin() throws Exception {
		camera.launchCameraPhotoApplication();
		camera.selectOneEffectFromCameraSettings("Timeshift video");
		boolean subButton = commonModule.waitForId(
				moduleData.get("Common_Record_Button_Id"), 5000);
		if (subButton) {
			commonModule.clickResourceId(moduleData
					.get("Common_Record_Button_Id"));
		} else {
			commonModule.clickResourceId(moduleData
					.get("Record_Video_Main_Button_Id"));
		}
		commonModule.wait(2);
	}

	public void doAfter() throws UiObjectNotFoundException {

		// AcceptanceTestCase.assertTrue("Video recording failed",
		// commonModule.waitForResourceId("com.sonyericsson.android.camera:id/recording_time",
		// 5000));
		commonModule.wait(10);
		AcceptanceTestCase.assertTrue(
				"Camera display incorrectly",
				commonModule.waitForResourceId(
						moduleData.get("Common_Record_Button_Id"), 10 * 1000));
		commonModule.clickResourceId(moduleData.get("Common_Record_Button_Id"));
		commonModule.backOutToHomeScreen();
	}

}
