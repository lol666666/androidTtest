package com.test.rt.phase2;

import com.parser.cases.TestDataExtract;
import com.sonyericsson.test.acceptancetest.AcceptanceTestCase;
import com.utils.TestUIWatcher;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class RTAutomaticTestPhaseII extends AcceptanceTestCase{
    private static final String TAG = "RTTest";

    private static RTAutomaticModulesPhaseII tc = null;

    private static int[] loopList = new int[100];

    public static boolean hasLoadConfigFile = false;

    public static HashMap<String, String> sCurrParameter;

    public static int sCurrLoop = 1;

    public static int sRunLoops = 1;

    TestUIWatcher watcher;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.stayAwake();
        this.disableLockScreen();

        // if not run from InstrumentationTestRunner, the configure file will
        // not load, so load it here.
        if (!hasLoadConfigFile) {
            TestDataExtract.loadConfigFile(this, "RTConfigPhaseII.xml");
            hasLoadConfigFile = true;
        }
        if (tc == null) {
            tc = new RTAutomaticModulesPhaseII(this);
        }

        watcher = new TestUIWatcher();
        watcher.watch();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

        watcher.removeWatchers();
    }

    @SuppressWarnings("static-access")
    public void test_000() throws Exception {
        Log.d(TAG, "==============Begin test_000==============");

        this.sCurrParameter = TestDataExtract.getParameters(0);
        sCurrLoop = ++loopList[0];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(0) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(0));
        fieldMethods(TestDataExtract.getCasename(0), tc, sCurrParameter);

        Log.d(TAG, "==================End test_000==============");

    }

    @SuppressWarnings("static-access")
    public void test_001() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_001============");

        this.sCurrParameter = TestDataExtract.getParameters(1);
        sCurrLoop = ++loopList[1];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(1) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(1));
        fieldMethods(TestDataExtract.getCasename(1), tc, sCurrParameter);
        Log.d(TAG, "===============End test_001================");
    }

    @SuppressWarnings("static-access")
    public void test_002() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_002===============");

        this.sCurrParameter = TestDataExtract.getParameters(2);
        sCurrLoop = ++loopList[2];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(2) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(2));
        fieldMethods(TestDataExtract.getCasename(2), tc, sCurrParameter);
        Log.d(TAG, "================End test_002================");
    }

    @SuppressWarnings("static-access")
    public void test_003() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_003===============");

        this.sCurrParameter = TestDataExtract.getParameters(3);
        sCurrLoop = ++loopList[3];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(3) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(3));
        fieldMethods(TestDataExtract.getCasename(3), tc, sCurrParameter);
        Log.d(TAG, "================End test_003================");
    }

    @SuppressWarnings("static-access")
    public void test_004() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_004===============");

        this.sCurrParameter = TestDataExtract.getParameters(4);
        sCurrLoop = ++loopList[4];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(4) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(4));
        fieldMethods(TestDataExtract.getCasename(4), tc, sCurrParameter);
        Log.d(TAG, "================End test_004================");
    }

    @SuppressWarnings("static-access")
    public void test_005() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_005===============");

        this.sCurrParameter = TestDataExtract.getParameters(5);
        sCurrLoop = ++loopList[5];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(5) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(5));
        fieldMethods(TestDataExtract.getCasename(5), tc, sCurrParameter);
        Log.d(TAG, "================End test_005================");
    }

    @SuppressWarnings("static-access")
    public void test_006() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_006===============");

        this.sCurrParameter = TestDataExtract.getParameters(6);
        sCurrLoop = ++loopList[6];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(6) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(6));
        fieldMethods(TestDataExtract.getCasename(6), tc, sCurrParameter);
        Log.d(TAG, "================End test_006================");
    }

    @SuppressWarnings("static-access")
    public void test_007() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_007===============");
        Log.d(TAG, "^^^^^^^^^^^" + TestDataExtract.getCasename(7) + "^^^^^^^^^^^");
        this.sCurrParameter = TestDataExtract.getParameters(7);
        sCurrLoop = ++loopList[7];
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(7));
        fieldMethods(TestDataExtract.getCasename(7), tc, sCurrParameter);
        Log.d(TAG, "================End test_007================");
    }

    @SuppressWarnings("static-access")
    public void test_008() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_008===============");

        this.sCurrParameter = TestDataExtract.getParameters(8);
        sCurrLoop = ++loopList[8];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(8) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(8));
        fieldMethods(TestDataExtract.getCasename(8), tc, sCurrParameter);
        Log.d(TAG, "================End test_008================");
    }

    @SuppressWarnings("static-access")
    public void test_009() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_009===============");

        this.sCurrParameter = TestDataExtract.getParameters(9);
        sCurrLoop = ++loopList[9];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(9) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(9));
        fieldMethods(TestDataExtract.getCasename(9), tc, sCurrParameter);
        Log.d(TAG, "================End test_009================");
    }

    @SuppressWarnings("static-access")
    public void test_010() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_010===============");

        this.sCurrParameter = TestDataExtract.getParameters(10);
        sCurrLoop = ++loopList[10];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(10) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(10));
        fieldMethods(TestDataExtract.getCasename(10), tc, sCurrParameter);
        Log.d(TAG, "================End test_010================");
    }

    @SuppressWarnings("static-access")
    public void test_011() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_011===============");

        this.sCurrParameter = TestDataExtract.getParameters(11);
        sCurrLoop = ++loopList[11];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(11) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(11));
        fieldMethods(TestDataExtract.getCasename(11), tc, sCurrParameter);
        Log.d(TAG, "================End test_011================");
    }

    @SuppressWarnings("static-access")
    public void test_012() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_012===============");

        this.sCurrParameter = TestDataExtract.getParameters(12);
        sCurrLoop = ++loopList[12];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(12) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(12));
        fieldMethods(TestDataExtract.getCasename(12), tc, sCurrParameter);
        Log.d(TAG, "================End test_012================");
    }

    @SuppressWarnings("static-access")
    public void test_013() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_013===============");

        this.sCurrParameter = TestDataExtract.getParameters(13);
        sCurrLoop = ++loopList[13];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(13) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(13));
        fieldMethods(TestDataExtract.getCasename(13), tc, sCurrParameter);
        Log.d(TAG, "================End test_013================");
    }

    @SuppressWarnings("static-access")
    public void test_014() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_014===============");

        this.sCurrParameter = TestDataExtract.getParameters(14);
        sCurrLoop = ++loopList[14];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(14) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(14));
        fieldMethods(TestDataExtract.getCasename(14), tc, sCurrParameter);
        Log.d(TAG, "================End test_014================");
    }

    @SuppressWarnings("static-access")
    public void test_015() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_015===============");

        this.sCurrParameter = TestDataExtract.getParameters(15);
        sCurrLoop = ++loopList[15];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(15) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(15));
        fieldMethods(TestDataExtract.getCasename(15), tc, sCurrParameter);
        Log.d(TAG, "================End test_015================");
    }

    @SuppressWarnings("static-access")
    public void test_016() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_016===============");

        this.sCurrParameter = TestDataExtract.getParameters(16);
        sCurrLoop = ++loopList[16];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(16) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(16));
        fieldMethods(TestDataExtract.getCasename(16), tc, sCurrParameter);
        Log.d(TAG, "================End test_016================");
    }

    @SuppressWarnings("static-access")
    public void test_017() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_017===============");

        this.sCurrParameter = TestDataExtract.getParameters(17);
        sCurrLoop = ++loopList[17];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(17) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(17));
        fieldMethods(TestDataExtract.getCasename(17), tc, sCurrParameter);
        Log.d(TAG, "================End test_017================");
    }

    @SuppressWarnings("static-access")
    public void test_018() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_018===============");

        this.sCurrParameter = TestDataExtract.getParameters(18);
        sCurrLoop = ++loopList[18];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(18) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(18));
        fieldMethods(TestDataExtract.getCasename(18), tc, sCurrParameter);
        Log.d(TAG, "================End test_018================");
    }

    @SuppressWarnings("static-access")
    public void test_019() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_019===============");

        this.sCurrParameter = TestDataExtract.getParameters(19);
        sCurrLoop = ++loopList[19];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(19) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(19));
        fieldMethods(TestDataExtract.getCasename(19), tc, sCurrParameter);
        Log.d(TAG, "================End test_019================");
    }

    @SuppressWarnings("static-access")
    public void test_020() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_020===============");

        this.sCurrParameter = TestDataExtract.getParameters(20);
        sCurrLoop = ++loopList[20];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(20) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(20));
        fieldMethods(TestDataExtract.getCasename(20), tc, sCurrParameter);
        Log.d(TAG, "================End test_020================");
    }

    @SuppressWarnings("static-access")
    public void test_021() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_021===============");

        this.sCurrParameter = TestDataExtract.getParameters(21);
        sCurrLoop = ++loopList[21];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(21) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(21));
        fieldMethods(TestDataExtract.getCasename(21), tc, sCurrParameter);
        Log.d(TAG, "================End test_021================");
    }

    @SuppressWarnings("static-access")
    public void test_022() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_022===============");

        this.sCurrParameter = TestDataExtract.getParameters(22);
        sCurrLoop = ++loopList[22];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(22) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(22));
        fieldMethods(TestDataExtract.getCasename(22), tc, sCurrParameter);
        Log.d(TAG, "================End test_022================");
    }

    @SuppressWarnings("static-access")
    public void test_023() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_023===============");

        this.sCurrParameter = TestDataExtract.getParameters(23);
        sCurrLoop = ++loopList[23];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(23) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(23));
        fieldMethods(TestDataExtract.getCasename(23), tc, sCurrParameter);
        Log.d(TAG, "================End test_023================");
    }

    @SuppressWarnings("static-access")
    public void test_024() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_024===============");

        this.sCurrParameter = TestDataExtract.getParameters(24);
        sCurrLoop = ++loopList[24];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(24) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(24));
        fieldMethods(TestDataExtract.getCasename(24), tc, sCurrParameter);
        Log.d(TAG, "================End test_024================");
    }

    @SuppressWarnings("static-access")
    public void test_025() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_025===============");

        this.sCurrParameter = TestDataExtract.getParameters(25);
        sCurrLoop = ++loopList[25];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(25) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(25));
        fieldMethods(TestDataExtract.getCasename(25), tc, sCurrParameter);
        Log.d(TAG, "================End test_025================");
    }

    @SuppressWarnings("static-access")
    public void test_026() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_026===============");

        this.sCurrParameter = TestDataExtract.getParameters(26);
        sCurrLoop = ++loopList[26];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(26) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(26));
        fieldMethods(TestDataExtract.getCasename(26), tc, sCurrParameter);
        Log.d(TAG, "================End test_026================");
    }

    @SuppressWarnings("static-access")
    public void test_027() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_027===============");

        this.sCurrParameter = TestDataExtract.getParameters(27);
        sCurrLoop = ++loopList[27];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(27) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(27));
        fieldMethods(TestDataExtract.getCasename(27), tc, sCurrParameter);
        Log.d(TAG, "================End test_027================");
    }

    @SuppressWarnings("static-access")
    public void test_028() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_028===============");

        this.sCurrParameter = TestDataExtract.getParameters(28);
        sCurrLoop = ++loopList[28];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(28) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(28));
        fieldMethods(TestDataExtract.getCasename(28), tc, sCurrParameter);
        Log.d(TAG, "================End test_028================");
    }

    @SuppressWarnings("static-access")
    public void test_029() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_029===============");

        this.sCurrParameter = TestDataExtract.getParameters(29);
        sCurrLoop = ++loopList[29];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(29) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(29));
        fieldMethods(TestDataExtract.getCasename(29), tc, sCurrParameter);
        Log.d(TAG, "================End test_029================");
    }

    @SuppressWarnings("static-access")
    public void test_030() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_030===============");

        this.sCurrParameter = TestDataExtract.getParameters(30);
        sCurrLoop = ++loopList[30];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(30) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(30));
        fieldMethods(TestDataExtract.getCasename(30), tc, sCurrParameter);
        Log.d(TAG, "================End test_030================");
    }

    @SuppressWarnings("static-access")
    public void test_031() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_031===============");

        this.sCurrParameter = TestDataExtract.getParameters(31);
        sCurrLoop = ++loopList[31];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(31) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(31));
        fieldMethods(TestDataExtract.getCasename(31), tc, sCurrParameter);
        Log.d(TAG, "================End test_031================");
    }

    @SuppressWarnings("static-access")
    public void test_032() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_032===============");

        this.sCurrParameter = TestDataExtract.getParameters(32);
        sCurrLoop = ++loopList[32];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(32) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(32));
        fieldMethods(TestDataExtract.getCasename(32), tc, sCurrParameter);
        Log.d(TAG, "================End test_032================");
    }

    @SuppressWarnings("static-access")
    public void test_033() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_033===============");

        this.sCurrParameter = TestDataExtract.getParameters(33);
        sCurrLoop = ++loopList[33];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(33) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(33));
        fieldMethods(TestDataExtract.getCasename(33), tc, sCurrParameter);
        Log.d(TAG, "================End test_033================");
    }

    @SuppressWarnings("static-access")
    public void test_034() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_034===============");

        this.sCurrParameter = TestDataExtract.getParameters(34);
        sCurrLoop = ++loopList[34];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(34) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(34));
        fieldMethods(TestDataExtract.getCasename(34), tc, sCurrParameter);
        Log.d(TAG, "================End test_034================");
    }

    @SuppressWarnings("static-access")
    public void test_035() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_035===============");

        this.sCurrParameter = TestDataExtract.getParameters(35);
        sCurrLoop = ++loopList[35];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(35) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(35));
        fieldMethods(TestDataExtract.getCasename(35), tc, sCurrParameter);
        Log.d(TAG, "================End test_035================");
    }

    @SuppressWarnings("static-access")
    public void test_036() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_036===============");

        this.sCurrParameter = TestDataExtract.getParameters(36);
        sCurrLoop = ++loopList[36];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(36) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(36));
        fieldMethods(TestDataExtract.getCasename(36), tc, sCurrParameter);
        Log.d(TAG, "================End test_036================");
    }

    @SuppressWarnings("static-access")
    public void test_037() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_037===============");

        this.sCurrParameter = TestDataExtract.getParameters(37);
        sCurrLoop = ++loopList[37];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(37) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(37));
        fieldMethods(TestDataExtract.getCasename(37), tc, sCurrParameter);
        Log.d(TAG, "================End test_037================");
    }

    @SuppressWarnings("static-access")
    public void test_038() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_038===============");

        this.sCurrParameter = TestDataExtract.getParameters(38);
        sCurrLoop = ++loopList[38];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(38) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(38));
        fieldMethods(TestDataExtract.getCasename(38), tc, sCurrParameter);
        Log.d(TAG, "================End test_038================");
    }

    @SuppressWarnings("static-access")
    public void test_039() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_039===============");

        this.sCurrParameter = TestDataExtract.getParameters(39);
        sCurrLoop = ++loopList[39];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(39) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(39));
        fieldMethods(TestDataExtract.getCasename(39), tc, sCurrParameter);
        Log.d(TAG, "================End test_039================");
    }

    @SuppressWarnings("static-access")
    public void test_040() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_040===============");

        this.sCurrParameter = TestDataExtract.getParameters(40);
        sCurrLoop = ++loopList[40];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(40) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(40));
        fieldMethods(TestDataExtract.getCasename(40), tc, sCurrParameter);
        Log.d(TAG, "================End test_040================");
    }

    @SuppressWarnings("static-access")
    public void test_041() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_041===============");

        this.sCurrParameter = TestDataExtract.getParameters(41);
        sCurrLoop = ++loopList[41];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(41) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(41));
        fieldMethods(TestDataExtract.getCasename(41), tc, sCurrParameter);
        Log.d(TAG, "================End test_041================");
    }

    @SuppressWarnings("static-access")
    public void test_042() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_042===============");

        this.sCurrParameter = TestDataExtract.getParameters(42);
        sCurrLoop = ++loopList[42];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(42) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(42));
        fieldMethods(TestDataExtract.getCasename(42), tc, sCurrParameter);
        Log.d(TAG, "================End test_042================");
    }

    @SuppressWarnings("static-access")
    public void test_043() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_043===============");

        this.sCurrParameter = TestDataExtract.getParameters(43);
        sCurrLoop = ++loopList[43];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(43) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(43));
        fieldMethods(TestDataExtract.getCasename(43), tc, sCurrParameter);
        Log.d(TAG, "================End test_043================");
    }

    @SuppressWarnings("static-access")
    public void test_044() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_044===============");

        this.sCurrParameter = TestDataExtract.getParameters(44);
        sCurrLoop = ++loopList[44];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(44) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(44));
        fieldMethods(TestDataExtract.getCasename(44), tc, sCurrParameter);
        Log.d(TAG, "================End test_044================");
    }

    @SuppressWarnings("static-access")
    public void test_045() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_045===============");

        this.sCurrParameter = TestDataExtract.getParameters(45);
        sCurrLoop = ++loopList[45];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(45) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(45));
        fieldMethods(TestDataExtract.getCasename(45), tc, sCurrParameter);
        Log.d(TAG, "================End test_045================");
    }

    @SuppressWarnings("static-access")
    public void test_046() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_046===============");

        this.sCurrParameter = TestDataExtract.getParameters(46);
        sCurrLoop = ++loopList[46];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(46) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(46));
        fieldMethods(TestDataExtract.getCasename(46), tc, sCurrParameter);
        Log.d(TAG, "================End test_046================");
    }

    @SuppressWarnings("static-access")
    public void test_047() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_047===============");

        this.sCurrParameter = TestDataExtract.getParameters(47);
        sCurrLoop = ++loopList[47];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(47) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(47));
        fieldMethods(TestDataExtract.getCasename(47), tc, sCurrParameter);
        Log.d(TAG, "================End test_047================");
    }

    @SuppressWarnings("static-access")
    public void test_048() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_048===============");

        this.sCurrParameter = TestDataExtract.getParameters(48);
        sCurrLoop = ++loopList[48];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(48) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(48));
        fieldMethods(TestDataExtract.getCasename(48), tc, sCurrParameter);
        Log.d(TAG, "================End test_048================");
    }

    @SuppressWarnings("static-access")
    public void test_049() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_049===============");

        this.sCurrParameter = TestDataExtract.getParameters(49);
        sCurrLoop = ++loopList[49];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(49) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(49));
        fieldMethods(TestDataExtract.getCasename(49), tc, sCurrParameter);
        Log.d(TAG, "================End test_049================");
    }

    @SuppressWarnings("static-access")
    public void test_050() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_050===============");

        this.sCurrParameter = TestDataExtract.getParameters(50);
        sCurrLoop = ++loopList[50];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(50) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(50));
        fieldMethods(TestDataExtract.getCasename(50), tc, sCurrParameter);
        Log.d(TAG, "================End test_050================");
    }

    @SuppressWarnings("static-access")
    public void test_051() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_051===============");

        this.sCurrParameter = TestDataExtract.getParameters(51);
        sCurrLoop = ++loopList[51];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(51) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(51));
        fieldMethods(TestDataExtract.getCasename(51), tc, sCurrParameter);
        Log.d(TAG, "================End test_051================");
    }

    @SuppressWarnings("static-access")
    public void test_052() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_052===============");

        this.sCurrParameter = TestDataExtract.getParameters(52);
        sCurrLoop = ++loopList[52];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(52) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(52));
        fieldMethods(TestDataExtract.getCasename(52), tc, sCurrParameter);
        Log.d(TAG, "================End test_052================");
    }

    @SuppressWarnings("static-access")
    public void test_053() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_053===============");

        this.sCurrParameter = TestDataExtract.getParameters(53);
        sCurrLoop = ++loopList[53];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(53) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(53));
        fieldMethods(TestDataExtract.getCasename(53), tc, sCurrParameter);
        Log.d(TAG, "================End test_053================");
    }

    @SuppressWarnings("static-access")
    public void test_054() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_054===============");

        this.sCurrParameter = TestDataExtract.getParameters(54);
        sCurrLoop = ++loopList[54];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(54) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(54));
        fieldMethods(TestDataExtract.getCasename(54), tc, sCurrParameter);
        Log.d(TAG, "================End test_054================");
    }

    @SuppressWarnings("static-access")
    public void test_055() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_055===============");

        this.sCurrParameter = TestDataExtract.getParameters(55);
        sCurrLoop = ++loopList[55];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(55) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(55));
        fieldMethods(TestDataExtract.getCasename(55), tc, sCurrParameter);
        Log.d(TAG, "================End test_055================");
    }

    @SuppressWarnings("static-access")
    public void test_056() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_056===============");

        this.sCurrParameter = TestDataExtract.getParameters(56);
        sCurrLoop = ++loopList[56];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(56) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(56));
        fieldMethods(TestDataExtract.getCasename(56), tc, sCurrParameter);
        Log.d(TAG, "================End test_056================");
    }

    @SuppressWarnings("static-access")
    public void test_057() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_057===============");

        this.sCurrParameter = TestDataExtract.getParameters(57);
        sCurrLoop = ++loopList[57];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(57) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(57));
        fieldMethods(TestDataExtract.getCasename(57), tc, sCurrParameter);
        Log.d(TAG, "================End test_057================");
    }

    @SuppressWarnings("static-access")
    public void test_058() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_058===============");

        this.sCurrParameter = TestDataExtract.getParameters(58);
        sCurrLoop = ++loopList[58];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(58) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(58));
        fieldMethods(TestDataExtract.getCasename(58), tc, sCurrParameter);
        Log.d(TAG, "================End test_058================");
    }

    @SuppressWarnings("static-access")
    public void test_059() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_059===============");

        this.sCurrParameter = TestDataExtract.getParameters(59);
        sCurrLoop = ++loopList[59];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(59) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(59));
        fieldMethods(TestDataExtract.getCasename(59), tc, sCurrParameter);
        Log.d(TAG, "================End test_059================");
    }

    @SuppressWarnings("static-access")
    public void test_060() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_060===============");

        this.sCurrParameter = TestDataExtract.getParameters(60);
        sCurrLoop = ++loopList[60];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(60) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(60));
        fieldMethods(TestDataExtract.getCasename(60), tc, sCurrParameter);
        Log.d(TAG, "================End test_060================");
    }

    @SuppressWarnings("static-access")
    public void test_061() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_061===============");

        this.sCurrParameter = TestDataExtract.getParameters(61);
        sCurrLoop = ++loopList[61];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(61) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(61));
        fieldMethods(TestDataExtract.getCasename(61), tc, sCurrParameter);
        Log.d(TAG, "================End test_061================");
    }

    @SuppressWarnings("static-access")
    public void test_062() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_062===============");

        this.sCurrParameter = TestDataExtract.getParameters(62);
        sCurrLoop = ++loopList[62];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(62) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(62));
        fieldMethods(TestDataExtract.getCasename(62), tc, sCurrParameter);
        Log.d(TAG, "================End test_062================");
    }

    @SuppressWarnings("static-access")
    public void test_063() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_063===============");

        this.sCurrParameter = TestDataExtract.getParameters(63);
        sCurrLoop = ++loopList[63];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(63) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(63));
        fieldMethods(TestDataExtract.getCasename(63), tc, sCurrParameter);
        Log.d(TAG, "================End test_063================");
    }

    @SuppressWarnings("static-access")
    public void test_064() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_064===============");

        this.sCurrParameter = TestDataExtract.getParameters(64);
        sCurrLoop = ++loopList[64];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(64) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(64));
        fieldMethods(TestDataExtract.getCasename(64), tc, sCurrParameter);
        Log.d(TAG, "================End test_064================");
    }

    @SuppressWarnings("static-access")
    public void test_065() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_065===============");

        this.sCurrParameter = TestDataExtract.getParameters(65);
        sCurrLoop = ++loopList[65];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(65) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(65));
        fieldMethods(TestDataExtract.getCasename(65), tc, sCurrParameter);
        Log.d(TAG, "================End test_065================");
    }

    @SuppressWarnings("static-access")
    public void test_066() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_066===============");

        this.sCurrParameter = TestDataExtract.getParameters(66);
        sCurrLoop = ++loopList[66];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(66) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(66));
        fieldMethods(TestDataExtract.getCasename(66), tc, sCurrParameter);
        Log.d(TAG, "================End test_066================");
    }

    @SuppressWarnings("static-access")
    public void test_067() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_067===============");

        this.sCurrParameter = TestDataExtract.getParameters(67);
        sCurrLoop = ++loopList[67];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(67) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(67));
        fieldMethods(TestDataExtract.getCasename(67), tc, sCurrParameter);
        Log.d(TAG, "================End test_067================");
    }

    @SuppressWarnings("static-access")
    public void test_068() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_068===============");

        this.sCurrParameter = TestDataExtract.getParameters(68);
        sCurrLoop = ++loopList[68];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(68) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(68));
        fieldMethods(TestDataExtract.getCasename(68), tc, sCurrParameter);
        Log.d(TAG, "================End test_068================");
    }

    @SuppressWarnings("static-access")
    public void test_069() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_069===============");

        this.sCurrParameter = TestDataExtract.getParameters(69);
        sCurrLoop = ++loopList[69];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(69) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(69));
        fieldMethods(TestDataExtract.getCasename(69), tc, sCurrParameter);
        Log.d(TAG, "================End test_069================");
    }

    @SuppressWarnings("static-access")
    public void test_070() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_070===============");

        this.sCurrParameter = TestDataExtract.getParameters(70);
        sCurrLoop = ++loopList[70];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(70) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(70));
        fieldMethods(TestDataExtract.getCasename(70), tc, sCurrParameter);
        Log.d(TAG, "================End test_070================");
    }

    @SuppressWarnings("static-access")
    public void test_071() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_071===============");

        this.sCurrParameter = TestDataExtract.getParameters(71);
        sCurrLoop = ++loopList[71];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(71) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(71));
        fieldMethods(TestDataExtract.getCasename(71), tc, sCurrParameter);
        Log.d(TAG, "================End test_071================");
    }

    @SuppressWarnings("static-access")
    public void test_072() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_072===============");

        this.sCurrParameter = TestDataExtract.getParameters(72);
        sCurrLoop = ++loopList[72];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(72) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(72));
        fieldMethods(TestDataExtract.getCasename(72), tc, sCurrParameter);
        Log.d(TAG, "================End test_072================");
    }

    @SuppressWarnings("static-access")
    public void test_073() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_073===============");

        this.sCurrParameter = TestDataExtract.getParameters(73);
        sCurrLoop = ++loopList[73];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(73) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(73));
        fieldMethods(TestDataExtract.getCasename(73), tc, sCurrParameter);
        Log.d(TAG, "================End test_073================");
    }

    @SuppressWarnings("static-access")
    public void test_074() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_074===============");

        this.sCurrParameter = TestDataExtract.getParameters(74);
        sCurrLoop = ++loopList[74];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(74) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(74));
        fieldMethods(TestDataExtract.getCasename(74), tc, sCurrParameter);
        Log.d(TAG, "================End test_074================");
    }

    @SuppressWarnings("static-access")
    public void test_075() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_075===============");

        this.sCurrParameter = TestDataExtract.getParameters(75);
        sCurrLoop = ++loopList[75];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(75) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(75));
        fieldMethods(TestDataExtract.getCasename(75), tc, sCurrParameter);
        Log.d(TAG, "================End test_075================");
    }

    @SuppressWarnings("static-access")
    public void test_076() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_076===============");

        this.sCurrParameter = TestDataExtract.getParameters(76);
        sCurrLoop = ++loopList[76];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(76) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(76));
        fieldMethods(TestDataExtract.getCasename(76), tc, sCurrParameter);
        Log.d(TAG, "================End test_076================");
    }

    @SuppressWarnings("static-access")
    public void test_077() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_077===============");

        this.sCurrParameter = TestDataExtract.getParameters(77);
        sCurrLoop = ++loopList[77];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(77) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(77));
        fieldMethods(TestDataExtract.getCasename(77), tc, sCurrParameter);
        Log.d(TAG, "================End test_077================");
    }

    @SuppressWarnings("static-access")
    public void test_078() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_078===============");

        this.sCurrParameter = TestDataExtract.getParameters(78);
        sCurrLoop = ++loopList[78];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(78) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(78));
        fieldMethods(TestDataExtract.getCasename(78), tc, sCurrParameter);
        Log.d(TAG, "================End test_078================");
    }

    @SuppressWarnings("static-access")
    public void test_079() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_079===============");

        this.sCurrParameter = TestDataExtract.getParameters(79);
        sCurrLoop = ++loopList[79];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(79) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(79));
        fieldMethods(TestDataExtract.getCasename(79), tc, sCurrParameter);
        Log.d(TAG, "================End test_079================");
    }

    @SuppressWarnings("static-access")
    public void test_080() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_080===============");

        this.sCurrParameter = TestDataExtract.getParameters(80);
        sCurrLoop = ++loopList[80];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(80) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(80));
        fieldMethods(TestDataExtract.getCasename(80), tc, sCurrParameter);
        Log.d(TAG, "================End test_080================");
    }

    @SuppressWarnings("static-access")
    public void test_081() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_081===============");

        this.sCurrParameter = TestDataExtract.getParameters(81);
        sCurrLoop = ++loopList[81];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(81) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(81));
        fieldMethods(TestDataExtract.getCasename(81), tc, sCurrParameter);
        Log.d(TAG, "================End test_081================");
    }

    @SuppressWarnings("static-access")
    public void test_082() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_082===============");

        this.sCurrParameter = TestDataExtract.getParameters(82);
        sCurrLoop = ++loopList[82];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(82) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(82));
        fieldMethods(TestDataExtract.getCasename(82), tc, sCurrParameter);
        Log.d(TAG, "================End test_082================");
    }

    @SuppressWarnings("static-access")
    public void test_083() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_083===============");

        this.sCurrParameter = TestDataExtract.getParameters(83);
        sCurrLoop = ++loopList[83];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(83) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(83));
        fieldMethods(TestDataExtract.getCasename(83), tc, sCurrParameter);
        Log.d(TAG, "================End test_083================");
    }

    @SuppressWarnings("static-access")
    public void test_084() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_084===============");

        this.sCurrParameter = TestDataExtract.getParameters(84);
        sCurrLoop = ++loopList[84];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(84) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(84));
        fieldMethods(TestDataExtract.getCasename(84), tc, sCurrParameter);
        Log.d(TAG, "================End test_084================");
    }

    @SuppressWarnings("static-access")
    public void test_085() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_085===============");

        this.sCurrParameter = TestDataExtract.getParameters(85);
        sCurrLoop = ++loopList[85];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(85) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(85));
        fieldMethods(TestDataExtract.getCasename(85), tc, sCurrParameter);
        Log.d(TAG, "================End test_085================");
    }

    @SuppressWarnings("static-access")
    public void test_086() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_086===============");

        this.sCurrParameter = TestDataExtract.getParameters(86);
        sCurrLoop = ++loopList[86];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(86) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(86));
        fieldMethods(TestDataExtract.getCasename(86), tc, sCurrParameter);
        Log.d(TAG, "================End test_086================");
    }

    @SuppressWarnings("static-access")
    public void test_087() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_087===============");

        this.sCurrParameter = TestDataExtract.getParameters(87);
        sCurrLoop = ++loopList[87];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(87) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(87));
        fieldMethods(TestDataExtract.getCasename(87), tc, sCurrParameter);
        Log.d(TAG, "================End test_087================");
    }

    @SuppressWarnings("static-access")
    public void test_088() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_088===============");

        this.sCurrParameter = TestDataExtract.getParameters(88);
        sCurrLoop = ++loopList[88];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(88) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(88));
        fieldMethods(TestDataExtract.getCasename(88), tc, sCurrParameter);
        Log.d(TAG, "================End test_088================");
    }

    @SuppressWarnings("static-access")
    public void test_089() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_089===============");

        this.sCurrParameter = TestDataExtract.getParameters(89);
        sCurrLoop = ++loopList[89];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(89) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(89));
        fieldMethods(TestDataExtract.getCasename(89), tc, sCurrParameter);
        Log.d(TAG, "================End test_089================");
    }

    @SuppressWarnings("static-access")
    public void test_090() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_090===============");

        this.sCurrParameter = TestDataExtract.getParameters(90);
        sCurrLoop = ++loopList[90];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(90) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(90));
        fieldMethods(TestDataExtract.getCasename(90), tc, sCurrParameter);
        Log.d(TAG, "================End test_090================");
    }

    @SuppressWarnings("static-access")
    public void test_091() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_091===============");

        this.sCurrParameter = TestDataExtract.getParameters(91);
        sCurrLoop = ++loopList[91];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(91) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(91));
        fieldMethods(TestDataExtract.getCasename(91), tc, sCurrParameter);
        Log.d(TAG, "================End test_091================");
    }

    @SuppressWarnings("static-access")
    public void test_092() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_092===============");

        this.sCurrParameter = TestDataExtract.getParameters(92);
        sCurrLoop = ++loopList[92];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(92) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(92));
        fieldMethods(TestDataExtract.getCasename(92), tc, sCurrParameter);
        Log.d(TAG, "================End test_092================");
    }

    @SuppressWarnings("static-access")
    public void test_093() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_093===============");

        this.sCurrParameter = TestDataExtract.getParameters(93);
        sCurrLoop = ++loopList[93];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(93) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(93));
        fieldMethods(TestDataExtract.getCasename(93), tc, sCurrParameter);
        Log.d(TAG, "================End test_093================");
    }

    @SuppressWarnings("static-access")
    public void test_094() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_094===============");

        this.sCurrParameter = TestDataExtract.getParameters(94);
        sCurrLoop = ++loopList[94];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(94) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(94));
        fieldMethods(TestDataExtract.getCasename(94), tc, sCurrParameter);
        Log.d(TAG, "================End test_094================");
    }

    @SuppressWarnings("static-access")
    public void test_095() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_095===============");

        this.sCurrParameter = TestDataExtract.getParameters(95);
        sCurrLoop = ++loopList[95];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(95) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(95));
        fieldMethods(TestDataExtract.getCasename(95), tc, sCurrParameter);
        Log.d(TAG, "================End test_095================");
    }

    @SuppressWarnings("static-access")
    public void test_096() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_096===============");

        this.sCurrParameter = TestDataExtract.getParameters(96);
        sCurrLoop = ++loopList[96];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(96) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(96));
        fieldMethods(TestDataExtract.getCasename(96), tc, sCurrParameter);
        Log.d(TAG, "================End test_096================");
    }

    @SuppressWarnings("static-access")
    public void test_097() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_097===============");

        this.sCurrParameter = TestDataExtract.getParameters(97);
        sCurrLoop = ++loopList[97];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(97) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(97));
        fieldMethods(TestDataExtract.getCasename(97), tc, sCurrParameter);
        Log.d(TAG, "================End test_097================");
    }

    @SuppressWarnings("static-access")
    public void test_098() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_098===============");

        this.sCurrParameter = TestDataExtract.getParameters(98);
        sCurrLoop = ++loopList[98];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(98) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(98));
        fieldMethods(TestDataExtract.getCasename(98), tc, sCurrParameter);
        Log.d(TAG, "================End test_098================");
    }

    @SuppressWarnings("static-access")
    public void test_099() throws IllegalArgumentException, ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.d(TAG, "===============Begin test_099===============");

        this.sCurrParameter = TestDataExtract.getParameters(99);
        sCurrLoop = ++loopList[99];
        Log.d(TAG, "^^^^^^^^^^^^^" + TestDataExtract.getCasename(99) + "|" + sCurrLoop
                + "^^^^^^^^^^^^^^");
        printSnarioNameInResult(sCurrParameter.get("snarioname"));
        printCaseNameInResult(TestDataExtract.getCasename(99));
        fieldMethods(TestDataExtract.getCasename(99), tc, sCurrParameter);
        Log.d(TAG, "================End test_099================");
    }


    /**
     * Print case module name in Instrumentation Test Result
     *
     * @param name: case module name
     */
    private void printCaseNameInResult(String name) {
        Bundle bundle = new Bundle();
        bundle.putString("casename", name);
        this.getInstrumentation().sendStatus(1, bundle);
    }

    private void printSnarioNameInResult(String name) {
        Bundle bundle = new Bundle();
        bundle.putString("snarioname", name);
        this.getInstrumentation().sendStatus(1, bundle);
    }

    private void fieldMethods(String methodName, RTAutomaticModulesPhaseII nts, HashMap<String, String> paras)
            throws ClassNotFoundException, NoSuchMethodException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException {
        Class clazz = Class.forName("com.test.rt.phase2.RTAutomaticModulesPhaseII");
        Log.e("ubq", methodName);
        Method method = clazz.getDeclaredMethod(methodName, String.class, HashMap.class);
        Log.e("ubq", method.getName());
        method.invoke(nts, new Object[] {
                methodName, paras
        });

    }
}
