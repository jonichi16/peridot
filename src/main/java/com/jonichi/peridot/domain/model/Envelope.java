package com.jonichi.peridot.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "envelopes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envelope {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private BigDecimal budget;
    private BigDecimal spent = BigDecimal.ZERO;

    public void addExpense(BigDecimal amount) {
        if (spent.add(amount).compareTo(budget) > 0) {
            throw new IllegalArgumentException("Budget exceeded for " + category);
        }
        spent = spent.add(amount);
    }

    public BigDecimal getRemainingBudget() {
        return budget.subtract(spent);
    }
}