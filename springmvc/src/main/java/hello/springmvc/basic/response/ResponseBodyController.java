package hello.springmvc.basic.response;

import hello.springmvc.basic.Hellodata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException{
        response.getWriter().write("OK");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() throws IOException{
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() throws IOException{
        return "ok";
    }

    @ResponseBody
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<Hellodata> responseBodyJsonV1() throws IOException{
        Hellodata hellodata = new Hellodata();
        hellodata.setUsername("UserA");
        hellodata.setAge(20);
        return new ResponseEntity<>(hellodata,HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public Hellodata responseBodyJsonV2() throws IOException{
        Hellodata hellodata = new Hellodata();
        hellodata.setUsername("UserA");
        hellodata.setAge(20);
        return hellodata;
    }

}
