package br.entidades

import java.io.Serializable

class ProcessoCpproConsulta : Serializable {
    var numerinical: String? = null
    var clienteprincipal: String? = null
    var orgaoinicial: String? = null
    var contrarioprincipal: String? = null
    var tipoacaorito: String? = null
    var codigopasta: String? = null
    var processoeletronico: String? = null
    var pastacliente: String? = null
    var responsavel: String? = null

    constructor()
    constructor(numerinical: String?, clienteprincipal: String?, orgaoinicial: String?,
                contrarioprincipal: String?, tipoacaorito: String?, codigopasta: String?, processoeletronico: String?,
                pastacliente: String?, responsavel: String?) : super() {
        this.numerinical = numerinical
        this.clienteprincipal = clienteprincipal
        this.orgaoinicial = orgaoinicial
        this.contrarioprincipal = contrarioprincipal
        this.tipoacaorito = tipoacaorito
        this.codigopasta = codigopasta
        this.processoeletronico = processoeletronico
        this.pastacliente = pastacliente
        this.responsavel = responsavel
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (clienteprincipal == null) 0 else clienteprincipal.hashCode()
        result = prime * result + if (codigopasta == null) 0 else codigopasta.hashCode()
        result = prime * result + if (contrarioprincipal == null) 0 else contrarioprincipal.hashCode()
        result = prime * result + if (numerinical == null) 0 else numerinical.hashCode()
        result = prime * result + if (orgaoinicial == null) 0 else orgaoinicial.hashCode()
        result = prime * result + if (pastacliente == null) 0 else pastacliente.hashCode()
        result = prime * result + if (processoeletronico == null) 0 else processoeletronico.hashCode()
        result = prime * result + if (responsavel == null) 0 else responsavel.hashCode()
        result = prime * result + if (tipoacaorito == null) 0 else tipoacaorito.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as ProcessoCpproConsulta
        if (clienteprincipal == null) {
            if (other.clienteprincipal != null) return false
        } else if (clienteprincipal != other.clienteprincipal) return false
        if (codigopasta == null) {
            if (other.codigopasta != null) return false
        } else if (codigopasta != other.codigopasta) return false
        if (contrarioprincipal == null) {
            if (other.contrarioprincipal != null) return false
        } else if (contrarioprincipal != other.contrarioprincipal) return false
        if (numerinical == null) {
            if (other.numerinical != null) return false
        } else if (numerinical != other.numerinical) return false
        if (orgaoinicial == null) {
            if (other.orgaoinicial != null) return false
        } else if (orgaoinicial != other.orgaoinicial) return false
        if (pastacliente == null) {
            if (other.pastacliente != null) return false
        } else if (pastacliente != other.pastacliente) return false
        if (processoeletronico == null) {
            if (other.processoeletronico != null) return false
        } else if (processoeletronico != other.processoeletronico) return false
        if (responsavel == null) {
            if (other.responsavel != null) return false
        } else if (responsavel != other.responsavel) return false
        if (tipoacaorito == null) {
            if (other.tipoacaorito != null) return false
        } else if (tipoacaorito != other.tipoacaorito) return false
        return true
    }

    override fun toString(): String {
        return ("ProcessoCpproConsulta [numerinical=" + numerinical + ", clienteprincipal=" + clienteprincipal
                + ", orgaoinicial=" + orgaoinicial + ", contrarioprincipal=" + contrarioprincipal + ", tipoacaorito="
                + tipoacaorito + ", codigopasta=" + codigopasta + ", processoeletronico=" + processoeletronico
                + ", pastacliente=" + pastacliente + ", responsavel=" + responsavel + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}