package cl.inacap.aforocontrol.modelo

import java.util.Date

// Roles de usuario: el Administrador controla, el Guardia solo observa.
enum class Rol { ADMIN, GUARDIA }

// Los tres colores del semáforo Keyes del proyecto EV1.
enum class Semaforo { VERDE, AMARILLO, ROJO }

// Estado del "nodo IoT" (el Arduino simulado). Se guarda en Firestore: nodo/sala1
data class EstadoNodo(
    val aforo: Int = 0,                 // personas dentro de la sala
    val maximo: Int = 10,               // aforo máximo permitido
    val forzado: Boolean = false,       // true = el Admin forzó el cierre de la barrera
    val alertaVibracion: Boolean = false // true = el SW-420 detectó un golpe
)

// Un registro del historial. Se guarda en Firestore: eventos/{id}
data class Evento(
    val tipo: String,
    val aforo: Int,
    val usuario: String,
    val detalle: String,
    val fecha: Date?
)
