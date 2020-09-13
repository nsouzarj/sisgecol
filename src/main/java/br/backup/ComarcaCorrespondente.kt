package br.backup

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import javax.persistence.Embeddable
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Embeddable
class ComarcaCorrespondente : Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "idcorrespondente")
    var correspondente: Correspondente? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "idcomarca")
    var comarca: Comarca? = null

    constructor()
    constructor(correspondente: Correspondente?, comarca: Comarca?) {
        this.correspondente = correspondente
        this.comarca = comarca
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (comarca == null) 0 else comarca.hashCode()
        result = (prime * result
                + if (correspondente == null) 0 else correspondente.hashCode())
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as ComarcaCorrespondente
        if (comarca == null) {
            if (other.comarca != null) return false
        } else if (comarca != other.comarca) return false
        if (correspondente == null) {
            if (other.correspondente != null) return false
        } else if (correspondente != other.correspondente) return false
        return true
    }

    override fun toString(): String {
        return ("ComarcaCorrespondente [correspondente=" + correspondente
                + ", comarca=" + comarca + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}