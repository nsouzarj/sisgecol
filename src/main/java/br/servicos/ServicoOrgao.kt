package br.servicos

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoOrgao {
    @Autowired
    private val entityManager: EntityManager? = null
    fun findAll(): MutableList<Any?>? {
        return entityManager!!.createQuery("from Orgao order by descricao").resultList
    }
}