package br.entidades

import lombok.Data
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "histarqcppro")
@Data
@SequenceGenerator(name = "seqhistcpro", sequenceName = "idarqcppro", allocationSize = 1, initialValue = 1)
class HistArqCpro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqhistcpro")
    var idarqcppro: Int? = null

    @OneToOne
    var solicitacaoAnexo: SolicitacaoAnexo? = null
    var idarquivocppro: Int? = null
    var salvoem: Date? = null

    
}