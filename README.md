# Desafio-Literalura

## 📚 Sobre o Projeto

Desafio-Literalura é um catálogo de livros desenvolvido em Java que consome dados da API pública [Gutendex](https://gutendex.com/) para exibir informações literárias. O projeto oferece uma interação via console com o usuário, permitindo:

- Listar livros disponíveis
- Buscar livros por autor
- Filtrar livros pelo ano de nascimento do autor
- Exibir favoritos (funcionalidade futura)
- Sair da aplicação

## 🚀 Tecnologias Utilizadas

- Java 17
- Maven (para gerenciamento de dependências)
- Jackson (para desserialização JSON)
- API Gutendex para dados de livros

## 📦 Estrutura do Projeto

- `model/` – Classes que representam os dados (ex: Livro, LivroResponse)
- `service/` – Classes responsáveis pelo consumo da API e lógica de negócio
- `controller/` – Controla a interação do usuário via console
- `Aplicacao.java` – Classe principal para execução do programa

## 💡 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/Renanziins/Desafio-Literalura.git
