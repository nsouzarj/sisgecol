package br.entidades

import lombok.Data
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
@Data
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

    companion object {
        private const val serialVersionUID = 1L
    }
}