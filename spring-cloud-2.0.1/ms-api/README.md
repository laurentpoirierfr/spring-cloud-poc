# MS-API

Exemple d'une api avec Spring Boot.

```java
@Controller
@RequestMapping("/")
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @ResponseBody
    @GetMapping("hello-world")
    public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
```

Exemple d'utilisation

```
http://localhost:8081/hello-world?name=MyName
```

Résultat :

```json
{"id":1,"content":"Hello, MyName!"}
```