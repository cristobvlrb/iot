package cl.inacap.aforocontrol.modelo

// Es la misma lógica de la función actualizarInterfazVisual() del Arduino (EV1),
// pasada a Kotlin. En la EV3 el Arduino aplicará estas mismas reglas.
object LogicaAforo {

    // En el Arduino: if (aforoActual >= (AFORO_MAXIMO * 0.7)) -> amarillo
    const val UMBRAL_AMARILLO = 0.7

    fun semaforo(e: EstadoNodo): Semaforo = when {
        e.forzado || e.aforo >= e.maximo -> Semaforo.ROJO
        e.aforo >= e.maximo * UMBRAL_AMARILLO -> Semaforo.AMARILLO
        else -> Semaforo.VERDE
    }

    // En el Arduino: barreraServo.write(90) cuando el aforo está lleno
    fun barreraCerrada(e: EstadoNodo): Boolean = e.forzado || e.aforo >= e.maximo

    fun puedeEntrar(e: EstadoNodo): Boolean = !barreraCerrada(e)

    fun puedeSalir(e: EstadoNodo): Boolean = e.aforo > 0
}
