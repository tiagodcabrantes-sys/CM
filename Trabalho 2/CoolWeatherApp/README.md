# Assignment 2 - Cool Weather Application

Curso: Computação Móvel  
Aluno(s): Tiago Abrantes  


---

## 1. Introdução

O objetivo deste trabalho foi desenvolver uma aplicação móvel Android denominada “Cool Weather Application”, utilizando Kotlin e layouts XML. O projeto teve como principal finalidade explorar conceitos fundamentais do desenvolvimento Android moderno, incluindo consumo de APIs, design responsivo, localização GPS, suporte a múltiplos idiomas, temas visuais e arquitetura MVVM.

A aplicação permite ao utilizador consultar informações meteorológicas em tempo real através da API Open-Meteo, utilizando coordenadas geográficas introduzidas manualmente ou obtidas automaticamente através da localização do dispositivo.

Os principais objetivos do projeto foram:

- Desenvolver uma aplicação Android em Kotlin
- Consumir dados meteorológicos através de uma API REST
- Implementar layouts responsivos para diferentes orientações e dispositivos
- Utilizar localização GPS do dispositivo
- Implementar temas Day/Night
- Utilizar recursos XML para weather codes
- Aplicar o padrão arquitetural MVVM
- Utilizar LiveData e Data Binding
- Explorar o uso de Inteligência Artificial como apoio ao desenvolvimento

---

## 2. Visão Geral do Sistema

A aplicação apresenta informações meteorológicas de uma localização específica através de uma interface moderna e responsiva.

Principais funcionalidades:

- Obtenção automática da localização GPS do dispositivo
- Atualização manual da meteorologia através de coordenadas
- Visualização da temperatura atual
- Visualização da velocidade e direção do vento
- Visualização da pressão atmosférica
- Visualização da hora local da localização selecionada
- Alteração automática entre modo dia e noite
- Atualização dinâmica dos ícones meteorológicos
- Suporte para smartphone e tablet
- Suporte para portrait e landscape
- Suporte para Português e Inglês

A aplicação utiliza a API Open-Meteo para obter:

- Temperatura
- Velocidade do vento
- Direção do vento
- Pressão atmosférica
- Hora local
- Sunrise e Sunset
- Weather Codes

Caso de utilização:

O utilizador abre a aplicação e a localização atual do dispositivo é automaticamente obtida. A aplicação consulta a API meteorológica e apresenta as informações atualizadas, incluindo o ícone e background adequados à condição meteorológica e à hora local.

---

## 3. Arquitetura e Design

### Arquitetura

O projeto foi desenvolvido utilizando o padrão arquitetural MVVM (Model-View-ViewModel).

Principais componentes:

- MainActivity → gestão da interface gráfica
- WeatherViewModel → lógica de negócio e comunicação com a API
- WeatherData → modelo de dados meteorológicos
- XML Resources → armazenamento de weather codes e imagens

### Estrutura de Pastas

- java/dam_A15315.coolweatherapp/ → código Kotlin
- res/layout/ → layouts portrait smartphone
- res/layout-land/ → layouts landscape smartphone
- res/layout-sw600dp/ → layouts tablet
- res/layout-sw600dp-land/ → layouts landscape tablet
- res/drawable/ → ícones meteorológicos e backgrounds
- res/values/ → strings, temas e cores

### MVVM

O padrão MVVM foi utilizado para separar a lógica da interface.

A MainActivity é responsável apenas pela interface gráfica e observação dos dados.

A WeatherViewModel é responsável por:

- Comunicação com a API
- Gestão dos dados meteorológicos
- Atualização dos dados através de LiveData
- Processamento da informação meteorológica

### Data Binding

Foi utilizado Data Binding para associar a View ao ViewModel.

Os layouts foram convertidos para suportar binding através do elemento:

```xml
<layout>
```

### LiveData e Observer

Foi utilizado LiveData para comunicação entre o ViewModel e a View.

A MainActivity observa alterações nos dados meteorológicos e atualiza automaticamente a interface.

### Design Responsivo

Foram desenvolvidos layouts específicos para:

- Smartphone portrait
- Smartphone landscape
- Tablet portrait
- Tablet landscape

### Temas Day/Night

A aplicação inclui:

- Theme_Day
- Theme_Day_Land
- Theme_Night
- Theme_Night_Land

O background e os ícones são alterados automaticamente de acordo com a hora local da localização selecionada.

---

## 4. Implementação

### API Meteorológica

A aplicação utiliza a API Open-Meteo.

Exemplo de parâmetros utilizados:

- latitude
- longitude
- current_weather
- pressure_msl
- sunrise
- sunset
- timezone

A comunicação foi realizada utilizando:

- URL
- Gson
- InputStreamReader

### Localização GPS

Foi implementado acesso à localização do dispositivo através de:

```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```

A aplicação solicita permissões ao utilizador e obtém automaticamente a última localização conhecida.

### Weather Codes

