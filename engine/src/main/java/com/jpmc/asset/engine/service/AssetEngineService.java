package com.jpmc.asset.engine.service;

import com.jpmc.asset.engine.SSI;
import com.jpmc.asset.engine.bean.MessageBodyRequest;
import com.jpmc.asset.engine.entity.PayerParty;
import com.jpmc.asset.engine.entity.ReceiverParty;
import com.jpmc.asset.engine.entity.SettlementMessage;
import com.jpmc.asset.engine.repository.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AssetEngineService {
    @Autowired
    private EngineRepository repository;


    public SettlementMessage createSettlement(MessageBodyRequest messageBodyRequest) {

        SettlementMessage message = new SettlementMessage();
        message.setAmount(messageBodyRequest.getAmount());
        message.setCurrency(messageBodyRequest.getCurrency());
        message.setTradeId(messageBodyRequest.getTradeId());
        message.setValueDate(messageBodyRequest.getValueDate());
        message.setMessageId(UUID.randomUUID().toString());
        PayerParty payerParty = new PayerParty();
        SSI ssi = SSI.valueOf(messageBodyRequest.getSsiCode());
        message.setSupportingInfo(ssi.getSupportingInfo());
        payerParty.setPayerAccountNumber(ssi.getPayAccNumber());
        payerParty.setTradeId(messageBodyRequest.getTradeId());
        payerParty.setPayerBankCode(ssi.getPayerBank());
        ReceiverParty receiverParty = new ReceiverParty();
        receiverParty.setReceiverBankCode(ssi.getRevBank());
        receiverParty.setTradeId(messageBodyRequest.getTradeId());
        receiverParty.setReceiverAccountNumber(ssi.getRevAccNumber());
        message.setPayerParty(payerParty);
        message.setReceiverParty(receiverParty);
        repository.save(message);
        return message;

    }

    public SettlementMessage getSettlementMessage(String tradeId) throws TradeNotFoundException{
       // SettlementMessage message = new SettlementMessage();
        Optional<SettlementMessage> details=repository.findById(tradeId);
        if(details.isPresent()) {
            return details.get();
        } else {
            throw new TradeNotFoundException("Trade Id not found: " + tradeId);
        }
    }

    public class TradeNotFoundException extends Exception {
        public TradeNotFoundException(String errorMessage) {
            super(errorMessage);
        }
    }
}
