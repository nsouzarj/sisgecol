package br.entidades

import java.sql.Timestamp
import java.util.*

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

    constructor()
    constructor(idsolicitacao: Int?, numeroprocesso: String?, pasta: String?, motivo: String?, documento: String?,
                anexadopor: String?, datanexado: Timestamp?, rejeitadoem: Timestamp?, datasolicitacao: Timestamp?,
                quemrejeitou: String?) : super() {
        this.idsolicitacao = idsolicitacao
        this.numeroprocesso = numeroprocesso
        this.pasta = pasta
        this.motivo = motivo
        this.documento = documento
        this.anexadopor = anexadopor
        this.datanexado = datanexado
        this.rejeitadoem = rejeitadoem
        this.datasolicitacao = datasolicitacao
        this.quemrejeitou = quemrejeitou
    }

    fun setDatanexado(datanexado: Timestamp?) {
        this.datanexado = datanexado
    }

    fun getDatanexado(): Date? {
        return datanexado
    }

    override fun toString(): String {
        return ("Rejeitado [idsolicitacao=" + idsolicitacao + ", numeroprocesso=" + numeroprocesso + ", pasta=" + pasta
                + ", motivo=" + motivo + ", documento=" + documento + ", anexadopor=" + anexadopor + ", datanexado="
                + datanexado + ", rejeitadoem=" + rejeitadoem + ", datasolicitacao=" + datasolicitacao
                + ", quemrejeitou=" + quemrejeitou + "]")
    }
}