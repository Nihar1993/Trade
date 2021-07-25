package com.jpmc.asset.engine.repository;

import com.jpmc.asset.engine.entity.SettlementMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineRepository extends JpaRepository<SettlementMessage,String> {

}
