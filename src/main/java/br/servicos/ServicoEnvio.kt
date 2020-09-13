package br.servicos

import br.entidades.Envio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoEnvio {
    @Autowired
    private val entityManager: EntityManager? = null
    fun findAll(): List<Envio?> {
        return entityManager!!.createQuery("from Envio").resultList as List<Envio?>
    }

    fun findOne(idenvio: Int?): Envio {
        return entityManager!!.find(Envio::class.java, idenvio)
    }

    fun save(cor: Envio): Envio {
        entityManager!!.transaction.begin()
        entityManager.persist(cor)
        entityManager.transaction.commit()
        return cor
    }

    fun delete(idenvio: Int?) {
        entityManager!!.transaction.begin()
        val corr = entityManager.find(Envio::class.java, idenvio)
        entityManager.remove(corr)
        entityManager.transaction.commit()
    }

    fun update(idenvio: Int?): Envio {
        entityManager!!.transaction.begin()
        val corr = entityManager.find(Envio::class.java, idenvio)
        entityManager.merge(corr)
        entityManager.transaction.commit()
        return corr
    }
}