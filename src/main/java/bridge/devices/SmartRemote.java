package bridge.devices;

import bridge.devices.Device;
import bridge.devices.SmartTV;

public class SmartRemote extends AdvancedRemote {

    public SmartRemote(Device device) {
        super(device);
    }

    // New specific functionality for the SmartRemote
    public void voiceControl(String command) {
        System.out.println("SmartRemote: Voice command received -> '" + command + "'");

        if (command.equalsIgnoreCase("youtube")) {
            if (device instanceof SmartTV) {
                ((SmartTV) device).browseInternet("www.youtube.com");
            } else {
                System.out.println("SmartRemote Error: Connected device does not support web browsing.");
            }
        } else if (command.equalsIgnoreCase("mute")) {
            mute(); // Utilizes the method inherited from AdvancedRemote
        }
    }
}