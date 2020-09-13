package br.servicos

import br.entidades.Uf
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager


@Service
class ServicoUf {
    @Autowired
    private val entityManager: EntityManager? = null
    fun findAll(): List<Uf?> {
        return entityManager!!.createQuery("from Uf order by nome").resultList as List<Uf?>
    }

    fun findOne(iduf: Int?): Uf {
        return entityManager!!.find(Uf::class.java, iduf)
    }

    fun save(uf: Uf): Uf {
        entityManager!!.transaction.begin()
        entityManager.persist(uf)
        entityManager.transaction.commit()
        return uf
    }

    fun delete(iduf: Int?) {
        entityManager!!.transaction.begin()
        val uf = entityManager.find(Uf::class.java, iduf)
        entityManager.remove(uf)
        entityManager.transaction.commit()
    }

    fun update(iduf: Int?): Uf {
        entityManager!!.transaction.begin()
        val uf = entityManager.find(Uf::class.java, iduf)
        entityManager.merge(uf)
        entityManager.transaction.commit()
        return uf
    }
}