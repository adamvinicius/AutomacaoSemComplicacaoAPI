#language:pt

Funcionalidade: Token PlataformaFilmes
	@TokenPlataformaFilmes
	Cenario: Realizar Login
		Dado que sejam preenchidos os campos com valores validos do token
		Quando for realizado uma requisicao do tipo POST de Token de PlataformaFilme
		Entao o sistema devolve o status 200
		E valor do token de plataformaFilmes e armazenado
		