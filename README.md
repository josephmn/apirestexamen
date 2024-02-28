# .:: API RestFull Usuario (v1.0) ::.

![java](https://img.shields.io/badge/Java-11-blue)
![Spring](https://img.shields.io/badge/SpringBoot-2.3.3-brightgreen)
![hibernate](https://img.shields.io/badge/hibernate-6.0.12-brightgreen)
![h2](https://img.shields.io/badge/h2-1.4.200-brightgreen)
![jjwt](https://img.shields.io/badge/jjwt-0.11.3-brightgreen)
![swagger](https://img.shields.io/badge/Swagger2-2.9.2-brightgreen)
![swagger-ui](https://img.shields.io/badge/swagger_ui-2.9.2-brightgreen)
![mockito](https://img.shields.io/badge/Mockito-3.12.4-brightgreen)

## Requisitos previos

* Tener instalado una versión de **Java 11** para que pueda funcionar el proyecto.
* Tener un **IDE** para poder ejecutar el proyecto y/o realizar cambios.

## Instalación

1. Descargar el código fuente del repositorio:
   ```
   https://github.com/josephmn/apirestexamen
   ```

2. Ejecutar: el proyecto principal **ApirestexampleApplication** (en mi caso uso **IntelliJ IDEA**):

   ![img.png](src/main/resources/static/img.png)

## Uso
1. Para realizar la prueba del API, se puede usar:

   * **Swagger** en la siguiente URL:
      ```
      http://localhost:8080/swagger-ui.html
      ```
     ![img.png](src/main/resources/static/img2.png)     

   * **Postman:**
   
        ![img.png](src/main/resources/static/img3.png)


2. Para poder consumir el **API** con **POSTMAN**, este sería la estructura:

    ```
    http://localhost:8080/api/v1/usuario/registro
    ```
    Siendo: **registro** el método para poder realizar el registro.

    La estructura body a ejecutar sería el siguiente:
    ```
    {
        "name": "Pedro Hernandez",
        "email": "pedro.hernandez@gmail.com",
        "password": "$PQwerty123",
        "phones": [
            {
            "number": "999777555",
            "citycode": "1",
            "contrycode": "51"
            }
        ]
    }
    ```
    * Deberia quedar de la siguiente manera antes de ejecutar: 
    ![img.png](src/main/resources/static/img4.png)


3. Cuando se envíe la petición al API y si todo es correcto, este devuelve el siguiente mensaje:

    ![img.png](src/main/resources/static/img5.png)

    * Aqui devuelve la siguiente estructura:
      ```
      {
           "id": "e1e1f583-0221-447d-9a3c-5f5091273741",
           "created": "2024-02-28T22:22:40.996+00:00",
           "modified": "2024-02-28T22:22:40.997+00:00",
           "last_Login": "2024-02-28T22:22:40.997+00:00",
           "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJQZWRybyBIZXJuYW5kZXoiLCJpYXQiOjE3MDkxNTg5NjEsImV4cCI6MTcwOTE1OTAyMX0.qEqURE2lll2KUpRfZnAbB7j7lE-iLVjBSHQ7PdBHW6E",
           "active": false
      }
      ```
    * Y devuelve un Status: **200 OK**.


4. En caso se tenga errores:

    * Correo con expresión regular:
      
        * En el ejemplo, se esta ingresando: **pedro.@_%hernandez@gmail.com**, con una expresión no válida de correo.
        ![img.png](src/main/resources/static/img6.png)
        
        * En el ejemplo, se esta ingresando: **pedro.hernandez@**, con una expresión no válida de correo.
        ![img_1.png](src/main/resources/static/img7.png)
    
    * Correo duplicado
   
        * Luego de haber ejecutado de manera correcta el punto 4, se intentará ejecutar nuevamente el mismo registro en json; este dará el siguiente mensaje:
        ![img_2.png](src/main/resources/static/img8.png)
        
    * Contraseña con expresión regular:
        
        * La expresión regular que se esta usando es la siguiente (se encunetra en **application.properties**):
          ```
          regularExp = ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$
          ```
          > La expresión regular puede ser cambiada en **application.properties**, solo se tiene que buscar dicha expresión y reiniciar el proyecto para que se actualicen los cambios, ya que este se crea desde el inicio del proyecto.
                    
        * En resumen, esta expresión regular asegura que la contraseña cumpla con los siguientes requisitos:

              > Al menos un dígito numérico.
              > Al menos una letra minúscula.
              > Al menos una letra mayúscula.
              > Al menos uno de los caracteres especiales especificados.
              > No debe contener espacios en blanco.
              > La longitud debe ser de al menos 8 caracteres.
            
        * En caso no se cumpla las condiciones indicadas, es API devolvera el siguiente mensaje:
            ![img.png](img.png)
            
            * El mensaje arroja error ya que no se cumple con los requisitos.

## Contribuir

Por el momento no hay contribuciones.
