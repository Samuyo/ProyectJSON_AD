# AUTORES: <u>David Baquero y Samuel<u>

## Repositorio github: https://github.com/Samuyo/ProyectJSON_AD/
***

# Índice
1. [INTRODUCCIÓN:](#intorduccion)
2. [CAPTURAS POSTMAN](#capturas-postman)
3. [MANUAL USUARIO](#manual-usuario)
4. [MANUAL TÉCNICO](#manual-tecnico)
5. [REPARTO DE TAREAS](#reparto-de-tareas)
6. [EXTRAS REALIZADOS](#extras-realizados)
7. [PROPUESTAS](#propuestas)
8. [CONTROL DE ERRORES](#control-de-errores)
9. [CONCLUSIÓN Y TIEMPO DEDICADO](#conclusión-y-dedicación-temporal)

***

## INTRODUCCIÓN:
 ### OBJETIVO DEL PROYECTO:
El objetivo del proyecto es hacer una aplicación con interfaz gráfica, que acceda a una "base de datos" en un archivo "json" de una api que está en internet. En nuestro caso lo elegimos de VALORANT, donde vamos a buscar agentes.

***

## CAPTURAS POSTMAN

***

2.1 La primera imagen es Gekko, un agente de VALORANT. La captura la hicimos en postman, la aplicación que usamos para comprobar las consultas.

***

2.2 Está captura es sobre Fade, que al igual que Gekko, es un agente de VALORANT 

***

2.3 La última captura es sobre la consulta de Breach

***

## MANUAL USUARIO
 Este punto se divide en 3, usado el jar, usando el IDE o compilador y el funcionamiento genérico.
Antes de entrar al funcionamiento, se debe hacer un git clone (enlace del github) ruta/donde/quieres/clonar.
  3.1 Funcionamiento con el jar
    Tienes que usar en la cmd el comando java -jar ruta/de/archivo/jar
   3.2 Funcionamiento desde el IDE o compilador
Para ejecutar el programa es necesario entrar a la carpeta y ejecutar el archivo "Main.java"
   3.3 Funcionamiento genérico
Una vez tienes la ventana de login, el usuario de inicio es "Usuario" y la contraseña es "1234a" (posibilidad de registrarte no llevado a cabo aún) y darle al botón que pone Enter 
Se te abrirá una ventana donde vas a tener un botón para salir a la pantalla de login y un sitio donde introducir el nombre de el agente que quieres 
(Gekko, Fade, Sova, Breach, KAY/O, Skye, Phoenix, Neon, Reyna, Raze, Jett, Iso, Yoru, Vyse, Deadlock, Chamber, Sage, Killjoy, Cypher, Omen, Clove, Brimstone, Viper, Astra y Harbor) y una vez le das a buscar, se cambiará la ventana.

En esta ventana, observarás un botón para volver al buscador y los datos (nombre, descripción, habilidades y rol) en inglés, ya que por el momento, la api solo está en inglés

-añadir imagen si lo conseguimos.

***

## MANUAL TÉCNICO
En la paquete de Controller, están ubicados los controladores de las ventas y sus funciones (tratado en el 4.2)
En el paquete Modelo, están ubicados las clases y los métodos de funcionamiento de la aplicación (tratado en el 4.3)
4.1 Requisitos de uso
Es necesario tener instalado javafx y el jdk de java 17.

***

## REPARTO DE TAREAS
Paquete Modelo: Samuel
Paquete Controller: 
Funcionamiento con la interfaz gráfica: David 
Acceso a JSON: Ambos, principalmente Samuel ya que tuvimos un problema y fue quien lo arregló 
README.MD: David
Main: David
Diseño de interfaz: Ambos

***

## EXTRAS REALIZADOS
Por revisar cuáles hemos hecho

***

## PROPUESTAS
Si en algún momento se continúa con la aplicación, se podría añadir la búsqueda de mapas y armas. En cuanto a las skins podría ser una función mucho más adelante en las armas.

***

## CONTROL DE ERRORES
Por el momento:
Si se introduce el nombre de un agente que no existe, la aplicación no busca nada.
Si el usuario con el que se intenta iniciar no existe, la aplicación no entrará.

***

## CONCLUSIÓN Y TIEMPO DEDICADO
El tiempo dedicado de David es aproximadamente de: 16h (por ahora)
El tiempo dedicado de Samuel es aproximadamente de : -----

9.1  Conclusión:
Con este proyecto hemos aprendido: a hacer interfaces y vincularlas en java, ya que de momento solo sabíamos en Python, hemos aprendido a entrar a archivos json en red, hemos practicado control de versiones en distintas ramas y nos ha servido como repaso para el examen de este temario.
