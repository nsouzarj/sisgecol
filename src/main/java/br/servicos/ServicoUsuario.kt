package br.servicos

import br.entidades.Usuario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoUsuario {
    @Autowired
    private val entityManager: EntityManager? = null
    fun findAll(): MutableList<Any?>? {
        return entityManager!!.createQuery("from Usuario where login is not null"
                + "  and ativo=true and tipo in (1,2,3) order by nomecompleto").resultList
    }

    fun findUsuariosLocais(): MutableList<Any?>? {
        return entityManager!!.createQuery("from Usuario where login is not null"
                + "  and ativo=true and tipo in (1,2) order by nomecompleto").resultList
    }

    fun findOne(idusuario: Int?): Usuario {
        return entityManager!!.find(Usuario::class.java, idusuario)
    }

    fun buscanome(emailprincipal: String): Usuario {
        val usu = entityManager!!.createQuery("from Usuario where emailprincipal=$emailprincipal").singleResult as Usuario
        System.out.printf("usuario $usu")
        return usu
    }

    fun save(usu: Usuario): Usuario {
        entityManager!!.transaction.begin()
        entityManager.persist(usu)
        entityManager.transaction.commit()
        return usu
    }

    fun delete(idusuario: Int?) {
        entityManager!!.transaction.begin()
        val usu = entityManager.find(Usuario::class.java, idusuario)
        entityManager.remove(usu)
        entityManager.transaction.commit()
    }

    fun update(idusuario: Int?): Usuario {
        entityManager!!.transaction.begin()
        val usu = entityManager.find(Usuario::class.java, idusuario)
        entityManager.merge(usu)
        entityManager.transaction.commit()
        return usu
    }
}