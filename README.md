# Testes de Software em Sistema Bancário

## Objetivo Geral

Implementar e executar técnicas de testes de software para validar o funcionamento de um sistema bancário simplificado. Os testes foram realizados em dois módulos principais:

* **`ContaService`**: responsável por operações financeiras como saques, depósitos, transferências e gerenciamento de contas.
* **`ClienteService`**: responsável pela administração de clientes, incluindo cadastro, ativação, desativação e validação de idade.

Para garantir uma ampla cobertura de regras de negócio, foram utilizadas as seguintes técnicas:

* **Teste de Ramificação**: cobertura das condições lógicas;
* **Teste de Transição de Estado**: validação do ciclo de vida dos clientes;
* **Teste de Matriz (Tabela de Decisão)**: análise sistemática de regras de negócio;
* **Teste de Matriz Ortogonal**: cobertura crítica com menos redundância;
* **Teste de Loop**: validação de estruturas de repetição em métodos críticos.
* **Teste de Padrão**: verificação de conformidade e comportamento repetitivo no sistema.

---

## Técnicas Aplicadas e Casos de Teste

### 1. Teste de Ramificação

Assegurou que todas as ramificações lógicas do código fossem testadas. Casos de teste foram aplicados no método `sacar()` da `ContaService`.

| CT   | Cenário              | Entrada                               | Resultado Esperado |
| :--- | :------------------- | :------------------------------------ | :----------------- |
| **CT01** | Caminho verdadeiro   | `idConta=1`, `valor=100.0`, `saldo=500` | `true`             |
| **CT02** | Conta inexistente    | `idConta=999`, `valor=50.0`           | `false`            |
| **CT03** | Valor negativo       | `idConta=1`, `valor=-50.0`            | `false`            |
| **CT04** | Saldo insuficiente   | `idConta=1`, `valor=1000.0`           | `false`            |

### 2. Teste de Transição de Estado

Testes focados no ciclo de vida do cliente (`Ativo` <-> `Inativo`) para validar as mudanças de estado com base nos eventos do sistema.

| CT   | Transição                 | Estado Inicial | Evento                | Estado Final     |
| :--- | :------------------------ | :------------- | :-------------------- | :--------------- |
| **CT01** | Ativo → Inativo           | Ativo          | `desativarCliente(1)` | Inativo          |
| **CT02** | Inativo → Ativo           | Inativo        | `ativarCliente(1)`    | Ativo            |
| **CT03** | Ativar cliente já ativo   | Ativo          | `ativarCliente(1)`    | Permanece Ativo  |

### 3. Teste de Matriz (Tabela de Decisão)

Utilizado para mapear combinações de regras de negócio e condições. Exemplo aplicado à operação de saque em `ContaService`.

| Conta Existe | Valor > 0 | Saldo >= Valor | Resultado Esperado            |
| :----------: | :-------: | :------------: | :---------------------------- |
|      Não     |    Sim    |      Sim       | `false` – Conta inexistente   |
|      Sim     |    Não    |      Sim       | `false` – Valor inválido      |
|      Sim     |    Sim    |      Não       | `false` – Saldo insuficiente  |
|   **Sim** |  **Sim** |    **Sim** | **`true` – Saque realizado** |

### 4. Teste de Matriz Ortogonal

Objetivo de reduzir a redundância de testes, validando apenas as combinações mais críticas entre diferentes variáveis do sistema.

| Operação      | Status da Conta | Saldo | Resultado Esperado             |
| :------------ | :-------------- | :---- | :----------------------------- |
| Saque         | Ativa           | Médio | Saque bem-sucedido             |
| Saque         | Inativa         | Alto  | Operação negada                |
| Transferência | Ativa           | Baixo | Negada por saldo insuficiente  |
| Depósito      | Ativa           | Médio | Depósito realizado             |

### 5. Teste de Loop

Os testes de loop foram aplicados em métodos que iteram sobre listas (como `pesquisaConta`), garantindo que o comportamento seja validado para diferentes cenários de quantidade de elementos.

| Cenário                       | Descrição                                                              |
| :---------------------------- | :--------------------------------------------------------------------- |
| **Loop não executado** | A lista de contas está vazia, nenhuma iteração ocorre.                 |
| **Uma iteração** | A conta procurada é encontrada na primeira posição da lista.             |
| **Múltiplas iterações** | A conta é encontrada na última posição, forçando o loop a percorrer toda a lista. |
| **Loop completo sem resultado** | Nenhuma conta corresponde ao ID pesquisado após percorrer toda a lista. |

### 6. Teste de Padrão

Utilizados para verificar a conformidade com comportamentos repetitivos e consistentes no sistema, garantindo que as regras de negócio sejam aplicadas de forma uniforme.

| Operação Testada      | Condição                                | Resultado Esperado                  |
| :-------------------- | :-------------------------------------- | :---------------------------------- |
| **Saque** | Saldo final se tornaria negativo        | Lançar erro ou retornar `false`     |
| **Transferência** | Conta de destino está inativa           | Operação negada                     |
| **Ativação de cliente** | Cliente já se encontra no estado "Ativo" | Nenhuma alteração de estado ocorre  |

---

## Resultados Obtidos

A aplicação sistemática das técnicas de teste permitiu:
* A validação das principais regras de negócio do sistema.
* A identificação antecipada de erros em estruturas de repetição e na lógica de validação de saldo.
* A garantia de consistência nos estados dos clientes e no resultado das operações financeiras.
