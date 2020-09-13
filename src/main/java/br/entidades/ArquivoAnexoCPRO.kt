package br.entidades

import java.io.Serializable
import java.sql.Timestamp

/**
 * Arquivos do cpro
 *
 * @author Nelson
 */
class ArquivoAnexoCPRO : Serializable {
    var idarquivo: Int? = null
    var idcontexto: Int? = null
    var pastaDoProcesso: String? = null
    var nomeDocumento: String? = null
    var caminhoGed: String? = null
    var anexadoPor: String? = null
    var tipoDocumento: String? = null
    var descricao: String? = null
    var anexadoEm: Timestamp? = null
    var rejeitado = false
    var motivodarejeicao: String? = null

    constructor()
    constructor(idArquivo: Int?, idContexto: Int?, pastaDoProcesso: String?, nomeDocumento: String?,
                caminhoGed: String?, anexadoPor: String?, tipoDocumento: String?, descricao: String?, anexadoEm: Timestamp?,
                rejeitado: Boolean, motivodarejeicao: String?) : super() {
        this.idarquivo = idArquivo
        this.idcontexto = idContexto
        this.pastaDoProcesso = pastaDoProcesso
        this.nomeDocumento = nomeDocumento
        this.caminhoGed = caminhoGed
        this.anexadoPor = anexadoPor
        this.tipoDocumento = tipoDocumento
        this.descricao = descricao
        this.anexadoEm = anexadoEm
        this.rejeitado = rejeitado
        this.motivodarejeicao = motivodarejeicao
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (anexadoEm == null) 0 else anexadoEm.hashCode()
        result = prime * result + if (anexadoPor == null) 0 else anexadoPor.hashCode()
        result = prime * result + if (caminhoGed == null) 0 else caminhoGed.hashCode()
        result = prime * result + if (descricao == null) 0 else descricao.hashCode()
        result = prime * result + if (nomeDocumento == null) 0 else nomeDocumento.hashCode()
        result = prime * result + if (pastaDoProcesso == null) 0 else pastaDoProcesso.hashCode()
        result = prime * result + if (tipoDocumento == null) 0 else tipoDocumento.hashCode()
        result = prime * result + if (idarquivo == null) 0 else idarquivo.hashCode()
        result = prime * result + if (idcontexto == null) 0 else idcontexto.hashCode()
        result = prime * result + if (motivodarejeicao == null) 0 else motivodarejeicao.hashCode()
        result = prime * result + if (rejeitado) 1231 else 1237
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as ArquivoAnexoCPRO
        if (anexadoEm == null) {
            if (other.anexadoEm != null) return false
        } else if (!anexadoEm!!.equals(other.anexadoEm)) return false
        if (anexadoPor == null) {
            if (other.anexadoPor != null) return false
        } else if (anexadoPor != other.anexadoPor) return false
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
        if (idarquivo == null) {
            if (other.idarquivo != null) return false
        } else if (idarquivo != other.idarquivo) return false
        if (idcontexto == null) {
            if (other.idcontexto != null) return false
        } else if (idcontexto != other.idcontexto) return false
        if (motivodarejeicao == null) {
            if (other.motivodarejeicao != null) return false
        } else if (motivodarejeicao != other.motivodarejeicao) return false
        return rejeitado == other.rejeitado
    }

    override fun toString(): String {
        return ("ArquivoAnexoCPRO [idArquivo=" + idarquivo + ", idContexto=" + idcontexto + ", PastaDoProcesso="
                + pastaDoProcesso + ", NomeDocumento=" + nomeDocumento + ", CaminhoGed=" + caminhoGed + ", AnexadoPor="
                + anexadoPor + ", TipoDocumento=" + tipoDocumento + ", Descricao=" + descricao + ", AnexadoEm="
                + anexadoEm + ", rejeitado=" + rejeitado + ", motivodarejeicao=" + motivodarejeicao + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}