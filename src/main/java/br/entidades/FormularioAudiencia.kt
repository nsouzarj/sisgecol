package br.entidades

import lombok.Data
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "formularioaudiencia")
@Data
@SequenceGenerator(name = "seqformulario", sequenceName = "idformulario", allocationSize = 1, initialValue = 1)
class FormularioAudiencia : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqformulario")
    var idformulario: Int? = null
    var nomeadvogado: String? = null
    var numoab: String? = null
    var telefoneadvogado: String? = null
    var advogadoadverso: String? = null
    var numoabadverso: String? = null
    var telefoneadvadervoso: String? = null
    var emailadvadverso: String? = null
    var defesagenerica = false
    var contraproposta = false
    var aijdesiginada = false
    var dataaij: Date? = null
    var valorproposta = 0.0
    var valorcontraproposta = 0.0

    @Column(length = 1000, columnDefinition = "Text")
    var obrigacaoafazer: String? = null

    @Column(length = 1000, columnDefinition = "Text")
    var informecontraproposta: String? = null

    @Column(length = 1000, columnDefinition = "Text")
    var objetodalide: String? = null

    @Column(length = 1000, columnDefinition = "Text")
    var estrategiadefesa: String? = null

    @Column(length = 1000, columnDefinition = "Text")
    var informeacontecimento: String? = null
    var nivel: Int? = null
    var dataformulario: Date? = null
    var acordorealizado = false
    var valoracordo = 0.0

    companion object {
        private const val serialVersionUID = 1L
    }
}