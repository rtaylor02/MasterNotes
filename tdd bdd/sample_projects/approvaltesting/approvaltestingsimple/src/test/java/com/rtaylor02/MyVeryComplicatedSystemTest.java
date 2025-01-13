package com.rtaylor02;

import org.junit.jupiter.api.Test;
import org.approvaltests.Approvals;

/**
 * [Description]
 *
 */
class MyVeryComplicatedSystemTest {
    private MyVeryComplicatedSystem sut = new MyVeryComplicatedSystem();

    @Test
    void shouldApproveChanges() {
        Approvals.verify(sut.doSomethingVeryComplicated("Hello"));
    }
}