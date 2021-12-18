package br.entidades

import lombok.Data
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import java.util.*
import javax.persistence.*
@Data
@Entity
@Table(name = "recibopagamento")
@SequenceGenerator(initialValue = 1, name = "seqpag", sequenceName = "seqpag", allocationSize = 1)
class ReciboPagamento : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqpag")
    var idrecibo: Int? = null
    @Temporal(TemporalType.TIMESTAMP)
    var datafechamento: Date? = null
    var anotacao: String? = null
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idusuario")
    var usuario: Usuario? = null
    companion object {
        private const val serialVersionUID = 1L
    }
}