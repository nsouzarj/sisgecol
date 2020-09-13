package br.entidades

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import java.util.*
import javax.persistence.*

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

    constructor()
    constructor(idrecibo: Int?, datafechamento: Date?,
                anotacao: String?, usuario: Usuario?) {
        this.idrecibo = idrecibo
        this.datafechamento = datafechamento
        this.anotacao = anotacao
        this.usuario = usuario
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = (prime * result
                + if (anotacao == null) 0 else anotacao.hashCode())
        result = (prime * result
                + if (datafechamento == null) 0 else datafechamento.hashCode())
        result = (prime * result
                + if (idrecibo == null) 0 else idrecibo.hashCode())
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as ReciboPagamento
        if (anotacao == null) {
            if (other.anotacao != null) return false
        } else if (anotacao != other.anotacao) return false
        if (datafechamento == null) {
            if (other.datafechamento != null) return false
        } else if (datafechamento != other.datafechamento) return false
        if (idrecibo == null) {
            if (other.idrecibo != null) return false
        } else if (idrecibo != other.idrecibo) return false
        return true
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}