#language:pt

Funcionalidade: Filmes PlataformaFilmes
	Contexto:
		Dado que sejam preenchidos os campos com valores validos do token
		Quando for realizado uma requisicao do tipo POST de Token de PlataformaFilme
		Entao o sistema devolve o status 200
		E valor do token de plataformaFilmes e armazenado
	
	@FilmesPlataformaFilmes
	Cenario: Realizar Cadastro Filmes
		Dado que sejam preenchidos os campos com valores validos do filmes
		Quando for realizado uma requisicao do tipo POST de filmes de PlataformaFilme
		Entao o sistema devolve o status 201
		Entao o sistema devolve o campo "nome" com o valor "O Poço 2"