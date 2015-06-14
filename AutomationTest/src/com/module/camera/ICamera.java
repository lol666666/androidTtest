package com.module.camera;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.parents.Module;

public interface ICamera extends Module{

    /**
     * Starts camera photo application and makes sure that camera is ready to
     * take picture.
     *
     * @throws ViewNotFoundException
     */
    void launchCameraPhotoApplication();

    /**
     * Pressing camera button for recording a video during specific recording
     * time when camera video application is opened. Make sure that camera video
     * application is launched before invoking this method.
     *
     * @recordingTime recordingTime in seconds.
     */
    void recordVideo(int recordingTime) throws UiObjectNotFoundException;

    /**
     * Pressing switch camera button for switch camera
     *
     */
    void switchCamera();

    /**
     * Pressing camera button to take picture when camera photo application is
     * opened. Make sure that camera Photo application is launched before
     * invoking this method.
     */
    void takePictures(int picNum) throws UiObjectNotFoundException;

    /**
     * Pressing more menu icon to change Preview. Make sure that camera photo
     * application is launched before invoking this method,and it is Creative
     * Effect mode.
     *
     * @preview The vertical coordinate of the selected Creative Effect.
     */
    void changePreviewMode(String preview,boolean videoSetting) throws UiObjectNotFoundException;

    /**
     * Pressing the coordinates for change the Creative Effect mode. Make sure
     * that camera photo application is launched and into Creative Effect mode
     * before invoking this method.
     *
     * @y The vertical coordinate of the selected Creative Effect.
     */
    void selectOneCreativeEffect(int y) throws UiObjectNotFoundException;

    /**
     * Starts camera photo application. Pressing resent photos for checking the
     * pictures. Scroll the screen to view next picture.
     *
     * @picNum the number of pictures are checked.
     */
    void checkPictures(int picNum) throws UiObjectNotFoundException;

    /**
     * Launch camera, then pressing camera mode selected button to choose the
     * mode application in camera.
     *
     * @cameraMode Camera Mode
     */
    void launchCameraByMode(String cameraMode);

    /**
     * Switch camera microphone on/off in timeshift mode, Make sure that camera
     * timeshift mode application is launched before invoking this method.
     */
    void switchMicrophoneOnTimeshiftMode();

    /**
     * Open the last picture in camera. Make sure that camera is launched, and
     * have taken a picture via camera.
     */
    void openLatestPictureInCamera() throws UiObjectNotFoundException;

    /**
     * Open the last picture in camera. Make sure that camera is launched, and
     * have recorded a video via camera.
     */
    void openLatestVideoInCamera() throws UiObjectNotFoundException;

    /**
     * Pressing camera button for recording a video on timeshift mode when
     * camera timeshift application is opened. Make sure that camera timeshift
     * application application is launched before invoking this method.
     *
     * @recordingTime recording time in second
     */
    void recordVideoOnTimeshiftMode(int recordingTime) throws UiObjectNotFoundException;

    /**
     * Pressing mode selector button for selecting one Effect. Make sure that
     * camera photo application is launched before invoking this method.
     *
     * @effectName Be selected effect name.
     */
    void selectOneEffectFromCameraSettings(String effectName) throws UiObjectNotFoundException;

    /**
     * Change AR effect mode. Make sure that camera photo application is
     * launched and into AR effect mode before invoking this method.
     *
     * @effectName Be selected effect name.
     */
    void selectOneAREffect(String areffect);

    /**
     * Taking pictures with Background defocus mode. Make sure that camera photo
     * application is launched and into Background defocus mode before invoking
     * this method.
     */
    void takePicturesWithBackgroundDefocusMode();

    /**
     * Launch Camera application, clear camera data from recentApp.Launch Camera
     * application again, agree remember photo location.
     */
    void activeGeoTagFromCameraSettings() throws UiObjectNotFoundException;

    /**
     * Open HDR mode from camera setting in manual mode
     *
     */
    void openHDR();

    /**
     * Open 4k2k mode for picture from camera setting in manual mode
     *
     */
    public void open4K2KPictureMode();

    /**
     * Change the settings in 4K video. Make sure that 4K mode application is
     * launched before invoking this method.
     *
     * @steadyShot steadyShot setting in 4K video mode, value is 0: Standard, 1: Off
     * @preview preview setting in 4K video mode, value is 0: On, 1: Edit, 2: Off
     */
	public void change4KVideoSetting(int steadyShot, int preview);

