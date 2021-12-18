package br.entidades

import lombok.Data
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Data
@Entity
@Table(name = "preposto")
@SequenceGenerator(initialValue = 1, name = "seqpreposto", sequenceName = "seqpreposto")
class Preposto : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqpreposto")
    var idpresposto: Int? = null
    var nomecompleto: String? = null
    var cpf: String? = null
    var identidade: String? = null
    var datanascimento: Date? = null
    var observacao: String? = null
    @ManyToOne
    @JoinColumn(name = "enderecos_idendereco")
    var enderecos: Endereco? = null
    companion object {
        private const val serialVersionUID = 1L
    }
}