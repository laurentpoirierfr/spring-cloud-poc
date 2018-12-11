# MS-CONFIG


Distribution de  la configuration de service.

### Notes :

Uniquement les fichiers de type { key / value } peuvent être distribués, exemple YML et PROPERTIES.


```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

#### Starter

```java
@EnableConfigServer
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
```

#### Configuration en mode natif, avec accès aux fichiers de configuration via classpath.

```yml
spring:
  profiles:
    active: native
  cloud:
    config:
      server:
        native:
          searchLocations: classpath:offline-repository/
      git:
        uri: https://github.com/ima/{application} # ou bien ==> file://${user.home}/config-repo
```

Il est possible de déseactiver le mode natif afin de récupérer les fichiers du dépot soit sur GIT, SVN, soit Filesystem.


#### Contenu du dépôt de configuration :

```
./offline-repository
24/04/2018  08:50    <REP>          .
24/04/2018  08:50    <REP>          ..
24/04/2018  08:50             1 192 ms-admin.yml
24/04/2018  08:50             1 206 ms-api.yml
24/04/2018  08:50             1 286 ms-frontend.yml
24/04/2018  08:50             1 190 ms-service.yml
24/04/2018  08:50             1 161 ms-zipkin.yml
```

#### Convention de nommage des fichiers de configration

```
{application}-{profile}.yml
{application}-{profile}.properties
```

#### Exemple de dépôt de configuration avec gestion de profiles :


```
ms-application-production.yml
ms-application-developpement.yml
ms-application-recette.yml
ms-application-integraton.yml
...
```



#### Exemple de lancement java :

```
java -Dspring.profiles.active=production -jar {application}.{version}.jar
```

#### Exemple avec positionnement d'une vairable d'environnement :

```
export SPRING_PROFILES_ACTIVE = production
java -jar {application}.{version}.jar
```


#### Exemple de lancement avec container Docker :

```
docker run -e "SPRING_PROFILES_ACTIVE=production" -p 8080:8080 -t org.homezone.app/{application}:latest
```

