package br.entidades

import org.hibernate.validator.constraints.Email
import java.io.Serializable
import java.util.*
import javax.persistence.*
import lombok.Data

@Entity
@Table(name = "usuario")
@Data
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "sequsu", sequenceName = "idusuario")
class Usuario : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequsu")
    var idusuario: Int? = null
    var login: String? = null
    var senha: String? = null
    var nomecompleto: String? = null
    var emailprincipal: @Email String? = null
    var emailsecundario: @Email String? = null
    var emailresponsavel: @Email String? = null

    @OneToOne
    var correspondente: Correspondente? = null
    var tipo // 1-Adm, 2-Advgodado, 3-Correspondente
            : Int? = null

    @Temporal(TemporalType.TIMESTAMP)
    var dataentrada: Date? = null
    var ativo = false

    companion object {
        private const val serialVersionUID = 1L
    }
}