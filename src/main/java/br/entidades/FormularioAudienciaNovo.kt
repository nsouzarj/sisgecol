package br.entidades

import lombok.Data
import javax.persistence.*

@Entity(name = "formaudnovo")
@Data
@SequenceGenerator(name = "seqformnovo", sequenceName = "idformnovo", allocationSize = 1, initialValue = 1)
class FormularioAudienciaNovo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqformnovo")
    var idformnovo: Int? = null
    var assitidoadvogado //O autor est� assistido por por advogado
            = false
    var autorcompaudiencia //Autor compareceu a audiencia
            = false
    var encerrarformulario //Encerra o formualrio nao presente mas nada
            = false
    var telautor //Telefone do autor
            : String? = null
    var emaildoautor //Email do autor
            : String? = null
    var aijdesignada // Aij desiganda
            = false
    var acordorealizado //Acordo realizado
            = false
    var oabexadverso //Oab do exadverso
            : String? = null
    var telexadverso // Telefone do exaadverso
            : String? = null
    var emailexadverso //Email do exadverso
            : String? = null

  
}