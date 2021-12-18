package br.entidades

import lombok.Data
import java.io.Serializable
import javax.persistence.*
@Data
@Entity
@Table(name = "comarca")
@SequenceGenerator(name = "seqcomarca", sequenceName = "idcomarca", allocationSize = 1, initialValue = 1)
class Comarca : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqcomarca")
    var idcomarca: Int? = null
    var nome: String? = null

    @ManyToOne
    var uf: Uf? = null


    companion object {
        private const val serialVersionUID = 1L
    }
}