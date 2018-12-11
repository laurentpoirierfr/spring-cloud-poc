# MS-SERVICE

Exemple d'api, utilisant l'approche ```@EnableFeignClients``` pour la résolution de service.


### Création d'une interface cliente Feign

Cette interface récupére la localisation du service : ```ms-api``` via l'annuaire consul.
Techniquement c'est une liste d'url qui est retournée, ce qui permet la mise en place d'un pool de service.
Le service embarque ainsi un mécanisme de laodbalancing par défaut.

```java
@FeignClient(value = "ms-api")
public interface HelloWorldClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hello-world", consumes = "application/json")
    public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) ;

}
```


### Utilisation du client

Le client est embarqué dans le controller d'api, afin de faire place plat.

```java
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
```