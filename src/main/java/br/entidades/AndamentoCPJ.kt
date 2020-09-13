package br.entidades

import java.util.*

class AndamentoCPJ {
    var ficha: String? = null
    var datahora: Date? = null
    var andamento: String? = null

    constructor()
    constructor(ficha: String?, datahora: Date?, andamento: String?) {
        this.ficha = ficha
        this.datahora = datahora
        this.andamento = andamento
    }

    override fun toString(): String {
        return ("AndamentoCPJ [ficha=" + ficha + ", datahora=" + datahora
                + ", andamento=" + andamento + "]")
    }
}