package br.controles

import br.entidades.*
import br.servicos.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.config.annotation.CorsRegistry


@Controller
@CrossOrigin(origins = ["*"], maxAge = 3600)
class ControleGeral {

    fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").exposedHeaders("*").allowedMethods("*")
                .allowCredentials(true).maxAge(3600)
        registry.addMapping("/resources/**").allowedOrigins("*").allowedHeaders("*").exposedHeaders("*").allowedMethods("*")
                .allowCredentials(true).maxAge(3600)
        registry.addMapping("/js/**").allowedOrigins("*").allowedHeaders("*").exposedHeaders("*").allowedMethods("*")
                .allowCredentials(true).maxAge(3600)
        registry.addMapping("/usuarios/**").allowedOrigins("*").allowedHeaders("*").exposedHeaders("*").allowedMethods("*")
                .allowCredentials(true).maxAge(3600)
        registry.addMapping("/static/js/**").allowedOrigins("*").allowedHeaders("*").exposedHeaders("*").allowedMethods("*")
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

    @CrossOrigin
    @ResponseBody
    @RequestMapping(method = [RequestMethod.GET], value = ["/pagina"])
    fun listar(): String {
        return "pagina"
    }

    @CrossOrigin
    @GetMapping("/")
    fun loginpa():String {
        return "redirect:/menu"
    }


    @CrossOrigin
    @GetMapping("/login")
    fun loginpagina():String {
       return  "paginas/login"

    }




    @CrossOrigin
    //@RequestMapping("/menu", method = [RequestMethod.POST])
    @GetMapping("/menu")
    //@RequestMapping("/menu", method = [RequestMethod.POST] )
    fun menu(): ModelAndView {
        val username=getUserName().toUpperCase()
        val mv = ModelAndView("paginas/menu")
        mv.addObject("username",username)
        return mv
    }

    fun getUserName():String{
        val auth: Authentication = SecurityContextHolder.getContext().authentication
        return auth.name
    }
    fun isAuth():Boolean{
        val auth: Authentication = SecurityContextHolder.getContext().authentication
        return auth.isAuthenticated
    }

    @CrossOrigin
    @GetMapping("/index")
    fun index(): String {
        return "redirect:/menu"
    }


    @CrossOrigin
    @RequestMapping("/erro")
    fun error(): String {
        return "/login?error"
    }



    @CrossOrigin
    @RequestMapping("/logout")
    fun logout(): String {
        return "/login&logout"
    }


    /**
     * Comarcas
     *
     * @return
     */
    @CrossOrigin
    @GetMapping("/comarcas")
    fun pesquisar(): ModelAndView {
        val com = servicoComarca!!.findAll()
        val com1 = servicoUf!!.findAll()
        val mv = ModelAndView("paginas/comarcas/comarcas")
        mv.addObject("comar", com)
        mv.addObject("uf", com1)
        return mv
    }

    /**
     * Usuarios
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = [RequestMethod.GET], value = ["/usuarios"])
    fun ListaUsuarios(): ModelAndView {
        val com1 = servicoUsuario!!.findAll()
        val mv = ModelAndView("paginas/usuarios/usuarios")
        mv.addObject("usuario", com1)
        return mv
    }

    /**
     * Traz usuario selecionando
     * @param idusuario
     * @return
     */
    @CrossOrigin //@GetMapping("{idusuario}")
    @RequestMapping(method = [RequestMethod.GET], value = ["/usuarios/{idusuario}"])
    fun BuscaUnicoUsuario(@PathVariable("idusuario") idusuario: Int): ModelAndView {
        val usuario = servicoUsuario!!.findOne(idusuario)
        val mv = ModelAndView("paginas/usuarios/usuarios")
        mv.addObject("usuariounico", usuario)
        println(usuario.nomecompleto)
        return mv
    }

    /**
     * CAdastro de usuarios
     *
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = [RequestMethod.GET], value = ["/usuarios/cadastro"])
    open fun CadastroUnicoUsuario(): ModelAndView {
        val corr = servicoCorrespondente!!.findAll()
        val usuario = Usuario()
        val mv = ModelAndView("paginas/usuarios/cadastro")
        mv.addObject("novousuario", usuario)
        mv.addObject("corr", corr)
        return mv
    }

    @CrossOrigin
    @RequestMapping(method = [RequestMethod.GET], value = ["/usuarios/alterar/{idusuario}"])
    fun AletaraUnicoUsuario(@PathVariable("idusuario") idusuario: Int): ModelAndView {
        val usuario = servicoUsuario!!.findOne(idusuario)
        val correspondente = servicoCorrespondente!!.findAll()
        val mv = ModelAndView("paginas/usuarios/alterar")
        mv.addObject("altera", usuario)
        mv.addObject("correspondente", correspondente)
        println(">>>>>>>>$usuario")
        return mv
    }

    @CrossOrigin
    @GetMapping("/comarcas/cadastro")
    fun pesquisarUf(): ModelAndView {
        val com1 = servicoUf!!.findAll()
        val mv = ModelAndView("paginas/comarcas/cadastrocomarca")
        mv.addObject("ufteste", com1)
        return mv
    }

    /**
     * Paga as Comarcas
     *
     * @return
     */
    @CrossOrigin
    @GetMapping("/uf")
    fun pesquisarEstados(): ModelAndView {
        val com = servicoUf!!.findAll()
        val mv = ModelAndView("paginas/comarcas/comarcas")
        mv.addObject("uf", com)
        return mv
    }

