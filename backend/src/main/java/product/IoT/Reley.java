package product.IoT;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

public interface Reley {
     void turnOn(GpioPinDigitalOutput pinNumber);
     void turnOff(GpioPinDigitalOutput pinNumber);
     void test();
     void testOff();
     void testOn();
     void testWave(Boolean s) throws InterruptedException;
}
