package br.backup

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "logsistema")
@SequenceGenerator(name = "seqlog", sequenceName = "idlog", allocationSize = 1, initialValue = 1)
class LogSistema : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqlog")
    var idlog: Int? = null
    var usuario: String? = null
    var idsolicitacao: Int? = null
    var datalog: Date? = null
    var tela: String? = null

    @Column(length = 3000, columnDefinition = "Text")
    var descricao: String? = null

    constructor()
    constructor(idlog: Int?, usuario: String?, datalog: Date?, tela: String?,
                descricao: String?, idsolicitacao: Int?) {
        this.idlog = idlog
        this.usuario = usuario
        this.datalog = datalog
        this.tela = tela
        this.descricao = descricao
        this.idsolicitacao = idsolicitacao
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (datalog == null) 0 else datalog.hashCode()
        result = (prime * result
                + if (descricao == null) 0 else descricao.hashCode())
        result = prime * result + if (idlog == null) 0 else idlog.hashCode()
        result = (prime * result
                + if (idsolicitacao == null) 0 else idsolicitacao.hashCode())
        result = prime * result + if (tela == null) 0 else tela.hashCode()
        result = prime * result + if (usuario == null) 0 else usuario.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as LogSistema
        if (datalog == null) {
            if (other.datalog != null) return false
        } else if (datalog != other.datalog) return false
        if (descricao == null) {
            if (other.descricao != null) return false
        } else if (descricao != other.descricao) return false
        if (idlog == null) {
            if (other.idlog != null) return false
        } else if (idlog != other.idlog) return false
        if (idsolicitacao == null) {
            if (other.idsolicitacao != null) return false
        } else if (idsolicitacao != other.idsolicitacao) return false
        if (tela == null) {
            if (other.tela != null) return false
        } else if (tela != other.tela) return false
        if (usuario == null) {
            if (other.usuario != null) return false
        } else if (usuario != other.usuario) return false
        return true
    }

    override fun toString(): String {
        return ("LogSistema [idlog=" + idlog + ", usuario=" + usuario
                + ", idsolicitacao=" + idsolicitacao + ", datalog=" + datalog
                + ", tela=" + tela + ", descricao=" + descricao + "]")
    }

    companion object {
        /**
         *
         */
        private const val serialVersionUID = 1L
    }
}