Inicialmente os weather codes estavam implementados através de enumerações Kotlin.

Posteriormente, a implementação foi alterada para utilizar XML Resources através de arrays de recursos.

Isso permitiu:

- Melhor organização do código
- Maior flexibilidade
- Melhor utilização de recursos Android

### Atualização da Interface

A atualização da interface é realizada através do método updateUI.

Os dados atualizados incluem:

- Temperatura
- Velocidade do vento
- Direção do vento
- Pressão
- Hora local
- Latitude e longitude
- Ícone meteorológico
- Background da aplicação

### Day/Night Automático

A aplicação calcula automaticamente se é dia ou noite utilizando:

- Hora atual
- Sunrise
- Sunset

Dependendo do resultado:

- O background muda automaticamente
- Os ícones meteorológicos mudam automaticamente

### Suporte Multi-Language

Foram adicionados:

- Português
- Inglês

Todas as strings foram colocadas no ficheiro strings.xml.

### Suporte Tablet

Foram criados layouts específicos para tablets utilizando:

- layout-sw600dp
- layout-sw600dp-land

---

## 5. Testes e Validação

### Estratégia de Testes

A aplicação foi testada utilizando:

- Android Emulator
- Smartphone Android
- Diferentes resoluções
- Diferentes orientações

### Cenários Testados

- Obtenção automática da localização
- Atualização manual das coordenadas
- Atualização automática dos dados meteorológicos
- Mudança automática entre modo dia e noite
- Atualização automática dos ícones
- Funcionamento em portrait
- Funcionamento em landscape
- Funcionamento em tablet
- Funcionamento multi-language
- Funcionamento do GPS
- Comunicação com a API

### Edge Cases Testados

- Coordenadas inválidas
- Mudança rápida de orientação
- Falta de permissões GPS
- Mudança entre localizações distantes
- Localizações com diferentes fusos horários

### Limitações Conhecidas

- A aplicação necessita de ligação à internet
- A precisão do GPS depende do dispositivo
- O tema inicial pode aparecer momentaneamente antes da API responder

---

## 6. Instruções de Utilização

### Requisitos

- Android Studio
- Android SDK
- Ligação à internet
- Dispositivo Android ou Emulator

### Execução

1. Abrir o projeto no Android Studio
2. Fazer sincronização do Gradle
3. Executar a aplicação
4. Permitir acesso à localização
5. Testar diferentes coordenadas geográficas

### Dependências Utilizadas

- Gson
- AndroidX
- Lifecycle ViewModel
- LiveData
- ConstraintLayout

---

## 13. Dificuldades e Aprendizagens

### Principais Dificuldades

Durante o desenvolvimento da aplicação foram encontradas várias dificuldades técnicas relacionadas com o desenvolvimento Android.

As principais dificuldades foram:

- Implementação do padrão MVVM
- Configuração de Data Binding
- Gestão de LiveData
- Implementação de layouts responsivos
- Suporte para tablet e landscape
- Implementação da localização GPS
- Comunicação com a API meteorológica
- Atualização dinâmica do tema Day/Night
- Gestão de recursos XML
- Correção de erros de XML e Gradle

Outra dificuldade importante foi garantir que todos os layouts funcionassem corretamente em diferentes tamanhos de ecrã e orientações.

### Aprendizagens

O desenvolvimento deste projeto permitiu aprofundar conhecimentos importantes relacionados com Android.

Principais competências adquiridas:

- Desenvolvimento Android em Kotlin
- Utilização de XML layouts
- Implementação de MVVM
- Utilização de LiveData
- Configuração de Data Binding
- Consumo de APIs REST
- Utilização de GPS em Android
- Gestão de temas Day/Night
- Utilização de recursos XML
- Desenvolvimento de interfaces responsivas
- Debugging em Android Studio

O projeto também permitiu compreender melhor a separação entre lógica de negócio e interface gráfica.

---

## 14. Melhorias Futuras

Embora a aplicação esteja funcional, existem várias melhorias que poderão ser adicionadas no futuro.

Possíveis melhorias:

- Adicionar previsão meteorológica para vários dias
- Adicionar gráficos meteorológicos
- Adicionar animações meteorológicas
- Guardar localizações favoritas
- Melhorar ainda mais o design visual
- Adicionar notificações meteorológicas
- Melhorar o sistema automático Day/Night
- Utilizar Retrofit para comunicação com a API
- Adicionar sistema offline/cache
- Melhorar ainda mais o suporte para tablets
- Adicionar widgets Android
- Adicionar seleção automática de localização em tempo real

---

## 15. Declaração de Uso de IA

Durante o desenvolvimento do projeto foram utilizadas ferramentas de apoio para esclarecimento de dúvidas técnicas relacionadas com Android Studio, Kotlin e arquitetura MVVM. Todo o código, testes, validações e decisões finais do projeto foram realizados e verificados manualmente pelo estudante, que assume total responsabilidade pelo trabalho submetido.

