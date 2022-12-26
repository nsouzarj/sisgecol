package br.entidades

import java.io.Serializable
import javax.persistence.*
import lombok.Data

@Entity
@Table(name = "comarca")
@Data
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