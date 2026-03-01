package it.unibo.pps.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    private SmartDoorLock smartDoor;
    private final int INITIAL_PIN = SmartDoorLockImpl.INITIAL_PIN;

    @BeforeEach
    void beforeEach(){
        smartDoor = new SmartDoorLockImpl();
        smartDoor.setPin(INITIAL_PIN);
    }

    void blockDoor(){
        smartDoor.lock();
        for (int i = 0; i <= SmartDoorLockImpl.MAX_ATTEMPTS; i++) {
            smartDoor.unlock(INITIAL_PIN+1);
        }
    }

    @Test
    public void testNonAllowedPinSettingBecauseLocked () {
        smartDoor.lock();
        smartDoor.setPin(INITIAL_PIN + 1);
        assertEquals(smartDoor.getPin(), INITIAL_PIN );
    }

    @Test
    public void testNonAllowedPinSettingBecauseBlocked () {
        blockDoor();
        if (smartDoor.isBlocked()){
            smartDoor.setPin(INITIAL_PIN + 1);
            assertEquals(smartDoor.getPin(), INITIAL_PIN );
        }
    }

    @Test
    public void testLockBlockedAfterMaxAttempts () {
        blockDoor();
        assertTrue(smartDoor.isBlocked());
    }

    @Test
    public void testUnlocking () {
        smartDoor.unlock(INITIAL_PIN);
        assertFalse(smartDoor.isLocked());
    }

    @Test
    public void testWrongUnlocking () {
        smartDoor.lock();
        smartDoor.unlock(INITIAL_PIN + 1);
        assertTrue(smartDoor.isLocked());
    }

    @Test
    public void testResetting () {
        smartDoor.reset();
        assertTrue(smartDoor.getPin() == 0 &&
                smartDoor.getFailedAttempts() == 0 &&
                !smartDoor.isBlocked() &&
                !smartDoor.isLocked());
    }
}
