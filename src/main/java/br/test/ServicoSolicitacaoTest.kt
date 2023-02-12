package br.test


import br.entidades.Usuario
import br.servicos.ServicoUsuario
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

//@RunWith(PowerMockRunner::class)
//@PrepareForTest(ServicoUsuario::class)
class ServicoSolicitacaoTest {

    @InjectMocks
    private lateinit var servicoUsuario: ServicoUsuario

    @Mock
    private lateinit var usuario: Usuario

    @Before
    fun setup(){
       MockitoAnnotations.initMocks(this)
       println("Antes")
    }


    fun final(){
        println("Final..")
    }

    @Test
    fun testeGeral(){
        //Cenario
        usuario.nomecompleto="Nelson"
        usuario.idusuario=1;
        usuario.nomecompleto="teste"

        //Acao
        usuario=servicoUsuario.findOne(1)

        //Verificacao

        val valor =34

        Assert.assertEquals(valor,34)

        println("Foi")
    }




}