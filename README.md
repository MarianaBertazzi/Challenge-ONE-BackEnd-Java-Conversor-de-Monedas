# Conversor de Monedas

![Java](https://img.shields.io/badge/Java-21-blue)
![Maven](https://img.shields.io/badge/Maven-3.8.6-blue)
![Gson](https://img.shields.io/badge/Gson-2.10.1-green)

## Descripción

El **Conversor de Monedas** es una aplicación de consola en Java que permite convertir entre diferentes monedas utilizando las tasas de cambio actuales obtenidas a través de la API de Exchange Rate API. 
La aplicación también mantiene un historial de conversiones, permitiendo a los usuarios ver sus actividades previas y guardar estos registros en un archivo JSON.

## Funcionalidades

- Conversión entre las siguientes monedas:
  - ARS - Peso argentino
  - BOB - Boliviano boliviano
  - BRL - Real brasileño
  - CLP - Peso chileno
  - COP - Peso colombiano
  - USD - Dólar estadounidense
  - EUR - Euro
  - GBP - Libra esterlina

- Historial de Conversiones:
  - Rastrea y muestra el historial de las conversiones realizadas.
  - Guarda el historial de conversiones en un archivo JSON con formato `PrettyPrinting`.

## Uso

1. Ejecutar la aplicación.
2. Seleccionar la moneda de origen.
3. Ingresar el monto a convertir (debe ser un número positivo).
4. Seleccionar la moneda de destino.
5. Ver el resultado de la conversión.
6. Consultar el historial de conversiones si lo desea.

## Requisitos y Dependencias

- Java 21
- Maven 3.8.6 o superior
- Gson 2.10.1

## Instalación

1. Clonar el repositorio:

    ```sh
    git clone https://github.com/your-username/your-repository.git
    ```

2. Navegar al directorio del proyecto:

    ```sh
    cd your-repository
    ```

3. Compilar y ejecutar la aplicación con Maven:

    ```sh
    mvn clean compile exec:java -Dexec.mainClass="com.example.currencyconverter.CurrencyConverter"
    ```

## Ejemplo de Uso

A continuación se muestra un ejemplo de cómo usar la aplicación:

```sh
===============================================
     ¡Bienvenido al Conversor de Monedas!     
===============================================
¡Convierte fácilmente entre diferentes monedas!
===============================================

Seleccione una opción:
1. ARS - Peso argentino
2. BOB - Boliviano boliviano
3. BRL - Real brasileño
4. CLP - Peso chileno
5. COP - Peso colombiano
6. USD - Dólar estadounidense
7. EUR - Euro
8. GBP - Libra esterlina
9. Consultar historial de conversiones
0. Salir
