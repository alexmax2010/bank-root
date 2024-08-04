**Modelo de Proyecto recomendado para los backend de Kruger**

## Antecedentes
El proyecto está pensado para desplegar como un jar de forma independiente teniendo para esto el servidor de tomcat embebido, por lo que al construir se generara un **jar**.
Además contiene el wrapper de gradle en su version 6.9, asi pues puede construir usando **gradlew build** en windows y **./gradlew build** en linux.

## Primeros pasos
1. Clonar el proyecto base-root
2. Ejecutar **gradlew clean build** para contruir en windows.
3. Para ejecutar:

        1. Definir variable de ambiente
        `export SPRING_PROFILES_ACTIVE='CONSOLA'` en linux o macos y en window `SET SPRING_PROFILES_ACTIVE='CONSOLA'`


### Configuración en repositorio
1. Clonar el repositorio asignado para su proyecto
2. Copiar los archivos del proyecto base, **EXCEPTO la carpeta .git**

### Configuración de clientId
1. Solicitar la creación del clientId en keycloak
2. Copiar el clientId (resource) en los archivos de ambiente .yaml
