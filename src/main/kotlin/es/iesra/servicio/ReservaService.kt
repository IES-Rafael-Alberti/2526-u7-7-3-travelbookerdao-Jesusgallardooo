package es.iesra.servicio

import es.iesra.repositorio.IReservaRepository
import es.iesra.dominio.Reserva
import es.iesra.dominio.ReservaHotel
import es.iesra.dominio.ReservaVuelo

/**
 * Implementación concreta de IReservaService.
 * Depende de la abstracción IReservaRepository, no de una implementación concreta.
 */
class ReservaService(private val repositorio: IReservaRepository) : IReservaService {

    override fun crearReservaVuelo(descripcion: String, origen: String, destino: String, horaVuelo: String): Boolean {
        val reservaVuelo = ReservaVuelo.creaInstancia(descripcion, origen, destino, horaVuelo)
        return repositorio.anadir(reservaVuelo)
    }

    override fun crearReservaHotel(descripcion: String, ubicacion: String, numeroNoches: Int): Boolean {
        val reservaHotel = ReservaHotel.creaInstancia(descripcion, ubicacion, numeroNoches)
        return repositorio.anadir(reservaHotel)
    }

    override fun listarReservas() = repositorio.obtenerTodas()

    override fun eliminarReserva(id: Int): Boolean {
        val reserva = repositorio.obtenerPorId(id)

        if (reserva != null){
            repositorio.eliminar(id)
            return true
        }else{
            return false
        }
    }

    override fun obtenerReserva(id: Int): Reserva? {
        return repositorio.obtenerPorId(id)
    }

    override fun actualizarReserva(reserva: Reserva): Boolean {
        val reservaExistente = repositorio.obtenerPorId(reserva.id)

        if (reservaExistente != null){
            repositorio.actualizar(reserva)
            return true
        }else{
            return false
        }
    }

}