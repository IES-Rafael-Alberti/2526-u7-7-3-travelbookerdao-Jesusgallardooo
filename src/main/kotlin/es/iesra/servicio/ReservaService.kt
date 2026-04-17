package es.iesra.servicio

import es.iesra.DAO.DaoHotel
import es.iesra.DAO.DaoVuelo
import es.iesra.repositorio.IReservaRepository
import es.iesra.dominio.Reserva
import es.iesra.dominio.ReservaHotel
import es.iesra.dominio.ReservaVuelo

/**
 * Implementación concreta de IReservaService.
 * Depende de la abstracción IReservaRepository, no de una implementación concreta.
 */
class ReservaService(
    private val hotelDao: DaoHotel,
    private val vueloDao: DaoVuelo,
    ) : IReservaService {

    override fun crearReservaVuelo(descripcion: String, origen: String, destino: String, horaVuelo: String): Boolean {
        val reservaVuelo = ReservaVuelo.creaInstancia(descripcion, origen, destino, horaVuelo)
        return vueloDao.anadir(reservaVuelo)
    }

    override fun crearReservaHotel(descripcion: String, ubicacion: String, numeroNoches: Int): Boolean {
        val reservaHotel = ReservaHotel.creaInstancia(descripcion, ubicacion, numeroNoches)
        return hotelDao.anadir(reservaHotel)
    }

    override fun listarReservas() = vueloDao.obtenerTodas() + hotelDao.obtenerTodas()

    override fun eliminarReserva(tipo:String, id: Int): Boolean {

        when(tipo.lowercase()){
            "vuelo" -> {
                val existe = vueloDao.obtenerTodas().find { it.id == id }
                if (existe != null){
                    vueloDao.eliminar(id)
                    return true
                }else{
                    return false
                }
            }

            "hotel" -> {
                val existe = hotelDao.obtenerTodas().find { it.id == id }
                if (existe != null){
                    hotelDao.eliminar(id)
                    return true
                }else{
                    return false
                }
            }

            else -> return false
        }

    }

    override fun obtenerReserva(tipo:String, id: Int): Reserva? {
        when (tipo.lowercase()) {
            "vuelo" -> return vueloDao.obtenerTodas().find { it.id == id }
            "hotel" -> return hotelDao.obtenerTodas().find { it.id == id }
            else -> return null
        }
    }


    override fun actualizarReserva(reserva: Reserva): Boolean {

        when (reserva) {

            is ReservaVuelo -> {
                val existente = vueloDao.obtenerTodas().find { it.id == reserva.id }
                if (existente != null) {
                    vueloDao.actualizar(reserva)
                    return true
                } else {
                    return false
                }
            }

            is ReservaHotel -> {
                val existente = hotelDao.obtenerTodas().find { it.id == reserva.id }
                if (existente != null) {
                    hotelDao.actualizar(reserva)
                    return true
                } else {
                    return false
                }
            }

            else -> return false
        }

    }

}