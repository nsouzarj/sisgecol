package br.entidades

import lombok.Data
import java.io.Serializable
import javax.persistence.*

@Data
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


    companion object {
        /**
         *
         */
        private const val serialVersionUID = 1L
    }
}