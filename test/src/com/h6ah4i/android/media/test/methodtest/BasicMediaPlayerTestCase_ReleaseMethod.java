/*
 *    Copyright (C) 2014 Haruki Hasegawa
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */


package com.h6ah4i.android.media.test.methodtest;

import java.io.IOException;

import junit.framework.TestSuite;

import com.h6ah4i.android.media.IBasicMediaPlayer;
import com.h6ah4i.android.media.IMediaPlayerFactory;
import com.h6ah4i.android.media.test.base.BasicMediaPlayerStateTestCaseBase;
import com.h6ah4i.android.media.test.base.BasicMediaPlayerTestCaseBase;
import com.h6ah4i.android.media.test.utils.CompletionListenerObject;
import com.h6ah4i.android.media.test.utils.ErrorListenerObject;
import com.h6ah4i.android.testing.ParameterizedTestArgs;

public class BasicMediaPlayerTestCase_ReleaseMethod
        extends BasicMediaPlayerStateTestCaseBase {

    public static TestSuite buildTestSuite(Class<? extends IMediaPlayerFactory> factoryClazz) {
        return BasicMediaPlayerTestCaseBase.buildBasicTestSuite(
                BasicMediaPlayerTestCase_ReleaseMethod.class, factoryClazz);
    }

    public BasicMediaPlayerTestCase_ReleaseMethod(ParameterizedTestArgs args) {
        super(args);
    }

    private void expectsNoErrors(IBasicMediaPlayer player) throws IOException {
        Object sharedSyncObj = new Object();
        ErrorListenerObject err = new ErrorListenerObject(sharedSyncObj, false);
        CompletionListenerObject comp = new CompletionListenerObject(sharedSyncObj);

        // check no errors
        player.setOnErrorListener(err);
        player.setOnCompletionListener(comp);

        player.release();

        if (comp.await(SHORT_EVENT_WAIT_DURATION)) {
            fail(comp + ", " + err);
        }

        assertFalse(comp.occurred());
        assertFalse(err.occurred());
    }

    // private void expectsIllegalStateException(IBasicMediaPlayer player) {
    // try {
    // player.release();
    // } catch (IllegalStateException e) {
    // // expected
    // return;
    // }
    // fail();
    // }

    @Override
    protected void onTestStateIdle(IBasicMediaPlayer player, Object args) throws Throwable {
        expectsNoErrors(player);
    }

    @Override
    protected void onTestStateInitialized(IBasicMediaPlayer player, Object args) throws Throwable {
        expectsNoErrors(player);
    }

    @Override
    protected void onTestStatePreparing(IBasicMediaPlayer player, Object args) throws Throwable {
        expectsNoErrors(player);
    }

    @Override
    protected void onTestStatePrepared(IBasicMediaPlayer player, Object args) throws Throwable {
        expectsNoErrors(player);
    }

    @Override
    protected void onTestStateStarted(IBasicMediaPlayer player, Object args) throws Throwable {
        expectsNoErrors(player);
    }

    @Override
    protected void onTestStatePaused(IBasicMediaPlayer player, Object args) throws Throwable {
        expectsNoErrors(player);
    }

    @Override
    protected void onTestStateStopped(IBasicMediaPlayer player, Object args) throws Throwable {
        expectsNoErrors(player);
    }

    @Override
    protected void onTestStatePlaybackCompleted(IBasicMediaPlayer player, Object args)
            throws Throwable {
        expectsNoErrors(player);
    }

    @Override
    protected void onTestStateErrorBeforePrepared(IBasicMediaPlayer player, Object args)
            throws Throwable {
        expectsNoErrors(player);
    }

    @Override
    protected void onTestStateErrorAfterPrepared(IBasicMediaPlayer player, Object args)
            throws Throwable {
        expectsNoErrors(player);
    }

    @Override
    protected void onTestStateEnd(IBasicMediaPlayer player, Object args) throws Throwable {
        // NOTE: StandardMediaPlayer will fail on this test case. It throws
        // IllegalStateException.
        expectsNoErrors(player);
        // expectsIllegalStateException(player);
    }
}
