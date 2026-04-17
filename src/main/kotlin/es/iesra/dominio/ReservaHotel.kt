package es.iesra.dominio

import java.time.LocalDateTime

/**
 * Clase que representa una Reserva de Hotel.
 * Hereda de Reserva y agrega atributos específicos: ubicación y número de noches.
 */
class ReservaHotel private constructor(
    id: Int,
    descripcion: String,
    var ubicacion: String,
    var numeroNoches: Int
) : Reserva(id, LocalDateTime.now(), descripcion) {



    // Se sobreescribe la propiedad detalle para incluir la ubicación.
    override val detalle: String
        get() = "$id - $ubicacion - $descripcion"

    // Sobrescritura de toString para mostrar la información formateada.
    override fun toString(): String {
        return "Reserva de Hotel: $detalle [Noches: $numeroNoches, Fecha creación: $fechaCreacion]"
    }

    companion object {
        // Generador de ids únicos para ReservaHotel.
        private var contador: Int = 1

        /**
         * Método de clase para crear una nueva instancia de ReservaHotel.
         */
        fun creaInstancia(descripcion: String, ubicacion: String, numeroNoches: Int): ReservaHotel {
            require(numeroNoches > 0) { "El número de noches debe ser mayor a 0" }
            val reserva = ReservaHotel(contador, descripcion, ubicacion, numeroNoches)
            contador++
            return reserva
        }

        /** Método para reconstruir una reserva desde el fichero con su ID original.
        * También actualiza el contador para evitar colisiones de ID.
        */
        fun reconstruirDesdeFichero(id: Int, descripcion: String, ubicacion: String, numeroNoches: Int): ReservaHotel {
            // Actualizar el contador si el ID leído es mayor o igual
            if (id >= contador) {
                contador = id + 1
            }
            return ReservaHotel(id, descripcion, ubicacion, numeroNoches)
        }
    }
}