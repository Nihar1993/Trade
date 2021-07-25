package com.jpmc.asset.engine.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Setter
@Getter
@Entity
@Table(name = "settlement")
public class SettlementMessage implements Serializable {
    @Id
    @Column(name = "traderId")
    private String tradeId;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "valueDaate")
    private Date valueDate;
    @Column(name = "currency")
    private String currency;
    @Column(name = "messageId")
    private String messageId;
    @Column(name = "supportingInfo")
    private String supportingInfo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "traderId")
    private PayerParty payerParty;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "traderId")
    private ReceiverParty receiverParty;
}
