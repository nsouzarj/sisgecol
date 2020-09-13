package br.servicos

import br.entidades.Usuario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ejb.access.EjbAccessException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoLogin {
    @Autowired
    private val entityManager: EntityManager? = null
    fun busca(emaiprincipal: String, senha: String?): Usuario? {
        try {
            var novo: Usuario? = null
            val usu = entityManager!!.createQuery("from Usuario where emailprincipal='$emaiprincipal'").singleResult as Usuario
            val valido = BCryptPasswordEncoder().matches(senha, usu.senha)
            if (valido == true) {
                novo = usu
                println("Anchou")
            } else {
                println("Não achou")
                novo = null
            }
            return novo
        } catch (e: EjbAccessException) {
            print("erro$e")
        }
        return null
    }
}