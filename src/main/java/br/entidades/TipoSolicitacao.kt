package br.entidades

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "tiposolicitacao")
@SequenceGenerator(name = "seqtiposolicitacao", sequenceName = "idtiposolicitacao", allocationSize = 1, initialValue = 1)
class TipoSolicitacao : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqtiposolicitacao")
    var idtiposolicitacao: Int? = null
    var especie: String? = null
    var descricao: String? = null
    var tipo: String? = null
    var visualizar: Boolean? = null

    constructor()

    constructor(idtiposolicitacao: Int?, especie: String?,
                descricao: String?, tipo: String?, visualizar: Boolean?) : super() {
        this.idtiposolicitacao = idtiposolicitacao
        this.especie = especie
        this.descricao = descricao
        this.tipo = tipo
        this.visualizar = visualizar
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = (prime * result
                + if (descricao == null) 0 else descricao.hashCode())
        result = prime * result + if (especie == null) 0 else especie.hashCode()
        result = (prime
                * result
                + if (idtiposolicitacao == null) 0 else idtiposolicitacao
                .hashCode())
        result = prime * result + if (tipo == null) 0 else tipo.hashCode()
        result = (prime * result
                + if (visualizar == null) 0 else visualizar.hashCode())
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as TipoSolicitacao
        if (descricao == null) {
            if (other.descricao != null) return false
        } else if (descricao != other.descricao) return false
        if (especie == null) {
            if (other.especie != null) return false
        } else if (especie != other.especie) return false
        if (idtiposolicitacao == null) {
            if (other.idtiposolicitacao != null) return false
        } else if (idtiposolicitacao != other.idtiposolicitacao) return false
        if (tipo == null) {
            if (other.tipo != null) return false
        } else if (tipo != other.tipo) return false
        if (visualizar == null) {
            if (other.visualizar != null) return false
        } else if (visualizar != other.visualizar) return false
        return true
    }

    override fun toString(): String {
        return ("TipoSolicitacao [idtiposolicitacao=" + idtiposolicitacao
                + ", especie=" + especie + ", descricao=" + descricao
                + ", tipo=" + tipo + ", visualizar=" + visualizar + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}