package es.iesra.DAO

import es.iesra.dominio.ReservaVuelo

class DaoVuelo: IDAO<ReservaVuelo> {

    private val vuelos = mutableListOf<ReservaVuelo>()

    override fun anadir(reserva: ReservaVuelo): Boolean {

        if (vuelos.any() {it.id == reserva.id}) {
            return false
        }else{
            vuelos.add(reserva)
            return true
        }

    }

    override fun actualizar(reserva: ReservaVuelo) {
        val indice = vuelos.indexOfFirst { it.id == reserva.id }
        if (indice != -1) {
            vuelos[indice] = reserva
        }
    }

    override fun eliminar(id: Int) {
        vuelos.removeIf { it.id == id }
    }

    override fun obtenerTodas(): List<ReservaVuelo> {
        return vuelos.toList()
    }

    override fun obtenerPorId(id: Int): ReservaVuelo? {
        return vuelos.find { it.id == id }
    }


}