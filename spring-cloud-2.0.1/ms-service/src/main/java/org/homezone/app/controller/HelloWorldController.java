package org.homezone.app.controller;

import org.homezone.app.client.HelloWorldClient;
import org.homezone.app.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloWorldController {

    @Autowired
    private HelloWorldClient helloWorldClient;


    @GetMapping("service")
    @ResponseBody
    public Greeting index(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return helloWorldClient.sayHello(name);
    }

}
