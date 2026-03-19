

Course: Computação Móvel  
Student(s): Tiago Abrantes  
Date: 18/03/2026  
Repository URL:https://github.com/tiagodcabrantes-sys/CM/tree/main/Trabalho1/Random%20Facts%20App
---

## 1. Introdução
O objetivo deste trabalho foi desenvolver uma aplicação móvel Android utilizando Kotlin e layouts em XML, com apoio de ferramentas de Inteligência Artificial, conforme os requisitos do trabalho MIP.

A aplicação desenvolvida, denominada “Random Facts App”, permite ao utilizador visualizar factos aleatórios relacionados com tecnologia, acompanhados por uma imagem correspondente.

Este projeto teve como principal objetivo aplicar conceitos fundamentais de desenvolvimento Android, incluindo criação de interfaces, interação com o utilizador e atualização dinâmica de conteúdos, ao mesmo tempo que se explorou o uso da Inteligência Artificial como ferramenta de apoio ao desenvolvimento.

---

## 2. Visão Geral do Sistema
A aplicação consiste num único ecrã com uma interface simples e intuitiva.

O ecrã apresenta:
- Um título com o nome da aplicação
- Uma imagem associada ao facto
- Um texto com o facto gerado
- Um botão para gerar novos factos

### Funcionalidades principais:
- Geração aleatória de factos a partir de uma lista pré-definida
- Exibição de uma imagem correspondente a cada facto
- Evita a repetição do mesmo facto consecutivamente
- Atualização dinâmica do conteúdo ao clicar no botão
- Suporte para orientação vertical (portrait) e horizontal (landscape)

### Caso de utilização:
O utilizador abre a aplicação e pressiona o botão para gerar um novo facto. A cada clique, o texto e a imagem são atualizados.

---

## 3. Arquitetura e Design

### Arquitetura
A aplicação segue uma estrutura simples e organizada:
- **MainActivity** → responsável pela lógica e controlo da interface
- **Layouts XML** → definem a estrutura visual da aplicação
- **Resources** → armazenam imagens e textos

---

### Estrutura de Pastas
- `java/` → código Kotlin (MainActivity)
- `res/layout/` → layouts para portrait e landscape
- `res/drawable/` → imagens
- `res/values/` → strings.xml

---

### Decisões de Design
O design da aplicação foi definido de forma simples e clara, com foco na facilidade de utilização.

- O layout foi desenhado manualmente pelo estudante utilizando ConstraintLayout
- Foram criadas versões diferentes do layout para portrait e landscape
- A interface foi centrada e organizada para destacar os factos e imagens
- Foi utilizada uma abordagem baseada em listas para associar factos e imagens

Todas as decisões relacionadas com o design e organização da interface foram feitas pelo estudante, garantindo total compreensão do funcionamento da aplicação.

---

## 4. Implementação

### Componentes da Interface
A aplicação utiliza os seguintes componentes:

- **TextView (título)** → apresenta o nome da aplicação  
- **ImageView** → mostra a imagem associada ao facto  
- **TextView (factText)** → exibe o facto  
- **Button** → permite gerar novos factos  

---

### Estrutura de Dados
Foram utilizadas duas listas:
- Lista de factos (String)
- Lista de imagens (referências a recursos drawable)

Cada facto está associado a uma imagem através do mesmo índice.

---

### Lógica da Aplicação
Quando o utilizador pressiona o botão:
1. É gerado um índice aleatório
2. O sistema verifica se não é o mesmo índice anterior
3. O facto e a imagem correspondentes são apresentados

Este mecanismo evita repetições consecutivas e melhora a experiência do utilizador.

---

### Comportamento Dinâmico
- O texto e a imagem são atualizados dinamicamente
- O botão altera o seu texto para “Next Fact!” após o primeiro clique

---

## 5. Testes e Validação

### Estratégia de Teste
A aplicação foi testada utilizando o emulador Android.

Foram realizados testes em:
- Modo portrait
- Modo landscape

---

### Casos Testados
- A aplicação inicia corretamente  
- O botão gera novos factos  
- O texto é atualizado corretamente  
- A imagem muda corretamente  
- Não há repetição imediata de factos  
- O layout adapta-se à rotação do dispositivo  

---

### Limitações
- Os factos são estáticos (não utiliza API externa)
- Não existe armazenamento de dados
- Interface simples sem funcionalidades avançadas

---

## 6. Instruções de Utilização

### Requisitos
- Android Studio  
- Android SDK  

---

### Execução
1. Abrir o projeto no Android Studio  
2. Fazer sincronização do Gradle  
3. Executar a aplicação  
4. Selecionar um dispositivo ou emulador  
5. Pressionar o botão para gerar factos  

---

# Secções de Engenharia de Software Autónoma

## 7. Estratégia de Prompting
Foram utilizadas ferramentas de Inteligência Artificial (ChatGPT) principalmente para apoio na geração de ideias e compreensão de conceitos.

Inicialmente, foram utilizados prompts mais gerais, como:
- “Ideias de aplicações simples em Android”

Posteriormente, os prompts tornaram-se mais específicos:
- “Como gerar valores aleatórios em Kotlin?”
- “Como evitar repetir valores aleatórios?”

Esta evolução permitiu um uso mais eficiente da IA.

---

## 8. Workflow com IA
A Inteligência Artificial foi utilizada como ferramenta de apoio em várias fases:

- Planeamento → geração da ideia da aplicação  
- Desenvolvimento → esclarecimento de dúvidas na lógica  
- Debug → ajuda na identificação de erros  

No entanto, toda a implementação e design foram realizados manualmente pelo estudante.

---

## 9. Verificação de Código Gerado por IA
Todo o conteúdo obtido através de IA foi analisado e validado manualmente.

A verificação incluiu:
- Execução da aplicação no emulador  
- Testes funcionais  
- Validação da lógica  
- Confirmação do comportamento esperado  

---

## 10. Contribuição Humana vs IA

### Contribuição Humana
- Implementação completa da aplicação  
- Design da interface  
- Organização das listas de dados  
- Testes e validação  
- Decisões finais do projeto  

### Contribuição da IA
- Apoio na geração de ideias  
- Explicação de conceitos  
- Ajuda pontual na lógica  

O estudante manteve controlo total sobre o desenvolvimento.

---

## 11. Uso Ético e Responsável da IA
A IA foi utilizada de forma responsável, apenas como ferramenta de apoio.

Foram seguidos os seguintes princípios:
- Compreensão total do código utilizado  
- Não utilização de código sem validação  
- Avaliação crítica das sugestões  

---

# Processo de Desenvolvimento

## 12. Controlo de Versões
Foi utilizado Git e GitHub para gestão do projeto.

---

## 13. Dificuldades e Aprendizagens

### Dificuldades
- Implementação de lógica aleatória sem repetição  
- Organização do layout em diferentes orientações  

---

### Aprendizagens
- Desenvolvimento de interfaces Android  
- Manipulação de eventos  
- Uso de listas e lógica em Kotlin  
- Utilização eficaz de IA como apoio  

---

## 14. Melhorias Futuras
- Integração com API externa  
- Melhorias visuais (Material Design)  
- Animações  
- Sistema de favoritos  

---

## 15. Declaração de Uso de IA

Foram utilizadas ferramentas de Inteligência Artificial (ChatGPT) para apoio na geração de ideias e compreensão de conceitos.

Todo o design, implementação e decisões finais foram realizados pelo estudante, que assume total responsabilidade pelo trabalho.