    /**
     * Pressing camera button for recording a video on 4k mode
     * when camera 4k application is opened. Make sure that camera 4k application
     * application is launched before invoking this method.
     *
     * @recordingTime recording time in second
     */
	public void recordVideoOn4KMode(int recordingTime) throws UiObjectNotFoundException;

	/**
	 * Change scenes. Make sure that camera photo application is
	 * launched and into Manual mode before invoking this method.
	 *
	 * @scenes Scenes name.
	 */
	void changeScenes(String scenes) throws UiObjectNotFoundException;

	void changeScenesByCoordinate(int pointX);

	/**
	 * Pressing camera button for recording a video on AR effect mode when
	 * camera AR effect application is opened. Make sure that camera AR effect
	 * application is launched before invoking this method.
	 *
	 * @recordingTime recording time in second
	 */
	void recordVideoByAREffect(int recordingTime) throws UiObjectNotFoundException;

	/**
	 * Pressing thumbnail of latest photo for checking the pictures. Scroll the
	 * screen to view next video.
	 *
	 * @videoNum The videos number.
	 */
	void checkVideos(int videoNum) throws UiObjectNotFoundException;

	int selectAllAREffectAndTakePictures()throws UiObjectNotFoundException;

	void selectAllCreativeEffectAndTakePictures() throws UiObjectNotFoundException;

	void selectAllPreviewModeAndTakePictures() throws UiObjectNotFoundException;

	void selectAllScenesAndTakePictures() throws UiObjectNotFoundException;

	int selectAllAREffectAndRecordVideos(int recordingTime) throws UiObjectNotFoundException;

	/**
	 * Pressing switch to video icon.Make sure camera is launched by Manual
	 * mode.
	 */
	void switchToVideoWithManualMode() throws UiObjectNotFoundException;

	/**
	 * Pressing camera button for recording a video on Manual mode when camera
     * Manual is opened. Make sure that camera Manual application is launched
     * before invoking this method.
     *
	 * @param scenes
	 * @throws UiObjectNotFoundException
	 */
	void selectScenesAndRecordVideos(String ... scenes) throws UiObjectNotFoundException;

	void recordVideoByManualMode(int recordingTime) throws UiObjectNotFoundException;

	void selectAllAppsAndRecordVideos(int recordingTime) throws UiObjectNotFoundException;

    /**
     * Pressing camera button for recording a video on Manual mode when camera
     * Manual is opened, during video recording zoom+ and zoom-.
     *
     * @recordingTime recording time in second
     */
    void recordVideoWithZoom() throws UiObjectNotFoundException;

    /**
     * Launch Camera application, set Geo Tagging off in camera settings.
     */
    void setGeoTaggingOff() throws UiObjectNotFoundException;

    /**
     * Launch Camera application, select all White balance, then take pictures. Make sure camera
     * launched by Manual Mode.
     */
    void selectAllWhiteBalanceAndTakePhotos() throws UiObjectNotFoundException;

    /**
     * Verify the White Balance change correctly. Make sure camera launched by
     * Manual Mode.
     *
     * @wb The description of White balance be changed.
     */
    void verifyWhiteBalance(String wb) throws UiObjectNotFoundException;

    /**
     * set HDR On or Off in camera setting.Make sure camera launched by Manual
     * Mode.
     *
     * @flag On or Off.
     */
    void setHDROnOrOff(String flag)throws UiObjectNotFoundException;

    /**
     * Select All video resolution, and record videos.Make sure camera launched
     * by Manual Mode.
     *
     * @recordingTime recording time in second
     */
    void selectAllResolutionAndRecordVideos(int recordingTime) throws UiObjectNotFoundException;

    /**
     * Short press zoom- and zoom+. Make sure camera launched by Manual Mode.
     */
    void shortPressZoomKey();

    /**
     * Long press zoom- and zoom+. Make sure camera launched by Manual Mode.
     */
    void longPressZoomKey();

    /**
     * Change "Use Volume Key As" to Zoom/Volume/Shutter. Make sure camera
     * launched by Manual Mode.
     *
     * @volumeKey Zoom/Volume/Shutter
     */
    void changeUseVolumeKeyAs(String volumeKey) throws UiObjectNotFoundException;

    /**
     * Verify change "Use Volume Key As" Volume work well. Make sure camera
     * launched by Manual Mode.
     */
    void verifyVolumeKeyAsVolume();

    /**
     * Verify change "Use Volume Key As" Shutter work well. Make sure camera
     * launched by Manual Video Mode.
     */
    void verifyVolumeKeyAsShutter();

    /**
     * Launch camera by holding camera key
     */
    void holdCameraKey();

