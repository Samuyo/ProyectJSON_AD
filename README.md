# AUTORES: *David Baquero y Samuel*

## Repositorio github: https://github.com/Samuyo/ProyectJSON_AD/
***

# Índice
1. [INTRODUCCIÓN](#introducción)
2. [CAPTURAS POSTMAN](#capturas-postman)
3. [MANUAL USUARIO](#manual-usuario)
4. [MANUAL TÉCNICO](#manual-técnico)
5. [REPARTO DE TAREAS](#reparto-de-tareas)
6. [EXTRAS REALIZADOS](#extras-realizados)
7. [PROPUESTAS](#propuestas)
8. [CONTROL DE ERRORES](#control-de-errores)
9. [CONCLUSIÓN Y TIEMPO DEDICADO](#conclusión-y-tiempo-dedicado)

***

## INTRODUCCIÓN:
 ### OBJETIVO DEL PROYECTO:
El objetivo del proyecto es hacer una aplicación con interfaz gráfica, que acceda a una "base de datos" en un archivo "json" de una api que está en internet. En nuestro caso lo elegimos de VALORANT, donde vamos a buscar agentes.

***

## CAPTURAS POSTMAN

***

### 2.1 
La primera imagen es Gekko, un agente de VALORANT. La captura la hicimos en postman, la aplicación que usamos para comprobar las consultas.
![Imagen gekko](https://github.com/Samuyo/ProyectJSON_AD/blob/main/src/main/resources/querys/Gekko.png)

***

### 2.2 
Está captura es sobre Fade, que al igual que Gekko, es un agente de VALORANT. 
![Imagen fade](https://github.com/Samuyo/ProyectJSON_AD/blob/main/src/main/resources/querys/Fade.png)

***

### 2.3 
La última captura es sobre la consulta de Breach.
![Imagen breach](https://github.com/Samuyo/ProyectJSON_AD/blob/main/src/main/resources/querys/Breach.png)

***

## MANUAL USUARIO
Este punto se divide en 3, usado el jar, usando el IDE o compilador y el funcionamiento genérico.
Antes de entrar al funcionamiento, se debe hacer:

```bash
git clone https://github.com/Samuyo/ProyectJSON_AD.git ruta/donde/quieres/clonar
```

***

### 3.1 Funcionamiento con el jar
Tienes que usar en la cmd el comando 
```bash
java -jar ruta/de/archivo/jar
```

***

### 3.2 Funcionamiento desde el IDE o compilador
Para ejecutar el programa es necesario entrar a la carpeta y ejecutar el archivo "Main.java".

***

### 3.3 Funcionamiento genérico
Una vez tienes la ventana de login, el usuario de inicio es "Usuario" y la contraseña es "1234a" (posibilidad de registrarte no llevado a cabo aún) y darle al botón que pone Enter.
Se te abrirá una ventana donde vas a tener un botón para salir a la pantalla de login y un sitio donde introducir el nombre de el agente que quieres y una vez le das a buscar, se cambiará la ventana.
*Los agentes disponibles son:*
```bash
Gekko, Fade, Sova, Breach, KAY/O, Skye,
Phoenix, Neon, Reyna, Raze, Jett, Iso, Yoru,
Vyse, Deadlock, Chamber, Sage, Killjoy, Cypher,
Omen, Clove, Brimstone, Viper, Astra y Harbor 
```

En esta ventana, observarás un botón para volver al buscador y los datos *(nombre, descripción, habilidades y rol)* en inglés, ya que por el momento, la api solo está en inglés.

-añadir imagen si lo conseguimos.

***

## MANUAL TÉCNICO
En la paquete de Controller, están ubicados los controladores de las ventas y sus funciones *tratado en el 4.2*
En el paquete Modelo, están ubicados las clases y los métodos de funcionamiento de la aplicación *tratado en el 4.3*.

***

### 4.1 Requisitos de uso
Es necesario tener instalado **javafx** y el **jdk de java 17**.

***

### 4.2 Paquete Controller

#### LoginController

`leer:` Este método se encarga de leer y dividir usuario y contraseña de un [archivo txt](https://github.com/Samuyo/ProyectJSON_AD/blob/main/src/main/resources/BD/users.txt) que guarda los usuarios y se lo pasa a un `HashMap`.

`autentificacionUser:` Entra al `HashMap` y verifica que el valor de la contraseña es igual a la contraseña que se le pasa más adelante en el método `handleBtnEnter`.

`handleBtnEnter`: Este metodo es el del botón Enter, antes de activarse, obtiene el texto que se le pasa por teclado a la aplicación, tanto del usuario como de la contraseña, si el método `autentificacionUser` devuelve `True`, entonces entra, carga, obtiene el estado y muestra la pantalla de `Search`.

#### AgentesController

`handlebtnReturn:` Es el botón encargado de volver al apartado de busqueda de agentes. Básicamente, carga la venta de `search.fxml`, obitiene el estado en el que está y luego muesta la ventana.

`accesoAPI:` Es el método encargado de acceder a la API por un objeto `URL`, hace un `GET` y obtiene la respuesta. Después comprueba que la respuesta sea igual que lo que hay, si es así, lee cada linea y la guarda en String.

`procesarRespuesta:` Es el método que se encarga de procesar la respuesta del método anterior. Primero crea un `ArrayList`, un `JSONObject` y un `JSONArray`. Por cada agente en el array obtiene sus datos, añadiendo después todo como un objeto de la clase `Character` y por último lo añade al `ArrayList`.

`getAgentes:` Es el método que utilizamos para vincular los metodos anteriores. Obtiene el `String` de `accesoAPI` y si no es nulo, almacena el resultado de `procesarRespuesta` en un `ArrayList` de `Character`.

#### SearchController

`handlebtnBuscar` Es el método encargado de buscar un agente, pero antes de ello verifica que esté dentro del `ArrayList` donde almacenamos la información.

`handlebtnSalir` Es el método encargado de cargar, obtener el estado y mostrar la ventana de login. Básicamente funciona como un `Cerrar sesión`.


***

### 4.3 Paquete Model

#### Character
Lo usamos principalmente para el constructor

#### User
`saveUser:` Es el método encargado de escribir los usuarios que existen dentro del el archivo [txt](https://github.com/Samuyo/ProyectJSON_AD/blob/main/src/main/resources/BD/users.txt).


***

## REPARTO DE TAREAS
- Paquete Modelo: Samuel
- Paquete Controller:
  Funcionamiento con la interfaz gráfica: David
  Acceso a JSON: Ambos, principalmente Samuel ya que tuvimos un problema y fue quien lo arregló
- README.MD: David
- Main: David
- Diseño de interfaz: Ambos

***

## EXTRAS REALIZADOS
Por revisar cuáles hemos hecho

***

## PROPUESTAS
Si en algún momento se continúa con la aplicación, se podría añadir la búsqueda de mapas y armas. En cuanto a las skins podría ser una función mucho más adelante en las armas.

***

## CONTROL DE ERRORES
Por el momento:
 - Si se introduce el nombre de un agente que no existe, la aplicación no busca nada.
 - Si el usuario con el que se intenta iniciar no existe, la aplicación no entrará.

***

## CONCLUSIÓN Y TIEMPO DEDICADO
El tiempo dedicado de David es aproximadamente de: 17h (por ahora) <br/>
El tiempo dedicado de Samuel es aproximadamente de : -----

### 9.1  Conclusión:
Con este proyecto hemos aprendido: a hacer interfaces y vincularlas en java, ya que de momento solo sabíamos en Python, hemos aprendido a entrar a archivos json en red, hemos practicado control de versiones en distintas ramas y nos ha servido como repaso para el examen de este temario.
