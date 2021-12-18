package br.entidades

import lombok.Data
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import javax.persistence.*

@Data
@Entity
@Table(name = "perfilusuario")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "seqperfil", sequenceName = "idperfil")
class PerfilUsuario : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqperfil")
    var idperfilusuario: Int? = null
    var perfil: String? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "idusuario")
    var usuario: Usuario? = null
    companion object {
        private const val serialVersionUID = 1L
    }
}