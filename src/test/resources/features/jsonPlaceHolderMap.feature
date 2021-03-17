#language:pt
Funcionalidade: JsonPlaceHolderMap Com token

  Contexto: 
    Quando for realizado uma requisicao do tipo POST do Token e o valor do token e armazenado
	
	@JsonPlaceHolderMap
  Cenario: Valida JsonPlaceHolder Map
    Dado que sejam preenchidos os campos do JsonPlaceHolderMap
    Quando forem alterados os campos do JsonPlaceHolderMap
      | nome  | Leila |
      | idade |    45 |
    Quando for realizado uma requisicao do tipo POST do JsonPlaceHolderMap
    Entao o sistema devolve o status 201
    Entao o sistema devolve o campo "nome" com o valor "Leila"
    Entao o sistema devolve o campo "idade" com o valor "45"