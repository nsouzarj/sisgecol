package br.entidades

import java.io.Serializable
import javax.persistence.*
import lombok.Data

@Entity
@Table(name = "renumeracao")
@Data
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