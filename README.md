# Práctica de Patrones de Refactorización

Este proyecto es una práctica de aplicación de patrones de refactorización en un sistema de gestión de una tienda de libros de filosofia, juegos de mesa y lectores electronicos de libros

## Lista de los nombres de refactory a practicar por orden de dificultad  y tipo

| 1. Extract Method | 2. Inline Method | 3. Extract Variable |
|-------------------|------------------|---------------------|
| 4. Inline Temp | 5. Replace Temp with Query | 6. Split Temporary Variable |
| 7. Remove Assignments to Parameters | 8. Replace Method with Method Object | 9. Substitute Algorithm |
| 10. Move Method | 11. Move Field | 12. Extract Class |
| 13. Inline Class | 14. Hide Delegate | 15. Remove Middle Man |
| 16. Introduce Foreign Method | 17. Introduce Local Extension | 18. Self Encapsulate Field |
| 19. Replace Data Value with Object | 20. Change Value to Reference | 21. Change Reference to Value |
| 22. Replace Array with Object | 23. Duplicate Observed Data | 24. Change Unidirectional Association to Bidirectional |
| 25. Change Bidirectional Association to Unidirectional | 26. Replace Magic Number with Symbolic Constant | 27. Encapsulate Field |
| 28. Encapsulate Collection | 29. Replace Type Code with Class | 30. Replace Type Code with Subclasses |
| 31. Replace Type Code with State/Strategy | 32. Replace Subclass with Fields | 33. Decompose Conditional |
| 34. Consolidate Conditional Expression | 35. Consolidate Duplicate Conditional Fragments | 36. Remove Control Flag |
| 37. Replace Nested Conditional with Guard Clauses | 38. Replace Conditional with Polymorphism | 39. Introduce Null Object |
| 40. Introduce Assertion | 41. Rename Method | 42. Add Parameter |
| 43. Remove Parameter | 44. Separate Query from Modifier | 45. Parameterize Method |
| 46. Replace Parameter with Explicit Methods | 47. Preserve Whole Object | 48. Replace Parameter with Method Call |
| 49. Introduce Parameter Object | 50. Remove Setting Method | 51. Hide Method |
| 52. Replace Constructor with Factory Method | 53. Replace Error Code with Exception | 54. Replace Exception with Test |
| 55. Pull Up Field | 56. Pull Up Method | 57. Pull Up Constructor Body |
| 58. Push Down Method | 59. Push Down Field | 60. Extract Subclass |


## Estructura del Proyecto

El proyecto sigue una estructura de paquetes basada en arquitectura limpia (clean architecture):

- `common`: Contiene clases y utilidades comunes utilizadas en todo el proyecto.
    - `model`: Contiene las clases de modelo que representan las entidades del dominio, como `Book`, `BoardGame`, `EReader`, `Order`, entre otras.
    - `repository`: Contiene las interfaces y implementaciones de los repositorios para acceder a los datos.
        - `BookRepository`: Repositorio específico para gestionar los libros.
        - `ProductRepository`: Interfaz genérica para repositorios de productos.
        - `OrderRepository`: Repositorio para gestionar las órdenes.
        - `DatabaseConnection`: Clase para establecer y gestionar la conexión con la base de datos.
    - `util`: Contiene clases de utilidad.
        - `ProductUtils`: Utilidades relacionadas con los productos, como cálculo de precios y formateo de información.
        - `ValidationUtils`: Utilidades de validación para productos y órdenes.
- `refactory_practices`: Contiene ejemplos de aplicación de prácticas de refactorización.
    - `practice01_extract_method_test`: Ejemplo de aplicación del patrón Extract Method.
        - `BookDiscountCalculatorAfter`: Clase después de aplicar el patrón.
        - `BookDiscountCalculatorBefore`: Clase antes de aplicar el patrón.
    - `practice02_inline_method_test`: Ejemplo de aplicación del patrón Inline Method.
- `resources`: Contiene archivos de recursos del proyecto.
    - `db`: Contiene scripts SQL para la configuración de la base de datos.
        - `schema.sql`: Script para crear la estructura de la base de datos.
        - `data.sql`: Script para insertar datos de ejemplo en la base de datos.

## Prácticas de Refactorización

El proyecto incluye ejemplos de aplicación de los siguientes patrones de refactorización:

1. **Extract Method**: Consiste en extraer un fragmento de código en un nuevo método para mejorar la legibilidad y reutilización del código.

2. **Inline Method**: Consiste en reemplazar una llamada a un método con el cuerpo del método directamente en el lugar de la llamada, cuando el método es muy simple y no aporta claridad.

## Configuración de la Base de Datos

El proyecto utiliza una base de datos H2 en memoria. Los scripts SQL para la creación de la estructura de la base de datos y la inserción de datos de ejemplo se encuentran en la carpeta `resources/db`.

- `schema.sql`: Contiene las sentencias SQL para crear las tablas necesarias en la base de datos.
- `data.sql`: Contiene las sentencias SQL para insertar datos de ejemplo en las tablas.

## Dependencias

El proyecto utiliza las siguientes dependencias principales:

- H2 Database: Base de datos en memoria utilizada para almacenar y recuperar datos.
- Lombok: Biblioteca que ayuda a reducir el código repetitivo mediante anotaciones.
- SLF4J: Fachada para logging.

Puedes encontrar el detalle completo de las dependencias en el archivo `pom.xml`.

## Ejecutar el Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Clona el repositorio en tu máquina local.
2. Asegúrate de tener Java y Maven instalados.
3. Abre el proyecto en tu IDE favorito.
4. Compila el proyecto utilizando Maven.
5. Ejecuta los tests unitarios para ver los ejemplos de refactorización en acción.

## Contribución

Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama con un nombre descriptivo para tu contribución.
3. Realiza tus cambios y asegúrate de que los tests pasen.
4. Envía un pull request describiendo tus cambios.

## Actualizaciones
 - Semanalmente entre 3 a 5  diferentes
 - Terminacion del reto aproximado: enero 15 de 2024