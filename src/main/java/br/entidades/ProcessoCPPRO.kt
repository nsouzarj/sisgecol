/**
 *
 */
package br.entidades

import java.io.Serializable
import javax.persistence.*
import lombok.Data

/**
 * @author nelson
 * Esta tabela guarda os processo do cprpo que ficam armazenado em planilha
 */
@Entity
@Table(name = "processocppro")
@Data
@SequenceGenerator(name = "seqprocessocppro", sequenceName = "idprocessocppro", allocationSize = 1, initialValue = 1)
class ProcessoCPPRO : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqprocessocppro")
    var idprocessocppro: Int? = null
    var numprocesso: String? = null
    var cliente: String? = null
    var orgaoinicial: String? = null
    var partecontraria: String? = null

    @Column(length = 600, columnDefinition = "Text")
    var acao: String? = null
    var localizador: String? = null
    var eletronico: String? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}