package br.backup

import javax.persistence.*

@Entity(name = "formaudnovo")
@SequenceGenerator(name = "seqformnovo", sequenceName = "idformnovo", allocationSize = 1, initialValue = 1)
class FormularioAudienciaNovo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqformnovo")
    var idformnovo: Int? = null
    var assitidoadvogado //O autor est� assistido por por advogado
            = false
    var autorcompaudiencia //Autor compareceu a audiencia
            = false
    var encerrarformulario //Encerra o formualrio nao presente mas nada
            = false
    var telautor //Telefone do autor
            : String? = null
    var emaildoautor //Email do autor
            : String? = null
    var aijdesignada // Aij desiganda
            = false
    var acordorealizado //Acordo realizado
            = false
    var oabexadverso //Oab do exadverso
            : String? = null
    var telexadverso // Telefone do exaadverso
            : String? = null
    var emailexadverso //Email do exadverso
            : String? = null

    constructor(idformnovo: Int?,
                assitidoadvogado: Boolean, autorcompaudiencia: Boolean,
                encerrarformulario: Boolean, telautor: String?, emaildoautor: String?,
                aijdesignada: Boolean, acordorealizado: Boolean, oabexadverso: String?,
                telexadverso: String?, emailexadverso: String?) {
        this.idformnovo = idformnovo
        this.assitidoadvogado = assitidoadvogado
        this.autorcompaudiencia = autorcompaudiencia
        this.encerrarformulario = encerrarformulario
        this.telautor = telautor
        this.emaildoautor = emaildoautor
        this.aijdesignada = aijdesignada
        this.acordorealizado = acordorealizado
        this.oabexadverso = oabexadverso
        this.telexadverso = telexadverso
        this.emailexadverso = emailexadverso
    }

    constructor()

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (acordorealizado) 1231 else 1237
        result = prime * result + if (aijdesignada) 1231 else 1237
        result = prime * result + if (assitidoadvogado) 1231 else 1237
        result = prime * result + if (autorcompaudiencia) 1231 else 1237
        result = (prime * result
                + if (emaildoautor == null) 0 else emaildoautor.hashCode())
        result = (prime * result
                + if (emailexadverso == null) 0 else emailexadverso.hashCode())
        result = prime * result + if (encerrarformulario) 1231 else 1237
        result = (prime * result
                + if (idformnovo == null) 0 else idformnovo.hashCode())
        result = (prime * result
                + if (oabexadverso == null) 0 else oabexadverso.hashCode())
        result = (prime * result
                + if (telautor == null) 0 else telautor.hashCode())
        result = (prime * result
                + if (telexadverso == null) 0 else telexadverso.hashCode())
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as FormularioAudienciaNovo
        if (acordorealizado != other.acordorealizado) return false
        if (aijdesignada != other.aijdesignada) return false
        if (assitidoadvogado != other.assitidoadvogado) return false
        if (autorcompaudiencia != other.autorcompaudiencia) return false
        if (emaildoautor == null) {
            if (other.emaildoautor != null) return false
        } else if (emaildoautor != other.emaildoautor) return false
        if (emailexadverso == null) {
            if (other.emailexadverso != null) return false
        } else if (emailexadverso != other.emailexadverso) return false
        if (encerrarformulario != other.encerrarformulario) return false
        if (idformnovo == null) {
            if (other.idformnovo != null) return false
        } else if (idformnovo != other.idformnovo) return false
        if (oabexadverso == null) {
            if (other.oabexadverso != null) return false
        } else if (oabexadverso != other.oabexadverso) return false
        if (telautor == null) {
            if (other.telautor != null) return false
        } else if (telautor != other.telautor) return false
        if (telexadverso == null) {
            if (other.telexadverso != null) return false
        } else if (telexadverso != other.telexadverso) return false
        return true
    }

    override fun toString(): String {
        return ("FormularioAudienciaNovo [idformnovo=" + idformnovo
                + ", assitidoadvogado=" + assitidoadvogado
                + ", autorcompaudiencia=" + autorcompaudiencia
                + ", encerrarformulario=" + encerrarformulario + ", telautor="
                + telautor + ", emaildoautor=" + emaildoautor
                + ", aijdesignada=" + aijdesignada + ", acordorealizado="
                + acordorealizado + ", oabexadverso=" + oabexadverso
                + ", telexadverso=" + telexadverso + ", emailexadverso="
                + emailexadverso + "]")
    }
}