package br.servicos

import br.entidades.ComarcaPossui
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoComarcaPossui {
    @Autowired
    private val entityManager: EntityManager? = null
    fun findByid(idcorrespondente: Int?): MutableList<Any?>? {
        return entityManager!!.createQuery("from ComarcaPossui S where S.comarcaCorrespondente.correspondente.idcorrespondente=?1")
                .setParameter(1, idcorrespondente).resultList
    }

    fun salvar(comarcaPossui: ComarcaPossui): ComarcaPossui {
        entityManager!!.transaction.begin()
        entityManager.persist(comarcaPossui)
        entityManager.transaction.commit()
        return comarcaPossui
    }

    fun excluir(comarcaPossui: ComarcaPossui?) {
        entityManager!!.transaction.begin()
        entityManager.remove(comarcaPossui)
        entityManager.transaction.commit()
    }
}