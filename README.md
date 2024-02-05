# Projeto Gerador de Senha API

## Tecnologias Usadas
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40" width="40"/>  `Spring Boot 3`
<img src="https://www.svgrepo.com/show/374111/swagger.svg" width="50" height="50">  `Swagger`
<img src="https://raw.githubusercontent.com/projectlombok/lombok/f3a4b1b4151a9dd1646f1b170c17f5f29903f45a/src/installer/lombok/installer/lombok.svg" width="40" height="40">  `Lombok`
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="40" height="40"/>`Java`
## Instruções de Instalação

1. Clone o repositório: `git clone https://github.com/Fernand0-jf/generated_password.git`
3. Instale as dependências: `mvn install` ou `./gradlew build`
4. Execute a aplicação: `mvn spring-boot:run` ou `./gradlew bootRun`


## Documentação da API com Swagger

Acesse a documentação da API utilizando Swagger:

-verifique se está com host e a porta certa ex: http://host:port/swagger-ui.html
- [Swagger UI](http://localhost:8080/swagger-ui.html): Visualize e teste as endpoints da API.

## Uso da API

- Utilize o Postman ou qualquer outra ferramenta para realizar requisições HTTP para as seguintes rotas:

### Rotas da API

- `GET /api/password`: Cria uma senha forte de 8 digitos.
- `GET /api/funcionarios/{password}`: Verifica se a senha é forte.
- `POST /api/password`: Cria uma senha customizada.

### Exemplos


## Gerar senha aleatória forte

**Request:**
```http
GET /api/password
```
**Resposta:**
```http
5-"j%*!#uniC.
```
## Verificar se é uma senha forte

**Request:**
```http
GET /api/password/Seilanao01.
```
**Resposta:**
```http
True
```
## Gera uma senha aleatória customizada

**Request:**
```http
GET /api/password
{
  "lowerCase":false,
	"upperCase":true,
	"special":true,
	"length1":10
}
```
**Resposta:**

```http
#..&F*!N$(!,.,+
```
