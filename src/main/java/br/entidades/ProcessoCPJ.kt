/**
 *
 */
package br.entidades

import java.io.Serializable

/**
 * @author nelson
 */
class ProcessoCPJ : Serializable {
    var numprocesso: String? = null
    var numficha: String? = null
    var numprocessopes: String? = null
    var nomeautor: String? = null
    var nomereu: String? = null
    var siglaloc: String? = null
    var locnumero: String? = null
    var siglaintegracao: String? = null
    var numerointegracao: String? = null
    var juizo: String? = null
    var acao: String? = null
    var ojnumero: String? = null
    var ojsigla: String? = null
    var assuntodoprocesso: String? = null
    var proceletronico: String

    constructor() {
        proceletronico = ""
    }

    constructor(numprocesso: String?, numficha: String?,
                numprocessopes: String?, nomeautor: String?, nomereu: String?,
                siglaloc: String?, locnumero: String?, siglaintegracao: String?,
                numerointegracao: String?, juizo: String?, ojnumero: String?,
                ojsigla: String?, acao: String?, assuntodoprocesso: String?,
                proceletronico: String) {
        this.numprocesso = numprocesso
        this.numficha = numficha
        this.numprocessopes = numprocessopes
        this.nomeautor = nomeautor
        this.nomereu = nomereu
        this.siglaloc = siglaloc
        this.locnumero = locnumero
        this.siglaintegracao = siglaintegracao
        this.numerointegracao = numerointegracao
        this.juizo = juizo
        this.ojnumero = ojnumero
        this.ojsigla = ojsigla
        this.assuntodoprocesso = assuntodoprocesso
        this.proceletronico = proceletronico
        this.acao = acao
    }

    override fun toString(): String {
        return ("ProcessoCPJ [numprocesso=" + numprocesso + ", numficha="
                + numficha + ", numprocessopes=" + numprocessopes
                + ", nomeautor=" + nomeautor + ", nomereu=" + nomereu
                + ", siglaloc=" + siglaloc + ", locnumero=" + locnumero
                + ", siglaintegracao=" + siglaintegracao
                + ", numerointegracao=" + numerointegracao + ", juizo=" + juizo
                + ", ojnumero=" + ojnumero + ", ojsigla=" + ojsigla
                + ", assuntodoprocesso=" + assuntodoprocesso + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}