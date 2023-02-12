package br.entidades

import lombok.Data
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "endereco")
@Data
@SequenceGenerator(name = "seqendereco", sequenceName = "idendereco", allocationSize = 1, initialValue = 1)
class Endereco : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqendereco")
    var idendereco: Int? = null
    var logradouro: String? = null
    var bairro: String? = null
    var cidade: String? = null

    @ManyToOne
    var uf: Uf? = null
    var cep: String? = null
    var observacao: String? = null

    override fun toString(): String {
        return ("Endereco [idendereco=" + idendereco + ", logradouro="
                + logradouro + ", bairro=" + bairro + ", cidade=" + cidade
                + ", uf=" + uf + ", cep=" + cep + ", observacao=" + observacao
                + "]")
    }
    companion object {
        private const val serialVersionUID = 1L
    }
}