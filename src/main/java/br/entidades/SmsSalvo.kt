package br.entidades

import lombok.Data
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "smsalvo")
@Data
@SequenceGenerator(name = "seqsms", sequenceName = "idsms", allocationSize = 1, initialValue = 1)
class SmsSalvo : Serializable {
    @Id
    var idsms: Int? = null
    var usuario: Usuario? = null

    @Temporal(TemporalType.TIMESTAMP)
    var dataenvio: Date? = null
    var numero: String? = null
    var menssagem: String? = null

      companion object {
        private const val serialVersionUID = 1L
    }
}