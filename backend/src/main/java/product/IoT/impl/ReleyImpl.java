package product.IoT.impl;

import org.springframework.stereotype.Component;


@Component
public class ReleyImpl{

/*
    @Autowired
    private ReleyImpl reley;

    private String turnOnPinNumber="";

    private String turnOffPinNumber="";

    final GpioController gpio = GpioFactory.getInstance();

    final GpioPinDigitalOutput pin_00 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "GPIO_00");
    final GpioPinDigitalOutput pin_01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "GPIO_01");
    final GpioPinDigitalOutput pin_02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "GPIO_02");
    final GpioPinDigitalOutput pin_03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "GPIO_03");
    final GpioPinDigitalOutput pin_04 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "GPIO_04");
    final GpioPinDigitalOutput pin_05 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "GPIO_05");
    final GpioPinDigitalOutput pin_06 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "GPIO_06");
    //Doesn't have number 7 bcs its static pin
    //final GpioPinDigitalOutput pin_07 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "GPIO_07");
    final GpioPinDigitalOutput pin_08 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "GPIO_08");
    final GpioPinDigitalOutput pin_09 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "GPIO_09");
    final GpioPinDigitalOutput pin_10 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, "GPIO_10");
    final GpioPinDigitalOutput pin_11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, "GPIO_11");
    final GpioPinDigitalOutput pin_12 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "GPIO_12");
    final GpioPinDigitalOutput pin_13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "GPIO_13");
    final GpioPinDigitalOutput pin_14 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "GPIO_14");
    final GpioPinDigitalOutput pin_15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "GPIO_15");
    final GpioPinDigitalOutput pin_16 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, "GPIO_16");
    final GpioPinDigitalOutput pin_17 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "GPIO_17");
    final GpioPinDigitalOutput pin_18 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18, "GPIO_18");
    final GpioPinDigitalOutput pin_19 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19, "GPIO_19");
    final GpioPinDigitalOutput pin_20 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_20, "GPIO_20");
    final GpioPinDigitalOutput pin_21 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "GPIO_21");
    final GpioPinDigitalOutput pin_22 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "GPIO_22");
    final GpioPinDigitalOutput pin_23 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "GPIO_23");
    final GpioPinDigitalOutput pin_24 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "GPIO_24");
    final GpioPinDigitalOutput pin_25 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "GPIO_25");
    final GpioPinDigitalOutput pin_26 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "GPIO_26");
    final GpioPinDigitalOutput pin_27 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "GPIO_28");
    final GpioPinDigitalOutput pin_28 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "GPIO_29");
    final GpioPinDigitalOutput pin_29 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "GPIO_30");
    final GpioPinDigitalOutput pin_30 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_30, "GPIO_31");
    final GpioPinDigitalOutput pin_31 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_31, "GPIO_32");



    public String getTurnOnPinNumber() {
        return turnOnPinNumber;
    }

    public void setTurnOnPinNumber(String turnOnPinNumber) {
        this.turnOnPinNumber = turnOnPinNumber;
    }

    public String getTurnOffPinNumber() {
        return turnOffPinNumber;
    }

    public void setTurnOffPinNumber(String turnOffPinNumber) {
        this.turnOffPinNumber = turnOffPinNumber;
    }

    public List<GpioPinDigitalOutput> gpioPinsList = new ArrayList<>();

    private Thread thread;

    @Scheduled(fixedDelay = 1000)
    public void startReley()
    {
        if(gpioPinsList == null || gpioPinsList.isEmpty()){
            gpioPinsList.add(pin_00);   gpioPinsList.add(pin_11);   gpioPinsList.add(pin_21);
            gpioPinsList.add(pin_01);   gpioPinsList.add(pin_12);   gpioPinsList.add(pin_22);
            gpioPinsList.add(pin_02);   gpioPinsList.add(pin_13);   gpioPinsList.add(pin_23);
            gpioPinsList.add(pin_03);   gpioPinsList.add(pin_14);   gpioPinsList.add(pin_24);
            gpioPinsList.add(pin_04);   gpioPinsList.add(pin_15);   gpioPinsList.add(pin_25);
            gpioPinsList.add(pin_05);   gpioPinsList.add(pin_16);   gpioPinsList.add(pin_26);
            gpioPinsList.add(pin_06);   gpioPinsList.add(pin_17);   gpioPinsList.add(pin_27);
            gpioPinsList.add(pin_08);   gpioPinsList.add(pin_18);   gpioPinsList.add(pin_28);
            gpioPinsList.add(pin_09);   gpioPinsList.add(pin_19);   gpioPinsList.add(pin_29);
            gpioPinsList.add(pin_10);   gpioPinsList.add(pin_20);   gpioPinsList.add(pin_30);
                                                                    gpioPinsList.add(pin_31);

        }
        int releyNumber = 0;
        if(turnOnPinNumber != null) {
            turnOffPinNumber = null;
            try{
                releyNumber = Integer.parseInt(turnOnPinNumber);
            }catch (NumberFormatException e){
            }
           reley.turnOn(gpioPinsList.get(releyNumber));
        }
        if(turnOffPinNumber != null){
            turnOnPinNumber = null;
            try{
                releyNumber = Integer.parseInt(turnOffPinNumber);
            }catch (NumberFormatException e){
            }
            reley.turnOff(gpioPinsList.get(releyNumber));
        }

    }

    //Turn on pin that is sent in request parametar
    @Override
    public void turnOn(GpioPinDigitalOutput pinNumber) {
        if(pinNumber != null) {
        if(!pinNumber.isHigh()){
              System.out.println("Turned on number: "+ pinNumber);
              pinNumber.high();
             }
        }
    }

    @Override
    public void turnOff(GpioPinDigitalOutput pinNumber) {
        if(pinNumber != null) {
        if(pinNumber.isLow()){
            System.out.println("Turned off number: "+ pinNumber);
            pinNumber.low();
        }
    }
    }
    @Override
    public void test(){
        for(int i=0;i<gpioPinsList.size();i++){
            System.out.println("Test has run");
                gpioPinsList.get(i).pulse(300);
        }
        System.out.println("Test has finished");
    }

    @Override
    public void testOff(){
        for(int i=0;i<gpioPinsList.size();i++){
            System.out.println("Test has run");
            gpioPinsList.get(i).low();
        }
        System.out.println("Test has finished");
    }

    @Override
    public void testOn(){
        for(int i=0;i<gpioPinsList.size();i++){
            System.out.println("Test has run");
            gpioPinsList.get(i).high();
        }
        System.out.println("Test has finished");
    }

    @Override
    public void testWave(Boolean startSeqence) throws InterruptedException {
        System.out.println("Test has run");
        for(int i=0;startSeqence;i++){
            if(i==25){
            thread.wait(2000);
            i=0;}
            gpioPinsList.get(i).high();
        }
        System.out.println("Test has finished");
    }*/

}