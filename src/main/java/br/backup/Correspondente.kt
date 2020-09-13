package br.backup

import org.hibernate.validator.constraints.Email
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "correspondente")
@SequenceGenerator(name = "seqcorrespondente", sequenceName = "idcorrespondente", allocationSize = 1, initialValue = 1)
class Correspondente : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqcorrespondente")
    var idcorrespondente: Int? = null
    var nome: String? = null
    var responsavel: String? = null
    var cpfcnpj: String? = null
    var oab: String? = null
    var tipocorrepondente: String? = null
    var telefoneprimario: String? = null
    var telefonesecundario: String? = null
    var telefonecelularprimario: String? = null
    var telefonecelularsecundario: String? = null
    var emailprimario: @Email String? = null
    var emailsecundario: @Email String? = null

    @Temporal(TemporalType.TIMESTAMP)
    var datacadastro: Date? = null
    var ativo = false
    var observacao: String? = null

    @OneToOne
    var enderecos: Endereco? = null
    var aplicaregra1 = false
    var aplicaregra2 = false

    constructor()
    constructor(idcorrespondente: Int?, nome: String?,
                responsavel: String?, cpfcnpj: String?, oab: String?,
                tipocorrepondente: String?, telefoneprimario: String?,
                telefonesecundario: String?, telefonecelularprimario: String?,
                telefonecelularsecundario: String?, emailprimario: String?,
                emailsecundario: String?, datacadastro: Date?, ativo: Boolean,
                observacao: String?, enderecos: Endereco?, aplicaregra1: Boolean,
                aplicaregra2: Boolean) {
        this.idcorrespondente = idcorrespondente
        this.nome = nome
        this.responsavel = responsavel
        this.cpfcnpj = cpfcnpj
        this.oab = oab
        this.tipocorrepondente = tipocorrepondente
        this.telefoneprimario = telefoneprimario
        this.telefonesecundario = telefonesecundario
        this.telefonecelularprimario = telefonecelularprimario
        this.telefonecelularsecundario = telefonecelularsecundario
        this.emailprimario = emailprimario
        this.emailsecundario = emailsecundario
        this.datacadastro = datacadastro
        this.ativo = ativo
        this.observacao = observacao
        this.enderecos = enderecos
        this.aplicaregra1 = aplicaregra1
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (aplicaregra1) 1231 else 1237
        result = prime * result + if (aplicaregra2) 1231 else 1237
        result = prime * result + if (ativo) 1231 else 1237
        result = prime * result + if (cpfcnpj == null) 0 else cpfcnpj.hashCode()
        result = (prime * result
                + if (datacadastro == null) 0 else datacadastro.hashCode())
        result = (prime * result
                + if (emailprimario == null) 0 else emailprimario.hashCode())
        result = (prime * result
                + if (emailsecundario == null) 0 else emailsecundario.hashCode())
        result = (prime
                * result
                + if (idcorrespondente == null) 0 else idcorrespondente.hashCode())
        result = prime * result + if (nome == null) 0 else nome.hashCode()
        result = prime * result + if (oab == null) 0 else oab.hashCode()
        result = (prime * result
                + if (observacao == null) 0 else observacao.hashCode())
        result = (prime * result
                + if (responsavel == null) 0 else responsavel.hashCode())
        result = (prime
                * result
                + if (telefonecelularprimario == null) 0 else telefonecelularprimario.hashCode())
        result = (prime
                * result
                + if (telefonecelularsecundario == null) 0 else telefonecelularsecundario.hashCode())
        result = (prime
                * result
                + if (telefoneprimario == null) 0 else telefoneprimario.hashCode())
        result = (prime
                * result
                + if (telefonesecundario == null) 0 else telefonesecundario
                .hashCode())
        result = (prime
                * result
                + if (tipocorrepondente == null) 0 else tipocorrepondente
                .hashCode())
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Correspondente
        if (aplicaregra1 != other.aplicaregra1) return false
        if (aplicaregra2 != other.aplicaregra2) return false
        if (ativo != other.ativo) return false
        if (cpfcnpj == null) {
            if (other.cpfcnpj != null) return false
        } else if (cpfcnpj != other.cpfcnpj) return false
        if (datacadastro == null) {
            if (other.datacadastro != null) return false
        } else if (datacadastro != other.datacadastro) return false
        if (emailprimario == null) {
            if (other.emailprimario != null) return false
        } else if (emailprimario != other.emailprimario) return false
        if (emailsecundario == null) {
            if (other.emailsecundario != null) return false
        } else if (emailsecundario != other.emailsecundario) return false
        if (idcorrespondente == null) {
            if (other.idcorrespondente != null) return false
        } else if (idcorrespondente != other.idcorrespondente) return false
        if (nome == null) {
            if (other.nome != null) return false
        } else if (nome != other.nome) return false
        if (oab == null) {
            if (other.oab != null) return false
        } else if (oab != other.oab) return false
        if (observacao == null) {
            if (other.observacao != null) return false
        } else if (observacao != other.observacao) return false
        if (responsavel == null) {
            if (other.responsavel != null) return false
        } else if (responsavel != other.responsavel) return false
        if (telefonecelularprimario == null) {
            if (other.telefonecelularprimario != null) return false
        } else if (telefonecelularprimario != other.telefonecelularprimario) return false
        if (telefonecelularsecundario == null) {
            if (other.telefonecelularsecundario != null) return false
        } else if (telefonecelularsecundario != other.telefonecelularsecundario) return false
        if (telefoneprimario == null) {
            if (other.telefoneprimario != null) return false
        } else if (telefoneprimario != other.telefoneprimario) return false
        if (telefonesecundario == null) {
            if (other.telefonesecundario != null) return false
        } else if (telefonesecundario != other.telefonesecundario) return false
        if (tipocorrepondente == null) {
            if (other.tipocorrepondente != null) return false
        } else if (tipocorrepondente != other.tipocorrepondente) return false
        return true
    }

    override fun toString(): String {
        return ("Correspondente [idcorrespondente=" + idcorrespondente
                + ", nome=" + nome + ", responsavel=" + responsavel
                + ", cpfcnpj=" + cpfcnpj + ", oab=" + oab
                + ", tipocorrepondente=" + tipocorrepondente
                + ", telefoneprimario=" + telefoneprimario
                + ", telefonesecundario=" + telefonesecundario
                + ", telefonecelularprimario=" + telefonecelularprimario
                + ", telefonecelularsecundario=" + telefonecelularsecundario
                + ", emailprimario=" + emailprimario + ", emailsecundario="
                + emailsecundario + ", datacadastro=" + datacadastro
                + ", ativo=" + ativo + ", observacao=" + observacao
                + ", enderecos=" + enderecos + ", aplicaregra1=" + aplicaregra1
                + ", aplicaregra2=" + aplicaregra2 + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}