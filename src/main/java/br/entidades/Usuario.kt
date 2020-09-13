package br.entidades

import org.hibernate.validator.constraints.Email
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "usuario")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "sequsu", sequenceName = "idusuario")
class Usuario : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequsu")
    var idusuario: Int? = null
    var login: String? = null
    var senha: String? = null
    var nomecompleto: String? = null
    var emailprincipal: @Email String? = null
    var emailsecundario: @Email String? = null
    var emailresponsavel: @Email String? = null

    @OneToOne
    var correspondente: Correspondente? = null
    var tipo // 1-Adm, 2-Advgodado, 3-Correspondente
            : Int? = null

    @Temporal(TemporalType.TIMESTAMP)
    var dataentrada: Date? = null
    var ativo = false

    constructor()
    constructor(idusuario: Int?, login: String?, senha: String?,
                nomecompleto: String?, emailprincipal: String?, emailsecundario: String?, emailresponsavel: String?,
                correspondente: Correspondente?, tipo: Int?, dataentrada: Date?,
                ativo: Boolean) {
        this.idusuario = idusuario
        this.login = login
        this.senha = senha
        this.nomecompleto = nomecompleto
        this.emailprincipal = emailprincipal
        this.emailsecundario = emailsecundario
        this.correspondente = correspondente
        this.tipo = tipo
        this.emailresponsavel = emailresponsavel
        this.dataentrada = dataentrada
        this.ativo = ativo
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (ativo) 1231 else 1237
        result = (prime * result
                + if (dataentrada == null) 0 else dataentrada.hashCode())
        result = (prime * result
                + if (emailprincipal == null) 0 else emailprincipal.hashCode())
        result = (prime
                * result
                + if (emailresponsavel == null) 0 else emailresponsavel.hashCode())
        result = (prime * result
                + if (emailsecundario == null) 0 else emailsecundario.hashCode())
        result = (prime * result
                + if (idusuario == null) 0 else idusuario.hashCode())
        result = prime * result + if (login == null) 0 else login.hashCode()
        result = (prime * result
                + if (nomecompleto == null) 0 else nomecompleto.hashCode())
        result = prime * result + if (senha == null) 0 else senha.hashCode()
        result = prime * result + if (tipo == null) 0 else tipo.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Usuario
        if (ativo != other.ativo) return false
        if (dataentrada == null) {
            if (other.dataentrada != null) return false
        } else if (dataentrada != other.dataentrada) return false
        if (emailprincipal == null) {
            if (other.emailprincipal != null) return false
        } else if (emailprincipal != other.emailprincipal) return false
        if (emailresponsavel == null) {
            if (other.emailresponsavel != null) return false
        } else if (emailresponsavel != other.emailresponsavel) return false
        if (emailsecundario == null) {
            if (other.emailsecundario != null) return false
        } else if (emailsecundario != other.emailsecundario) return false
        if (idusuario == null) {
            if (other.idusuario != null) return false
        } else if (idusuario != other.idusuario) return false
        if (login == null) {
            if (other.login != null) return false
        } else if (login != other.login) return false
        if (nomecompleto == null) {
            if (other.nomecompleto != null) return false
        } else if (nomecompleto != other.nomecompleto) return false
        if (senha == null) {
            if (other.senha != null) return false
        } else if (senha != other.senha) return false
        if (tipo == null) {
            if (other.tipo != null) return false
        } else if (tipo != other.tipo) return false
        return true
    }

    override fun toString(): String {
        return ("Usuario [idusuario=" + idusuario + ", login=" + login
                + ", senha=" + senha + ", nomecompleto=" + nomecompleto
                + ", emailprincipal=" + emailprincipal + ", emailsecundario="
                + emailsecundario + ", emailresponsavel=" + emailresponsavel
                + ", correspondente=" + correspondente + ", tipo=" + tipo
                + ", dataentrada=" + dataentrada + ", ativo=" + ativo + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}