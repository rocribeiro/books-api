Para rodar meu código é necessario:

*Ide usada Eclipse.

1- Rodar o maven para instalar as dependencias.

2- Criar um database chamado "api" no mysql versão 5 eu utilizei a 5.0.12, com username "root" e sem senha.Caso necessario apenas troca
essa configuração no resources arquivo "application.properties".(Eu utilizei JPA para criar as tabelas sozinhas quando o projeto rodar
pela primeira vez).

3- Rodar o projeto clicando com o botão direito em cima do projeto "run as" java application.

4- Após o projeto estart startado basta ir no browser e chamar o métodos da controller.

--http://localhost:8080/book

*Recebe um Json e armazena no banco de dados, tem um retorno simples de "ok"

--http://localhost:8080/books/(Um ID existente no banco)

*Retorna o objeto referente ao ID passado.

--http://localhost:8080/books
*Popula o banco com livros do site "https://kotlinlang.org/docs/books.html", porém esse método contém dois problemas.

**1-A descrição do primeiro livro por ter 3 TAGS "p" faz com que as outras fiquem de certa forma embaranhadas.

**2-Não consegui capturar os ISBN, pois não consegui encontrar um padrão entre os sites de cada livro.
