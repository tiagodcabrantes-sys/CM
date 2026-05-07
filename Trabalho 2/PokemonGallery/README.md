# Assignment 2 - Pokemon Gallery

Curso: Computação Móvel  
Aluno(s): Tiago Abrantes  

---

## 1. Introdução

O objetivo deste trabalho foi desenvolver uma aplicação móvel Android utilizando Kotlin e layouts XML, aplicando conceitos de consumo de APIs, RecyclerView e desenvolvimento Android moderno.

A aplicação desenvolvida, denominada “Pokemon Gallery”, permite ao utilizador explorar informações de vários Pokémon através da PokéAPI.

Os principais objetivos do projeto foram:

- Consumir uma API REST
- Apresentar dados dinâmicos num RecyclerView
- Criar uma interface interativa em Android
- Implementar sistemas de pesquisa e filtros
- Suportar layouts portrait e landscape
- Explorar o uso de Inteligência Artificial como ferramenta de apoio ao desenvolvimento

---

## 2. Visão Geral do Sistema

A aplicação apresenta informações de Pokémon numa interface moderna e intuitiva.

Principais funcionalidades:

- Visualização de Pokémon em grelha
- Pesquisa de Pokémon por nome
- Filtros por tipo
- Sistema de favoritos
- Página de detalhes do Pokémon
- Suporte para landscape
- Carregamento dinâmico de imagens

Cada cartão de Pokémon apresenta:

- Imagem do Pokémon
- Nome
- Altura
- Peso
- Botão de favorito

A aplicação inclui também uma página de detalhes com informações adicionais.

Caso de utilização:

O utilizador abre a aplicação, explora a lista de Pokémon, pesquisa Pokémon específicos, utiliza filtros por tipo e adiciona Pokémon aos favoritos.

---

## 3. Arquitetura e Design

### Arquitetura

O projeto segue uma estrutura inspirada no padrão MVVM:

- MainActivity → lógica principal da interface
- PokemonDetailsActivity → página de detalhes
- MainViewModel → gestão de dados e filtros
- PokemonRepository → comunicação com a API
- PokemonAdapter → RecyclerView adapter
- RetrofitInstance → configuração do Retrofit

### Estrutura de Pastas

- data/api/ → comunicação com API
- data/model/ → modelos de resposta
- data/repository/ → camada repository
- ui/main/ → ViewModel
- adapter/ → RecyclerView adapter
- res/layout/ → layouts XML
- res/layout-land/ → layouts landscape

### Decisões de Design

A interface foi desenvolvida com foco na simplicidade e facilidade de utilização.

Principais decisões:

- Utilização de MaterialCardView para os cartões
- Layout responsivo para diferentes orientações
- Secção horizontal de favoritos
- Barra de pesquisa dinâmica
- Botões de filtros por tipo
- Página separada para detalhes do Pokémon

Todas as melhorias visuais e ajustes da interface foram realizados manualmente pelo estudante.

---

## 4. Implementação

### Componentes Principais

A aplicação utiliza:

- RecyclerView → apresentação da lista de Pokémon
- Retrofit → comunicação com a API
- Glide → carregamento de imagens
- ViewModel → gestão de estado
- MaterialCardView → estilização dos cartões

### Consumo da API

A aplicação utiliza a PokéAPI através do Retrofit.

Os dados obtidos incluem:

- Nome do Pokémon
- Imagem
- Altura
- Peso
- Tipos do Pokémon

### RecyclerView

O RecyclerView foi utilizado para apresentar os cartões de Pokémon de forma eficiente.

Cada cartão apresenta:

- Imagem do Pokémon
- Nome
- Altura
- Peso
- Botão de favorito

### Pesquisa e Filtros

O sistema de pesquisa filtra os Pokémon dinamicamente à medida que o utilizador escreve.

Filtros disponíveis:

- Fire
- Water
- Grass
- Electric
- Normal
- Bug
- Flying
- Poison
- Ground
- Psychic

### Sistema de Favoritos

Os utilizadores podem marcar Pokémon como favoritos através de um botão em forma de estrela.

Os favoritos são apresentados numa secção horizontal no topo da aplicação.

### Suporte Landscape

Foi criado um layout específico para orientação landscape utilizando a pasta layout-land.

---

## 5. Testes e Validação

### Estratégia de Testes

