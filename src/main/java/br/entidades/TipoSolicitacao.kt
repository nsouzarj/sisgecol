package br.entidades

import lombok.Data
import java.io.Serializable
import javax.persistence.*

@Data
@Entity
@Table(name = "tiposolicitacao")
@SequenceGenerator(name = "seqtiposolicitacao", sequenceName = "idtiposolicitacao", allocationSize = 1, initialValue = 1)
class TipoSolicitacao : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqtiposolicitacao")
    var idtiposolicitacao: Int? = null
    var especie: String? = null
    var descricao: String? = null
    var tipo: String? = null
    var visualizar: Boolean? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}