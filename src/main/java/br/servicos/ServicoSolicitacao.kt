package br.servicos
import br.entidades.Solicitacao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.EntityTransaction


@Service
class ServicoSolicitacao {
    @Autowired
     var emf: EntityManagerFactory? = null
     @Autowired
     var entityManager: EntityManager? = emf?.createEntityManager()
   
    fun findAll(page:Int,max:Int): List<Solicitacao?> {
        return entityManager!!.createQuery("from Solicitacao  order by idsolicitacao desc").setFirstResult(page).setMaxResults(max).resultList as List<Solicitacao?>
    }

    fun findById(idsolicitacao: Int?): Solicitacao {
        return entityManager!!.find(Solicitacao::class.java, idsolicitacao)
    }

    /**
     * Salva a solicitacao
     * @param post
     * @return
     */
    fun save(solicitacao: Solicitacao): Solicitacao {
        var perssitencia:EntityManager=emf!!.createEntityManager()
        var  trassacao: EntityTransaction = perssitencia.transaction
        trassacao.begin()
        perssitencia.persist(solicitacao)
        trassacao.commit()
        perssitencia.close()
        return solicitacao
    }

    /**
     * Deleta a spolicitacao
     * @param idsolicitacao
     */
    fun delete(idsolicitacao: Int?) {
     var perssitencia:EntityManager=emf!!.createEntityManager()
        var  trassacao: EntityTransaction = perssitencia.transaction
        trassacao.begin()
        var solicitacao= perssitencia.find(Solicitacao::class.java, idsolicitacao)
        perssitencia.remove(solicitacao)
        trassacao.commit()
        perssitencia.close()
    }   

    /**
     * Aletra a solitcitacacao
     * @param idsolicitacao
     * @return
     */
    fun update(idsolicitacao: Int?): Solicitacao {
        var perssitencia:EntityManager=emf!!.createEntityManager()
        var  trassacao: EntityTransaction = perssitencia.transaction
        trassacao.begin()
        var solicitacao= perssitencia.find(Solicitacao::class.java, idsolicitacao)
        perssitencia.merge(solicitacao)
        trassacao.commit()
        perssitencia.close()
        return solicitacao
    }
}