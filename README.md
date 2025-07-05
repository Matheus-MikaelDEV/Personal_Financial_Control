
# 💰 Personal Financial System

Um sistema simples em Java que permite registrar, remover e listar transações financeiras com base em data, valor e tipo (depósito ou saque). Desenvolvido utilizando conceitos de Programação Orientada a Objetos (POO), `BigDecimal` para precisão monetária, `LocalDate` para manipulação de datas e `Enum` para o tipo de transação.

---

## 🧾 Funcionalidades

- ✅ Adicionar transações (DEPÓSITO ou SAQUE)
- ❌ Remover transações por ID
- 📆 Listar transações por período (entre duas datas)
- 📋 Listar todas as transações
- 💸 Exibir o saldo total (em desenvolvimento)

---

## 📂 Estrutura de Pacotes

```plaintext
src/
├── application/
│   └── Main.java             # Classe principal que inicia o sistema
├── entities/
│   ├── Transaction.java      # Classe que representa uma transação
│   └── enums/
│       └── TypeTransaction.java  # Enum com os tipos de transação
├── util/
│   └── Financial.java        # Classe responsável pela lógica de controle financeiro
```

---

## 🚀 Como Executar

1. Clone o repositório ou copie os arquivos para sua IDE Java (como IntelliJ IDEA ou Eclipse).
2. Execute a classe `Main.java`.
3. Quando solicitado, digite `start` para iniciar o sistema.

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- `java.time.LocalDate`
- `java.math.BigDecimal`
- Programação Orientada a Objetos (POO)
- Enumeração (`enum`)

---

## 📌 Exemplo de Uso

### ➕ Adicionar Transação

```
1 - Transaction
Enter a description for your transaction: Salary
What type of transaction is it? deposit
Transfer date (YYYY-MM-DD): 2025-07-01
Enter amount to deposit: 2500
Transaction completed!
```

### ❌ Remover Transação

```
2 - Remove Transaction
Transaction ID that will be removed: 0
Complete removal!
```

### 📆 Listar por Período

```
3 - List by Period
First date (YYYY-MM-DD): 2025-07-01
Second date (YYYY-MM-DD): 2025-07-31
0 - Salary - DEPOSIT - 2500 - R$2025-07-01
Listing by period completed!
```

---

## ⚠️ Observações

- O sistema ainda não implementa a opção 4 (exibir total acumulado).
- Ao usar o tipo da transação, digite `deposit` ou `withdraw` (sem acentos e em inglês).
- O ID das transações listadas é apenas sequencial para identificação temporária na sessão.
