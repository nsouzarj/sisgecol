package br.entidades

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "solicitacao")
@SequenceGenerator(name = "seqsolicitacao", sequenceName = "idsolicitacao", allocationSize = 1, initialValue = 1)
class Solicitacao : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqsolicitacao")
    var idsolicitacao: Int? = null
    var referenciasolicitacao: Int? = null

    @Temporal(TemporalType.TIMESTAMP)
    var datasolictacao: Date? = null

    @Temporal(TemporalType.TIMESTAMP)
    var dataconclusao: Date? = null

    @Temporal(TemporalType.TIMESTAMP)
    var dataprazo: Date? = null

    @Column(length = 600, columnDefinition = "Text")
    var observacao: String? = null

    @Column(length = 600, columnDefinition = "Text")
    var instrucoes: String? = null

    @Column(length = 600, columnDefinition = "Text")
    var complemento: String? = null

    @Column(length = 600, columnDefinition = "Text")
    var justificativa: String? = null

    @Column(length = 600, columnDefinition = "Text")
    var tratposaudiencia //Tratamento pos audiencia
            : String? = null

    @Column(length = 30)
    var numcontrole: String? = null
    var tempreposto = false
    var convolada = false

    @Column(nullable = true, length = 10)
    var horaudiencia: String? = null

    @Column(nullable = true, length = 20)
    var statusexterno // CONFIRMAR - REJEITAR
            : String? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idprocesso")
    var processo: Processo? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idrenumeracao")
    var renumeracao: Renumeracao? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idstatus")
    var statusSolicitacao: StatusSolicitacao? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idcomarca") //@javax.validation.constraints.NotBlank
    //@Column(nullable=false)
    var comarca: Comarca? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idformulario")
    var formularioAudiencia: FormularioAudiencia? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idbanca") //@javax.validation.constraints.NotBlank
    var bancaProcesso: BancaProcesso? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idenviosolicitacao")
    var enviosolicitacao: Enviosolicitacao? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idrecibo")
    var reciboPagamento: ReciboPagamento? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idusuario")
    var usuario: Usuario? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idaudiinterna")
    var auditoriaInterna: AuditoriaInterna? = null
    var valor = 0f
    var valordaalcada = 0f
    var emailenvio: String? = null
    var pago: String? = null
    var grupo: Int? = null

    @Column(nullable = true)
    var propostaacordo = false

    @Column(nullable = true)
    var audinterna = false

    @Column(length = 1)
    var lide: String? = null
    var avaliacaonota: Int? = null
    var textoavaliacao: String? = null

    constructor()
    constructor(idsolicitacao: Int?, referenciasolicitacao: Int?, datasolictacao: Date?, dataconclusao: Date?,
                dataprazo: Date?, observacao: String?, instrucoes: String?, complemento: String?, justificativa: String?,
                tratposaudiencia: String?, numcontrole: String?, tempreposto: Boolean, convolada: Boolean, horaudiencia: String?,
                statusexterno: String?, processo: Processo?, renumeracao: Renumeracao?, statusSolicitacao: StatusSolicitacao?,
                comarca: Comarca?, formularioAudiencia: FormularioAudiencia?, bancaProcesso: BancaProcesso?,
                enviosolicitacao: Enviosolicitacao?, reciboPagamento: ReciboPagamento?, usuario: Usuario?,
                auditoriaInterna: AuditoriaInterna?, valor: Float, valordaalcada: Float, emailenvio: String?, pago: String?,
                grupo: Int?, propostaacordo: Boolean, audinterna: Boolean, lide: String?, avaliacaonota: Int?,
                textoavaliacao: String?) : super() {
        this.idsolicitacao = idsolicitacao
        this.referenciasolicitacao = referenciasolicitacao
        this.datasolictacao = datasolictacao
        this.dataconclusao = dataconclusao
        this.dataprazo = dataprazo
        this.observacao = observacao
        this.instrucoes = instrucoes
        this.complemento = complemento
        this.justificativa = justificativa
        this.tratposaudiencia = tratposaudiencia
        this.numcontrole = numcontrole
        this.tempreposto = tempreposto
        this.convolada = convolada
        this.horaudiencia = horaudiencia
        this.statusexterno = statusexterno
        this.processo = processo
        this.renumeracao = renumeracao
        this.statusSolicitacao = statusSolicitacao
        this.comarca = comarca
        this.formularioAudiencia = formularioAudiencia
        this.bancaProcesso = bancaProcesso
        this.enviosolicitacao = enviosolicitacao
        this.reciboPagamento = reciboPagamento
        this.usuario = usuario
        this.auditoriaInterna = auditoriaInterna
        this.valor = valor
        this.valordaalcada = valordaalcada
        this.emailenvio = emailenvio
        this.pago = pago
        this.grupo = grupo
        this.propostaacordo = propostaacordo
        this.audinterna = audinterna
        this.lide = lide
        this.avaliacaonota = avaliacaonota
        this.textoavaliacao = textoavaliacao
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (audinterna) 1231 else 1237
        result = prime * result + if (avaliacaonota == null) 0 else avaliacaonota.hashCode()
        result = prime * result + if (complemento == null) 0 else complemento.hashCode()
        result = prime * result + if (convolada) 1231 else 1237
        result = prime * result + if (dataconclusao == null) 0 else dataconclusao.hashCode()
        result = prime * result + if (dataprazo == null) 0 else dataprazo.hashCode()
        result = prime * result + if (datasolictacao == null) 0 else datasolictacao.hashCode()
        result = prime * result + if (emailenvio == null) 0 else emailenvio.hashCode()
        result = prime * result + if (enviosolicitacao == null) 0 else enviosolicitacao.hashCode()
        result = prime * result + if (grupo == null) 0 else grupo.hashCode()
        result = prime * result + if (horaudiencia == null) 0 else horaudiencia.hashCode()
        result = prime * result + if (idsolicitacao == null) 0 else idsolicitacao.hashCode()
        result = prime * result + if (instrucoes == null) 0 else instrucoes.hashCode()
        result = prime * result + if (justificativa == null) 0 else justificativa.hashCode()
        result = prime * result + if (lide == null) 0 else lide.hashCode()
        result = prime * result + if (numcontrole == null) 0 else numcontrole.hashCode()
        result = prime * result + if (observacao == null) 0 else observacao.hashCode()
        result = prime * result + if (pago == null) 0 else pago.hashCode()
        result = prime * result + if (propostaacordo) 1231 else 1237
        result = prime * result + if (referenciasolicitacao == null) 0 else referenciasolicitacao.hashCode()
        result = prime * result + if (statusexterno == null) 0 else statusexterno.hashCode()
        result = prime * result + if (tempreposto) 1231 else 1237
        result = prime * result + if (textoavaliacao == null) 0 else textoavaliacao.hashCode()
        result = prime * result + if (tratposaudiencia == null) 0 else tratposaudiencia.hashCode()
        result = prime * result + if (usuario == null) 0 else usuario.hashCode()
        result = prime * result + java.lang.Float.floatToIntBits(valor)
        result = prime * result + java.lang.Float.floatToIntBits(valordaalcada)
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Solicitacao
        if (audinterna != other.audinterna) return false
        if (avaliacaonota == null) {
            if (other.avaliacaonota != null) return false
        } else if (avaliacaonota != other.avaliacaonota) return false
        if (complemento == null) {
            if (other.complemento != null) return false
        } else if (complemento != other.complemento) return false
        if (convolada != other.convolada) return false
        if (dataconclusao == null) {
            if (other.dataconclusao != null) return false
        } else if (dataconclusao != other.dataconclusao) return false
        if (dataprazo == null) {
            if (other.dataprazo != null) return false
        } else if (dataprazo != other.dataprazo) return false
        if (datasolictacao == null) {
            if (other.datasolictacao != null) return false
        } else if (datasolictacao != other.datasolictacao) return false
        if (emailenvio == null) {
            if (other.emailenvio != null) return false
        } else if (emailenvio != other.emailenvio) return false
        if (enviosolicitacao == null) {
            if (other.enviosolicitacao != null) return false
        } else if (enviosolicitacao != other.enviosolicitacao) return false
        if (grupo == null) {
            if (other.grupo != null) return false
        } else if (grupo != other.grupo) return false
        if (horaudiencia == null) {
            if (other.horaudiencia != null) return false
        } else if (horaudiencia != other.horaudiencia) return false
        if (idsolicitacao == null) {
            if (other.idsolicitacao != null) return false
        } else if (idsolicitacao != other.idsolicitacao) return false
        if (instrucoes == null) {
            if (other.instrucoes != null) return false
        } else if (instrucoes != other.instrucoes) return false
        if (justificativa == null) {
            if (other.justificativa != null) return false
        } else if (justificativa != other.justificativa) return false
        if (lide == null) {
            if (other.lide != null) return false
        } else if (lide != other.lide) return false
        if (numcontrole == null) {
            if (other.numcontrole != null) return false
        } else if (numcontrole != other.numcontrole) return false
        if (observacao == null) {
            if (other.observacao != null) return false
        } else if (observacao != other.observacao) return false
        if (pago == null) {
            if (other.pago != null) return false
        } else if (pago != other.pago) return false
        if (propostaacordo != other.propostaacordo) return false
        if (referenciasolicitacao == null) {
            if (other.referenciasolicitacao != null) return false
        } else if (referenciasolicitacao != other.referenciasolicitacao) return false
        if (statusexterno == null) {
            if (other.statusexterno != null) return false
        } else if (statusexterno != other.statusexterno) return false
        if (tempreposto != other.tempreposto) return false
        if (textoavaliacao == null) {
            if (other.textoavaliacao != null) return false
        } else if (textoavaliacao != other.textoavaliacao) return false
        if (tratposaudiencia == null) {
            if (other.tratposaudiencia != null) return false
        } else if (tratposaudiencia != other.tratposaudiencia) return false
        if (usuario == null) {
            if (other.usuario != null) return false
        } else if (usuario != other.usuario) return false
        if (java.lang.Float.floatToIntBits(valor) != java.lang.Float.floatToIntBits(other.valor)) return false
        return java.lang.Float.floatToIntBits(valordaalcada) == java.lang.Float.floatToIntBits(other.valordaalcada)
    }

    override fun toString(): String {
        return ("Solicitacao [idsolicitacao=" + idsolicitacao + ", referenciasolicitacao=" + referenciasolicitacao
                + ", datasolictacao=" + datasolictacao + ", dataconclusao=" + dataconclusao + ", dataprazo=" + dataprazo
                + ", observacao=" + observacao + ", instrucoes=" + instrucoes + ", complemento=" + complemento
                + ", justificativa=" + justificativa + ", tratposaudiencia=" + tratposaudiencia + ", numcontrole="
                + numcontrole + ", tempreposto=" + tempreposto + ", convolada=" + convolada + ", horaudiencia="
                + horaudiencia + ", statusexterno=" + statusexterno + ", processo=" + processo + ", renumeracao="
                + renumeracao + ", statusSolicitacao=" + statusSolicitacao + ", comarca=" + comarca
                + ", formularioAudiencia=" + formularioAudiencia + ", bancaProcesso=" + bancaProcesso
                + ", enviosolicitacao=" + enviosolicitacao + ", reciboPagamento=" + reciboPagamento + ", usuario="
                + usuario + ", auditoriaInterna=" + auditoriaInterna + ", valor=" + valor + ", valordaalcada="
                + valordaalcada + ", emailenvio=" + emailenvio + ", pago=" + pago + ", grupo=" + grupo
                + ", propostaacordo=" + propostaacordo + ", audinterna=" + audinterna + ", lide=" + lide
                + ", avaliacaonota=" + avaliacaonota + ", textoavaliacao=" + textoavaliacao + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}