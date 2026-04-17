package es.iesra.DAO

import es.iesra.dominio.ReservaVuelo

class DaoVuelo: IDAO<ReservaVuelo> {

    private val vuelos = mutableListOf<ReservaVuelo>()

    override fun anadir(reserva: ReservaVuelo): Boolean {
        TODO("Not yet implemented")
    }

    override fun actualizar(reserva: ReservaVuelo) {
        TODO("Not yet implemented")
    }

    override fun eliminar(id: Int) {
        TODO("Not yet implemented")
    }

    override fun obtenerTodas(): List<ReservaVuelo> {
        TODO("Not yet implemented")
    }

    override fun obtenerPorId(id: Int): ReservaVuelo? {
        TODO("Not yet implemented")
    }


}