package com.baeldung.um.test.suite;

import com.baeldung.um.security.AuthenticationRestLiveTest;
import com.baeldung.um.web.privilege.PrivilegeLogicRestLiveTest;
import com.baeldung.um.web.role.RoleLogicRestLiveTest;
import com.baeldung.um.web.user.UserLogicRestLiveTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ // @formatter:off
    UserLogicRestLiveTest.class,
    RoleLogicRestLiveTest.class,
    PrivilegeLogicRestLiveTest.class,

    AuthenticationRestLiveTest.class
})
// @formatter:off
public final class LiveLogicSuite {
    //
}
