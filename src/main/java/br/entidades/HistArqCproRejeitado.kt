package br.entidades

import lombok.Data
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "histarqcpprorej")
@Data
@SequenceGenerator(name = "seqhistcprorej", sequenceName = "idarqcpprorej", allocationSize = 1, initialValue = 1)
class HistArqCproRejeitado : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqhistcprorej")
    var idarqcpprorej: Int? = null
    var idarquivocppro: Int? = null
    var rejeitadoem: Date? = null

    @Column(columnDefinition = "TEXT")
    var motivo: String? = null

  
    companion object {

        private const val serialVersionUID = 1L
    }
}