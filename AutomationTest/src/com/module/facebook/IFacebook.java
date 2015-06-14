
package com.module.facebook;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.parents.Module;

public interface IFacebook extends Module {

    /**
     * Launch Facebook.
     *
     * @param facebookaccount
     * @param facebookpassword
     */
    void launchFacebook(String facebookaccount, String facebookpassword)
            throws UiObjectNotFoundException;

    /**
     * Add Xperia Facebook Account from settings.
     *
     * @param facebookaccount
     * @param facebookpassword
     */
    void addXperiaFacebookAccount(String facebookaccount, String facebookpassword)
            throws UiObjectNotFoundException;

    /**
     * Add events from Facebook.
     */
    void addEventsFromFacebook() throws UiObjectNotFoundException;

    /**
     * Select sync Calendar to sync the calendar data.
     *
     * @throws UiObjectNotFoundException
     */
    void selectSyncCalendar() throws UiObjectNotFoundException;

    /**
     * Check Facebook data is shown in Calendar.
     */
    void checkCalendarData();

    /**
     * Open a facebook photo from Album
     *
     * @param folderIndex The count of photo folder in facebook album
     * @param landscapeView
     */
    public void openAFacebookPhoto(int folderIndex, boolean landscapeView)
            throws UiObjectNotFoundException;

    /**
     * Add comment for already opened photos
     */
    void addCommentForPhoto() throws UiObjectNotFoundException;

    /**
     * Check all photos in Facebook Album.
     *
     * @throws UiObjectNotFoundException
     */
    void checkAllPhotosInFacebookAlbum() throws UiObjectNotFoundException;

    /**
     * Create a new Facebook Album.
     *
     * @param name
     * @param desc
     * @param loc
     * @throws UiObjectNotFoundException
     */
    void createNewFacebookAlbum(String name, String desc, String loc)
            throws UiObjectNotFoundException;

    /**
     * Upload a new photo via take photo.
     *
     * @param albumName
     * @throws UiObjectNotFoundException
     */
    void uploadANewPhotoViaTakePhoto(String albumName) throws UiObjectNotFoundException;

    /**
     * Enter one album, select one photo, press more icon, select share via
     * Facebook, tap tag friends icon to add contact, press post to upload. Then
     * back to photos view.
     *
     * @throws UiObjectNotFoundException
     */
    void sharePhotoToContact(String albumName) throws UiObjectNotFoundException;

    /**
     * Upload a new photo From memory card.
     *
     * @param albumName
     * @throws UiObjectNotFoundException
     */
    void uploadANewPhotoFromMemory(String albumName) throws UiObjectNotFoundException;

    /**
     * Delete Facebook album by album name.
     *
     * @param album
     * @throws UiObjectNotFoundException
     */
    void deleteFacebookAlbum(String album) throws UiObjectNotFoundException;

    public void addFacebookAccount(String account, String password) throws UiObjectNotFoundException;
   
    public void syncFacebookInSetting(String account) throws UiObjectNotFoundException;

}