package br.entidades

import java.io.Serializable
import javax.persistence.*

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

    constructor()
    constructor(idbanco: Int?, codbanco: String?, agencia: String?,
                banco: String?, contacorrente: String?, correspondente: Correspondente?) {
        this.idbanco = idbanco
        this.codbanco = codbanco
        this.agencia = agencia
        this.banco = banco
        this.contacorrente = contacorrente
        this.correspondente = correspondente
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (agencia == null) 0 else agencia.hashCode()
        result = prime * result + if (banco == null) 0 else banco.hashCode()
        result = (prime * result
                + if (codbanco == null) 0 else codbanco.hashCode())
        result = (prime * result
                + if (contacorrente == null) 0 else contacorrente.hashCode())
        result = prime * result + if (idbanco == null) 0 else idbanco.hashCode()
        return result
    }

    /**
     * Aqui e os rescode
     */
    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Banco
        if (agencia == null) {
            if (other.agencia != null) return false
        } else if (agencia != other.agencia) return false
        if (banco == null) {
            if (other.banco != null) return false
        } else if (banco != other.banco) return false
        if (codbanco == null) {
            if (other.codbanco != null) return false
        } else if (codbanco != other.codbanco) return false
        if (contacorrente == null) {
            if (other.contacorrente != null) return false
        } else if (contacorrente != other.contacorrente) return false
        if (idbanco == null) {
            if (other.idbanco != null) return false
        } else if (idbanco != other.idbanco) return false
        return true
    }

    override fun toString(): String {
        return ("Banco [idbanco=" + idbanco + ", codbanco=" + codbanco
                + ", agencia=" + agencia + ", banco=" + banco
                + ", contacorrente=" + contacorrente + ", correspondente="
                + correspondente + "]")
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}