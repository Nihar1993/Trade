package com.jpmc.asset.engine.controller;

import com.jpmc.asset.engine.bean.MessageBodyRequest;
import com.jpmc.asset.engine.entity.SettlementMessage;
import com.jpmc.asset.engine.service.AssetEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/asset-engine")
public class AssetEngineController {
    @Autowired
    private AssetEngineService service;


    @PostMapping("/message")
    public SettlementMessage marketSettlementMessage(@RequestBody MessageBodyRequest messageBodyRequest) {

        return service.createSettlement(messageBodyRequest);
    }

    @GetMapping("/fetchSettlement/message")
    public ResponseEntity<SettlementMessage> marketSettlementMessage(@RequestParam String tradeId) {
        try {
            return ResponseEntity.ok(service.getSettlementMessage(tradeId));
        } catch (AssetEngineService.TradeNotFoundException ex) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }

    }
}
