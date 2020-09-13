package br.backup

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "processo")
@SequenceGenerator(name = "seqprocesso", sequenceName = "idprocesso", allocationSize = 1, initialValue = 1)
class Processo : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqprocesso")
    var idprocesso: Int? = null
    var numeroprocesso: String? = null
    var numeroprocessopesq: String? = null
    var parte: String? = null
    var adverso: String? = null
    var posicao: String? = null
    var status: String? = null
    var cartorio: String? = null

    @Column(length = 600, columnDefinition = "Text")
    var assunto: String? = null
    var localizacao: String? = null
    var numerointegracao: String? = null

    @OneToOne(fetch = FetchType.EAGER)
    var comarca: Comarca? = null

    @OneToOne(fetch = FetchType.EAGER)
    var orgao: Orgao? = null
    var numorgao: Int? = null
    var proceletronico: String? = null
    var quantsoli: Int? = null

    @Transient
    private val totalfeita: Int? = null

    constructor()
    constructor(idprocesso: Int?, numeroprocesso: String?, parte: String?,
                adverso: String?, posicao: String?, status: String?, cartorio: String?,
                assunto: String?, localizacao: String?, numerointegracao: String?,
                comarca: Comarca?, orgao: Orgao?, numorgao: Int?,
                proceletronico: String?, quantsoli: Int?) {
        this.idprocesso = idprocesso
        this.numeroprocesso = numeroprocesso
        this.parte = parte
        this.adverso = adverso
        this.posicao = posicao
        this.status = status
        this.cartorio = cartorio
        this.assunto = assunto
        this.localizacao = localizacao
        this.numerointegracao = numerointegracao
        this.comarca = comarca
        this.orgao = orgao
        this.numorgao = numorgao
        this.proceletronico = proceletronico
        this.quantsoli = quantsoli
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (adverso == null) 0 else adverso.hashCode()
        result = prime * result + if (assunto == null) 0 else assunto.hashCode()
        result = (prime * result
                + if (cartorio == null) 0 else cartorio.hashCode())
        result = (prime * result
                + if (idprocesso == null) 0 else idprocesso.hashCode())
        result = (prime * result
                + if (localizacao == null) 0 else localizacao.hashCode())
        result = (prime
                * result
                + if (numerointegracao == null) 0 else numerointegracao.hashCode())
        result = (prime * result
                + if (numeroprocesso == null) 0 else numeroprocesso.hashCode())
        result = (prime
                * result
                + if (numeroprocessopesq == null) 0 else numeroprocessopesq
                .hashCode())
        result = (prime * result
                + if (numorgao == null) 0 else numorgao.hashCode())
        result = prime * result + if (parte == null) 0 else parte.hashCode()
        result = prime * result + if (posicao == null) 0 else posicao.hashCode()
        result = (prime * result
                + if (proceletronico == null) 0 else proceletronico.hashCode())
        result = (prime * result
                + if (quantsoli == null) 0 else quantsoli.hashCode())
        result = prime * result + if (status == null) 0 else status.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Processo
        if (adverso == null) {
            if (other.adverso != null) return false
        } else if (adverso != other.adverso) return false
        if (assunto == null) {
            if (other.assunto != null) return false
        } else if (assunto != other.assunto) return false
        if (cartorio == null) {
            if (other.cartorio != null) return false
        } else if (cartorio != other.cartorio) return false
        if (idprocesso == null) {
            if (other.idprocesso != null) return false
        } else if (idprocesso != other.idprocesso) return false
        if (localizacao == null) {
            if (other.localizacao != null) return false
        } else if (localizacao != other.localizacao) return false
        if (numerointegracao == null) {
            if (other.numerointegracao != null) return false
        } else if (numerointegracao != other.numerointegracao) return false
        if (numeroprocesso == null) {
            if (other.numeroprocesso != null) return false
        } else if (numeroprocesso != other.numeroprocesso) return false
        if (numeroprocessopesq == null) {
            if (other.numeroprocessopesq != null) return false
        } else if (numeroprocessopesq != other.numeroprocessopesq) return false
        if (numorgao == null) {
            if (other.numorgao != null) return false
        } else if (numorgao != other.numorgao) return false
        if (parte == null) {
            if (other.parte != null) return false
        } else if (parte != other.parte) return false
        if (posicao == null) {
            if (other.posicao != null) return false
        } else if (posicao != other.posicao) return false
        if (proceletronico == null) {
            if (other.proceletronico != null) return false
        } else if (proceletronico != other.proceletronico) return false
        if (quantsoli == null) {
            if (other.quantsoli != null) return false
        } else if (quantsoli != other.quantsoli) return false
        if (status == null) {
            if (other.status != null) return false
        } else if (status != other.status) return false
        return true
    }

    override fun toString(): String {
        return ("Processo [idprocesso=" + idprocesso + ", numeroprocesso="
                + numeroprocesso + ", numeroprocessopesq=" + numeroprocessopesq
                + ", parte=" + parte + ", adverso=" + adverso + ", posicao="
                + posicao + ", status=" + status + ", cartorio=" + cartorio
                + ", assunto=" + assunto + ", localizacao=" + localizacao
                + ", numerointegracao=" + numerointegracao + ", comarca="
                + comarca + ", orgao=" + orgao + ", numorgao=" + numorgao
                + ", proceletronico=" + proceletronico + ", quantsoli="
                + quantsoli + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}