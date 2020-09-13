package br.backup

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "preposto")
@SequenceGenerator(initialValue = 1, name = "seqpreposto", sequenceName = "seqpreposto")
class Preposto : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqpreposto")
    var idpresposto: Int? = null
    var nomecompleto: String? = null
    var cpf: String? = null
    var identidade: String? = null
    var datanascimento: Date? = null
    var observacao: String? = null
    var enderecos: Endereco? = null

    constructor()
    constructor(idpresposto: Int?, nomecompleto: String?, cpf: String?,
                identidade: String?, datanascimento: Date?, observacao: String?,
                enderecos: Endereco?) {
        this.idpresposto = idpresposto
        this.nomecompleto = nomecompleto
        this.cpf = cpf
        this.identidade = identidade
        this.datanascimento = datanascimento
        this.observacao = observacao
        this.enderecos = enderecos
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (cpf == null) 0 else cpf.hashCode()
        result = (prime * result
                + if (datanascimento == null) 0 else datanascimento.hashCode())
        result = (prime * result
                + if (identidade == null) 0 else identidade.hashCode())
        result = (prime * result
                + if (idpresposto == null) 0 else idpresposto.hashCode())
        result = (prime * result
                + if (nomecompleto == null) 0 else nomecompleto.hashCode())
        result = (prime * result
                + if (observacao == null) 0 else observacao.hashCode())
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Preposto
        if (cpf == null) {
            if (other.cpf != null) return false
        } else if (cpf != other.cpf) return false
        if (datanascimento == null) {
            if (other.datanascimento != null) return false
        } else if (datanascimento != other.datanascimento) return false
        if (identidade == null) {
            if (other.identidade != null) return false
        } else if (identidade != other.identidade) return false
        if (idpresposto == null) {
            if (other.idpresposto != null) return false
        } else if (idpresposto != other.idpresposto) return false
        if (nomecompleto == null) {
            if (other.nomecompleto != null) return false
        } else if (nomecompleto != other.nomecompleto) return false
        if (observacao == null) {
            if (other.observacao != null) return false
        } else if (observacao != other.observacao) return false
        return true
    }

    override fun toString(): String {
        return ("Preposto [idpresposto=" + idpresposto + ", nomecompleto="
                + nomecompleto + ", cpf=" + cpf + ", identidade=" + identidade
                + ", datanascimento=" + datanascimento + ", observacao="
                + observacao + ", enderecos=" + enderecos + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}