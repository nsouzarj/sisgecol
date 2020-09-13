package br.backup

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "bancaprocesso")
@SequenceGenerator(name = "seqbanca", sequenceName = "idbanca", allocationSize = 1, initialValue = 1)
class BancaProcesso : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqbanca")
    var idbanca: Int? = null
    var banca: String? = null
    var descricao: String? = null
    var ativa = false
    var email //Email da banca
            : String? = null
    var emailgestordabanca //Email do gestor da banca
            : String? = null

    constructor()
    constructor(idbanca: Int?, banca: String?, descricao: String?, ativa: Boolean, email: String?,
                emailgestordabanca: String?) {
        this.idbanca = idbanca
        this.banca = banca
        this.descricao = descricao
        this.ativa = ativa
        this.email = email
        this.emailgestordabanca = emailgestordabanca
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (ativa) 1231 else 1237
        result = prime * result + if (banca == null) 0 else banca.hashCode()
        result = prime * result + if (descricao == null) 0 else descricao.hashCode()
        result = prime * result + if (email == null) 0 else email.hashCode()
        result = prime * result + if (emailgestordabanca == null) 0 else emailgestordabanca.hashCode()
        result = prime * result + if (idbanca == null) 0 else idbanca.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as BancaProcesso
        if (ativa != other.ativa) return false
        if (banca == null) {
            if (other.banca != null) return false
        } else if (banca != other.banca) return false
        if (descricao == null) {
            if (other.descricao != null) return false
        } else if (descricao != other.descricao) return false
        if (email == null) {
            if (other.email != null) return false
        } else if (email != other.email) return false
        if (emailgestordabanca == null) {
            if (other.emailgestordabanca != null) return false
        } else if (emailgestordabanca != other.emailgestordabanca) return false
        if (idbanca == null) {
            if (other.idbanca != null) return false
        } else if (idbanca != other.idbanca) return false
        return true
    }

    override fun toString(): String {
        return ("BancaProcesso [idbanca=" + idbanca + ", banca=" + banca + ", descricao=" + descricao + ", ativa="
                + ativa + ", email=" + email + ", emailgestordabanca=" + emailgestordabanca + "]")
    }

    companion object {
        /**
         *
         */
        private const val serialVersionUID = 1L
    }
}