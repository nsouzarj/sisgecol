package br.entidades;

import lombok.Data
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "uf")
@Data
@SequenceGenerator(name = "sequf", sequenceName = "sequf", initialValue = 1, allocationSize = 1)
class Uf : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequf")
    var iduf: Int? = null

    @Column(length = 2)
    var sigla: String? = null

    @Column(length = 60)
    var nome: String? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}