package br.entidades

import lombok.Data
import java.io.Serializable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "comarcapossui")
@Data
class ComarcaPossui : Serializable {
    @EmbeddedId
    var comarcaCorrespondente: ComarcaCorrespondente? = null
    var inativado = false

    companion object {
        private const val serialVersionUID = 1L
    }

}