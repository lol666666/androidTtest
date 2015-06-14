package com.concurrent.events;

import com.sonyericsson.test.acceptancetest.AcceptanceTestCase;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.parser.module.PropertyNotFoundException;

public interface IConcurrentEvents {

    public void answerIncomingCall() throws PropertyNotFoundException;
    
    public void hangUpIncomingCall() throws PropertyNotFoundException;
    
    public void ignoreIncomingCall()throws PropertyNotFoundException;
    
    public void rejectWithSMSBusyIncomingCall() throws PropertyNotFoundException;
    
    public void rejectWithSMSMeetingIncomingCall() throws PropertyNotFoundException;
    
    public void rejectWithSMSDrivingIncomingCall() throws PropertyNotFoundException;
    
    public void rejectWithSMSEatingIncomingCall() throws PropertyNotFoundException;
    
    public void rejectWithSMSAntherCallIncomingCall() throws PropertyNotFoundException;
    
    public void receiveSMS() throws PropertyNotFoundException;
    
    public void receiveSMSFormStatusBar() throws PropertyNotFoundException,UiObjectNotFoundException; 
    
    public void receiveMessageInBackground(String type) throws PropertyNotFoundException,UiObjectNotFoundException; 

    public void receiveMMS() throws PropertyNotFoundException;
    
    public void receiveEmail() throws PropertyNotFoundException;
    
    public void musicPlayInBackground() throws PropertyNotFoundException,UiObjectNotFoundException;
    
    public void FMRadioPlayInBackground() throws PropertyNotFoundException;
    
    public void videoPlayInBackground() throws PropertyNotFoundException;
    
    public void alarmExpired() throws PropertyNotFoundException;
    
    public void calendarExpired() throws PropertyNotFoundException;
    
    public void SNSStatusUpdateTwitter() throws PropertyNotFoundException;
    
    public void SNSStatusUpdateFacebook() throws PropertyNotFoundException;
    
    public void SNSStatusUpdateTwitterWechat() throws PropertyNotFoundException;
    
    public void SNSStatusUpdateWeibo() throws PropertyNotFoundException;
    
    public void receiveFileViaBT() throws PropertyNotFoundException;

    public void receiveSMSInBackground() throws PropertyNotFoundException;
    
    public void calendarExpiredInBackground() throws PropertyNotFoundException;
    
    public void downloadFileOnBackground() throws UiObjectNotFoundException;
    
    public void playGame() throws UiObjectNotFoundException;
    
    public void editMessage() throws UiObjectNotFoundException;
}
