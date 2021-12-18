package br.entidades

import lombok.Data
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Data
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
    companion object {
        private const val serialVersionUID = 1L
    }
}