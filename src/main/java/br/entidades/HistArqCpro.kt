package br.entidades

import java.util.*
import javax.persistence.*
import lombok.Data

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