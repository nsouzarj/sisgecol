package br.entidades

import lombok.Data
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import javax.persistence.Embeddable
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Data
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
    companion object {
        private const val serialVersionUID = 1L
    }
}