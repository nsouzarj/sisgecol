package br.entidades

import lombok.Data
import org.hibernate.validator.constraints.Email
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Data
@Entity
@Table(name = "usuario")
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "sequsu", sequenceName = "idusuario")
class Usuario : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequsu")
    var idusuario: Int? = null
    var login: String? = null
    var senha: String? = null
    var nomecompleto: String? = null
    var emailprincipal: @Email String? = null
    var emailsecundario: @Email String? = null
    var emailresponsavel: @Email String? = null

    @OneToOne
    var correspondente: Correspondente? = null
    var tipo // 1-Adm, 2-Advgodado, 3-Correspondente
            : Int? = null

    @Temporal(TemporalType.TIMESTAMP)
    var dataentrada: Date? = null
    var ativo = false

    companion object {
        private const val serialVersionUID = 1L
    }

     fun toTipo(): String{
        var tipotexto=""
        if(tipo==1){
           tipotexto ="Admin"
        }else if(tipo==2){
            tipotexto = "Advgoado"
        }else if(tipo==3){
            tipotexto ="Correspondente"
        }else if(tipo==4){ 
            tipotexto ="Estagiário" 
        }else {
            tipotexto ="Tipo Desconhecido"
        }
        return tipotexto 
    }
}