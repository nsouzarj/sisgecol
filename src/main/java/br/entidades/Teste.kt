package br.entidades

import java.io.Serializable

class Teste : Serializable {
    var id: Int? = null
    var nome: String? = ""


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Teste

        if (id != other.id) return false
        if (nome != other.nome) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (nome?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Teste(id=$id, nome=$nome)"
    }


}

fun main(){
    var teste=Teste()
    teste.id=10
    teste.nome="NELSONS EIXAS DE SOUZA"
    println(teste.id)
    println(teste.nome)
    println("** FIM ***")
}