package com.jpmc.asset.engine.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Setter
@Getter
@Entity
@Table(name="Payer")
public class PayerParty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "trader_id")
    private String tradeId;
    @Column(name= "payer_accountNumber")
    private String payerAccountNumber;
    @Column(name= "payer_bankCode")
    private String payerBankCode;
}
