#language:pt
Funcionalidade: JsonPlaceHolder Com token

  Contexto: 
    Quando for realizado uma requisicao do tipo POST do Token e o valor do token e armazenado
	
	@JsonPlaceHolder
  Cenario: Valida JsonPlaceHolder
    Dado que sejam preenchidos os campos do JsonPlaceHolder
    Quando forem alterados os campos do JsonPlaceHolder
      | nome  | Leila |
      | idade |    45 |
    E for realizado uma requisicao do tipo POST do JsonPlaceHolder
    Entao o sistema devolve o status 201
    Entao o sistema devolve o campo "nome" com o valor "Leila"
    Entao o sistema devolve o campo "idade" com o valor "45"


  
		