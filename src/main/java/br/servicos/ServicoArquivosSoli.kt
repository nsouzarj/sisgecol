package br.servicos

import br.entidades.SoliArquivo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ServicoArquivosSoli {
    @Autowired
    private val entityManager: EntityManager? = null
    fun findBuscaArquivos(idsolicitacao: Int): List<SoliArquivo?> {
        return entityManager!!.createQuery("from SoliArquivo  S where S.solicitacaoPossuiArquivo.solicitacao.idsolicitacao='$idsolicitacao'").resultList as List<SoliArquivo?>
    }

    /**
     * Exclui o arquivo da tabela
     */
    fun delete(idarquivoanexo: Int){
        entityManager!!.transaction.begin()
        val arquivo=entityManager.find(SoliArquivo::class.java,idarquivoanexo)
        entityManager.remove(arquivo)
        entityManager.transaction.commit()
    }
}