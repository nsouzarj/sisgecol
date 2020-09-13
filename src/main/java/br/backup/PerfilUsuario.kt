package br.backup

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import javax.persistence.*

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

    constructor()
    constructor(idperfilusuario: Int?, perfil: String?, usuario: Usuario?) {
        this.idperfilusuario = idperfilusuario
        this.perfil = perfil
        this.usuario = usuario
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = (prime * result
                + if (idperfilusuario == null) 0 else idperfilusuario.hashCode())
        result = prime * result + if (perfil == null) 0 else perfil.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as PerfilUsuario
        if (idperfilusuario == null) {
            if (other.idperfilusuario != null) return false
        } else if (idperfilusuario != other.idperfilusuario) return false
        if (perfil == null) {
            if (other.perfil != null) return false
        } else if (perfil != other.perfil) return false
        return true
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}