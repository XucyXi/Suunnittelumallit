package bridge.devices;

import bridge.devices.Radio;
import bridge.devices.SmartTV;
import bridge.devices.Tv;
import bridge.devices.AdvancedRemote;
import bridge.devices.BasicRemote;
import bridge.devices.SmartRemote;

public class Main {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
        testSmartDevice(new SmartTV());
        testSmartDevice(new Radio()); // Testing graceful failure
    }

    public static void testDevice(bridge.devices.Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }

    public static void testSmartDevice(bridge.devices.Device device) {
        System.out.println("Tests with SmartRemote.");
        SmartRemote smartRemote = new SmartRemote(device);
        smartRemote.power();
        smartRemote.voiceControl("youtube");
        device.printStatus();
    }
}