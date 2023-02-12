package br.entidades

import lombok.Data
import org.hibernate.validator.constraints.Email
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "correspondente")
@Data
@SequenceGenerator(name = "seqcorrespondente", sequenceName = "idcorrespondente", allocationSize = 1, initialValue = 1)
class Correspondente : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqcorrespondente")
    var idcorrespondente: Int? = null
    var nome: String? = null
    var responsavel: String? = null
    var cpfcnpj: String? = null
    var oab: String? = null
    var tipocorrepondente: String? = null
    var telefoneprimario: String? = null
    var telefonesecundario: String? = null
    var telefonecelularprimario: String? = null
    var telefonecelularsecundario: String? = null
    var emailprimario: @Email String? = null
    var emailsecundario: @Email String? = null

    @Temporal(TemporalType.TIMESTAMP)
    var datacadastro: Date? = null
    var ativo = false
    var observacao: String? = null

    @OneToOne
    var enderecos: Endereco? = null
    var aplicaregra1 = false
    var aplicaregra2 = false

   
    companion object {
        private const val serialVersionUID = 1L
    }
}