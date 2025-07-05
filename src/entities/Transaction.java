package entities;

import entities.enums.TypeTransaction;
import util.Financial;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private String discription;
    private TypeTransaction type;
    private BigDecimal value;
    private LocalDate transactionDate;

    Financial financial;

    public Transaction(String discription, TypeTransaction type, BigDecimal value, LocalDate transactionDate) {
        this.discription = discription;
        this.type = type;
        this.value = value;
        this.transactionDate = transactionDate;
    }

    public String getDiscription() {
        return discription;
    }

    public TypeTransaction getType() {
        return type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public String toString () {
        StringBuilder sb = new StringBuilder();

        sb.append(discription+" - "+type.toString()+" - "+value.toString()+" - R$"+transactionDate.toString() + "\n");

        return sb.toString();
    }
}
