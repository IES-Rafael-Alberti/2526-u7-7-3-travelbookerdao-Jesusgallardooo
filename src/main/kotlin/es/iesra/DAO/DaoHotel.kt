package es.iesra.DAO

import es.iesra.dominio.ReservaHotel

class DaoHotel: IDAO<ReservaHotel> {

    private val hoteles = mutableListOf<ReservaHotel>()

    override fun anadir(reserva: ReservaHotel): Boolean {
        if (hoteles.any { it.id == reserva.id }) {
            return false
        }else {
            hoteles.add(reserva)
            return true
        }
    }

    override fun actualizar(reserva: ReservaHotel) {
        val indice = hoteles.indexOfFirst { it.id == reserva.id }

        if (indice != -1) {
            hoteles[indice] = reserva
        }
    }

    override fun eliminar(id: Int) {
        hoteles.removeIf { it.id == id }
    }

    override fun obtenerTodas(): List<ReservaHotel> {
        return hoteles.toList()
    }

    override fun obtenerPorId(id: Int): ReservaHotel? {
        return hoteles.find { it.id == id }
    }
}