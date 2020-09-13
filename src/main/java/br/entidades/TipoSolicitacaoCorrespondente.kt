package br.entidades

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import javax.persistence.Embeddable
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Embeddable
class TipoSolicitacaoCorrespondente : Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "idcorrespondente")
    var correspondente: Correspondente? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "idsolicitacao")
    var tipoSolicitacao: TipoSolicitacao? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "idenvio")
    var envio: Envio? = null

    constructor()
    constructor(correspondente: Correspondente?,
                tipoSolicitacao: TipoSolicitacao?) {
        this.correspondente = correspondente
        this.tipoSolicitacao = tipoSolicitacao
    }

    override fun toString(): String {
        return ("TipoSolicitacaoCorrespondente [correspondente="
                + correspondente + ", tipoSolicitacao=" + tipoSolicitacao + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}