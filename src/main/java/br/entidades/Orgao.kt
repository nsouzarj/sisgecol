package br.entidades

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "orgao")
@SequenceGenerator(name = "seqorgao", sequenceName = "idorgao", allocationSize = 1, initialValue = 1)
class Orgao : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqorgao")
    var idorgao: Int? = null

    @Column(length = 50)
    var descricao: String? = null

    constructor()
    constructor(idorgao: Int?, descricao: String?) {
        this.idorgao = idorgao
        this.descricao = descricao
    }

    override fun toString(): String {
        return "Orgao [idorgao=$idorgao, descricao=$descricao]"
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}