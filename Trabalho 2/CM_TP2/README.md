# Assignment 2 - Kotlin Advanced Exercises

Course: Computação Móvel  
Student(s): Tiago Abrantes  


---

## 1. Introdução

O objetivo deste trabalho foi aprofundar os conhecimentos da linguagem Kotlin através da implementação de vários exercícios focados em conceitos avançados da linguagem.

Ao longo do trabalho foram desenvolvidos exercícios relacionados com:
- Sealed classes
- Extension functions
- Higher-order functions
- Generics
- Operator overloading
- Programação funcional
- Lambdas
- Estruturas de dados genéricas

Cada exercício foi implementado em ambiente de consola utilizando o IntelliJ IDEA.

---

## 2. Visão Geral do Sistema

O projeto encontra-se organizado em diferentes packages, sendo cada exercício independente dos restantes.

Os exercícios desenvolvidos foram:

- `cm.exer_1` → processamento de eventos com extension functions  
- `cm.exer_2` → cache genérica em memória  
- `cm.exer_3` → pipeline configurável de processamento de dados  
- `cm.exer_4` → biblioteca matemática de vetores 2D  

Cada exercício possui a sua própria função `main()` para testes e validação das funcionalidades implementadas.

---

## 3. Arquitetura e Design

O projeto segue uma estrutura modular baseada em packages separados para cada exercício.

Foram utilizados diferentes paradigmas e funcionalidades da linguagem Kotlin conforme os requisitos de cada exercício.

### Conceitos utilizados

- Sealed classes
- Data classes
- Extension functions
- Higher-order functions
- Lambdas
- Generics
- Operator overloading
- Coleções e funções funcionais (`map`, `filter`, `sumOf`)
- Tratamento de exceções

### Organização

Cada exercício foi implementado num ficheiro independente, permitindo:
- Separação clara das funcionalidades
- Melhor organização do código
- Facilidade de manutenção
- Execução individual dos exercícios

---

## 4. Implementação

### 4.1 Exercício 1 - Event Log Processing

Neste exercício foi desenvolvido um sistema simples de processamento de eventos utilizando sealed classes e programação funcional.

#### Estrutura de Eventos

Foi criada uma sealed class `Event` com os seguintes tipos:
- `Login`
- `Purchase`
- `Logout`

Cada evento contém informação relacionada com o utilizador e timestamps.

---

#### Extension Functions

Foram implementadas:
- `filterByUser()` → filtra eventos de um utilizador específico
- `totalSpent()` → calcula o total gasto por um utilizador

Estas funções utilizam:
- `filter`
- `filterIsInstance`
- `sumOf`

---

#### Higher-order Function

Foi criada a função:
- `processEvents()`

Esta função recebe:
- Uma lista de eventos
- Uma lambda responsável pelo processamento de cada evento

Foi utilizada uma expressão `when` para tratar todos os tipos de eventos.

---

### 4.2 Exercício 2 - Generic Cache

Neste exercício foi implementada uma cache genérica em memória utilizando generics.

#### Classe Cache<K, V>

A cache utiliza internamente:
- `MutableMap<K, V>`

Foram implementadas as seguintes operações:
- `put()`
- `get()`
- `evict()`
- `size()`

---

#### Funcionalidades adicionais

##### getOrPut()
Permite:
- Obter um valor existente
- Criar automaticamente um novo valor caso a chave não exista

---

##### transform()
Aplica uma transformação sobre um valor existente na cache.

---

##### snapshot()
Devolve uma cópia imutável da cache.

---

#### Testes realizados

Foram testados dois cenários:
- Cache de frequências de palavras (`String`, `Int`)
- Cache de registo de utilizadores (`Int`, `String`)

---

### 4.3 Exercício 3 - Configurable Data Pipeline

Neste exercício foi criado um pipeline configurável de transformação de dados utilizando higher-order functions e lambdas.

#### Classe Pipeline

A classe permite:
- Adicionar etapas de transformação
- Executar transformações sequenciais
- Descrever as etapas existentes

Cada etapa corresponde a uma função do tipo:

```kotlin
(List<String>) -> List<String>
```

---

#### buildPipeline()

Foi implementada uma função top-level responsável pela criação e configuração do pipeline utilizando lambdas com receiver.

---

#### Etapas Implementadas

O pipeline desenvolvido processa logs através das seguintes etapas:
1. Trim
2. Filter errors
3. Uppercase
4. Add index

---

#### Programação Funcional

Foram utilizadas funções como:
- `map`
- `filter`

para transformar os dados de forma funcional.

---

### 4.4 Exercício 4 - Vec2 Operator Overloading

Neste exercício foi desenvolvida uma biblioteca matemática simples para vetores 2D.

#### Classe Vec2

Foi criada uma data class:
- `Vec2(x, y)`

---

#### Operator Overloading

Foram implementados os operadores:
- `+`
- `-`
- `*`
- `unary -`
- `compareTo`
- `get`

Isto permite utilizar objetos `Vec2` de forma semelhante a tipos numéricos.

---

#### Funções Matemáticas

Foram implementadas:
- `magnitude()`
- `dot()`
- `normalized()`

---

#### Comparação de Vetores

A comparação entre vetores é realizada através da magnitude Euclidiana.

Foi implementada a interface:
- `Comparable<Vec2>`

---

#### Tratamento de Exceções

Foram tratados casos inválidos como:
- Normalização do vetor nulo
- Índices inválidos no operador `get`

---

## 5. Testes e Validação

Os testes foram realizados através da execução manual no IntelliJ IDEA.

### Cenários testados

#### Exercício 1
- Filtragem correta de eventos
- Cálculo correto do total gasto
- Processamento de diferentes tipos de eventos

---

#### Exercício 2
- Inserção e remoção de dados
- Atualização de valores
- Transformações na cache
- Cópias imutáveis com `snapshot`

---

#### Exercício 3
- Execução sequencial das etapas
- Filtragem correta de logs
- Transformações de texto

---

#### Exercício 4
- Operações matemáticas entre vetores
- Comparações utilizando magnitude
- Normalização de vetores
- Acesso através de índices

Todos os testes produziram os resultados esperados.

---

## 6. Instruções de Utilização

### Requisitos
- IntelliJ IDEA
- Kotlin SDK

---

### Execução

1. Abrir o projeto no IntelliJ IDEA  
2. Fazer sync do projeto  
3. Executar o ficheiro correspondente ao exercício pretendido  
4. Visualizar os resultados na consola  

---

# Processo de Desenvolvimento

## 12. Controlo de Versões

Foi utilizado Git e GitHub para gestão e controlo de versões do projeto.

Os commits foram realizados ao longo do desenvolvimento dos exercícios.

---

## 13. Dificuldades e Aprendizagens

### Dificuldades
- Compreensão de operator overloading
- Utilização de higher-order functions
- Implementação de generics
- Estruturação de pipelines configuráveis
- Comparação de objetos através de `compareTo`

---

### Aprendizagens
- Utilização avançada de Kotlin
- Programação funcional
- Manipulação de coleções
- Desenvolvimento de classes genéricas
- Sobrecarga de operadores
- Organização modular de código

---

## 14. Melhorias Futuras

- Adicionar testes automáticos
- Melhorar reutilização de código
- Adicionar persistência de dados à cache
- Expandir a biblioteca Vec2 com mais operações matemáticas
- Tornar o pipeline mais dinâmico

---

## 15. AI Usage Disclosure

Não foram utilizadas ferramentas de Inteligência Artificial no desenvolvimento deste trabalho, conforme os requisitos do enunciado.
