package br.entidades

import javax.persistence.*

/**
 * Classe de teste
 * @author Nelson
 */
@Entity
@Table(name = "envio")
@SequenceGenerator(name = "seqenvio", sequenceName = "idenvio", initialValue = 1, allocationSize = 1)
class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqenvio")
    var idenvio: Int? = null
    var descricao: String? = null

    constructor()
    constructor(idenvio: Int?, descricao: String?) {
        this.idenvio = idenvio
        this.descricao = descricao
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = (prime * result
                + if (descricao == null) 0 else descricao.hashCode())
        result = prime * result + if (idenvio == null) 0 else idenvio.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Envio
        if (descricao == null) {
            if (other.descricao != null) return false
        } else if (descricao != other.descricao) return false
        if (idenvio == null) {
            if (other.idenvio != null) return false
        } else if (idenvio != other.idenvio) return false
        return true
    }

    override fun toString(): String {
        return "Envio [idenvio=$idenvio, descricao=$descricao]"
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}