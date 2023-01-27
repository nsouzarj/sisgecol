package br.Test

import br.entidades.Solicitacao
import br.servicos.ServicoSolicitacao
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Spy



class ServicoSolicitacaoTest {

    @Spy
    @InjectMocks
    var servicoSolictacao: ServicoSolicitacao? = null

    @Mock
    var solicitacao: Solicitacao? =null

    @BeforeEach
    fun setUp() {
      println("Começo dos teste")

    }

    @AfterEach
    fun final(){
        print("Final dos testes --")
    }


    @Test
    @Order(2)
    fun testeSave(){

        solicitacao?.idsolicitacao =1
        solicitacao?.audinterna=true
        solicitacao?.convolada=true
        servicoSolictacao?.save(solicitacao!!)

    }

    @Test
    @Order(1)
    fun testeDelete(){

        solicitacao?.idsolicitacao =1
        solicitacao?.audinterna=true
        solicitacao?.convolada=true
        servicoSolictacao?.delete(solicitacao?.idsolicitacao)

    }

    @Test
    @Order(1)
    fun testeFindSolictacao(){

        solicitacao?.idsolicitacao =1
        solicitacao?.audinterna=true
        solicitacao?.convolada=true
        var soli:Solicitacao= servicoSolictacao?.findById(solicitacao?.idsolicitacao)!!
        Assertions.assertEquals(solicitacao,soli)
    }



}