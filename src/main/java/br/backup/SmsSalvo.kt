package br.backup

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "smsalvo")
@SequenceGenerator(name = "seqsms", sequenceName = "idsms", allocationSize = 1, initialValue = 1)
class SmsSalvo : Serializable {
    @Id
    var idsms: Int? = null
    var usuario: Usuario? = null

    @Temporal(TemporalType.TIMESTAMP)
    var dataenvio: Date? = null
    var numero: String? = null
    var menssagem: String? = null

    constructor()
    constructor(idsms: Int?, usuario: Usuario?, dataenvio: Date?,
                numero: String?, menssagem: String?) {
        this.idsms = idsms
        this.usuario = usuario
        this.dataenvio = dataenvio
        this.numero = numero
        this.menssagem = menssagem
    }

    override fun toString(): String {
        return ("SmsSalvo [idsms=" + idsms + ", usuario=" + usuario
                + ", dataenvio=" + dataenvio + ", numero=" + numero
                + ", menssagem=" + menssagem + "]")
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = (prime * result
                + if (dataenvio == null) 0 else dataenvio.hashCode())
        result = prime * result + if (idsms == null) 0 else idsms.hashCode()
        result = (prime * result
                + if (menssagem == null) 0 else menssagem.hashCode())
        result = prime * result + if (numero == null) 0 else numero.hashCode()
        result = prime * result + if (usuario == null) 0 else usuario.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as SmsSalvo
        if (dataenvio == null) {
            if (other.dataenvio != null) return false
        } else if (dataenvio != other.dataenvio) return false
        if (idsms == null) {
            if (other.idsms != null) return false
        } else if (idsms != other.idsms) return false
        if (menssagem == null) {
            if (other.menssagem != null) return false
        } else if (menssagem != other.menssagem) return false
        if (numero == null) {
            if (other.numero != null) return false
        } else if (numero != other.numero) return false
        if (usuario == null) {
            if (other.usuario != null) return false
        } else if (usuario != other.usuario) return false
        return true
    }

    companion object {
        /**
         *
         */
        private const val serialVersionUID = 1L
    }
}