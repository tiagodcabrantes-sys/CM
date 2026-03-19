
Course: Computação Móvel  
Student(s): Tiago Abrantes  
Date: 18/03/2026  
Repository URL: https://github.com/tiagodcabrantes-sys/CM/tree/main/Trabalho1/Exercicios%20InteliJ

---

## 1. Introdução

O objetivo deste trabalho foi introduzir e consolidar os conceitos fundamentais da linguagem Kotlin através da implementação de vários exercícios práticos em ambiente de consola, utilizando o IntelliJ IDEA.

Foram desenvolvidos três exercícios focados em estruturas básicas da linguagem e um exercício mais avançado baseado em Programação Orientada a Objetos, que consiste na criação de um sistema de gestão de uma biblioteca virtual.

Ao longo do trabalho foram abordados conceitos como:
- Tipos básicos e arrays
- Estruturas de controlo
- Manipulação de strings
- Tratamento de exceções
- Programação funcional (map, filter, sequences)
- Programação orientada a objetos (classes, herança, encapsulamento e polimorfismo)

---

## 2. Visão Geral do Sistema

O projeto está organizado em diferentes packages, cada um correspondente a um exercício específico:

- `cm.exer_1` → cálculo de quadrados perfeitos  
- `cm.exer_2` → calculadora interativa  
- `cm.exer_3` → simulação dos saltos de uma bola  
- `cm.virtual_library` → sistema de biblioteca virtual  

Cada exercício é independente e executado através da função `main()`.

---

## 3. Arquitetura e Design

O projeto segue uma organização modular baseada em packages, permitindo uma separação clara entre os diferentes exercícios.

Na parte da biblioteca virtual foi utilizada Programação Orientada a Objetos, aplicando conceitos como:

- Classe abstrata (`Book`)
- Herança (`DigitalBook` e `PhysicalBook`)
- Encapsulamento (getters e setters personalizados)
- Polimorfismo (override de métodos)
- Companion object (variável partilhada)
- Data class (`LibraryMember`)

Esta estrutura permite criar um sistema organizado, escalável e próximo de um sistema real.

---

## 4. Implementação

### 4.1 Exercício 1 - Quadrados Perfeitos

Neste exercício foram implementadas três formas diferentes de gerar os primeiros 50 quadrados perfeitos:

**a) IntArray**
- Criação de um array de inteiros com tamanho fixo  
- Utilização de um ciclo `for` para calcular os valores  
- Acesso aos elementos através de índices  

**b) Range + map()**
- Utilização de um intervalo (1..50)  
- Aplicação da função `map` para calcular os quadrados  
- Abordagem baseada em programação funcional  

**c) Array com construtor**
- Criação de um array com valores inicializados  
- Cálculo manual dos quadrados  

Este exercício permitiu compreender diferentes formas de trabalhar com arrays e coleções em Kotlin.

---

### 4.2 Exercício 2 - Calculadora

Foi desenvolvida uma calculadora interativa que permite ao utilizador escolher entre operações numéricas e booleanas.

#### Funcionalidades:
- Operações aritméticas: +, -, *, /  
- Operadores booleanos: &&, ||, !  
- Operadores de bits: shl, shr  

#### Conceitos utilizados:
- Expressão `when` para seleção de operações  
- `try-catch` para tratamento de exceções  
- `readln()` para leitura de dados  
- Validação de inputs inválidos  
- Prevenção de divisão por zero  

Os resultados são apresentados em:
- Decimal  
- Hexadecimal  
- Booleano (quando aplicável)  

O programa executa em ciclo até o utilizador escolher sair.

---

### 4.3 Exercício 3 - Saltos da Bola

Neste exercício foi utilizada programação funcional para simular os saltos de uma bola.

A bola começa a uma altura de 100 metros e perde 40% da altura a cada salto.

#### Etapas:
1. Criação de uma sequência com `generateSequence`  
2. Aplicação da redução da altura (60%)  
3. Filtragem de valores superiores ou iguais a 1 metro  
4. Seleção dos primeiros 15 valores  
5. Formatação com duas casas decimais  

Este exercício permitiu explorar:
- Sequências em Kotlin  
- Avaliação lazy  
- Funções como `filter` e `take`  

---

### 4.4 Virtual Library

Este exercício consiste na implementação de um sistema de gestão de biblioteca virtual utilizando Programação Orientada a Objetos.

#### Classe abstrata Book
- Contém propriedades base dos livros  
- Getter personalizado para classificar a era do livro  
- Setter personalizado para controlar o número de cópias  
- Método abstrato `getStorageInfo()`  

---

#### Classes derivadas

**DigitalBook**
- Propriedades: tamanho do ficheiro e formato  
- Representa livros digitais  

**PhysicalBook**
- Propriedades: peso e tipo de capa  
- Representa livros físicos  

Ambas implementam:
- `getStorageInfo()`  
- `toString()`  

---

#### Classe Library

Responsável pela gestão dos livros:

- `addBook()` → adiciona livros  
- `borrowBook()` → permite emprestar livros  
- `returnBook()` → permite devolver livros  
- `showBooks()` → apresenta todos os livros  
- `searchByAuthor()` → pesquisa por autor  

Inclui também um `companion object` para contar o número total de livros adicionados.

---

#### Data Class

**LibraryMember**
- Representa um utilizador da biblioteca  
- Contém nome, ID e lista de livros  

---

## 5. Testes e Validação

Os testes foram realizados através da execução manual no IntelliJ.

Foram testados:
- Operações válidas e inválidas na calculadora  
- Divisão por zero  
- Entradas inválidas  
- Limite de stock na biblioteca  
- Pesquisa de livros  

Todos os testes produziram resultados corretos.

---

## 6. Instruções de Utilização

1. Abrir o projeto no IntelliJ IDEA  
2. Executar os ficheiros `main()` de cada exercício  
3. Seguir as instruções apresentadas no terminal  

---

# Processo de Desenvolvimento

## 12. Controlo de Versões
Foi utilizado Git local para controlo de versões, com commits ao longo do desenvolvimento.

---

## 13. Dificuldades e Aprendizagens

### Dificuldades
- Compreensão de `generateSequence`  
- Implementação de getters e setters personalizados  
- Estruturação da lógica da calculadora  
- Aplicação de herança e classes abstratas  

---

### Aprendizagens
- Estrutura da linguagem Kotlin  
- Manipulação de dados e lógica  
- Programação orientada a objetos  
- Organização de código em packages  

---

## 14. Melhorias Futuras

- Criar interface gráfica para os exercícios  
- Melhorar validação de inputs  
- Tornar a biblioteca mais completa  
- Adicionar persistência de dados  

---

## 15. AI Usage Disclosure

Foram utilizadas ferramentas de Inteligência Artificial de forma limitada como apoio ao estudo da linguagem Kotlin.

A sua utilização teve como objetivo esclarecer conceitos teóricos, compreender melhor a sintaxe da linguagem e consolidar conhecimentos relacionados com programação orientada a objetos e programação funcional.

Toda a lógica dos exercícios, bem como a implementação do código, foi desenvolvida de forma autónoma, garantindo a compreensão dos conceitos aplicados.

A utilização de IA serviu apenas como ferramenta de apoio à aprendizagem, não tendo sido utilizada para gerar soluções completas.
