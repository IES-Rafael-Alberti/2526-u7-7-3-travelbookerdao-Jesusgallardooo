package es.iesra.DAO

import es.iesra.dominio.ReservaHotel

class DaoHotel: IDAO<ReservaHotel> {

    private val hoteles = mutableListOf<ReservaHotel>()

    override fun anadir(reserva: ReservaHotel): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(reserva: ReservaHotel) {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: Int) {
        TODO("Not yet implemented")
    }

    override fun obtenerTodas(): List<ReservaHotel> {
        TODO("Not yet implemented")
    }

    override fun obtenerPorId(id: Int): ReservaHotel? {
        TODO("Not yet implemented")
    }
}