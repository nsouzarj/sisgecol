package br.servicos

import br.entidades.Correspondente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoCorrespondente {
    @Autowired
    private val entityManager: EntityManager? = null
    fun findAll(): List<Correspondente?> {
        return entityManager!!.createQuery("from Correspondente order by nome").resultList as List<Correspondente?>
    }

    fun findOne(idcorrespondente: Int?): Correspondente {
        return entityManager!!.find(Correspondente::class.java, idcorrespondente)
    }

    fun save(cor: Correspondente): Correspondente {
        entityManager!!.transaction.begin()
        entityManager.persist(cor)
        entityManager.transaction.commit()
        return cor
    }

    fun delete(idcorrespondente: Int?) {
        entityManager!!.transaction.begin()
        val corr = entityManager.find(Correspondente::class.java, idcorrespondente)
        entityManager.remove(corr)
        entityManager.transaction.commit()
    }

    fun update(idcorrespondente: Int?): Correspondente {
        entityManager!!.transaction.begin()
        val corr = entityManager.find(Correspondente::class.java, idcorrespondente)
        entityManager.merge(corr)
        entityManager.transaction.commit()
        return corr
    }
}