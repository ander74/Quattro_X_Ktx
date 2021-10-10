package com.ander74.quattrox.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Companeros")
data class Companero(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var matricula: Int,
    var nombre: String = "",
    var apellidos: String = "",
    var telefono: String = "",
    var email: String = "",
    var calificacion: TipoCompanero = TipoCompanero.NORMAL,
    var deudaInicial: Int = 0,
    var notas: String = ""
)

enum class TipoCompanero {
    NORMAL,
    BUENO,
    MALO
}