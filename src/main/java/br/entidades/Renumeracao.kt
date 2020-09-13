package br.entidades

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "renumeracao")
@SequenceGenerator(name = "seqrenumeracao", sequenceName = "idrenumeracao", allocationSize = 1, initialValue = 1)
class Renumeracao : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqrenumeracao")
    var idrenumeracao: Int? = null
    var tipoSolicitacaoCorrespondente: TipoSolicitacaoCorrespondente? = null

    // private ComarcaCorrespondente comarcaCorrespondente;
    var valor = 0f
    var ativo = false

    constructor()
    constructor(idrenumeracao: Int?, tipoSolicitacaoCorrespondente: TipoSolicitacaoCorrespondente?, valor: Float,
                ativo: Boolean) {
        this.idrenumeracao = idrenumeracao
        this.tipoSolicitacaoCorrespondente = tipoSolicitacaoCorrespondente
        this.valor = valor
        this.ativo = ativo
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (ativo) 1231 else 1237
        result = prime * result + if (idrenumeracao == null) 0 else idrenumeracao.hashCode()
        result = prime * result + java.lang.Float.floatToIntBits(valor)
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Renumeracao
        if (ativo != other.ativo) return false
        if (idrenumeracao == null) {
            if (other.idrenumeracao != null) return false
        } else if (idrenumeracao != other.idrenumeracao) return false
        return java.lang.Float.floatToIntBits(valor) == java.lang.Float.floatToIntBits(other.valor)
    }

    override fun toString(): String {
        return ("Renumeracao [idrenumeracao=" + idrenumeracao + ", tipoSolicitacaoCorrespondente="
                + tipoSolicitacaoCorrespondente + ", valor=" + valor + ", ativo=" + ativo + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}