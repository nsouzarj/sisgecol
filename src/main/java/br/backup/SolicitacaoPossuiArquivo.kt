package br.backup

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import javax.persistence.Embeddable
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Embeddable
class SolicitacaoPossuiArquivo : Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "idsolicitacao")
    var solicitacao: Solicitacao? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "idarquivoanexo")
    var solicitacaoAnexo: SolicitacaoAnexo? = null

    constructor()
    constructor(solicitacao: Solicitacao?,
                solicitacaoAnexo: SolicitacaoAnexo?) {
        this.solicitacao = solicitacao
        this.solicitacaoAnexo = solicitacaoAnexo
    }

    override fun toString(): String {
        return ("SolicitacaoPossuiArquivo [solicitacao=" + solicitacao
                + ", solicitacaoAnexo=" + solicitacaoAnexo + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}