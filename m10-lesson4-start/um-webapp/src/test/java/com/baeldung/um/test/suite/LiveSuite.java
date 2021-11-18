package com.baeldung.um.test.suite;

import com.baeldung.um.security.SecurityRestLiveTest;
import com.baeldung.um.test.live.UmAsyncRestLiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({// @formatter:off
    LiveDiscoverabilitySuite.class,
    LiveLogicSuite.class,
    SecurityRestLiveTest.class,
    UmAsyncRestLiveTest.class
})
// @formatter:on
public final class LiveSuite {
    //
}
