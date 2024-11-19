package com.jonichi.peridot.application;

import com.jonichi.peridot.adapters.out.persistence.EnvelopeRepository;
import com.jonichi.peridot.domain.model.Envelope;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetService {
    private final EnvelopeRepository envelopeRepository;

    public Envelope allocateBudget(String category, BigDecimal budget) {
        Envelope envelope = new Envelope(null, category, budget, BigDecimal.ZERO);
        return envelopeRepository.save(envelope);
    }

    public List<Envelope> getAllEnvelopes() {
        return envelopeRepository.findAll();
    }
}