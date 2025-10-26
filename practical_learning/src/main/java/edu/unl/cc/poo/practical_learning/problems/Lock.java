
package edu.unl.cc.poo.practical_learning.problems;

/**
 *
 * @author Xander
 */
public class Lock {

    private Integer pin;
    private int failedAttempts;
    private boolean locked;
    private boolean pinConfigured;

    public Lock() {
        this.pin = null;
        this.failedAttempts = 0;
        this.locked = false;
        this.pinConfigured = false;
    }

    public boolean configurePin(Integer newPin) {
        if (newPin < 0 || newPin > 9999) {
            return false;
        }
        this.pin = newPin;
        this.failedAttempts = 0;
        this.locked = false;
        this.pinConfigured = true;
        return true;
    }

    public boolean validatePin(Integer inputPin) {
        if (!pinConfigured || locked) {
            return false;
        }
        if (pin.equals(inputPin)) {
            failedAttempts = 0;
            return true;
        } else {
            failedAttempts++;
            if (failedAttempts >= 3) {
                locked = true;
            }
            return false;
        }
    }

    private void setPin(Integer pin) {
        this.pin = pin;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    private void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public boolean isLocked() {
        return locked;
    }

    private void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isPinConfigured() {
        return pinConfigured;
    }

    private void setPinConfigured(boolean pinConfigured) {
        this.pinConfigured = pinConfigured;
    }

    public void unlock() {
        this.locked = false;
        this.failedAttempts = 0;
    }
}
