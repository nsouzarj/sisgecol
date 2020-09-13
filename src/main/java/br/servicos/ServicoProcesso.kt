package br.servicos

import br.entidades.Processo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoProcesso {
    @Autowired
    private val entityManager: EntityManager? = null
    fun findAll(): List<Processo?> {
        return entityManager!!.createQuery("from Processo where parte <> '' and idprocesso < 200 order by parte").resultList as List<Processo?>
    }

    fun findOne(idprocesso: Int?): Processo {
        return entityManager!!.find(Processo::class.java, idprocesso)
    }

    fun save(post: Processo): Processo {
        entityManager!!.transaction.begin()
        entityManager.persist(post)
        entityManager.transaction.commit()
        return post
    }

    fun delete(idprocesso: Int?) {
        entityManager!!.transaction.begin()
        val processo = entityManager.find(Processo::class.java, idprocesso)
        entityManager.remove(processo)
        entityManager.transaction.commit()
    }
}