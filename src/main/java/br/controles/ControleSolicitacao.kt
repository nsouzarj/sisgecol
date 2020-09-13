package br.controles

import br.entidades.Comarca
import br.entidades.Solicitacao
import br.servicos.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.config.annotation.CorsRegistry

@Controller
@CrossOrigin(origins = ["*"], maxAge = 3600)
class ControleSolicitacao {
    fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").exposedHeaders("*").allowedMethods("*")
                .allowCredentials(true).maxAge(3600)
        registry.addMapping("/resources/**").allowedOrigins("*").allowedHeaders("*").exposedHeaders("*").allowedMethods("*")
                .allowCredentials(true).maxAge(3600)
    }

    @Autowired
    private val servicoSolicitacao: ServicoSolicitacao? = null

    @Autowired
    private val servicoUf: ServicoUf? = null

    @Autowired
    private val servicoComarca: ServicoComarca? = null

    @Autowired
    private val servicoBanca: ServicoBanca? = null

    @Autowired
    private val servicoCorrespondente: ServicoCorrespondente? = null

    @Autowired
    private val servicoUsuario: ServicoUsuario? = null

    @Autowired
    private val servicoComarcaPossui: ServicoComarcaPossui? = null

    @Autowired
    private val servicoTipoSolicitacao: ServicoTipoSolicitacao? = null

    @Autowired
    private val servicoStatusSolicitacao: ServicoStatusSolicitacao? = null

    @Autowired
    private val servicoLogin: ServicoLogin? = null

    @Autowired
    private val servicoProcesso: ServicoProcesso? = null

    @Autowired
    private val servicoOrgao: ServicoOrgao? = null

    @Autowired
    private val servicoHistorico: ServicoHistorico? = null

    @Autowired
    private val servicoArquivos: ServicoArquivosSoli? = null

    @Autowired
    private val servicoEmailCorrespondente: ServicoEmailCorrespondente? = null

    @Autowired
    private val servicoEnvio: ServicoEnvio? = null

    /**
     * CAdastro de usuarios
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = [RequestMethod.GET], value = ["/solicitacoes"])
    fun BuscaSolicitacoes(): ModelAndView {
        val solicitacoes = servicoSolicitacao!!.findAll()
        val correspondentes = servicoCorrespondente!!.findAll()
        val comarcas = servicoComarca!!.findAll()
        val status = servicoStatusSolicitacao!!.findAll()
        val orgaos = servicoOrgao!!.findAll()
        val banca = servicoBanca!!.findAll()
        val usuario = servicoUsuario!!.findUsuariosLocais()
        val mv = ModelAndView("paginas/solicitacao/solicitacoes")
        mv.addObject("solicitacoes", solicitacoes)
        mv.addObject("correspondentes", correspondentes)
        mv.addObject("comarcas", comarcas)
        mv.addObject("status", status)
        mv.addObject("orgaos", orgaos)
        mv.addObject("bancas", banca)
        mv.addObject("usuarios", usuario)
        return mv
    }

    /**
     * Busca unica Solcita~ao
     */
    @CrossOrigin
    @RequestMapping(method = [RequestMethod.GET], value = ["/solicitacao/{idsolicitacao}"])
    fun BuscaUnicaSolictacao(@PathVariable("idsolicitacao") idsolicitacao: Int): ModelAndView {
        val solicitacoUnica = servicoSolicitacao!!.findById(idsolicitacao)
        val correspondentes = servicoCorrespondente!!.findAll()
        val comarcas = servicoComarca!!.findAll()
        val status = servicoStatusSolicitacao!!.findAll()
        val orgaos = servicoOrgao!!.findAll()
        val banca = servicoBanca!!.findAll()
        val usuario = servicoUsuario!!.findUsuariosLocais()
        val historico = servicoHistorico!!.findBuscaHistorico(idsolicitacao)
        val arquivo = servicoArquivos!!.findBuscaArquivos(idsolicitacao)
        val mv = ModelAndView("paginas/solicitacao/cadastro")
        mv.addObject("soliunica", solicitacoUnica)
        mv.addObject("correspondentes", correspondentes)
        mv.addObject("comarcas", comarcas)
        mv.addObject("status", status)
        mv.addObject("orgaos", orgaos)
        mv.addObject("bancas", banca)
        mv.addObject("usuarios", usuario)
        mv.addObject("historico", historico)
        mv.addObject("arquivo", arquivo)
        return mv
    }

    /**
     * Nova Solicitacao
     */
    @CrossOrigin
    @RequestMapping(method = [RequestMethod.GET], value = ["/novasolicitacao"])
    fun NovaSolictacao(): ModelAndView {
        val novaSolcitacao = Solicitacao()
        val correspondentes = servicoCorrespondente!!.findAll()
        val estados = servicoUf!!.findAll()
        val comarcas = servicoComarca!!.findAll()
        val status = servicoStatusSolicitacao!!.findAll()
        val orgaos = servicoOrgao!!.findAll()
        val banca = servicoBanca!!.findAll()
        val email = servicoEmailCorrespondente!!.findAll()
        val tiposoli = servicoTipoSolicitacao!!.findAll()
        val enviode = servicoEnvio!!.findAll()
        // @formatter:on
        val mv = ModelAndView("paginas/solicitacao/novasolicitacao")
        mv.addObject("novasolictacao", novaSolcitacao)
        mv.addObject("correspondente", correspondentes)
        mv.addObject("comarcas", comarcas)
        mv.addObject("status", status)
        mv.addObject("orgaos", orgaos)
        mv.addObject("bancas", banca)
        mv.addObject("estados", estados)
        mv.addObject("email", email)
        mv.addObject("tiposoli", tiposoli)
        mv.addObject("enviode", enviode)
        //mv.addObject("usuarios", usuario);
        //mv.addObject("historico", historico);
        //mv.addObject("arquivo", arquivo);
        return mv
    }

    /**
     * Altera solicitacao
     */
    @CrossOrigin
    @RequestMapping(method = [RequestMethod.GET], value = ["/alterarsolicitacao/{idsolicitacao}"])
    fun AltearaUnicaSolictacao(@PathVariable("idsolicitacao") idsolicitacao: Int): ModelAndView {
        val solicitacoUnica = servicoSolicitacao!!.findById(idsolicitacao)
        val correspondentes = servicoCorrespondente!!.findAll()
        val comarcas = servicoComarca!!.findAll()
        val status = servicoStatusSolicitacao!!.findAll()
        val orgaos = servicoOrgao!!.findAll()
        val banca = servicoBanca!!.findAll()
        val usuario = servicoUsuario!!.findUsuariosLocais()
        val historico = servicoHistorico!!.findBuscaHistorico(idsolicitacao)
        val arquivo = servicoArquivos!!.findBuscaArquivos(idsolicitacao)
        val mv = ModelAndView("paginas/solicitacao/alterarsolicitacao")
        mv.addObject("alterarsoliunica", solicitacoUnica)
        mv.addObject("alterarcorrespondentes", correspondentes)
        mv.addObject("alterarcomarcas", comarcas)
        mv.addObject("alterarstatus", status)
        mv.addObject("altararorgaos", orgaos)
        mv.addObject("alterarbancas", banca)
        mv.addObject("alterarusuarios", usuario)
        mv.addObject("alterarhistorico", historico)
        mv.addObject("alterararquivo", arquivo)
        return mv
    }

    /**
     * Pega as comarcas por estado
     */
    @CrossOrigin
    @RequestMapping(method = [RequestMethod.GET], value = ["/comarcasuf/{iduf}"])
    @ResponseBody
    fun getRegions(@PathVariable("iduf") iduf: Int): List<Comarca?>? {
        return servicoComarca!!.buscaEstado(iduf)
    }

    @CrossOrigin
    @RequestMapping(method = [RequestMethod.GET], value = ["/novasolictacao/emailcorr/{idcorrespondente}"])
    @ResponseBody
    fun getEmail(@PathVariable("idcorrespondente") idcorrespondente: Int): MutableList<Any?>? {
        return servicoEmailCorrespondente!!.buscaemail(idcorrespondente)
    }
}