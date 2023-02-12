package br.entidades

import lombok.Data
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "orgao")
@Data
@SequenceGenerator(name = "seqorgao", sequenceName = "idorgao", allocationSize = 1, initialValue = 1)
class Orgao : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqorgao")
    var idorgao: Int? = null

    @Column(length = 50)
    var descricao: String? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}