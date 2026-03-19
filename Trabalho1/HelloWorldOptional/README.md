Course: Computação Móvel  
Student(s): Tiago Abrantes  
Date: 18/03/2026  
Repository URL: https://github.com/tiagodcabrantes-sys/CM/tree/main/Trabalho1/HelloWorldOptional

---

## 1. Introdução
O objetivo deste trabalho foi desenvolver uma aplicação Android capaz de apresentar informação sobre o dispositivo onde está a ser executada.

A informação apresentada é obtida diretamente das propriedades do sistema, utilizando a classe android.os.Build.

Este exercício permitiu compreender como aceder a dados internos do sistema Android e como apresentar essa informação de forma organizada na interface.

---

## 2. Visão Geral do Sistema

A aplicação desenvolvida apresenta um único ecrã contendo informação detalhada sobre o dispositivo, incluindo:
- Fabricante
- Marca
- Modelo
- Tipo de build
- Utilizador
- Versão do sistema
- SDK
- Outras propriedades relevantes

Toda a informação é apresentada num único componente de texto multilinha (TextView).

### Funcionalidades principais:
- Recolha de informação do sistema através da classe Build
- Apresentação dinâmica da informação
- Interface simples e direta

---

## 3. Arquitetura e Design

### Arquitetura
A aplicação segue uma estrutura simples:
- MainActivity → responsável pela lógica e apresentação dos dados
- Layout XML → define a interface com um TextView
- Classe Build → fornece as propriedades do sistema

### Estrutura de Pastas
- java/ → código Kotlin
- res/layout/ → layout da interface
- res/values/ → recursos

### Decisões de Design
- Utilização de um único TextView para simplificar a interface
- Uso de ConstraintLayout para ocupar todo o ecrã
- Construção do texto dinamicamente no código

---

## 4. Implementação

### TextView
- Ocupa todo o ecrã
- Permite mostrar várias linhas de texto
- Inclui padding para melhor leitura

### Recolha de Informação
A informação é obtida através da classe Build:
- Build.MANUFACTURER
- Build.BRAND
- Build.MODEL
- Build.TYPE
- Build.USER
- Build.VERSION.BASE_OS
- Build.VERSION.INCREMENTAL
- Build.VERSION.SDK_INT
- Build.DISPLAY

### Construção do Texto
Os dados são concatenados numa string e apresentados no TextView.

### Interface
- Interface simples
- Focada na apresentação de informação
- Sem interação do utilizador

---

## 5. Testes e Validação

### Estratégia de Teste
- Testes realizados no emulador Android

### Casos Testados
- Aplicação inicia corretamente
- Informação é apresentada no ecrã
- Dados correspondem ao dispositivo/emulador

### Limitações
- Interface básica
- Sem interação
- Apenas informativa

---

## 6. Instruções de Utilização

### Requisitos
- Android Studio
- Android SDK

### Execução
1. Abrir o projeto no Android Studio
2. Fazer sync do Gradle
3. Executar a aplicação
4. Selecionar um dispositivo/emulador
5. Visualizar a informação no ecrã

---

# Processo de Desenvolvimento

## 12. Controlo de Versões
Foi utilizado Git e GitHub para gestão do projeto.

---

## 13. Dificuldades e Aprendizagens

### Dificuldades
- Identificar propriedades relevantes da classe Build
- Organizar a informação de forma clara

### Aprendizagens
- Utilização da classe Build
- Acesso a informações do sistema Android
- Apresentação dinâmica de dados

---

## 14. Melhorias Futuras
- Melhorar o design da interface
- Organizar a informação em formato mais estruturado
- Adicionar scroll automático
- Incluir mais dados do sistema

---

## 15. Declaração de Uso de IA

Não foram utilizadas ferramentas de Inteligência Artificial neste trabalho, conforme os requisitos do enunciado.
