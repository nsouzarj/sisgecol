package br.entidades

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "histarqcppro")
@SequenceGenerator(name = "seqhistcpro", sequenceName = "idarqcppro", allocationSize = 1, initialValue = 1)
class HistArqCpro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqhistcpro")
    var idarqcppro: Int? = null

    @OneToOne
    var solicitacaoAnexo: SolicitacaoAnexo? = null
    var idarquivocppro: Int? = null
    var salvoem: Date? = null

    constructor()
    constructor(idarqcppro: Int?, solicitacaoAnexo: SolicitacaoAnexo?, idarquivocppro: Int?, salvoem: Date?) {
        this.idarqcppro = idarqcppro
        this.solicitacaoAnexo = solicitacaoAnexo
        this.idarquivocppro = idarquivocppro
        this.salvoem = salvoem
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (idarqcppro == null) 0 else idarqcppro.hashCode()
        result = prime * result + if (idarquivocppro == null) 0 else idarquivocppro.hashCode()
        result = prime * result + if (salvoem == null) 0 else salvoem.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as HistArqCpro
        if (idarqcppro == null) {
            if (other.idarqcppro != null) return false
        } else if (idarqcppro != other.idarqcppro) return false
        if (idarquivocppro == null) {
            if (other.idarquivocppro != null) return false
        } else if (idarquivocppro != other.idarquivocppro) return false
        if (salvoem == null) {
            if (other.salvoem != null) return false
        } else if (salvoem != other.salvoem) return false
        return true
    }

    override fun toString(): String {
        return ("HistArqCpro [idarqcppro=" + idarqcppro + ", solicitacaoAnexo=" + solicitacaoAnexo + ", idarquivocppro="
                + idarquivocppro + ", salvoem=" + salvoem + "]")
    }
}