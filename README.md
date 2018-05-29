<h1> Dead Pixel </h1> <br>

<h2> Instrucciones del juego </h2> <br>
Mueve el personaje con las teclas 'A' y 'D' <br>
Dispara con las teclas flecha izquierda y flecha derecha <br>
Cambia de armas con la tecla 'E' y 'Q' <br>
Subiras de nivel cada vez que mates toda la ronda de zombie, si alguno de los zombies sale del mapa, 
el juego quedara en un punto muerto y tendras que reiniciar el juego
Obtendras nuevas armas en el nivel 2 y 4

<h2> Como se cubrieron cada uno de los puntos </h2> <br>
1.El proyecto fue trabajado y montado en github https://github.com/NonSenseGuy/FinalProject.git <br>
2.El juego guarda partida cada vez que se pasa de nivel <br>
 Se puede cargar la partida desde el menu de inicio en el boton de cargar partida <br>
3.El juego maneja un archivo de texto plano en el que guarda los puntajes cuando el jugador se muere <br>
Y carga el archivo de texto en el menu de inicio con el boton puntajes <br>
4.Las pruebas unitarias estan en el codigo del juego <br>
5.Cada metodo de ordenamiento fue cubierto en la manera en la que se organizaban los puntajes, por nivel, por nombre y por puntaje <br>
6.Cuando los puntajes estan organizados por nivel o por puntaje se habilitan los metodos de busqueda binaria respectivos en la ventana de dialogo de puntajes <br>
7.Los escenarios y las armas fueron manejados como listas doblemente enlazadas ciclicas <br>
8.Las clases PersonajePrincipal, Zombie, Boss, Botiquin, ArmaTiro, Rocket, Raygun son clases hijas de otra clase <br>
Se implementaron las interfaces generar, mover y disparar <br>
9. Los zombies fueron manejados como arboles binarios, su factor de ordenamiento fue su posicion en x <br>
10. Los metodos de listas enlazadas y arboles binarios fueron codificados de manera recursiva <br>
11. PanelMenu y PanelJuego usan al menos 5 primitivas de graphics <br>
12. DeadPixels usa 4 hilos adicionales al main. El primero genera y mueve zombies, el segundo maneja los disparos del personaje, el tercer maneja el movimiento del personaje y el ultimo genera botiquines <br>
<br>
Adicionalmente en la carpeta de documentacion de este proyecto se encuentran el javadoc de Dead Pixels y su respectivo diagrama UML

