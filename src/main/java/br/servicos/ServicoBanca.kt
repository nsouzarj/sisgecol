package br.servicos

import br.entidades.BancaProcesso
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoBanca {
    @Autowired
    private val entityManager: EntityManager? = null
    fun findAll(): List<BancaProcesso?> {
        return entityManager!!.createQuery("from BancaProcesso where email <>'' and emailgestordabanca <> '' order by banca").resultList as List<BancaProcesso?>
    }

    fun findOne(idbanca: Int?): BancaProcesso {
        return entityManager!!.find(BancaProcesso::class.java, idbanca)
    }

    fun save(post: BancaProcesso): BancaProcesso {
        entityManager!!.transaction.begin()
        entityManager.persist(post)
        entityManager.transaction.commit()
        return post
    }

    fun delete(idbanca: Int?) {
        entityManager!!.transaction.begin()
        val post = entityManager.find(BancaProcesso::class.java, idbanca)
        entityManager.remove(post)
        entityManager.transaction.commit()
    }

    fun post(post: BancaProcesso): BancaProcesso {
        entityManager!!.transaction.begin()
        entityManager.merge(post)
        entityManager.transaction.commit()
        return post
    }
}