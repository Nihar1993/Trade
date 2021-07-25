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
@Table(name="Receiver")
public class ReceiverParty implements Serializable {
    @Id
    @Column(name = "trader_id")
    private String tradeId;
    @Column(name= "receiver_accountNumber")
    private String receiverAccountNumber;
    @Column(name= "receiver_bankCode")
    private String receiverBankCode;

}
