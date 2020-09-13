/**
 *
 */
package br.backup

import java.io.Serializable
import javax.persistence.*

/**
 * @author nelson
 * Esta tabela guarda os processo do cprpo que ficam armazenado em planilha
 */
@Entity
@Table(name = "processocppro")
@SequenceGenerator(name = "seqprocessocppro", sequenceName = "idprocessocppro", allocationSize = 1, initialValue = 1)
class ProcessoCPPRO : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqprocessocppro")
    var idprocessocppro: Int? = null
    var numprocesso: String? = null
    var cliente: String? = null
    var orgaoinicial: String? = null
    var partecontraria: String? = null

    @Column(length = 600, columnDefinition = "Text")
    var acao: String? = null
    var localizador: String? = null
    var eletronico: String? = null

    constructor()
    constructor(idprocessocppro: Int?, numprocesso: String?,
                cliente: String?, orgaoinicial: String?, partecontraria: String?,
                acao: String?, localizador: String?, eletronico: String?) {
        this.idprocessocppro = idprocessocppro
        this.numprocesso = numprocesso
        this.cliente = cliente
        this.orgaoinicial = orgaoinicial
        this.partecontraria = partecontraria
        this.acao = acao
        this.localizador = localizador
        this.eletronico = eletronico
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (acao == null) 0 else acao.hashCode()
        result = prime * result + if (cliente == null) 0 else cliente.hashCode()
        result = (prime * result
                + if (eletronico == null) 0 else eletronico.hashCode())
        result = (prime * result
                + if (idprocessocppro == null) 0 else idprocessocppro.hashCode())
        result = (prime * result
                + if (localizador == null) 0 else localizador.hashCode())
        result = (prime * result
                + if (numprocesso == null) 0 else numprocesso.hashCode())
        result = (prime * result
                + if (orgaoinicial == null) 0 else orgaoinicial.hashCode())
        result = (prime * result
                + if (partecontraria == null) 0 else partecontraria.hashCode())
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as ProcessoCPPRO
        if (acao == null) {
            if (other.acao != null) return false
        } else if (acao != other.acao) return false
        if (cliente == null) {
            if (other.cliente != null) return false
        } else if (cliente != other.cliente) return false
        if (eletronico == null) {
            if (other.eletronico != null) return false
        } else if (eletronico != other.eletronico) return false
        if (idprocessocppro == null) {
            if (other.idprocessocppro != null) return false
        } else if (idprocessocppro != other.idprocessocppro) return false
        if (localizador == null) {
            if (other.localizador != null) return false
        } else if (localizador != other.localizador) return false
        if (numprocesso == null) {
            if (other.numprocesso != null) return false
        } else if (numprocesso != other.numprocesso) return false
        if (orgaoinicial == null) {
            if (other.orgaoinicial != null) return false
        } else if (orgaoinicial != other.orgaoinicial) return false
        if (partecontraria == null) {
            if (other.partecontraria != null) return false
        } else if (partecontraria != other.partecontraria) return false
        return true
    }

    override fun toString(): String {
        return ("ProcessoCPPRO [idprocessocppro=" + idprocessocppro
                + ", numprocesso=" + numprocesso + ", cliente=" + cliente
                + ", orgaoinicial=" + orgaoinicial + ", partecontraria="
                + partecontraria + ", acao=" + acao + ", localizador="
                + localizador + ", eletronico=" + eletronico + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}