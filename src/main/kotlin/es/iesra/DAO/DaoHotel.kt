package es.iesra.DAO

import es.iesra.dominio.ReservaHotel
import java.io.File

class DaoHotel: IDAO<ReservaHotel> {

    private val fichero = "hoteles.txt"
    private val hoteles = mutableListOf<ReservaHotel>()

    init {
        cargarDesdeFichero()
    }

    private fun cargarDesdeFichero() {
        val file = File(fichero)

        if (!file.exists()) return

        file.forEachLine { linea ->

            val partes = linea.split(",")

            if (partes.size == 4){
                val id = partes[0].toInt()
                val descripcion = partes[1]
                val ubicacion = partes[2]
                val numNoches = partes[3].toInt()

                val reserva = ReservaHotel.reconstruirDesdeFichero(id, descripcion, ubicacion, numNoches)
                hoteles.add(reserva)
            }
        }
    }

    private fun guardarEnFichero() {
        val file = File(fichero)

        file.printWriter().use { out ->
            hoteles.forEach {
                out.println("${it.id},${it.descripcion},${it.ubicacion},${it.numeroNoches}")
            }
        }
    }


    override fun anadir(reserva: ReservaHotel): Boolean {
        if (hoteles.any { it.id == reserva.id }) {
            return false
        }else {
            hoteles.add(reserva)
            guardarEnFichero()
            return true
        }
    }

    override fun actualizar(reserva: ReservaHotel) {
        val indice = hoteles.indexOfFirst { it.id == reserva.id }

        if (indice != -1) {
            hoteles[indice] = reserva
            guardarEnFichero()
        }
    }

    override fun eliminar(id: Int) {
        val eliminado = hoteles.removeIf { it.id == id }

        if (eliminado) {
            guardarEnFichero()
        }
    }

    override fun obtenerTodas(): List<ReservaHotel> {
        return hoteles.toList()
    }

    override fun obtenerPorId(id: Int): ReservaHotel? {
        return hoteles.find { it.id == id }
    }
}