package br.backup

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "statussolicitacao")
@SequenceGenerator(name = "seqstatus", sequenceName = "idstatus", allocationSize = 1, initialValue = 1)
class StatusSolicitacao : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqstatus")
    var idstatus: Int? = null
    var status: String? = null

    constructor()
    constructor(idstatus: Int?, status: String?) {
        this.idstatus = idstatus
        this.status = status
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = (prime * result
                + if (idstatus == null) 0 else idstatus.hashCode())
        result = prime * result + if (status == null) 0 else status.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as StatusSolicitacao
        if (idstatus == null) {
            if (other.idstatus != null) return false
        } else if (idstatus != other.idstatus) return false
        if (status == null) {
            if (other.status != null) return false
        } else if (status != other.status) return false
        return true
    }

    override fun toString(): String {
        return ("StatusSolicitacao [idstatus=" + idstatus + ", status=" + status
                + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}