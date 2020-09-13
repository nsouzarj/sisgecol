package br.servicos

import br.entidades.EmailCorrespondente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoEmailCorrespondente {
    @Autowired
    private val entityManager: EntityManager? = null
    fun findAll(): List<EmailCorrespondente?> {
        return entityManager!!.createQuery("from EmailCorrespondente order by email")
                .resultList as List<EmailCorrespondente?>
    }

    fun buscaemail(idcorrespondente: Int): MutableList<Any?>? {
        return entityManager!!.createQuery("from EmailCorrespondente where correspondente.idcorrespondente = $idcorrespondente  order by email").resultList
    }
}