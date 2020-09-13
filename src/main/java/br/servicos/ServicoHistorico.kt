package br.servicos

import br.entidades.Historico
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoHistorico {
    @Autowired
    private val entityManager: EntityManager? = null
    fun findAll(): List<Historico?> {
        return entityManager!!.createQuery("from Historico").resultList as List<Historico?>
    }

    fun findBuscaHistorico(idsolicitacao: Int): MutableList<Any?>? {
        return entityManager!!.createQuery("from Historico where solicitacao.idsolicitacao='$idsolicitacao'").resultList
    }

    fun save(hist: Historico): Historico {
        entityManager!!.transaction.begin()
        entityManager.persist(hist)
        entityManager.transaction.commit()
        return hist
    }
}