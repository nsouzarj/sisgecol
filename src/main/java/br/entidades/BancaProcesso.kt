package br.entidades

import lombok.Data
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "bancaprocesso")
@Data
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


    companion object {
        /**
         *
         */
        private const val serialVersionUID = 1L
    }
}