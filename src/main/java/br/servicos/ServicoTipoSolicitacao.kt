package br.servicos

import br.entidades.TipoSolicitacao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoTipoSolicitacao {
    @Autowired
    var entityManager: EntityManager? = null
    fun findAll(): List<TipoSolicitacao?> {
        return entityManager!!.createQuery("from TipoSolicitacao ").resultList as List<TipoSolicitacao?>
    }

    fun findOne(idtiposolicitacao: Int?): TipoSolicitacao {
        return entityManager!!.find(TipoSolicitacao::class.java, idtiposolicitacao)
    }

    fun save(post: TipoSolicitacao): TipoSolicitacao {
        entityManager!!.persist(post)
        return post
    }

    fun delete(post: TipoSolicitacao?) {
        entityManager!!.remove(post)
    }
}