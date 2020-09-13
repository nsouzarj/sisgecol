package br.controles

import br.entidades.*
import br.servicos.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.CorsRegistry

class ApiJsonControle {
    fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").exposedHeaders("*").allowedMethods("*")
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

    @CrossOrigin
    @ResponseBody
    fun Busca(): String {
        return "<H2>SERVIDOR RESTFULL SIGECOL <H2>"
    }

    @CrossOrigin
    @RequestMapping("/erro")
    @ResponseBody
    fun Erro(): String {
        return "<H2>SENHA OU LOGIN ERRADO<H2>"
    }

    @CrossOrigin
    @RequestMapping(path = ["/usuariologin/{emailprincipal}/{senha}"])
    @ResponseBody
    fun login(@PathVariable("emailprincipal") emailprincipal: String, @PathVariable("senha") senha: String?): Usuario? {
        return servicoLogin!!.busca(emailprincipal, senha)
    }

    /**
     * Traz unica solicitacao
     *
     * @param idsolicitacao
     * @return
     */
    @CrossOrigin
    @GetMapping(path = ["/solicitacao/unica/{idsolicitacao}"])
    fun find2(@PathVariable("idsolicitacao") idsolicitacao: Int): Solicitacao? {
        return servicoSolicitacao!!.findById(idsolicitacao)
    }

    /**
     * Traz todas as solicitacoes
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping("/solicitacao/todas")
    fun findAllSoli(): List<Solicitacao?>? {
        return servicoSolicitacao!!.findAll()
    }

    /**
     * Traz as uf
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping("/uf")
    @ResponseBody
    fun findAll(): List<Uf?>? {
        return servicoUf!!.findAll()
    }

    /**
     * Busca unico
     *
     * @param iduf
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping(path = ["/uf/{iduf}"])
    fun find1(@PathVariable("iduf") iduf: Int): Uf? {
        return servicoUf!!.findOne(iduf)
    }

    /**
     * Pega todas as comarcas
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(path = ["/comarca"])
    @ResponseBody
    fun findAll2(): List<Comarca?>? {
        return servicoComarca!!.findAll()
    }

    /**
     * Busca unica comarca
     *
     * @param idcomarca
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping(path = ["/comarca/{idcomarca}"])
    fun buscaunicacomarca(@PathVariable("idcomarca") idcomarca: Int): Comarca? {
        return servicoComarca!!.findOne(idcomarca)
    }

    /**
     * Busca por estado através da silgla
     *
     * @param silga
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping(path = ["/comarca/porestado/{iduf}"])
    fun buscaunicaestado(@PathVariable("iduf") iduf: Int): List<Comarca?>? {
        return servicoComarca!!.buscaEstado(iduf)
    }

    /**
     * Busca todas as bancas
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(path = ["/bancas"])
    @ResponseBody
    fun findAllBanca(): List<BancaProcesso?>? {
        return servicoBanca!!.findAll()
    }

    /**
     * Traz todos os colaboradores
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(path = ["/colaborador"])
    @ResponseBody
    fun findAllCor(): List<Correspondente?>? {
        return servicoCorrespondente!!.findAll()
    }

    /**
     * TRaz unico correspondente
     *
     * @param idcorrespondente
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping(path = ["/colaborador/{id}"])
    fun findcor(@PathVariable("id") idcorrespondente: Int): Correspondente? {
        return servicoCorrespondente!!.findOne(idcorrespondente)
    }

    /**
     * Traz todos os usuarios
     *
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping(path = ["/usuarios"])
    fun findAllusuarios(): MutableList<Any?>? {
        return servicoUsuario!!.findAll()
    }

    /**
     * Traz unico unsuario
     *
     * @param idusuario
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping(path = ["/usuarios/{idusuario}"])
    fun findUnicoUsuario(@PathVariable("idusuario") idusuario: Int): Usuario? {
        return servicoUsuario!!.findOne(idusuario)
    }

    /**
     * Retorna as comarcas do correspondente
     */
    @CrossOrigin
    @ResponseBody
    @GetMapping(path = ["/comarcapossui/{idcorrespondente}"])
    fun findComPossui(@PathVariable("idcorrespondente") idcorrespondente: Int): MutableList<Any?>? {
        return servicoComarcaPossui!!.findByid(idcorrespondente)
    }

    /**
     * Traz todos os colaboradores
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(path = ["/tipos"])
    @ResponseBody
    fun findAllTipo(): List<TipoSolicitacao?>? {
        return servicoTipoSolicitacao!!.findAll()
    }

    /**
     * Traz todos os colaboradores
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(path = ["/status"])
    @ResponseBody
    fun findStatusSoli(): List<StatusSolicitacao?>? {
        return servicoStatusSolicitacao!!.findAll()
    }
}