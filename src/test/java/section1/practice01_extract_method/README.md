# Practice 01: Extract Method

## Referencia del Libro
- **Técnica**: Extract Method
- **Página**: 87
- **Categoría**: Composing Methods

## Problema
Tienes un fragmento de código que puede ser agrupado. Este code smell aparece cuando hay métodos demasiado largos o código que necesita explicación.

## Síntomas
- Métodos largos
- Código con muchos niveles de indentación
- Código que requiere comentarios para entender su propósito
- Bloques de código que tienen alta cohesión entre sí

## Solución
- Crear un nuevo método con un nombre que explique su propósito
- Mover el código relevante a este nuevo método
- Reemplazar el código original con una llamada al nuevo método

## Estructura de la Práctica
```
practice01_extract_method/
  ├── before/                     # Código original con code smells
  │   ├── OrderProcessor.java     # Clase con métodos largos
  │   └── OrderProcessorTest.java # Tests para verificar comportamiento
  │
  └── after/                      # Código refactorizado
      ├── OrderProcessor.java     # Clase con métodos extraídos
      └── OrderProcessorTest.java # Mismos tests verificando comportamiento
```

## Beneficios Esperados
- Mejor legibilidad del código
- Reducción de duplicación
- Métodos más cohesivos y mantenibles
- Mayor facilidad para reutilizar código