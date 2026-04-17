package es.iesra.repositorio

import es.iesra.dominio.Reserva

/**
 * Interfaz que define las operaciones básicas para almacenar y recuperar reservas.
 */
interface IReservaRepository {
    fun anadir(reserva: Reserva): Boolean
    fun actualizar(reserva: Reserva)
    fun eliminar(id:Int)
    fun obtenerTodas(): List<Reserva>
    fun obtenerPorId(id: Int): Reserva?
}
