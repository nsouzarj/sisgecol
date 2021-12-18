package br.entidades

import lombok.Data
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Data
@Entity
@Table(name = "auditoriainterna")
@SequenceGenerator(name = "seqaudiinterna", sequenceName = "idaudiinterna", allocationSize = 1, initialValue = 1)
class AuditoriaInterna : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqaudiinterna")
    var idaudiinterna: Int? = null
    var correpfezsub=false //Correspoendete se fez substituir = false
    var advogadosubs //Advogado substituto
            : String? = null
    var leuorientacao=false //Leu a orienta��o porra !! = false
    var conhecimentocaso=false //Correspondente  = false
    var duvpropacordo = false//D�vida no acordo = false
    var portdocumentacao = false//Portava documentacao = false
    var valorpropinicial=0 //valor da proposta inicial = 0f
    var notaavaliacao // Nota de avalaicao da audiencia
            : Int? = null

    @Column(length = 1000, columnDefinition = "Text")
    var avaliacao1 //Avaliacao 1
            : String? = null

    @Column(length = 1000, columnDefinition = "Text")
    var avaliacao2 //Avaliacao 2
            : String? = null

    @Temporal(TemporalType.TIMESTAMP)
    var dataauditoria: Date? = null
    companion object {
        private const val serialVersionUID = 1L
    }
}