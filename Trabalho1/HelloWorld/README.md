Course: Computação Móvel  
Student(s): Tiago Abrantes  
Date: 18/03/2026  
Repository URL: https://github.com/tiagodcabrantes-sys/CM/tree/main/Trabalho1/HelloWorld

---

## 1. Introdução
O objetivo deste trabalho foi evoluir a aplicação inicial "Hello Mobile World" (V1), introduzindo melhorias na interface gráfica e adicionando novos componentes visuais.

Nesta versão (V2), pretendeu-se aprofundar o conhecimento sobre:
- Criação de interfaces com ConstraintLayout
- Utilização de recursos (strings, cores, imagens)
- Organização e alinhamento de componentes na interface
- Suporte para diferentes orientações do dispositivo (portrait e landscape)

Este trabalho permitiu consolidar conceitos fundamentais no desenvolvimento de aplicações Android, especialmente ao nível da construção de interfaces adaptáveis.

---

## 2. Visão Geral do Sistema

A aplicação desenvolvida apresenta uma interface simples e intuitiva, contendo:
- Um título principal: "Hello Android World!"
- Um subtítulo: "My First App"
- Uma imagem representativa (logótipo da escola)
- Um componente de calendário

### Funcionalidades principais:
- Exibição de texto com estilos personalizados (cor, tamanho, alinhamento e fundo)
- Carregamento de imagem a partir da pasta drawable
- Visualização de calendário através do CalendarView
- Apresentação de uma mensagem de boas-vindas (Toast) ao iniciar a aplicação
- Adaptação automática da interface quando o dispositivo é rodado

A aplicação funciona como um exemplo básico de interface gráfica em Android.

---

## 3. Arquitetura e Design

### Arquitetura
A aplicação segue a estrutura base de uma aplicação Android:
- MainActivity → controla o ciclo de vida e comportamento da aplicação
- Layouts XML → definem a interface gráfica
- Resources → armazenam textos, cores e imagens

### Estrutura de Pastas
- java/ → código Kotlin (MainActivity)
- res/layout/ → layouts (portrait e landscape)
- res/values/ → strings.xml e colors.xml
- res/drawable/ → imagens

### Decisões de Design
- Utilização de ConstraintLayout para permitir posicionamento flexível e responsivo
- Separação de textos para strings.xml
- Definição de cores em colors.xml
- Criação de layout alternativo para landscape

---

## 4. Implementação

### TextView (Título)
- Texto: "Hello Android World!"
- Cor roxa, tamanho 24sp, negrito e centrado

### TextView (Subtítulo)
- Texto: "My First App"
- Fundo amarelo
- Ocupa toda a largura
- Alinhamento centrado

### ImageView
- Imagem da pasta drawable
- Inclui contentDescription para acessibilidade

### CalendarView
- Permite visualizar datas
- Portrait: abaixo da imagem
- Landscape: ao lado da imagem

### Layout Landscape
- Organização horizontal dos elementos
- Melhor uso do espaço

### MainActivity
- Mostra mensagem:
Toast.makeText(this,"Welcome to my App!",Toast.LENGTH_LONG).show()

- Ajusta layout às barras do sistema
- Regista informação no log

---

## 5. Testes e Validação

### Estratégia de Teste
- Testes no emulador
- Testes em portrait e landscape

### Casos Testados
- App inicia corretamente
- Textos aparecem corretamente
- Imagem é carregada
- Calendário funciona
- Rotação funciona
- Toast aparece

### Limitações
- Sem interação do utilizador
- Conteúdo estático
- Sem navegação

---

## 6. Instruções de Utilização

### Requisitos
- Android Studio
- Android SDK (API 24+)

### Execução
1. Abrir projeto no Android Studio
2. Fazer sync
3. Executar (Shift + F10)
4. Escolher dispositivo
5. Ver aplicação

---

# Processo de Desenvolvimento

## 12. Controlo de Versões
Foi utilizado Git e GitHub com vários commits ao longo do desenvolvimento.

---

## 13. Dificuldades e Aprendizagens

### Dificuldades
- ConstraintLayout
- Layout landscape

### Aprendizagens
- Estrutura Android
- Uso de resources
- Layouts adaptáveis

---

## 14. Melhorias Futuras
- Adicionar interação
- Melhorar design
- Tornar dinâmica
- Melhor responsividade

---

## 15. Declaração de Uso de IA

Foi utilizada uma ferramenta de Inteligência Artificial apenas como apoio pontual para compreender como criar um layout alternativo (landscape).

Todo o código, implementação e decisões do projeto foram desenvolvidos de forma autónoma pelo estudante.

O uso de IA teve apenas caráter educativo, semelhante à consulta de documentação ou fóruns.
