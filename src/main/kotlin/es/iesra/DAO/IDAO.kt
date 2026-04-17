package es.iesra.DAO

interface IDAO <T> {

    fun anadir(reserva: T): Boolean
    fun actualizar(reserva: T)
    fun eliminar(id: Int)
    fun obtenerTodas(): List<T>
    fun obtenerPorId(id: Int): T?

}