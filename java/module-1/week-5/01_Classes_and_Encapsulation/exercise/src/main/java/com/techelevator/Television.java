package com.techelevator;

public class Television {
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void turnOff() {
        isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }

    public void changeChannel(int newChannel) {
        if (isOn) {
            currentChannel = newChannel;
        }
    }

    public void channelUp() {
        if (isOn) {
            if (currentChannel == 18) {
                currentChannel = 3;
            } else {
                currentChannel++;
            }
        }
    }

    public void channelDown() {
        if (isOn) {
            if (currentChannel == 3) {
                currentChannel = 18;
            } else {
                currentChannel--;
            }
        }
    }

    public void raiseVolume() {
        if (isOn) {
            currentVolume++;
        }
    }

    public void lowerVolume() {
        if (isOn) {
            if (currentVolume == 0) {
                currentVolume = 0;
            } else {
                currentVolume--;
            }
        }
    }
}
