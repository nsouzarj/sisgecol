package br.servicos

import br.entidades.Comarca
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.EntityTransaction


/**
Classe de servico comarca
 */

@Service
 open class ServicoComarca {
     @Autowired
     var emf: EntityManagerFactory? = null
     @Autowired
     var entityManager: EntityManager? = emf?.createEntityManager()




    @Override

    fun findAll(): List<Comarca>? {

        return entityManager?.createQuery("from Comarca where uf.iduf > 0 order by nome")?.resultList as List<Comarca>?
    }
    /**
    
    Busca por estado
     */

    fun buscaEstado(iduf: Int): List<Comarca?>? {

        return entityManager!!.createQuery("from Comarca where uf.iduf='$iduf' order by nome").resultList as? List<Comarca?>?

    }
    /**
    Busca uma comarca
     */
    fun findOne(idcomarca: Int?): Comarca {
        return entityManager!!.find(Comarca::class.java, idcomarca)
    }
    /**
     Deleta a comarca
     */
    fun delete(idcomarca: Int?) {

        var perssitencia:EntityManager=emf!!.createEntityManager()
        var  trassacao: EntityTransaction = perssitencia.transaction
        trassacao.begin()
        var com= perssitencia.find(Comarca::class.java, idcomarca)
        perssitencia.remove(com)
        trassacao.commit()
        perssitencia.close()
    }
    /**Altera a
      comarca    
     */

    fun update(idcomarca: Int?) {
        var perssitencia:EntityManager=emf!!.createEntityManager()
        var  trassacao: EntityTransaction = perssitencia.transaction
        trassacao.begin()
        var com= perssitencia.find(Comarca::class.java, idcomarca)
        perssitencia.merge(com)
        trassacao.commit()
        perssitencia.close()
    }
    /**
    Salva a comarca
     */

     @Override

     open fun salvar(comarca: Comarca) {

      var perssitencia:EntityManager=emf!!.createEntityManager()
      var  trassacao: EntityTransaction = perssitencia.transaction
        trassacao.begin()
        perssitencia.persist(comarca)
        trassacao.commit()
        perssitencia.close()

    }


}