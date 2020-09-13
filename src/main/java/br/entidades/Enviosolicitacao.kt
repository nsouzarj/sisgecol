package br.entidades

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "enviode")
@SequenceGenerator(name = "seqenviosoli", sequenceName = "idenviosolicitacao", allocationSize = 1, initialValue = 1)
class Enviosolicitacao : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqenviosoli")
    var idenviosolicitacao: Int? = null
    var tipoenvio: String? = null

    constructor()
    constructor(idenviosolicitacao: Int?, tipoenvio: String?) {
        this.idenviosolicitacao = idenviosolicitacao
        this.tipoenvio = tipoenvio
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = (prime
                * result
                + if (idenviosolicitacao == null) 0 else idenviosolicitacao
                .hashCode())
        result = (prime * result
                + if (tipoenvio == null) 0 else tipoenvio.hashCode())
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Enviosolicitacao
        if (idenviosolicitacao == null) {
            if (other.idenviosolicitacao != null) return false
        } else if (idenviosolicitacao != other.idenviosolicitacao) return false
        if (tipoenvio == null) {
            if (other.tipoenvio != null) return false
        } else if (tipoenvio != other.tipoenvio) return false
        return true
    }

    override fun toString(): String {
        return "Enviosolicitacao [idenviosolicitacao=$idenviosolicitacao, tipoenvio=$tipoenvio]"
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}