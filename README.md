# Processos-Web

Aplicação MVC, utilizando SPRING MVC com integração  a banco de dados Mysql.

O sistema realiza operações crud em dois tipos de entidades no banco de dados: Tipo_de_processo e Processo. Seguindo as especificações a seguir.

## Especificações

    - 1 Cadastro de tipos de processo: Dado que eu esteja visualizando o formulário de cadastro de tipo de processo. Quando eu selecionar a opção salvar. Então o sistema deve registrar o nome do tipo de processo.

    - 2 Edição de tipo de processo: Dado que eu esteja editando um tipo de processo. Quando eu selecionar a opção alterar, então o sistema deve alterar o nome do tipo de processo.

    - 3 Visualização de tipo de processo: Dado que eu esteja na tela inicial do sistema, quando eu selecionar a opção visualizar tipos de processos, então o sistema deve exibir lista com id e nomes de tipos de processo.

    - 4 Cadastro de processo: O sistema permite a criação de um Processo, recebendo os dados: Tipo_de_processo, numero, data de entrada, valor do recurso e objetivo.
    
    - 5 Edição de processo:  Dado que eu esteja visualizando uma lista de processo, quando eu selecionar a opção editar, então o sistema deve permitir a edição dos campos: tipo de processo, data de entrada, valor do recurso e objetivo.

    - 6 Consulta de processo: Dado que eu esteja na página inicial do sistema quando eu selecionar a opção consultar processo, então o sistema deve permitir a busca pelo número do processo.

### Dificuldades encontradas

    - Item 4: exibir a lista de Tipos_de_processo, no formulário de cadastro de processo. 
    - Item 5: formatação apropriada da data. 
    - Item 6: o sistema permite a consulta de dados a partir de uma lista de processos. 
    - Implantação em Docker, infelizmente não consegui realizar 
