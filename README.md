Integrante 1: Eugenio Román Cortés Egaña / RUT: 22.405.687-7 7 / CARRERA: Ingeniería Civil en Computación e Informatica / Usuario: QuenoLL
Integrante 2: Matías Nicolás Núñez González / RUT: 22.256.666.5 / CARRERA: Ingeniería Civil en Computación e Informatica / Usuario: Manugooo

Descripcion:
Nuestro codigo TallerPOO3 programa un menu interactivo el cual se desglosa en dos submenus, simulando un mundo magico donde podemos administrar desde el panel de administrador
y analizar desde el panel de analisis multiples relaciones y creaciones de distintos objetos; Usuando la Programación Orientada a Objetos desde los mismos archivos.txt en uno 
de los folder del programa, llamados "Magos.txt" y "Hechizos.txt", creamos y relacionamos "Magos" y "Hechizos", implementando Arquitectura en Software, de manera que contamos
con un systema implementado de una interfaz y su respectuva app.

Estructura:
Dentro del programa contamos con un source folder llamado "Taller3" el cual contiene nuestros paquetes, clases, etc. como paquetes se implementaron dos, en base a la relacion
del Modelo de Negocios, Dominio, el cual contiene nuestras clases, objetos principales, en nuestro caso "Spells" clase abstracta y sus subclases y "Mage", los cuales son implementados
por una interfaz en el mismo paquete, "Conditional", contrato que hace cumplir con funcionalidades que tiene en común, aparte de esto aclarar la relacion de estas clases, en nuestro
 mundo magico los Magos contienen una serie de hechizos, los cuales de por si tiene una puntuacion especifica que a su misma vez la suma de estos puntua a los magos. El siguiente es el paquete de logica, el cual 
contiene dentro de si nuestra app, donde ejecutamos el codigo y pasamos datos primitivos al systemaImpl que ademas instanciamos y se da la trata con objetos y sus metodos, pero aparte de esto contamos
con la ISystem, interfaz del systema que le da al systemImpl los metodos que debe de implementar segun su contrato. Hacer incapíe que cada vez que agregamos, modificamos los hedchizos o los magos
todo cambio se vera representado en en los archivos.txt anteriormente nombrados.

Metódo de uso:
Al correr el programa en pantalla nos aparecera un menu interactivo con tres opciones, menu de administrador, menu de anailis y salir, el primero nos dara la facultad de
poder administrar el mundo magico, creando magos, hechizos, modificaciones a estos, como tambien de la eliminacion de alguno de estos; El segundo menu, nos permite analizar
los datos de las respectivas clases nombradas del mundo magico, poder viendo tops segun la puntuacion de cada uno de estos o simplemente un recuento de estos; y la tercera,
salir, finaliza el programa, cabe recalcar que el guatrdado de datos se hace a travez de los mismo metodos implementados en el taller.
