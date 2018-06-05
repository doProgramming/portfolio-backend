package product.portfoliosite.user;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import product.IoT.dto.Relay;
import product.IoT.impl.ReleyImpl;
import product.parsingweb.service.ScheduledWebParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {

    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private ScheduledWebParserService sendSmile;

    @Autowired
    private ReleyImpl reley;

    @RequestMapping("/greeting")
    @ResponseStatus(HttpStatus.OK)
    public Relay greeting(@RequestParam(value="name", defaultValue="") String name) {
        //reley.setTurnOnPinNumber(name);
        return new Relay(counter.incrementAndGet(), sendSmile.setAndGetDate().toString());
    }
    @RequestMapping("/date")
    public Relay date(@RequestParam(value="fileName") String fileName, @RequestParam(value="url") String url) throws IOException {
        //return reley.getAndParseBody(fileName,url);
        return null;
    }

    @RequestMapping("/turnon")
    public Relay turnon(@RequestParam(value="pin") String pin) throws IOException {
        //reley.setTurnOnPinNumber(pin);
        return new Relay(counter.incrementAndGet(), sendSmile.setAndGetDate().toString());
    }

    @RequestMapping("/turnoff")
    public Relay turnoff(@RequestParam(value="pin") String pin) throws IOException {
        //reley.setTurnOffPinNumber(pin);
        return new Relay(counter.incrementAndGet(), sendSmile.setAndGetDate().toString());
    }

    @RequestMapping("/test")
    public void test() throws IOException {
        //reley.test();
    }

    @RequestMapping("/teston")
    public void teston() throws IOException {
        //reley.testOn();
    }

    @RequestMapping("/testoff")
    public void testoff() throws IOException {
       // reley.testOff();
    }

    @RequestMapping("/testWave")
    public void test(@RequestParam(value="startSequence") Boolean startSequence) throws InterruptedException{
        //reley.testWave(startSequence);
    }
}