package product.portfoliosite.user;

import product.IoT.impl.ReleyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class WavesController {

    @Autowired
    private ReleyImpl reley;

    @ResponseBody
    @RequestMapping("/testWaves")
    public void test(@RequestParam(value="startSequence") Boolean startSequence)throws InterruptedException{
            //reley.testWave(startSequence);
    }
}
