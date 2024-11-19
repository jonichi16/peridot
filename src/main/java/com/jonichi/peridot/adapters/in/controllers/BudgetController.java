package com.jonichi.peridot.adapters.in.controllers;

import com.jonichi.peridot.application.BudgetService;
import com.jonichi.peridot.domain.model.Envelope;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/budget")
@RequiredArgsConstructor
public class BudgetController {
    private final BudgetService budgetService;

    @PostMapping("/allocate")
    public Envelope allocateBudget(@RequestParam String category, @RequestParam BigDecimal budget) {
        return budgetService.allocateBudget(category, budget);
    }

    @GetMapping("/envelopes")
    public List<Envelope> getAllEnvelopes() {
        return budgetService.getAllEnvelopes();
    }
}