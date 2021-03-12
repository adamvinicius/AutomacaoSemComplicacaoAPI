#language:pt
@GetCep
Funcionalidade: Get CEP
  Descricao do get cep

  @ValidaCep
  Cenario: Valida CEP
    Dado que seja recebido um cep valido com o valor "04055041"
    Quando for realizado uma requisicao do tipo Get do CEP
    Entao o sistema devolve o campo "logradouro" com o valor "Rua Mauro"
    Entao o sistema devolve o campo "bairro" com o valor "Saúde"
    Entao o sistema devolve o status 200

  @Caracteres
  Cenario: Realiza Consulta CEP
    Dado que seja recebido um cep valido com o valor "04055041"
    Quando for realizado uma requisicao do tipo Get do CEP
    Entao o sistema devolve o status 200

  Cenario: Valida logradouro do CEP
    Entao o sistema devolve o campo "logradouro" com o valor "Rua Mauro"

  Cenario: Valida bairro do CEP
    Entao o sistema devolve o campo "bairro" com o valor "Saúde"

  Cenario: Valida ddd do CEP
    Entao o sistema devolve o campo "ddd" com o valor "11"

  Cenario: Valida cep do CEP
    Entao o sistema devolve o campo "cep" com o valor "04055-041"

  @Caracteres
  Cenario: Valida quantidade exata de caracteres do cep
    Entao o campo "cep" devera retornar com 9 caracteres

  @Esquema
  Esquema do Cenario: Valida CEP <cenario>
    Dado que seja recebido um cep valido com o valor "<cep>"
    Quando for realizado uma requisicao do tipo Get do CEP
    Entao o sistema devolve o campo "logradouro" com o valor "<logradouro>"
    Entao o sistema devolve o campo "bairro" com o valor "<bairro>"
    Entao o sistema devolve o status <status>

    Exemplos: 
      | cenario | cep      | logradouro       | bairro        | status |
      | Adam    | 04055041 | Rua Mauro        | Saúde         |    200 |
      | Sampaio | 07270300 | Rua Feira Grande | Jardim Brasil |    200 |
      | Raquel  | 09921040 | Rua Canadá       | Centro        |    200 |
