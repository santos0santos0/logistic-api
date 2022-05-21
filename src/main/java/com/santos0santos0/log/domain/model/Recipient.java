package com.santos0santos0.log.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Recipient {

    @Column(name = "recipient_name")
    private String name;

    @Column(name = "recipient_address")
    private String address;

    @Column(name = "recipient_number")
    private String number;

    @Column(name = "recipient_complement")
    private String complement;

    @Column(name = "recipient_district")
    private String district;

}
