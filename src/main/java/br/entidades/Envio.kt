package br.entidades

import lombok.Data
import javax.persistence.*

/**
 * Classe de teste
 * @author Nelson
 */
@Data
@Entity
@Table(name = "envio")
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