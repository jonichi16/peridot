package com.jonichi.peridot.adapters.out.persistence;

import com.jonichi.peridot.domain.model.Envelope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvelopeRepository extends JpaRepository<Envelope, Long> {
}