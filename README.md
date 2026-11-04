# Práctica 1: Pruebas Unitarias en Spring Boot

## Objetivo

Desarrollar un servicio Spring Boot con operaciones `findAll` y `create` sobre una entidad `Producto`, y validar su funcionamiento mediante pruebas unitarias con JUnit 5, Mockito y AssertJ.

## Tecnologías

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA + H2
- JUnit 5, Mockito, AssertJ

## Estructura

```
src/main/java/com/utch/practica1/
  ├── Producto.java            // Entidad JPA
  ├── ProductoRepository.java  // JpaRepository
  ├── ProductoService.java     // Servicio con findAll y create
  └── Practica1Application.java

src/test/java/com/utch/practica1/
  └── ProductoServiceTest.java // Pruebas unitarias
```

## Cómo ejecutar las pruebas

```bash
mvn test
```

## Autor

Susana Gallegos — IDGS91N, UTCh
