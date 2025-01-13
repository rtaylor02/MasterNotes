package com.rtaylor02;

import org.junit.jupiter.api.Test;
import org.approvaltests.Approvals;

import static org.junit.jupiter.api.Assertions.*;

/**
 * [Description]
 *
 * @Author: Rodney Taylor (u228616) on 13/01/2025
 */
class MyVeryComplicatedSystemTest {
    private MyVeryComplicatedSystem sut = new MyVeryComplicatedSystem();

    @Test
    void shouldApproveChanges() {
        Approvals.verify(sut.doSomethingVeryComplicated("Hello"));
    }
}