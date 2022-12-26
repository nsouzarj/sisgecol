package br.entidades

import java.io.Serializable
import javax.persistence.*
import lombok.Data

@Entity
@Table(name = "tiposolicitacao")
@Data
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