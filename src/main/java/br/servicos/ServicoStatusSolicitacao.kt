package br.servicos

import br.entidades.StatusSolicitacao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoStatusSolicitacao {
    @Autowired
    private val entityManager: EntityManager? = null
    fun findAll(): List<StatusSolicitacao?> {
        return entityManager!!.createQuery("from StatusSolicitacao").resultList as List<StatusSolicitacao?>
    }

    fun buscar(idstatus: Int?): StatusSolicitacao {
        return entityManager!!.find(StatusSolicitacao::class.java, idstatus)
    }
}