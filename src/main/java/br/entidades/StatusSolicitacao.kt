package br.entidades

import lombok.Data
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "statussolicitacao")
@Data
@SequenceGenerator(name = "seqstatus", sequenceName = "idstatus", allocationSize = 1, initialValue = 1)
class StatusSolicitacao : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqstatus")
    var idstatus: Int? = null
    var status: String? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}