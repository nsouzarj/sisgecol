package br.entidades

import lombok.Data
import java.io.Serializable
import javax.persistence.*
@Data
@Entity
@Table(name = "banco")
@SequenceGenerator(name = "seqbanco", sequenceName = "idbanco", allocationSize = 1, initialValue = 1)
class Banco : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqbanco")
    var idbanco: Int? = null
    var codbanco: String? = null
    var agencia: String? = null
    var banco: String? = null
    var contacorrente: String? = null

    @ManyToOne
    var correspondente: Correspondente? = null


    companion object {
        private const val serialVersionUID = 1L
    }


    override fun toString(): String {
        return "Banco(idbanco=$idbanco, codbanco=$codbanco, agencia=$agencia, banco=$banco, contacorrente=$contacorrente, correspondente=$correspondente)"
    }



}