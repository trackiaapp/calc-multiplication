# @Trackia: Ejemplo de calculadora - Multiplication



## Introducción


Este software es parte de un conjunto de ejemplos que demuestran el funcionamiento de la librería @Trackia version 1.1.4.
Para más información puede dirigirse a la página de la librería [www.trackia.app](www.trackia.app) donde encontrará la documentación oficial y otros ejemplos relacionados.



Si bien, es posible ejecutar este servicio de manera autónoma, el ejemplo es aun más ilustrativo si se ejecuta junto a las otras 3 operaciones:
- [addition](https://github.com/trackiaapp/calc-addition)
- [subtraction](https://github.com/trackiaapp/calc-subtraction)
- [multiplication](https://github.com/trackiaapp/calc-multiplication)
- [division](https://github.com/trackiaapp/calc-division)

Por lo que se recomienda bajar las 4 operaciones de la calculadora y ejecutarlos en combinación.



## Arquitectura

Para que este ejemplo sea mas eficiente, es necesario entender la arquitectura de implementada. Este software esta construido en 3 capas:
- Controlador
- Servicio
- Repositorio



## Descripción
Este proyecto permite multiplicar 2 números y devuelve el resultado. Los parámetros de entrada son 2 expresiones que pueden ser:
- Un entero.
- O una expresión que represente otra operación que debe ser evaluada.


## Ejemplos

El siguiente ejemplo da como resultado 15:

**POST**: http://localhost:5559/multiplication

**Body**

```
{
    "left": "5",
    "right": "3"
}
```

Salida:

```
{
    "result": 15,
    "journalId": "6d89d6dc-0cc7-4cfb-8917-7c82e44f79ab"
}

```
Donde **journalId** es el número de transacción para realizar el seguimiento. Si se consulta el journalId en el E2E de trackia el resultado será el siguiente:


![Secuencia](secuence.png)



Veamos otro ejemplo. Aquí la multiplicacion de 2 números, el primero un 5 y el segundo es el resultado de la suma 3 + 2.
Es importante indicar, que para el completo funcionamiento de la operación deben estar ambos servicios (multiplication y addition) corriendo y configurados correctamente.


**POST**: http://localhost:5559/multiplication

**Body**

```
{    
    "left": "5",
    "right": 
        {

            "operation" : "+",
            "left": "3",
            "right": "2"
         }
}

```

Salida:

```
{
    "result": 25,
    "journalId": "b7325589-96aa-49c6-8c32-a4bb5216efb7"
}

```

![Secuencia](secuence2.png)


## Configuración
El proyecto está configurado con un archivo yml en la ruta: **multiplication/src/main/resources/application.yml** con algunos parámetros por default.


Lo primero que debe considerar es que se ejecuta en localhost en el puerto 5559, si requiere cambiar estos valores, recuerde cambiar los valores de los otros servicios de calculadora relacionados, es decir, se debe cambiar el puerto y/o host en los servicios addition, subtraction, multiplication y division correspondientes.

Otro aspecto importante a considerar, es que la configuración inicial envía la salida hacia el log, si desea cambiar la salida al servicio de trackia, debe crear una cuenta y modificar los valores de "trackia.dispatcher", para más información visite la documentación de dispatcher en
[www.trackia.app/documentacion/dispatcher](www.trackia.app/documentacion/dispatcher)






## Licencia
Proyecto de código abierto, siéntase libre de bajar y modificar este software como estime conveniente.

