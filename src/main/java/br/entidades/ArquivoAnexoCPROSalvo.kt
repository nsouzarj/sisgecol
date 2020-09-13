package br.entidades

import java.io.Serializable
import java.util.*
import javax.persistence.*

/**
 * Arquivos do cpro
 *
 * @author Nelson
 * Esta classe e a tabela dos arquivos salos do cppro
 */
@Entity
@Table(name = "anexocprosalvo")
@SequenceGenerator(name = "seqcprposalvo", sequenceName = "idarqcpprosalvo", allocationSize = 1, initialValue = 1)
class ArquivoAnexoCPROSalvo : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqcprposalvo")
    var idarqcpprosalvo: Int? = null
    var idarquivo: Int? = null
    var idcontexto: Int? = null
    var idsolicitacao: Int? = null
    var pastaDoProcesso: String? = null
    var nomeDocumento: String? = null
    var caminhoGed: String? = null
    var anexadoPor: String? = null
    var tipoDocumento: String? = null
    var descricao: String? = null
    var anexadoEm: Date? = null
    var baixadoEm: Date? = null
    var baixado = false
    var rejeitado = false
    var rejeitadopor //N�o tem funcionalidade
            : Usuario? = null
    var datareijeicao: Date? = null

    @Column(columnDefinition = "TEXT")
    var motivodarejeicao: String? = null

    constructor()
    constructor(idarqcpprosalvo: Int?, idArquivo: Int?, idContexto: Int?, idsolicitacao: Int?,
                pastaDoProcesso: String?, nomeDocumento: String?, caminhoGed: String?, anexadoPor: String?, tipoDocumento: String?,
                descricao: String?, anexadoEm: Date?, baixadoEm: Date?, baixado: Boolean, rejeitado: Boolean, rejeitadopor: Usuario?,
                datareijeicao: Date?, motivodarejeicao: String?) : super() {
        this.idarqcpprosalvo = idarqcpprosalvo
        this.idarquivo = idArquivo
        this.idcontexto = idContexto
        this.idsolicitacao = idsolicitacao
        this.pastaDoProcesso = pastaDoProcesso
        this.nomeDocumento = nomeDocumento
        this.caminhoGed = caminhoGed
        this.anexadoPor = anexadoPor
        this.tipoDocumento = tipoDocumento
        this.descricao = descricao
        this.anexadoEm = anexadoEm
        this.baixadoEm = baixadoEm
        this.baixado = baixado
        this.rejeitado = rejeitado
        this.rejeitadopor = rejeitadopor
        this.datareijeicao = datareijeicao
        this.motivodarejeicao = motivodarejeicao
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (anexadoEm == null) 0 else anexadoEm.hashCode()
        result = prime * result + if (anexadoPor == null) 0 else anexadoPor.hashCode()
        result = prime * result + if (baixadoEm == null) 0 else baixadoEm.hashCode()
        result = prime * result + if (caminhoGed == null) 0 else caminhoGed.hashCode()
        result = prime * result + if (descricao == null) 0 else descricao.hashCode()
        result = prime * result + if (nomeDocumento == null) 0 else nomeDocumento.hashCode()
        result = prime * result + if (pastaDoProcesso == null) 0 else pastaDoProcesso.hashCode()
        result = prime * result + if (tipoDocumento == null) 0 else tipoDocumento.hashCode()
        result = prime * result + if (baixado) 1231 else 1237
        result = prime * result + if (datareijeicao == null) 0 else datareijeicao.hashCode()
        result = prime * result + if (idarquivo == null) 0 else idarquivo.hashCode()
        result = prime * result + if (idcontexto == null) 0 else idcontexto.hashCode()
        result = prime * result + if (idarqcpprosalvo == null) 0 else idarqcpprosalvo.hashCode()
        result = prime * result + if (idsolicitacao == null) 0 else idsolicitacao.hashCode()
        result = prime * result + if (motivodarejeicao == null) 0 else motivodarejeicao.hashCode()
        result = prime * result + if (rejeitado) 1231 else 1237
        result = prime * result + if (rejeitadopor == null) 0 else rejeitadopor.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as ArquivoAnexoCPROSalvo
        if (anexadoEm == null) {
            if (other.anexadoEm != null) return false
        } else if (anexadoEm != other.anexadoEm) return false
        if (anexadoPor == null) {
            if (other.anexadoPor != null) return false
        } else if (anexadoPor != other.anexadoPor) return false
        if (baixadoEm == null) {
            if (other.baixadoEm != null) return false
        } else if (baixadoEm != other.baixadoEm) return false
        if (caminhoGed == null) {
            if (other.caminhoGed != null) return false
        } else if (caminhoGed != other.caminhoGed) return false
        if (descricao == null) {
            if (other.descricao != null) return false
        } else if (descricao != other.descricao) return false
        if (nomeDocumento == null) {
            if (other.nomeDocumento != null) return false
        } else if (nomeDocumento != other.nomeDocumento) return false
        if (pastaDoProcesso == null) {
            if (other.pastaDoProcesso != null) return false
        } else if (pastaDoProcesso != other.pastaDoProcesso) return false
        if (tipoDocumento == null) {
            if (other.tipoDocumento != null) return false
        } else if (tipoDocumento != other.tipoDocumento) return false
        if (baixado != other.baixado) return false
        if (datareijeicao == null) {
            if (other.datareijeicao != null) return false
        } else if (datareijeicao != other.datareijeicao) return false
        if (idarquivo == null) {
            if (other.idarquivo != null) return false
        } else if (idarquivo != other.idarquivo) return false
        if (idcontexto == null) {
            if (other.idcontexto != null) return false
        } else if (idcontexto != other.idcontexto) return false
        if (idarqcpprosalvo == null) {
            if (other.idarqcpprosalvo != null) return false
        } else if (idarqcpprosalvo != other.idarqcpprosalvo) return false
        if (idsolicitacao == null) {
            if (other.idsolicitacao != null) return false
        } else if (idsolicitacao != other.idsolicitacao) return false
        if (motivodarejeicao == null) {
            if (other.motivodarejeicao != null) return false
        } else if (motivodarejeicao != other.motivodarejeicao) return false
        if (rejeitado != other.rejeitado) return false
        if (rejeitadopor == null) {
            if (other.rejeitadopor != null) return false
        } else if (rejeitadopor != other.rejeitadopor) return false
        return true
    }

    override fun toString(): String {
        return ("ArquivoAnexoCPROSalvo [idarqcpprosalvo=" + idarqcpprosalvo + ", idArquivo=" + idarquivo
                + ", idContexto=" + idcontexto + ", idsolicitacao=" + idsolicitacao + ", PastaDoProcesso="
                + pastaDoProcesso + ", NomeDocumento=" + nomeDocumento + ", CaminhoGed=" + caminhoGed + ", AnexadoPor="
                + anexadoPor + ", TipoDocumento=" + tipoDocumento + ", Descricao=" + descricao + ", AnexadoEm="
                + anexadoEm + ", BaixadoEm=" + baixadoEm + ", baixado=" + baixado + ", rejeitado=" + rejeitado
                + ", rejeitadopor=" + rejeitadopor + ", datareijeicao=" + datareijeicao + ", motivodarejeicao="
                + motivodarejeicao + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}