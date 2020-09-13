package br.entidades

import java.io.Serializable
import javax.persistence.*

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

    constructor()
    constructor(idcomarca: Int?, nome: String?, uf: Uf?) {
        this.idcomarca = idcomarca
        this.nome = nome
        this.uf = uf
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = (prime * result
                + if (idcomarca == null) 0 else idcomarca.hashCode())
        result = prime * result + if (nome == null) 0 else nome.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Comarca
        if (idcomarca == null) {
            if (other.idcomarca != null) return false
        } else if (idcomarca != other.idcomarca) return false
        if (nome == null) {
            if (other.nome != null) return false
        } else if (nome != other.nome) return false
        return true
    }

    override fun toString(): String {
        return ("Comarca [idcomarca=" + idcomarca + ", nome=" + nome + ", uf="
                + uf + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}