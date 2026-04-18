package es.iesra.repositorio

import es.iesra.dominio.Reserva

/**
 * Implementación en memoria del repositorio de reservas.
 */

class ReservaRepository : IReservaRepository {

    private val reservas: MutableList<Reserva> = mutableListOf()

    override fun anadir(reserva: Reserva): Boolean {
        var agregado = false
        // Si no existe, se agrega la reserva a la lista.
        if (reservas.any { it.id == reserva.id }){
            agregado = false
        }else {
            reservas.add(reserva)
            agregado = true
        }
        return agregado
    }

    override fun actualizar(reserva: Reserva) {
        val i = reservas.indexOfFirst { it.id == reserva.id }
        if (i != -1){
            reservas[i] = reserva
        }
    }

    override fun eliminar(id: Int) {
        reservas.remove(reservas.find { it.id == id })
    }

    override fun obtenerTodas(): List<Reserva> = reservas.toList()

    override fun obtenerPorId(id: Int): Reserva? {
        return reservas.find { it.id == id }
    }
}