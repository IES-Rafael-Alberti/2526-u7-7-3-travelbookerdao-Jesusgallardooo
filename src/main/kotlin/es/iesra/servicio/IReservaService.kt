package es.iesra.servicio

import es.iesra.dominio.Reserva


/**
 * Interfaz que define los servicios disponibles para gestionar reservas.
 * Se aplica la inversión de dependencias en la capa de presentación.
 */
interface IReservaService {
    fun crearReservaVuelo(descripcion: String, origen: String, destino: String, horaVuelo: String): Boolean
    fun crearReservaHotel(descripcion: String, ubicacion: String, numeroNoches: Int): Boolean
    fun listarReservas(): List<Reserva>
    fun eliminarReserva(tipo: String, id: Int): Boolean
    fun obtenerReserva(tipo: String, id: Int): Reserva?
    fun actualizarReserva(reserva: Reserva): Boolean
}
