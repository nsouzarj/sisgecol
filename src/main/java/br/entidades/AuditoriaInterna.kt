package br.entidades

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "auditoriainterna")
@SequenceGenerator(name = "seqaudiinterna", sequenceName = "idaudiinterna", allocationSize = 1, initialValue = 1)
class AuditoriaInterna : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqaudiinterna")
    var idaudiinterna: Int? = null
    var correpfezsub=false //Correspoendete se fez substituir = false
    var advogadosubs //Advogado substituto
            : String? = null
    var leuorientacao=false //Leu a orienta��o porra !! = false
    var conhecimentocaso=false //Correspondente  = false
    var duvpropacordo = false//D�vida no acordo = false
    var portdocumentacao = false//Portava documentacao = false
    var valorpropinicial=0 //valor da proposta inicial = 0f
    var notaavaliacao // Nota de avalaicao da audiencia
            : Int? = null

    @Column(length = 1000, columnDefinition = "Text")
    var avaliacao1 //Avaliacao 1
            : String? = null

    @Column(length = 1000, columnDefinition = "Text")
    var avaliacao2 //Avaliacao 2
            : String? = null

    @Temporal(TemporalType.TIMESTAMP)
    var dataauditoria: Date? = null

    constructor()
    constructor(idaudiinterna: Int?, correpfezsub: Boolean,
                advogadosubs: String?, leuorientacao: Boolean,
                conhecimentocaso: Boolean, duvpropacordo: Boolean,
                portdocumentacao: Boolean, valorpropinicial: Float,
                avaliacao1: String?, avaliacao2: String?, dataauditoria: Date?, notaavaliacao: Int?) {
        this.idaudiinterna = idaudiinterna
        this.correpfezsub = correpfezsub
        this.advogadosubs = advogadosubs
        this.leuorientacao = leuorientacao
        this.conhecimentocaso = conhecimentocaso
        this.duvpropacordo = duvpropacordo
        this.portdocumentacao = portdocumentacao
        this.valorpropinicial = valorpropinicial.toInt()
        this.avaliacao1 = avaliacao1
        this.avaliacao2 = avaliacao2
        this.dataauditoria = dataauditoria
        this.notaavaliacao = notaavaliacao
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = (prime * result
                + if (advogadosubs == null) 0 else advogadosubs.hashCode())
        result = (prime * result
                + if (avaliacao1 == null) 0 else avaliacao1.hashCode())
        result = (prime * result
                + if (avaliacao2 == null) 0 else avaliacao2.hashCode())
        result = prime * result + if (conhecimentocaso) 1231 else 1237
        result = prime * result + if (correpfezsub) 1231 else 1237
        result = (prime * result
                + if (dataauditoria == null) 0 else dataauditoria.hashCode())
        result = prime * result + if (duvpropacordo) 1231 else 1237
        result = (prime * result
                + if (idaudiinterna == null) 0 else idaudiinterna.hashCode())
        result = prime * result + if (leuorientacao) 1231 else 1237
        result = (prime * result
                + if (notaavaliacao == null) 0 else notaavaliacao.hashCode())
        result = prime * result + if (portdocumentacao) 1231 else 1237
        result = prime * result + java.lang.Float.floatToIntBits(valorpropinicial.toFloat())
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as AuditoriaInterna
        if (advogadosubs == null) {
            if (other.advogadosubs != null) return false
        } else if (advogadosubs != other.advogadosubs) return false
        if (avaliacao1 == null) {
            if (other.avaliacao1 != null) return false
        } else if (avaliacao1 != other.avaliacao1) return false
        if (avaliacao2 == null) {
            if (other.avaliacao2 != null) return false
        } else if (avaliacao2 != other.avaliacao2) return false
        if (conhecimentocaso != other.conhecimentocaso) return false
        if (correpfezsub != other.correpfezsub) return false
        if (dataauditoria == null) {
            if (other.dataauditoria != null) return false
        } else if (dataauditoria != other.dataauditoria) return false
        if (duvpropacordo != other.duvpropacordo) return false
        if (idaudiinterna == null) {
            if (other.idaudiinterna != null) return false
        } else if (idaudiinterna != other.idaudiinterna) return false
        if (leuorientacao != other.leuorientacao) return false
        if (notaavaliacao == null) {
            if (other.notaavaliacao != null) return false
        } else if (notaavaliacao != other.notaavaliacao) return false
        if (portdocumentacao != other.portdocumentacao) return false
        return java.lang.Float.floatToIntBits(valorpropinicial.toFloat()) == java.lang.Float
                .floatToIntBits(other.valorpropinicial.toFloat())
    }

    override fun toString(): String {
        return ("AuditoriaInterna [idaudiinterna=" + idaudiinterna
                + ", correpfezsub=" + correpfezsub + ", advogadosubs="
                + advogadosubs + ", leuorientacao=" + leuorientacao
                + ", conhecimentocaso=" + conhecimentocaso + ", duvpropacordo="
                + duvpropacordo + ", portdocumentacao=" + portdocumentacao
                + ", valorpropinicial=" + valorpropinicial + ", notaavaliacao="
                + notaavaliacao + ", avaliacao1=" + avaliacao1
                + ", avaliacao2=" + avaliacao2 + ", dataauditoria="
                + dataauditoria + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}