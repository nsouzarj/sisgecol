package br.entidades

import lombok.Data
import java.io.Serializable
import javax.persistence.*

@Data
@Entity
@Table(name = "renumeracao")
@SequenceGenerator(name = "seqrenumeracao", sequenceName = "idrenumeracao", allocationSize = 1, initialValue = 1)
class Renumeracao : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqrenumeracao")
    var idrenumeracao: Int? = null
    var tipoSolicitacaoCorrespondente: TipoSolicitacaoCorrespondente? = null

    // private ComarcaCorrespondente comarcaCorrespondente;
    var valor = 0f
    var ativo = false

    companion object {
        private const val serialVersionUID = 1L
    }
}