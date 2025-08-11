# 📖 LiterAlura
![Static Badge](https://img.shields.io/badge/java-v21-blue)
![Static Badge](https://img.shields.io/badge/gson-lts-blue)
![Static Badge](https://img.shields.io/badge/java-dotenv-gree)
![Static Badge](https://img.shields.io/badge/GutenDex-blue)

* [Descrição do Projeto](#descrição-do-projeto)
* [Status do Projeto](#status-do-Projeto)
* [Funcionalidades](#funcionalidades)
* [Acesso ao Projeto](#acesso-ao-projeto)
* [Tecnologias utilizadas](#tecnologias-utilizadas)

## 📌 Descrição do Projeto
Este projeto é um catálogo de livros que oferece diversas interações (via console), 
possibilitando buscar livros através da API do *GutenDex*. 
O projeto foi desenvolvido em **Java** com SpringBoot, utilizando ObjectMapper, DTOs, Models, Repositories e utilizou o **Dotenv** para gerenciar variáveis de ambiente.

O projeto possui:
- **Interface Console**: com um menu interativo e opções predefinidas para buscar, salvar e recuperar livros e autores.
---
## 🚧 Status do Projeto
✅ Projeto finalizado  
📌 Possíveis melhorias: suporte para mais apis com diversos livros, estatísticas e recomendações, além do deploy como `.jar` executável.

---
## 🧩 Funcionalidades (Console 🔳)
1) Buscar livro por título
2) Listagem de todos os livros
3) Listagem de autores
4) Listagem de autores vivos em um determinado ano
5) Listagem de livro por idioma
6) Sair

---
## 🖥️ Demonstração

### Interface Console
![Console](./src/resources/console.gif)

---
## 🐦‍⬛ Acesso ao Projeto
 Clone o repositório:

```bash
git clone https://github.com/damatomos/LiterAlura.git
```
Abra em uma IDE com suporte ao java e modifique como desejar.

## 🩻 Tecnologias utilizadas
* Java 21
* DevTools
* Lombok
* Jackson
* PostgreSQL
* GutenDex API
