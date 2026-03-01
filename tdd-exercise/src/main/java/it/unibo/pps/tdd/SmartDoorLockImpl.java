package it.unibo.pps.tdd;

public class SmartDoorLockImpl implements SmartDoorLock{

    private int pin;
    private int failed_attemps;
    private boolean blocked;
    private boolean locked;
    public static final int INITIAL_PIN = 9090;
    public static final int MAX_ATTEMPTS = 5;

    public SmartDoorLockImpl(){
        this.pin = 0;
        this.failed_attemps = 0;
        this.blocked = false;
        this.locked = false;
    }

    @Override
    public void setPin(int pin) {
        if (!locked && !blocked) {
            this.pin = pin;
        }
    }

    @Override
    public void unlock(int pin) {
        if(isMaxAttemptsReached()){
            failed_attemps++;
            block();
        }else{
            if(isPinOk(pin)){
                if(locked){
                    locked = false;
                }
            }else {
                failed_attemps++;
            }
        }
    }

    @Override
    public void lock() {
        if (!locked) {
            this.locked = true;
        }
    }

    private  boolean isPinOk(int pin){
        return this.pin == pin;
    }

    private void block(){
        if (!blocked) {
            this.blocked = true;
        }
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public boolean isBlocked() {
        return this.blocked;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    private boolean isMaxAttemptsReached(){
       return getFailedAttempts() >= getMaxAttempts();
    }

    @Override
    public int getFailedAttempts() {
        return this.failed_attemps;
    }

    @Override
    public void reset() {
        this.pin = 0;
        this.failed_attemps = 0;
        this.blocked = false;
        this.locked = false;
    }

    @Override
    public int getPin() {
        return this.pin;
    }
}
