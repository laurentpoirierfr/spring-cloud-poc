# MS-FRONTEND

Exemple d'appel de service via un IHM


Mise en place d'une gateway embarquée, Zuul.

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
</dependency>
```

Configuration de la gateway par résolution de service : ```ms-service```


```yml
zuul:
  routes:
    api:
      path: /api/**
      serviceId: ms-service
```


