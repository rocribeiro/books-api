# Sobre a Aplicação

Esta API foi desenvolvida com propósitos acadêmicos e tem como objetivo demonstrar um simples CRUD (Create, Read, Update, Delete) de livros. Além disso, inclui um endpoint que realiza integração com a API do Google Books. 📚🎓

## Detalhes Técnicos

- Desenvolvida em Java 8 utilizando o framework Spring Boot 2.1.3. ☕🚀
- Utiliza o banco de dados H2 para armazenar os dados em memória. 💾
- Embora um Dockerfile tenha sido criado, a aplicação ainda não foi dockerizada. 🐳

## Endpoints

1. **Integração com Google Books API e Salvar no Banco:**

   - Método: POST
   - URL: `http://localhost:8080/books/save/{{theme}}`
   - Descrição: Este endpoint realiza a integração com a API do Google Books para obter livros com base no tema fornecido como parâmetro. Os livros são salvos no banco de dados. 🌐✨

2. **Salvar um Livro:**

   - Método: POST
   - URL: `http://localhost:8080/book`
   - Descrição: Este endpoint permite salvar um livro enviado no corpo da requisição. 📖✨

3. **Listar Todos os Livros:**

   - Método: GET
   - URL: `http://localhost:8080/all/books/`
   - Descrição: Este endpoint retorna uma lista de todos os livros cadastrados na aplicação. 📜📚

4. **Buscar um Livro por ID:**

   - Método: GET
   - URL: `http://localhost:8080/books/{id}`
   - Descrição: Este endpoint permite buscar um livro específico com base no ID fornecido. 🔍📚

## Instruções para Execução

1. Certifique-se de ter o Java 8 instalado. ☕
2. Clone o repositório. 📂
3. Execute a aplicação utilizando o comando `./mvnw spring-boot:run` (Linux/Mac) ou `mvnw.cmd spring-boot:run` (Windows). 🚀
4. Os endpoints estarão disponíveis em `http://localhost:8080/`. 🌐

## Dockerização

- Um Dockerfile foi fornecido na raiz do projeto. Para dockerizar a aplicação, você pode seguir os passos usuais de construção e execução de uma imagem Docker. Certifique-se de ter o Docker instalado em sua máquina. 🐳

## Observação

Esta aplicação é destinada apenas para fins educacionais. O uso de dados da API do Google Books pode estar sujeito aos termos de serviço do Google. Certifique-se de compreender e cumprir os requisitos legais ao utilizar esta aplicação. 🚀✨
