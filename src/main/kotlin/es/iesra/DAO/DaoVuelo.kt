package es.iesra.DAO

import es.iesra.dominio.ReservaVuelo
import java.io.File

class DaoVuelo: IDAO<ReservaVuelo> {

    private val fichero = "vuelos.txt"
    private val vuelos = mutableListOf<ReservaVuelo>()

    init {
        cargarDesdeFichero()
    }

    private fun cargarDesdeFichero() {
        val file = File(fichero)

        if (!file.exists()) return

        file.forEachLine { linea ->
            val partes = linea.split(",")

            if (partes.size == 5) {
                val id = partes[0].toInt()
                val descripcion = partes[1]
                val origen = partes[2]
                val destino = partes[3]
                val hora = partes[4]

                val reserva = ReservaVuelo.reconstruirDesdeFichero(id,descripcion, origen, destino, hora)
                vuelos.add(reserva)
            }
        }
    }

    private fun guardarEnFichero() {
        val file = File(fichero)

        file.printWriter().use { out ->
            vuelos.forEach {
                out.println("${it.id},${it.descripcion},${it.origen},${it.destino},${it.horaVuelo}")
            }
        }
    }

    override fun anadir(reserva: ReservaVuelo): Boolean {

        if (vuelos.any() {it.id == reserva.id}) {
            return false
        }else{
            vuelos.add(reserva)
            guardarEnFichero()
            return true
        }

    }

    override fun actualizar(reserva: ReservaVuelo) {
        val indice = vuelos.indexOfFirst { it.id == reserva.id }
        if (indice != -1) {
            vuelos[indice] = reserva
            guardarEnFichero()
        }
    }

    override fun eliminar(id: Int) {
        val eliminado = vuelos.removeIf { it.id == id }

        if (eliminado) {
            guardarEnFichero()
        }
    }

    override fun obtenerTodas(): List<ReservaVuelo> {
        return vuelos.toList()
    }

    override fun obtenerPorId(id: Int): ReservaVuelo? {
        return vuelos.find { it.id == id }
    }
}