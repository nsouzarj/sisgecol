package br.entidades

import javax.persistence.*
import lombok.Data

/**
 * Classe de teste
 * @author Nelson
 */
@Entity
@Table(name = "envio")
@Data
@SequenceGenerator(name = "seqenvio", sequenceName = "idenvio", initialValue = 1, allocationSize = 1)
class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqenvio")
    var idenvio: Int? = null
    var descricao: String? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}