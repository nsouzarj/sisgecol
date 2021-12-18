package br.entidades

import lombok.Data
import java.io.Serializable
import javax.persistence.*

@Data
@Entity
@Table(name = "processo")
@SequenceGenerator(name = "seqprocesso", sequenceName = "idprocesso", allocationSize = 1, initialValue = 1)
class Processo : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqprocesso")
    var idprocesso: Int? = null
    var numeroprocesso: String? = null
    var numeroprocessopesq: String? = null
    var parte: String? = null
    var adverso: String? = null
    var posicao: String? = null
    var status: String? = null
    var cartorio: String? = null

    @Column(length = 600, columnDefinition = "Text")
    var assunto: String? = null
    var localizacao: String? = null
    var numerointegracao: String? = null

    @OneToOne(fetch = FetchType.EAGER)
    var comarca: Comarca? = null

    @OneToOne(fetch = FetchType.EAGER)
    var orgao: Orgao? = null
    var numorgao: Int? = null
    var proceletronico: String? = null
    var quantsoli: Int? = null

    @Transient
    private val totalfeita: Int? = null



    companion object {
        private const val serialVersionUID = 1L
    }
}