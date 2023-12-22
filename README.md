# Prueba 1

_Proyecto para una prueba técnica_

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._


### Pre-requisitos 📋
_Se debe tener instalado docker_
_Se ha creado un docker file que incluye maven_
_Se debe de ejecutar los siguientes comandos_

Para construir la imagen docker java-maven
```
docker build -t java-maven .
```
Para ejecutar la imagen docker java-maven
```
docker run -p 8080:8080 java-maven 
```
### Estructura del proyecto

src
└── main
├── java
│   └── com
│       └── example
│           └── priceservice
│               ├── application
│               │   └── PriceQueryService.java
│               ├── domain
│               │   └── Price.java
│               ├── infrastructure
│               │   ├── adapter
│               │   │   └── persistence
│               │   │       ├── PriceEntity.java
│               │   │       ├── PriceRepositoryJpa.java
│               │   │       └── PriceRepositoryJpaAdapter.java
│               │   └── config
│               │       └── H2Config.java
│               ├── presentation
│               │   └── PriceController.java
│               └── PriceServiceApplication.java
└── resources
├── application.properties
└── data.sql
