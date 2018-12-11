package org.homezone.app.client;

import org.homezone.app.domain.Greeting;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ms-api")
public interface HelloWorldClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hello-world", consumes = "application/json")
    public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) ;

}