    /**
     * verify manual mode
     */
    void verifyManualMode();

    /**
     * Launch camera with geo active.
     */
    void launchCameraWithGeoActive() throws UiObjectNotFoundException;

	/**
     * Press take pacture key
     *
     */
    void pressCameraButton();

	/**
     * Take create effect video
     *
     */
    void takeCreateEffectVideo() throws UiObjectNotFoundException;

	/**
     * Stop video recording
     *
     */
    void stopCreateEffectVideoRecording() throws UiObjectNotFoundException;

    void repeatChangeEffectAndTakePicture(int timeout) throws UiObjectNotFoundException;

    void switchMicrophone() throws UiObjectNotFoundException;

    void recordVideoFaceIn(int recordingTime) throws UiObjectNotFoundException;

    void selectAllCreativeEffectAndRecordVideo() throws UiObjectNotFoundException;

    void openCameraAndTakePicture(String cameraMode) throws UiObjectNotFoundException;

    void openCameraAndRecordVideo(String cameraMode, int recordingTime) throws UiObjectNotFoundException;

    void pauseWhenRecordVideo(int recordingTime, int time) throws UiObjectNotFoundException;

    void takeAndPostPictureViaSocialLive() throws UiObjectNotFoundException;

    /**
     * Start Camera by press Camera key.
     */
    void startCameraByPressCameraKey ();

    /**
     * Play recent video until end.
     *
     * @param videoTime: By seconds
     * @throws UiObjectNotFoundException
     */
    void playRecentVideoUntilEnd(long videoSeconds) throws UiObjectNotFoundException;

    /**
     * Switch to Front Camera.
     *
     * @throws UiObjectNotFoundException
     */
    void switchToFrontCamera() throws UiObjectNotFoundException;

    /**
     * Select all photo resolution and take pictures.
     *
     * @throws UiObjectNotFoundException
     */
    void selectAllPhotoResolutionAndTakePictures() throws UiObjectNotFoundException;

    void clickRecentShot() throws UiObjectNotFoundException;

    void selectAllFrontVideoResolutionAndRecordVideos(int recordingMin) throws UiObjectNotFoundException;

    void setLastPictureAsContactPhoto(String contactName) throws UiObjectNotFoundException;

    void setLastPictureAsWallpaper() throws UiObjectNotFoundException;

    void selectAllWhiteBalanceAndRecordVideos(int recordSeconds) throws UiObjectNotFoundException;

    /**
     * Set phone on sleep mode. Press camera hard key to start camera, take a
     * picture by press camera key(soft), then check the picture.
     *
     * @throws UiObjectNotFoundException
     */
    void takePhotoBySleepModeAndCheck() throws UiObjectNotFoundException;

    /**
     * Press camera hard key to start camera, start
     * record a video, while recording, press camera key to capture a photo,
     * then check the video.
     *
     * @throws UiObjectNotFoundException
     */
    void takePhotoWhileRecordingVideoAndCheck() throws UiObjectNotFoundException;

    /**
     * Set phone on sleep mode. Press camera hard key to start camera.
     */
    void startCameraBySleepMode();

    /**
     * Launch camera application, take a picture, then start record a video.
     * while recording, capture a picture, then end recording. Check the video
     * and pictures before/while recording.
     *
     * @throws UiObjectNotFoundException
     */
    void takePhotosBeforeOrWhileRecordingVideoAndCheck() throws UiObjectNotFoundException;

    /**
     * Change selftimer setting.
     *
     * @param value
     * @throws UiObjectNotFoundException
     */
    void changeSelftimerSetting(String value) throws UiObjectNotFoundException;

    /**
     * take selftimer picture, before waiting, press back key to cancel.
     */
    void cancelTakeSelftimerPicture();

    /**
     * Take self timer by self timer picture.
     * @param value
     * @throws UiObjectNotFoundException
     */
    void takeSelftimerPicture(String value);

    /**
     * Set Touch capture setting on.
     *
     * @throws UiObjectNotFoundException
     */
    void setTouchCaptureSettingOn() throws UiObjectNotFoundException;

    /**
     * Touch screen to capture.
     */
    void touchScreenToCapture();

    /**
     * Touch screen to capture while Recording video.
     * @throws UiObjectNotFoundException
     */
    void touchScreenToCaptureWhileRecordVideo() throws UiObjectNotFoundException;
 /**
     * Change the picture and video storage 
     * @param storage
     * @throws UiObjectNotFoundException
     */
    void changeCameraStorage(String storage) throws UiObjectNotFoundException;
}