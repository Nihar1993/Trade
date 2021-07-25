package com.jpmc.asset.engine;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SSI {
    DBS_OCBC_1("05461368","DBSSGB2LXXX","438421","OCBCSGSGXXX","BNF:PAY CLIENT"),
    OCBC_DBS_1("438421","OCBCSGSGXXX","05461368","DBSSGB2LXXX","BNF:FFC-4697132"),
    OCBC_DBC_2("438421","OCBCSGSGXXX","05461369","DBSSSGSGXXX","BNF:FFC-482315"),
    DBS_SCB("185586","DBSSSGSGXXX","1868422","SCBLAU2SXXX","RFB:Test payment");


    private String payAccNumber;
    private String payerBank;
    private String revAccNumber;
    private String revBank;
    private String supportingInfo ;

}
