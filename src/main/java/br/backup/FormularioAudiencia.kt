package br.backup

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "formularioaudiencia")
@SequenceGenerator(name = "seqformulario", sequenceName = "idformulario", allocationSize = 1, initialValue = 1)
class FormularioAudiencia : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqformulario")
    var idformulario: Int? = null
    var nomeadvogado: String? = null
    var numoab: String? = null
    var telefoneadvogado: String? = null
    var advogadoadverso: String? = null
    var numoabadverso: String? = null
    var telefoneadvadervoso: String? = null
    var emailadvadverso: String? = null
    var defesagenerica = false
    var contraproposta = false
    var aijdesiginada = false
    var dataaij: Date? = null
    var valorproposta = 0.0
    var valorcontraproposta = 0.0

    @Column(length = 1000, columnDefinition = "Text")
    var obrigacaoafazer: String? = null

    @Column(length = 1000, columnDefinition = "Text")
    var informecontraproposta: String? = null

    @Column(length = 1000, columnDefinition = "Text")
    var objetodalide: String? = null

    @Column(length = 1000, columnDefinition = "Text")
    var estrategiadefesa: String? = null

    @Column(length = 1000, columnDefinition = "Text")
    var informeacontecimento: String? = null
    var nivel: Int? = null
    var dataformulario: Date? = null
    var acordorealizado = false
    var valoracordo = 0.0

    constructor()
    constructor(idformulario: Int?, nomeadvogado: String?,
                numoab: String?, telefoneadvogado: String?, advogadoadverso: String?,
                numoabadverso: String?, telefoneadvadervoso: String?,
                emailadvadverso: String?, defesagenerica: Boolean,
                contraproposta: Boolean, aijdesiginada: Boolean, dataaij: Date?,
                valorproposta: Double, valorcontraproposta: Double,
                obrigacaoafazer: String?, informecontraproposta: String?,
                objetodalide: String?, estrategiadefesa: String?,
                informeacontecimento: String?, nivel: Int?, dataformulario: Date?,
                acordorealizado: Boolean, valoracordo: Double) {
        this.idformulario = idformulario
        this.nomeadvogado = nomeadvogado
        this.numoab = numoab
        this.telefoneadvogado = telefoneadvogado
        this.advogadoadverso = advogadoadverso
        this.numoabadverso = numoabadverso
        this.telefoneadvadervoso = telefoneadvadervoso
        this.emailadvadverso = emailadvadverso
        this.defesagenerica = defesagenerica
        this.contraproposta = contraproposta
        this.aijdesiginada = aijdesiginada
        this.dataaij = dataaij
        this.valorproposta = valorproposta
        this.valorcontraproposta = valorcontraproposta
        this.obrigacaoafazer = obrigacaoafazer
        this.informecontraproposta = informecontraproposta
        this.objetodalide = objetodalide
        this.estrategiadefesa = estrategiadefesa
        this.informeacontecimento = informeacontecimento
        this.nivel = nivel
        this.dataformulario = dataformulario
        this.acordorealizado = acordorealizado
        this.valoracordo = valoracordo
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (acordorealizado) 1231 else 1237
        result = (prime * result
                + if (advogadoadverso == null) 0 else advogadoadverso.hashCode())
        result = prime * result + if (aijdesiginada) 1231 else 1237
        result = prime * result + if (contraproposta) 1231 else 1237
        result = prime * result + if (dataaij == null) 0 else dataaij.hashCode()
        result = (prime * result
                + if (dataformulario == null) 0 else dataformulario.hashCode())
        result = prime * result + if (defesagenerica) 1231 else 1237
        result = (prime * result
                + if (emailadvadverso == null) 0 else emailadvadverso.hashCode())
        result = (prime
                * result
                + if (estrategiadefesa == null) 0 else estrategiadefesa.hashCode())
        result = (prime * result
                + if (idformulario == null) 0 else idformulario.hashCode())
        result = (prime
                * result
                + if (informeacontecimento == null) 0 else informeacontecimento
                .hashCode())
        result = (prime
                * result
                + if (informecontraproposta == null) 0 else informecontraproposta
                .hashCode())
        result = prime * result + if (nivel == null) 0 else nivel.hashCode()
        result = (prime * result
                + if (nomeadvogado == null) 0 else nomeadvogado.hashCode())
        result = prime * result + if (numoab == null) 0 else numoab.hashCode()
        result = (prime * result
                + if (numoabadverso == null) 0 else numoabadverso.hashCode())
        result = (prime * result
                + if (objetodalide == null) 0 else objetodalide.hashCode())
        result = (prime * result
                + if (obrigacaoafazer == null) 0 else obrigacaoafazer.hashCode())
        result = (prime
                * result
                + if (telefoneadvadervoso == null) 0 else telefoneadvadervoso
                .hashCode())
        result = (prime
                * result
                + if (telefoneadvogado == null) 0 else telefoneadvogado.hashCode())
        var temp: Long
        temp = java.lang.Double.doubleToLongBits(valoracordo)
        result = prime * result + (temp xor (temp ushr 32)).toInt()
        temp = java.lang.Double.doubleToLongBits(valorcontraproposta)
        result = prime * result + (temp xor (temp ushr 32)).toInt()
        temp = java.lang.Double.doubleToLongBits(valorproposta)
        result = prime * result + (temp xor (temp ushr 32)).toInt()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as FormularioAudiencia
        if (acordorealizado != other.acordorealizado) return false
        if (advogadoadverso == null) {
            if (other.advogadoadverso != null) return false
        } else if (advogadoadverso != other.advogadoadverso) return false
        if (aijdesiginada != other.aijdesiginada) return false
        if (contraproposta != other.contraproposta) return false
        if (dataaij == null) {
            if (other.dataaij != null) return false
        } else if (dataaij != other.dataaij) return false
        if (dataformulario == null) {
            if (other.dataformulario != null) return false
        } else if (dataformulario != other.dataformulario) return false
        if (defesagenerica != other.defesagenerica) return false
        if (emailadvadverso == null) {
            if (other.emailadvadverso != null) return false
        } else if (emailadvadverso != other.emailadvadverso) return false
        if (estrategiadefesa == null) {
            if (other.estrategiadefesa != null) return false
        } else if (estrategiadefesa != other.estrategiadefesa) return false
        if (idformulario == null) {
            if (other.idformulario != null) return false
        } else if (idformulario != other.idformulario) return false
        if (informeacontecimento == null) {
            if (other.informeacontecimento != null) return false
        } else if (informeacontecimento != other.informeacontecimento) return false
        if (informecontraproposta == null) {
            if (other.informecontraproposta != null) return false
        } else if (informecontraproposta != other.informecontraproposta) return false
        if (nivel == null) {
            if (other.nivel != null) return false
        } else if (nivel != other.nivel) return false
        if (nomeadvogado == null) {
            if (other.nomeadvogado != null) return false
        } else if (nomeadvogado != other.nomeadvogado) return false
        if (numoab == null) {
            if (other.numoab != null) return false
        } else if (numoab != other.numoab) return false
        if (numoabadverso == null) {
            if (other.numoabadverso != null) return false
        } else if (numoabadverso != other.numoabadverso) return false
        if (objetodalide == null) {
            if (other.objetodalide != null) return false
        } else if (objetodalide != other.objetodalide) return false
        if (obrigacaoafazer == null) {
            if (other.obrigacaoafazer != null) return false
        } else if (obrigacaoafazer != other.obrigacaoafazer) return false
        if (telefoneadvadervoso == null) {
            if (other.telefoneadvadervoso != null) return false
        } else if (telefoneadvadervoso != other.telefoneadvadervoso) return false
        if (telefoneadvogado == null) {
            if (other.telefoneadvogado != null) return false
        } else if (telefoneadvogado != other.telefoneadvogado) return false
        if (java.lang.Double.doubleToLongBits(valoracordo) != java.lang.Double
                        .doubleToLongBits(other.valoracordo)) return false
        if (java.lang.Double.doubleToLongBits(valorcontraproposta) != java.lang.Double
                        .doubleToLongBits(other.valorcontraproposta)) return false
        return java.lang.Double.doubleToLongBits(valorproposta) == java.lang.Double
                .doubleToLongBits(other.valorproposta)
    }

    override fun toString(): String {
        return ("FormularioAudiencia [idformulario=" + idformulario
                + ", nomeadvogado=" + nomeadvogado + ", numoab=" + numoab
                + ", telefoneadvogado=" + telefoneadvogado
                + ", advogadoadverso=" + advogadoadverso + ", numoabadverso="
                + numoabadverso + ", telefoneadvadervoso="
                + telefoneadvadervoso + ", emailadvadverso=" + emailadvadverso
                + ", defesagenerica=" + defesagenerica + ", contraproposta="
                + contraproposta + ", aijdesiginada=" + aijdesiginada
                + ", dataaij=" + dataaij + ", valorproposta=" + valorproposta
                + ", valorcontraproposta=" + valorcontraproposta
                + ", obrigacaoafazer=" + obrigacaoafazer
                + ", informecontraproposta=" + informecontraproposta
                + ", objetodalide=" + objetodalide + ", estrategiadefesa="
                + estrategiadefesa + ", informeacontecimento="
                + informeacontecimento + ", nivel=" + nivel
                + ", dataformulario=" + dataformulario + ", acordorealizado="
                + acordorealizado + ", valoracordo=" + valoracordo + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}