package br.entidades

import lombok.Data
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "logsistema")
@Data
@SequenceGenerator(name = "seqlog", sequenceName = "idlog", allocationSize = 1, initialValue = 1)
class LogSistema : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqlog")
    var idlog: Int? = null
    var usuario: String? = null
    var idsolicitacao: Int? = null
    var datalog: Date? = null
    var tela: String? = null

    @Column(length = 3000, columnDefinition = "Text")
    var descricao: String? = null


    companion object {

        private const val serialVersionUID = 1L
    }
}