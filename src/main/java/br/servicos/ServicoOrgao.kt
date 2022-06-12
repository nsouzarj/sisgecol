package br.servicos

import br.entidades.Orgao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoOrgao {
    @Autowired
    private val entityManager: EntityManager? = null

    @Autowired
    fun findAll(): MutableList<Any?>? {
        return entityManager!!.createQuery("from Orgao order by descricao").resultList
    }

    fun findById(id: Int): Any? {
        return entityManager!!.find(Orgao::class.java, id)
    }
    fun save(orgao: Orgao): Orgao {
        entityManager!!.persist(orgao)
        return orgao
    }
     fun update(orgao: Orgao): Orgao {
        entityManager!!.merge(orgao)
        return orgao
    }
    fun delete(orgao: Orgao) {
        entityManager!!.remove(orgao)

    }

}