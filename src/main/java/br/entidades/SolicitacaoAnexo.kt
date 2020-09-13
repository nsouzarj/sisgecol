package br.entidades

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "arquivosanexo")
@SequenceGenerator(name = "seqanexo", sequenceName = "idarquivoanexo", allocationSize = 1, initialValue = 1)
class SolicitacaoAnexo : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqanexo")
    var idarquivoanexo: Int? = null

    @Lob
    @Transient
    var arquivo: ByteArray=ByteArray(2014)
    var linkarquivo: String? = null
    var datasolicitacao: Date? = null
    var tipoarquivo: String? = null
    var nomearquivo: String? = null
    var operacao // Entrada ou Saida
            : String? = null
    var origemarq // 1 - Siegecol 2-Cprpo
            : Int? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "idusuario")
    var usuario: Usuario? = null

    constructor()
    constructor(idarquivoanexo: Int?, arquivo: ByteArray, linkarquivo: String?, datasolicitacao: Date?,
                tipoarquivo: String?, nomearquivo: String?, operacao: String?, origemarq: Int?, usuario: Usuario?) {
        this.idarquivoanexo = idarquivoanexo
        this.arquivo = arquivo
        this.linkarquivo = linkarquivo
        this.datasolicitacao = datasolicitacao
        this.tipoarquivo = tipoarquivo
        this.nomearquivo = nomearquivo
        this.operacao = operacao
        this.origemarq = origemarq
        this.usuario = usuario
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (datasolicitacao == null) 0 else datasolicitacao.hashCode()
        result = prime * result + if (idarquivoanexo == null) 0 else idarquivoanexo.hashCode()
        result = prime * result + if (linkarquivo == null) 0 else linkarquivo.hashCode()
        result = prime * result + if (nomearquivo == null) 0 else nomearquivo.hashCode()
        result = prime * result + if (operacao == null) 0 else operacao.hashCode()
        result = prime * result + if (origemarq == null) 0 else origemarq.hashCode()
        result = prime * result + if (tipoarquivo == null) 0 else tipoarquivo.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as SolicitacaoAnexo
        if (datasolicitacao == null) {
            if (other.datasolicitacao != null) return false
        } else if (datasolicitacao != other.datasolicitacao) return false
        if (idarquivoanexo == null) {
            if (other.idarquivoanexo != null) return false
        } else if (idarquivoanexo != other.idarquivoanexo) return false
        if (linkarquivo == null) {
            if (other.linkarquivo != null) return false
        } else if (linkarquivo != other.linkarquivo) return false
        if (nomearquivo == null) {
            if (other.nomearquivo != null) return false
        } else if (nomearquivo != other.nomearquivo) return false
        if (operacao == null) {
            if (other.operacao != null) return false
        } else if (operacao != other.operacao) return false
        if (origemarq == null) {
            if (other.origemarq != null) return false
        } else if (origemarq != other.origemarq) return false
        if (tipoarquivo == null) {
            if (other.tipoarquivo != null) return false
        } else if (tipoarquivo != other.tipoarquivo) return false
        return true
    }

    override fun toString(): String {
        return ("SolicitacaoAnexo [idarquivoanexo=" + idarquivoanexo + ", arquivo=" + Arrays.toString(arquivo)
                + ", linkarquivo=" + linkarquivo + ", datasolicitacao=" + datasolicitacao + ", tipoarquivo="
                + tipoarquivo + ", nomearquivo=" + nomearquivo + ", operacao=" + operacao + ", origemarq=" + origemarq
                + ", usuario=" + usuario + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}