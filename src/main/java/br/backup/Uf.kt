package br.backup

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "uf")
@SequenceGenerator(name = "sequf", sequenceName = "sequf", initialValue = 1, allocationSize = 1)
class Uf : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequf")
    var iduf: Int? = null

    @Column(length = 2)
    var sigla: String? = null

    @Column(length = 60)
    var nome: String? = null

    constructor()
    constructor(iduf: Int?, sigla: String?, nome: String?) {
        this.iduf = iduf
        this.sigla = sigla
        this.nome = nome
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (iduf == null) 0 else iduf.hashCode()
        result = prime * result + if (nome == null) 0 else nome.hashCode()
        result = prime * result + if (sigla == null) 0 else sigla.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Uf
        if (iduf == null) {
            if (other.iduf != null) return false
        } else if (iduf != other.iduf) return false
        if (nome == null) {
            if (other.nome != null) return false
        } else if (nome != other.nome) return false
        if (sigla == null) {
            if (other.sigla != null) return false
        } else if (sigla != other.sigla) return false
        return true
    }

    override fun toString(): String {
        return "Uf [iduf=$iduf, sigla=$sigla, nome=$nome]"
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}