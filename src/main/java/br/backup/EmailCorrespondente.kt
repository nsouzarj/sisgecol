package br.backup

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "emailscorrespondente")
@SequenceGenerator(initialValue = 1, name = "seqemail", sequenceName = "idemail", allocationSize = 1)
class EmailCorrespondente : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqemail")
    var idemail: Int? = null

    @Column(length = 100)
    var email: String? = null

    @ManyToOne
    var correspondente: Correspondente? = null

    constructor()
    constructor(idemail: Int?, email: String?,
                correspondente: Correspondente?) {
        this.idemail = idemail
        this.email = email
        this.correspondente = correspondente
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (email == null) 0 else email.hashCode()
        result = prime * result + if (idemail == null) 0 else idemail.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as EmailCorrespondente
        if (email == null) {
            if (other.email != null) return false
        } else if (email != other.email) return false
        if (idemail == null) {
            if (other.idemail != null) return false
        } else if (idemail != other.idemail) return false
        return true
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}