    /**
     * Correspondentes
     *
     * @return
     */
    @CrossOrigin
    @GetMapping("/correspondentes")
    fun correspondentes(): ModelAndView {
        val corr = servicoCorrespondente!!.findAll()
        val com = servicoComarca!!.findAll()
        val mv = ModelAndView("paginas/correspondente/correspondentes")
        mv.addObject("corr", corr)
        mv.addObject("com", com)
        return mv
    }

    /**
     * Busca unico correspondente
     *
     */
    @CrossOrigin
    @GetMapping(path = ["/correspondente/{idcorrespondente}"])
    fun correspondente(@PathVariable("idcorrespondente") idcorrespondente: Int): ModelAndView {
        val correspondente = servicoCorrespondente!!.findOne(idcorrespondente)
        val mv = ModelAndView("paginas/correspondente/correspondente")
        mv.addObject("correspondente", correspondente)
        return mv
    }


    /**
     * Busca unico correspondente
     *
     */
    @CrossOrigin
    @GetMapping(path = ["/correspondente/cadcorr"])
    fun cadcorrespondente(): ModelAndView {
        val corr= Correspondente()
        val mv = ModelAndView("paginas/correspondente/cadcorr")
        mv.addObject("corr",corr)
        return mv
    }


    /**
     * Buscaps processo
     */
    @CrossOrigin
    @GetMapping("/processos")
    fun buscatodosprocessos(): ModelAndView {
        val processos = servicoProcesso!!.findAll()
        val mv = ModelAndView("paginas/processos/processos")
        mv.addObject("processos", processos)
        return mv
    }

    @CrossOrigin
    @GetMapping("/processos/cadastrar")
    fun cadprocessos(): String {
        /**
         * List<Processo> processos = servicoProcesso.findAll();
         * ModelAndView mv = new ModelAndView("paginas/processos/cadprocessos");
         * mv.addObject("processos",processos);
         * return mv;
        </Processo> */
        return "paginas/processos/cadprocesso"
    }

    /**
     * Traz as bancas cadastradas
     */
    @GetMapping("/bancas")
    fun buscabancas(): ModelAndView {
        val bancas = servicoBanca!!.findAll()
        val mv = ModelAndView("paginas/bancas/bancas")
        mv.addObject("bancas", bancas)
        println("teste")
        return mv
    }

    @GetMapping("/bancas/cadastro")
    fun cadastrobancas(): ModelAndView {
        //val banca = servicoBanca
        val mv = ModelAndView("paginas/bancas/cadastrobancas")
      //  mv.addObject("cadastro", bancas)
        println("teste")
        return mv
    }


   @CrossOrigin
   @RequestMapping(method = [RequestMethod.POST], value = ["/comarcas/cadastro"])

   fun  Salvar(comarca:Comarca) :ModelAndView {

       servicoComarca?.salvar(comarca)
       val mv=ModelAndView("paginas/comarcas/cadastrocomarca")
       val com1 = servicoUf!!.findAll()
       mv.addObject("ufteste", com1)
       mv.addObject("menssagem","Comarca salva com sucesso !!!")

       return mv
   }


    /**
     * Excluir a comarca do grid
     */
    @CrossOrigin
    @GetMapping(path = ["/comarcas/excluir/{idcomarca}"])
    fun excluircomarca(@PathVariable("idcomarca") idcomarca: Int): ModelAndView {
        var msg1=""
        var msgerror=""
        try {
            servicoComarca?.delete (idcomarca)
            msg1="Comarca excluirda com sucesso !!! "
        }catch (e:Exception) {
            msgerror="Erro ao excluir a comarca pode esta em uso !!! "
        }
        val com = servicoComarca!!.findAll()
        val com1 = servicoUf!!.findAll()
        val mv = ModelAndView("paginas/comarcas/comarcas")
        mv.addObject("comar", com)
        mv.addObject("uf", com1)
        mv.addObject("msg1",msg1)
        mv.addObject("msgerror",msgerror)
        return mv
    }



    /**
    Le as funções da biblioteca
     */
    @CrossOrigin
    @RequestMapping(method = [RequestMethod.GET], value = ["/js/libfuncoes.js"])
    fun Js(): String {
        return "/js/libfuncoes.js"
    }



}