"use strict";

/*Funcao de mascara campos */
function mascaravalor(src, mask) {
  var i = src.value.length;
  var saida = mask.substring(1, 2);
  var texto = mask.substring(i);

  if (texto.substring(0, 1) != saida) {
    src.value += texto.substring(0, 1);
  }
}

function confirmarRemover() {
  if (confirm("Deseja realmente excluir ?")) {
    return true;
  }

  return false;
}

function Limpar(valor, validos) {
  // retira caracteres invalidos da string
  var result = "";
  var aux;

  for (var i = 0; i < valor.length; i++) {
    aux = validos.indexOf(valor.substring(i, i + 1));

    if (aux >= 0) {
      result += aux;
    }
  }

  return result;
}

function entra() {
  document.getElementById("cliente:botaobuscar").click();
}

function avisobordero() {
  if (cont == 1) {
    window.alert("ANTES DE INSERIR UM OU MAIS BORDEROS POR FAVOR CLICK NO BOT�O ATUALIZAR DA PRIMEIRA ABA PELOS MENOS UMA VEZ!");
    cont++;
  }
}

function avisografico() {
  if (cont1 == 1) {
    window.alert("ANTES DE GERAR OS GRÁFICOS POR FAVOR CLICK NO BOT�O ATUALIZAR DA PRIMEIRA ABA PELO MENOS UMA VEZ!");
    cont1++;
  }
}

function sair() {
  window.alert("Obrigado por usar o sistema de consulta de cobran�a via web volte sempre.");
}
/** 
function verificavazio(form){
   var campo=form[form.id+":obs1"].value;
   if(campo==""){
	   window.alert("Atencao o campo esta vazio");
	   return false;
   }else{
	   return true;
	   form.submit();
   }
}
*/


function fechajanela(janela) {
  window.close();
}

function fecha() {
  window.close();
}

function relertela() {
  location.reload(true);
}

function verificavazio(campo) {
  if (campo == "") {
    window.alert("O campo " + campo + " está vazio");
    return false;
  } else {
    return true;
  }
} //Mostra a solitacao finalizada


function Finalizada() {
  window.alert("Sua solicião foi finalizada com sucesso!!");
} //Verifica a hora da solicitacao


function VerificaHora(campo) {
  var hora = campo.value;
  var min = campo.value;
  var num = parseInt(hora.substring(0, 2));
  var min2 = parseInt(min.substring(3, 5));

  if (num > 19 || num < 7 || min2 > 60) {
    window.alert("A HORA ESTA FORA DE PADRAO!");
    return false;
  } else {
    return true;
  }
} //Esconde o tipo
//Escode uma div


function escondetiposoli(divesconde, valor) {
  //	var valor = $(divesconde +" option:selected");
  var recebe = $(valor + " option:selected");
  var rec = recebe.text().search("AUDIENCIA");

  if (rec == 0) {
    $(divesconde).show().delay(2000).fadeIn();
  } else if (rec == -1) {
    $(divesconde).hide().delay(2000).fadeOut();
  }
} //Escode uma div


function esconde1(divesconde, esconde) {
  var valor = $(divesconde + " option:selected");

  if (valor.val() == 3) {
    $(esconde).show();
  } else {
    $(esconde).hide();
  }
} //Copia valor


function copiavalor(valororigem, valordestino) {
  var select = $(valororigem + " option:selected");
  $(valordestino).val(select.text());

}