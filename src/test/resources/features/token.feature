#language:pt

Funcionalidade: Token
	@efetuaLogin
	Cenario: Efetuar Login
		Dado que sejam preenchidos os campos para autenticacao
		Quando for realizado uma requisicao do tipo POST do Token
		Entao o sistema devolve o status 201
		Entao o valor do token e armazenado
		
	@efetuaLoginCompleto	
	Cenario: Efetuar Login passo unico
		Quando for realizado uma requisicao do tipo POST do Token e o valor do token e armazenado
