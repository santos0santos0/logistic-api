package com.santos0santos0.log.domain.model;

import com.santos0santos0.log.domain.ValidationGroups;
import com.santos0santos0.log.domain.exception.DomainException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @Embedded
    private Recipient recipient;

    private BigDecimal tax;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurrence> occurrences = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private StatusDelivery status;

    private OffsetDateTime dateOrder;

    private OffsetDateTime dateFinalization;

    public Occurrence addOccurrence(String description) {
        Occurrence occurrence = new Occurrence();
        occurrence.setDescription(description);
        occurrence.setDateRecord(OffsetDateTime.now());
        occurrence.setDelivery(this);

        this.getOccurrences().add(occurrence);

        return occurrence;
    }

    public void finished() {
        if (notCanFinished()) {
            throw new DomainException("Delivery cannot be completed");
        }

        setStatus(StatusDelivery.FINISHED);
        setDateFinalization(OffsetDateTime.now());
    }

    public boolean canFinished() {
        return StatusDelivery.PENDING.equals(getStatus());
    }

    public boolean notCanFinished() {
        return !canFinished();
    }

}
