package juego.modelo;

/**
 * Clase jugador.
 * 
 * @author José Miguel Ramírez Sanz
 * @author José Luis Garrido Labrador
 * @since 1.0
 * @version 2.0
 */
public class Jugador {
	// Atributos

	/**
	 * Nombre del jugador.
	 */
	private String nombre;

	/**
	 * Color con el que el jugador va a jugar.
	 */
	private Color color;

	/**
	 * Si está iniciado o no.
	 */
	private boolean iniciado;

	// Constructores

	/**
	 * Constuye al jugador con el nombre y con el color.
	 * 
	 * @param nombre
	 *            - Cadena que contendrá el nombre
	 * @param color
	 *            - Cadena que contendrá el color
	 */
	public Jugador(String nombre, Color color) {
		this.nombre = nombre;
		this.color = color;
	}

	// Procedimientos

	// Funciones

	/**
	 * Devuelve el nombre del jugador.
	 * 
	 * @return atributo nombre
	 */
	public String obtenerNombre() {
		return nombre;
	}

	/**
	 * Devuelve el color del jugador.
	 * 
	 * @return atributo color
	 */
	public Color obtenerColor() {
		return color;
	}

	/**
	 * Devuelva un atomo del color del jugador e incrementa el n_atomos.
	 * 
	 * @return el nuevo átomo creado
	 */
	public Atomo generarAtomo() {
		if (!iniciado)
			iniciado = true; //Cuando un átomo se genera por primera vez el jugador se inicia.
		return new Atomo(color);
	}

	/**
	 * Devulve el estado de la clase jugador.
	 */
	@Override
	public String toString() {
		return nombre + " - " + color;
	}

	/**
	 * Nos dice si un jugador ha iniciado algún átomo.
	 * 
	 * @return true si ha colocado algún átomo y false si no ha colocado ninguno
	 */
	public boolean estaIniciado() {
		return iniciado;
	}
}
