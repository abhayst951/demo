package com.teliolabs.demo.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NetworkFunctionRequestModel implements Serializable{
    private int nfId;
    private String nfInstanceId;
    private String nfType;
    private String nfStatus;
    private String fqdn;
    private String ipAddress;
    private String location;
}
