package br.entidades

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "histarqcpprorej")
@SequenceGenerator(name = "seqhistcprorej", sequenceName = "idarqcpprorej", allocationSize = 1, initialValue = 1)
class HistArqCproRejeitado : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqhistcprorej")
    var idarqcpprorej: Int? = null
    var idarquivocppro: Int? = null
    var rejeitadoem: Date? = null

    @Column(columnDefinition = "TEXT")
    var motivo: String? = null

    constructor()
    constructor(idarqcpprorej: Int?, idarquivocppro: Int?,
                rejeitadoem: Date?, motivo: String?) {
        this.idarqcpprorej = idarqcpprorej
        this.idarquivocppro = idarquivocppro
        this.rejeitadoem = rejeitadoem
        this.motivo = motivo
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (idarqcpprorej == null) 0 else idarqcpprorej.hashCode()
        result = prime * result + if (idarquivocppro == null) 0 else idarquivocppro.hashCode()
        result = prime * result + if (motivo == null) 0 else motivo.hashCode()
        result = prime * result + if (rejeitadoem == null) 0 else rejeitadoem.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as HistArqCproRejeitado
        if (idarqcpprorej == null) {
            if (other.idarqcpprorej != null) return false
        } else if (idarqcpprorej != other.idarqcpprorej) return false
        if (idarquivocppro == null) {
            if (other.idarquivocppro != null) return false
        } else if (idarquivocppro != other.idarquivocppro) return false
        if (motivo == null) {
            if (other.motivo != null) return false
        } else if (motivo != other.motivo) return false
        if (rejeitadoem == null) {
            if (other.rejeitadoem != null) return false
        } else if (rejeitadoem != other.rejeitadoem) return false
        return true
    }

    override fun toString(): String {
        return ("HistArqCproRejeitado [idarqcpprorej=" + idarqcpprorej + ", idarquivocppro=" + idarquivocppro
                + ", rejeitadoem=" + rejeitadoem + ", motivo=" + motivo + "]")
    }

    companion object {
        /**
         *
         */
        private const val serialVersionUID = 1L
    }
}