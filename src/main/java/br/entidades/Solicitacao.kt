package br.entidades

import lombok.Data
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "solicitacao")
@Data
@SequenceGenerator(name = "seqsolicitacao", sequenceName = "idsolicitacao", allocationSize = 1, initialValue = 1)
class Solicitacao : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqsolicitacao")
    var idsolicitacao: Int? = null
    var referenciasolicitacao: Int? = null

    @Temporal(TemporalType.TIMESTAMP)
    var datasolictacao: Date? = null

    @Temporal(TemporalType.TIMESTAMP)
    var dataconclusao: Date? = null

    @Temporal(TemporalType.TIMESTAMP)
    var dataprazo: Date? = null

    @Column(length = 600, columnDefinition = "Text")
    var observacao: String? = null

    @Column(length = 600, columnDefinition = "Text")
    var instrucoes: String? = null

    @Column(length = 600, columnDefinition = "Text")
    var complemento: String? = null

    @Column(length = 600, columnDefinition = "Text")
    var justificativa: String? = null

    @Column(length = 600, columnDefinition = "Text")
    var tratposaudiencia //Tratamento pos audiencia
            : String? = null

    @Column(length = 30)
    var numcontrole: String? = null
    var tempreposto = false
    var convolada = false

    @Column(nullable = true, length = 10)
    var horaudiencia: String? = null

    @Column(nullable = true, length = 20)
    var statusexterno // CONFIRMAR - REJEITAR
            : String? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idprocesso")
    var processo: Processo? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idrenumeracao")
    var renumeracao: Renumeracao? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idstatus")
    var statusSolicitacao: StatusSolicitacao? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idcomarca") //@javax.validation.constraints.NotBlank
    //@Column(nullable=false)
    var comarca: Comarca? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idformulario")
    var formularioAudiencia: FormularioAudiencia? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idbanca") //@javax.validation.constraints.NotBlank
    var bancaProcesso: BancaProcesso? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idenviosolicitacao")
    var enviosolicitacao: Enviosolicitacao? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idrecibo")
    var reciboPagamento: ReciboPagamento? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idusuario")
    var usuario: Usuario? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "idaudiinterna")
    var auditoriaInterna: AuditoriaInterna? = null
    var valor = 0f
    var valordaalcada = 0f
    var emailenvio: String? = null
    var pago: String? = null
    var grupo: Int? = null

    @Column(nullable = true)
    var propostaacordo = false

    @Column(nullable = true)
    var audinterna = false

    @Column(length = 1)
    var lide: String? = null
    var avaliacaonota: Int? = null
    var textoavaliacao: String? = null

   
    companion object {
        private const val serialVersionUID = 1L
    }
}