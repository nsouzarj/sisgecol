package br.backup

import java.io.Serializable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "arquivoanexado")
class SoliArquivo : Serializable {
    @EmbeddedId
    var solicitacaoPossuiArquivo: SolicitacaoPossuiArquivo? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}