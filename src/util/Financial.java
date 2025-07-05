package util;

import entities.Transaction;
import entities.enums.TypeTransaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Financial {
    private List<Transaction> transactions;
    private Integer id;

    private BigDecimal total;

    public Financial() {
        this.total = BigDecimal.ZERO;
        this.transactions = new ArrayList<>();
    }

    public boolean addTransaction(Transaction transaction) {
        boolean completed = false;

        if (transaction.getType() == TypeTransaction.DEPOSIT) {
            this.transactions.add(transaction);
            total = total.add(transaction.getValue());
            completed = true;
        } else if (transaction.getType() == TypeTransaction.WITHDRAW) {
            if (transaction.getValue().compareTo(total) <= 0) {
                transactions.add(transaction);
                total = total.subtract(transaction.getValue());

                completed = true;
            }
        }
        return completed;
    }

    public boolean removeTransaction(Integer remove) {
        boolean completed = false;

        if (transactions.isEmpty()) {
            completed = false;
        } else {
            if (remove <= transactions.size()) {
                transactions.remove(remove);
                completed = true;
            }
        }

        return completed;
    }

    public String listByPeriod (LocalDate start, LocalDate end) {
        StringBuilder sb = new StringBuilder();

        if (transactions.isEmpty()) {
            sb.append("No transactions found.");
        } else {
            id = 0;

            for (Transaction t : transactions) {
                if (t.getTransactionDate().isAfter(start) && t.getTransactionDate().isBefore(end)) {
                    sb.append(id + " - " + t);
                    id++;
                }
            }
        }

        return sb.toString();
    }

    public String list() {
        id = 0;

        StringBuilder sb = new StringBuilder();

        for (Transaction t : transactions) {
            sb.append(id + " - " + t);
            id++;
        }

        return sb.toString();
    }

    public Integer getId() {
        return id;
    }
}