A aplicação foi testada utilizando o Android Emulator.

Foram realizados testes em:

- Modo portrait
- Modo landscape
- Diferentes tamanhos de ecrã

### Cenários Testados

- A API carrega corretamente
- O RecyclerView apresenta os Pokémon
- A pesquisa funciona corretamente
- Os filtros atualizam a lista
- O sistema de favoritos funciona
- A página de detalhes abre corretamente
- O layout adapta-se corretamente à rotação

### Limitações Conhecidas

- Os favoritos não são guardados permanentemente
- Alguns tipos de Pokémon não possuem filtros específicos
- A aplicação necessita de internet

---

## 6. Instruções de Utilização

### Requisitos

- Android Studio
- Android SDK
- Ligação à internet

### Execução

1. Abrir o projeto no Android Studio
2. Fazer sincronização do Gradle
3. Executar a aplicação
4. Selecionar um emulador ou dispositivo Android
5. Explorar os Pokémon disponíveis

---

# Secções de Engenharia de Software Autónoma

## 7. Estratégia de Prompting

Foram utilizadas ferramentas de Inteligência Artificial para apoio no desenvolvimento e resolução de problemas.

Exemplos de prompts utilizados:

- “Como consumir uma API usando Retrofit em Android?”
- “Como implementar RecyclerView em Kotlin?”
- “Como criar layouts landscape em Android?”
- “Como implementar um sistema de favoritos?”

Ao longo do desenvolvimento, os prompts tornaram-se mais específicos e detalhados.

---

## 8. Workflow com IA

A Inteligência Artificial foi utilizada nas seguintes fases:

- Planeamento
- Melhorias da interface
- Implementação do RecyclerView
- Configuração do Retrofit
- Debugging
- Apoio com Git e GitHub
- Layouts landscape

O estudante manteve sempre controlo sobre as decisões finais do projeto.

---

## 9. Verificação de Código Gerado por IA

Todo o código e sugestões obtidas através de IA foram analisados e testados manualmente.

A verificação incluiu:

- Execução da aplicação
- Testes funcionais
- Validação manual da interface
- Testes do RecyclerView e filtros
- Verificação do GitHub

---

## 10. Contribuição Humana vs IA

### Contribuição Humana

- Estrutura do projeto
- Decisões de interface
- Personalização dos layouts
- Testes da aplicação
- Organização final do projeto
- Validação funcional

### Contribuição da IA

- Apoio em Kotlin
- Ajuda com RecyclerView
- Apoio com Retrofit
- Resolução de problemas no Git
- Sugestões de melhorias visuais

---

## 11. Uso Ético e Responsável da IA

A Inteligência Artificial foi utilizada apenas como ferramenta de apoio ao desenvolvimento.

Todas as sugestões geradas por IA foram:

- Analisadas manualmente
- Testadas antes de serem utilizadas
- Adaptadas aos requisitos do projeto

O estudante assume total responsabilidade pelo trabalho submetido.

---

# Processo de Desenvolvimento

## 12. Controlo de Versões e Histórico de Commits

Foi utilizado Git e GitHub durante todo o desenvolvimento do projeto.

O repositório contém múltiplos commits que representam a evolução do trabalho, implementação de funcionalidades e correção de erros.

---

## 13. Dificuldades e Aprendizagens

### Principais Dificuldades

- Implementação do RecyclerView
- Gestão de dados da API
- Layouts landscape
- Gestão do repositório GitHub
- Implementação de filtros
- Sistema de favoritos

### Aprendizagens

- Desenvolvimento de interfaces Android
- Consumo de APIs com Retrofit
- Utilização de RecyclerView
- Conceitos básicos de MVVM
- Utilização de Git e GitHub
- Criação de layouts responsivos

---

## 14. Melhorias Futuras

Possíveis melhorias futuras:

- Guardar favoritos permanentemente utilizando Room Database
- Adicionar mais filtros de Pokémon
- Adicionar animações e transições
- Melhorar ainda mais a interface
- Modo offline
- Estatísticas detalhadas dos Pokémon

---

## 15. Declaração de Uso de IA
- Apoio na resolução de problemas
- Debugging
- Melhorias da interface
- Explicações de Kotlin
- Apoio com Git e GitHub

O estudante mantém total responsabilidade sobre todo o conteúdo submetido.

