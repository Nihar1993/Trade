package com.jpmc.asset.engine.bean;

import lombok.Getter;

import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class MessageBodyRequest {
    @NotEmpty(message = "tradeId is mandatory")
    private String tradeId;
    @NotEmpty(message = "ssiCode is mandatory")
    private String ssiCode;
    @NotEmpty(message = "amount is mandatory")
    private BigDecimal amount;
    @NotEmpty(message = "currency is mandatory")
    private String currency;
    @NotEmpty(message = "valueDate is mandatory")
    private Date valueDate;
}
