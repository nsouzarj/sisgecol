package br.entidades

import lombok.Data
import java.sql.Timestamp
import java.util.*

@Data
class Rejeitado {
    var idsolicitacao: Int? = null
    var numeroprocesso: String? = null
    var pasta: String? = null
    var motivo: String? = null
    var documento: String? = null
    var anexadopor: String? = null
    private var datanexado: Timestamp? = null
    var rejeitadoem: Timestamp? = null
    var datasolicitacao: Timestamp? = null
    var quemrejeitou: String? = null

    companion object{
        private const val serialVersionUID = 1L
    }
}