package hello.springmvc.basic.requestmappin;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public  String helloBasic(){
        log.info("helloBasic");
        return "OK";
    }

    @GetMapping(value="/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){
        log.info("mappingPath user_id={}",data);
        return "ok";
    }

    @PostMapping(value="/mapping-consume",consumes="application/json")
    public String mappingConsume(){
        log.info("mappingconsumes");
        return  "ok";
    }

    /**
     * accept header기반
     * @return
     */
    @PostMapping(value="/mapping-produce",produces="text/html")
    public String mappingProduce(){
        log.info("mappingproduces");
        return  "ok";
    }

}
