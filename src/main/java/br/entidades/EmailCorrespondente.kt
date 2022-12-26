package br.entidades

import java.io.Serializable
import javax.persistence.*
import lombok.Data

@Entity
@Table(name = "emailscorrespondente")
@Data
@SequenceGenerator(initialValue = 1, name = "seqemail", sequenceName = "idemail", allocationSize = 1)
class EmailCorrespondente : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqemail")
    var idemail: Int? = null

    @Column(length = 100)
    var email: String? = null

    @ManyToOne
    var correspondente: Correspondente? = null


    companion object {
        private const val serialVersionUID = 1L
    }
}