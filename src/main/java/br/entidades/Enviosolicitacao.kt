package br.entidades

import lombok.Data
import java.io.Serializable
import javax.persistence.*
@Data
@Entity
@Table(name = "enviode")
@SequenceGenerator(name = "seqenviosoli", sequenceName = "idenviosolicitacao", allocationSize = 1, initialValue = 1)
class Enviosolicitacao : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqenviosoli")
    var idenviosolicitacao: Int? = null
    var tipoenvio: String? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}