package hammertank.grocery.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @GetMapping(path = "/echo", produces = MediaType.TEXT_PLAIN_VALUE)
    public String echo(@RequestParam("name") String name) {
        return "Hello, " + name + "!\n";
    }
}
