#   API de Gestão de Eventos


## Índice


- [Sobre](#sobre)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Arquitetura da API](#arquitetura-da-api)
- [Como a API Funciona](#como-a-api-funciona)
- [Tabelas no Banco de Dados](#tabelas-no-banco-de-dados)


## Sobre


A API de Gestão de Eventos tem como objetivo possibilitar ao usuário a compra de ingressos para eventos. Neste aplicativo, um **evento** é cadastrado por um **organizador** e, em seguida, um **cliente** cadastrado no aplicativo pode comprar um ingresso para um evento que também precisa estar cadastrado na API. A API foi desenvolvida utilizando os princípios da *Clean Architecture*.


## Tecnologias Utilizadas


O projeto foi desenvolvido utilizando as seguintes tecnologias:
- [Java 17](https://docs.oracle.com/en/java/javase/17/)
- [Lombok](https://projectlombok.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security)
- [JWT](https://jwt.io/) 
- [PostgreSQL](https://www.postgresql.org/docs/)
- [Docker](https://docs.docker.com/)
- [Git e Github](https://git-scm.com/doc)

## Arquitetura da API


![dominioGestaoDeEventos](https://github.com/victorgabdev/APIGestaoDeEventos/assets/75862737/fdbc5836-5183-4cc7-84e3-220e89931b73)
## Como a API Funciona

Essa API tem quatro entidades na sua camada de domínio, são elas:
Eventos (events), Clientes (customers), Organizadores (organizers) e Vendas (sales).
Ela é capaz de fazer um CRUD para events, customers, organizers e sales.


> Obs: CRUD -> Create, Read, Update, Delete.

A API não permite que um usário crie um evento, ou seja, somente um organizer pode cadastrar um evento.
Essa funcionalidade só é possível por causa da utilização do Spring Security.


## Tabelas no banco de Dados


#### Customers:

<table>
  <tr>
    <th>id</th>
    <th>document</th>
    <th>email</th>
    <th>name</th>
    <th>password</th>
    <th>phone</th>
    <th>created_at</th>
  </tr>
  <tr>
    <td>(PK) uuid</td>
    <td>varchar(255)</td>
    <td>varchar(255)</td>
    <td>varchar(255)</td>
    <td>criptografado </td>
    <td>varchar(255)</td>
    <td>timestamp without zone</td>
  </tr>
</table>

#### Events:

<table>
  <tr>
    <th>id</th>
    <th>address</th>
    <th>available_quantity</th>
    <th>created_at</th>
    <th>description</th>
    <th>end_at</th>
    <th>price</th>
    <th>quantity</th>
    <th>start_at</th>
    <th>organizer_id</th>
  </tr>
  <tr>
    <td>(PK) uuid</td>
    <td>varchar(255)</td>
    <td>integer</td>
    <td>timestamp without zone</td>
    <td>varchar(255)</td>
    <td>timestamp without zone</td>
    <td>numeric(19,2)</td>
    <td>integer</td>
    <td>timestamp without zone</td>
    <td>(FK) uuid</td>
  </tr>
</table>

#### Organizers:

<table>
  <tr>
    <th>id</th>
    <th>address</th>
    <th>Email</th>
    <th>password</th>
    <th>responsible</th>
    <th>created_at</th>
  </tr>
  <tr>
    <td>(PK) uuid</td>
    <td>varchar(255)</td>
    <td>varchar(255)</td>
     <td>varchar(255)</td>
    <td>varchar(255)</td>
    <td>timestamp without zone</td>
  </tr>
</table>
