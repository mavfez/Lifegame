# Lifegame
Repositorio para la aplicación El Juego de de la Vida realizado por el grupo de agilismo de TSI de la mano de su asesor Napoleón

El proyecto está organizado de la siguiente manera:

Rais: applications\lifegame

- gui: Aquí se encuentran 3 aplicaciones que funcionan como la interfaz gráfica de la librería principal o core, una es por          consola, otra es html5 y la otra es JavaServer Face. En la de consola encontrarán los fuente y los comnandos de compilación      y ejecución; en la de html5 encontrarán una aplicación básica para empezar a trabajar las historias de usuario o epic que       se dispongan pero solo en HTML5, En la aplicación JaveServer Faces encontrarán un proyecto netbeans para tranajar toda la       parte web en java. Hay que asociarle la librería core.

- lib: Aquí encontrarán los fuentes de la librería principal o core del juego de la vida, también están los comandos de                compilación y de ejecución de las pruebas.

- pattern: Aquí encontrarán los archivos de los diferentes patrones del juego de la vida.

Notas
- Para utilizar los archivos make hay que crear la carpeta log en la raiz del proyecto
- Para ejecutar la aplicación deben existir los archivos seed.txt y seed_symbols.properties
- El archivo seed_symbols.properties define que caracter se usa para un elemento vivo y 
  que caracter se usa para un elemento muerto, segun el patron contenido en el archivo seed.txt

