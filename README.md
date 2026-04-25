# 📦 LogiTrack Pro: Plataforma de Logística e Rastreamento em Tempo Real

> 🚧 **Status do Projeto:** Em Desenvolvimento ativo (Sprint 1 - Fundação do Monolito)

### 1. O Elevator Pitch (Proposta de Valor)
Para distribuidoras de médio e grande porte que perdem a visibilidade da sua frota durante picos de demanda, o **LogiTrack Pro** é uma plataforma de logística que garante o rastreamento em tempo real sob qualquer volume de acessos. Diferente dos sistemas monolíticos legados que travam o banco de dados sob estresse, nosso produto utiliza uma arquitetura orientada a eventos para absorver milhares de atualizações de GPS por segundo sem impacto na operação.

### 2. O Problema de Negócio (A Dor)
Em momentos de pico (chuva, sextas-feiras à noite, feriados), o sistema legado da distribuidora cai devido ao volume simultâneo de requisições de 50+ motoboys tentando atualizar seus status de GPS. Resultado: a operação fica "cega", atrasos não são comunicados aos clientes e a empresa perde confiabilidade e dinheiro.

### 3. As Personas (O Público-Alvo)
* **Roberto (Gestor da Distribuidora):** Precisa de um painel web que mostre os pedidos e os entregadores no mapa sem travar.
* **Carlos (Entregador):** Usa um app (simulado) que envia sua localização em segundo plano continuamente.
* **Maria (Cliente Final):** Deseja acompanhar o seu pedido em tempo real pelo navegador.

### 4. Fronteiras do Projeto (O Escopo)
O que **FAZ PARTE** da nossa entrega (In Scope):
* Sistema de gestão de pedidos (CRUD completo com MySQL).
* API de alta vazão para receber coordenadas de GPS de forma contínua.
* Integração assíncrona (Mensageria) para proteger o banco de dados.
* Painel web com mapa (Angular) atualizado em tempo real.
* Simulação de estresse comprovando a quebra do monolito e a resiliência dos microsserviços.

O que **NÃO FAZ PARTE** da entrega (Out of Scope):
* **Integração real de Pagamentos:** Não implementaremos gateways como Stripe ou Mercado Pago. O pagamento será apenas um status ("Aprovado/Pendente") no banco.
* **Algoritmo de Roteamento (Cálculo de Rotas):** Não criaremos rotas inteligentes como o Google Maps. Focaremos apenas na plotagem do ponto de GPS atual do motoboy no mapa.
* **Aplicativo Nativo Mobile:** Não desenvolveremos em Kotlin/Swift para Android/iOS. O "app do motoboy" será simulado via scripts (k6) para gerar carga, e a interface será web responsiva.

### 5. Métricas de Sucesso do Projeto (KPIs)
Como saberemos que este projeto deu certo?
* **Técnica:** O sistema não deve devolver Erro 500 mesmo recebendo 5.000 requisições de GPS por segundo.
* **Negócio:** A atualização do marcador da moto no mapa do painel administrativo deve ter um atraso (delay) máximo de 2 segundos em relação à vida real.

  ## 🗺️ Roadmap de Desenvolvimento
Para acompanhar a evolução da arquitetura, o projeto foi dividido nas seguintes etapas:

- [x] **Fase 1: Concepção e Design de Sistema** (Visão, Escopo e NFRs definidos).
- [ ] **Fase 2: Fundação Monolítica** (Modelagem de Dados e API Spring Boot inicial).
- [ ] **Fase 3: Visão do Cliente** (Painel Angular com consumo de mapa em tempo real).
- [ ] **Fase 4: O Colapso** (Scripts de estresse com k6 comprovando o gargalo do banco de dados).
- [ ] **Fase 5: Microsserviços e Eventos** (Introdução do RabbitMQ e segregação do serviço de GPS).
- [ ] **Fase 6: Orquestração** (Deploy com Docker e Minikube).
