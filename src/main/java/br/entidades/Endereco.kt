package br.entidades

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "endereco")
@SequenceGenerator(name = "seqendereco", sequenceName = "idendereco", allocationSize = 1, initialValue = 1)
class Endereco : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqendereco")
    var idendereco: Int? = null
    var logradouro: String? = null
    var bairro: String? = null
    var cidade: String? = null

    @ManyToOne
    var uf: Uf? = null
    var cep: String? = null
    var observacao: String? = null

    constructor()
    constructor(idendereco: Int?, logradouro: String?, bairro: String?,
                cidade: String?, uf: Uf?, cep: String?, observacao: String?) {
        this.idendereco = idendereco
        this.logradouro = logradouro
        this.bairro = bairro
        this.cidade = cidade
        this.uf = uf
        this.cep = cep
        this.observacao = observacao
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (bairro == null) 0 else bairro.hashCode()
        result = prime * result + if (cep == null) 0 else cep.hashCode()
        result = prime * result + if (cidade == null) 0 else cidade.hashCode()
        result = (prime * result
                + if (idendereco == null) 0 else idendereco.hashCode())
        result = (prime * result
                + if (logradouro == null) 0 else logradouro.hashCode())
        result = (prime * result
                + if (observacao == null) 0 else observacao.hashCode())
        result = prime * result + if (uf == null) 0 else uf.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Endereco
        if (bairro == null) {
            if (other.bairro != null) return false
        } else if (bairro != other.bairro) return false
        if (cep == null) {
            if (other.cep != null) return false
        } else if (cep != other.cep) return false
        if (cidade == null) {
            if (other.cidade != null) return false
        } else if (cidade != other.cidade) return false
        if (idendereco == null) {
            if (other.idendereco != null) return false
        } else if (idendereco != other.idendereco) return false
        if (logradouro == null) {
            if (other.logradouro != null) return false
        } else if (logradouro != other.logradouro) return false
        if (observacao == null) {
            if (other.observacao != null) return false
        } else if (observacao != other.observacao) return false
        if (uf == null) {
            if (other.uf != null) return false
        } else if (uf != other.uf) return false
        return true
    }

    override fun toString(): String {
        return ("Endereco [idendereco=" + idendereco + ", logradouro="
                + logradouro + ", bairro=" + bairro + ", cidade=" + cidade
                + ", uf=" + uf + ", cep=" + cep + ", observacao=" + observacao
                + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}