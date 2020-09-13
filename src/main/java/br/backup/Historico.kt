package br.backup

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "historico")
@SequenceGenerator(name = "seqhist", sequenceName = "idhistorico", allocationSize = 1, initialValue = 1)
class Historico : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqhist")
    var idhistorico: Int? = null

    @Temporal(TemporalType.TIMESTAMP)
    var datahistorico: Date? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idsolicitacao")
    var solicitacao: Solicitacao? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idstatus")
    var statusSolicitacao: StatusSolicitacao? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idusuario")
    var usuario: Usuario? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idrenumeracao")
    var renumeracao: Renumeracao? = null

    @Column(length = 600, columnDefinition = "Text")
    var textohistorico: String? = null

    constructor()
    constructor(idhistorico: Int?, datahistorico: Date?, solicitacao: Solicitacao?,
                statusSolicitacao: StatusSolicitacao?, usuario: Usuario?, renumeracao: Renumeracao?, textohistorico: String?) : super() {
        this.idhistorico = idhistorico
        this.datahistorico = datahistorico
        this.solicitacao = solicitacao
        this.statusSolicitacao = statusSolicitacao
        this.usuario = usuario
        this.renumeracao = renumeracao
        this.textohistorico = textohistorico
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (datahistorico == null) 0 else datahistorico.hashCode()
        result = prime * result + if (idhistorico == null) 0 else idhistorico.hashCode()
        result = prime * result + if (textohistorico == null) 0 else textohistorico.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Historico
        if (datahistorico == null) {
            if (other.datahistorico != null) return false
        } else if (datahistorico != other.datahistorico) return false
        if (idhistorico == null) {
            if (other.idhistorico != null) return false
        } else if (idhistorico != other.idhistorico) return false
        if (textohistorico == null) {
            if (other.textohistorico != null) return false
        } else if (textohistorico != other.textohistorico) return false
        return true
    }

    override fun toString(): String {
        return ("Historico [idhistorico=" + idhistorico + ", datahistorico=" + datahistorico + ", solicitacao="
                + solicitacao + ", statusSolicitacao=" + statusSolicitacao + ", usuario=" + usuario + ", renumeracao="
                + renumeracao + ", textohistorico=" + textohistorico + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}