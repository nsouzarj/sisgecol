package br.entidades

import java.io.Serializable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "comarcapossui")
class ComarcaPossui : Serializable {
    @EmbeddedId
    var comarcaCorrespondente: ComarcaCorrespondente? = null
    var inativado = false

    override fun toString(): String {
        return ("ComarcaPossui [comarcaCorrespondente=" + comarcaCorrespondente
                + "]")
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (inativado) 1231 else 1237
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as ComarcaPossui
        return inativado == other.inativado
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}