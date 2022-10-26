package com.teliolabs.demo.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="nf_nrf")
public class NetworkFunctionDao {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="nfId")
    private int nfId;

    @Column(name="nfInstanceId")
    private String nfInstanceId;

    @Column(name="nfType")
    private String nfType;

    @Column(name="nfStatus")
    private String nfStatus;

    @Column(name="fqdn")
    private String fqdn;

    @Column(name="ipAddress")
    private String ipAddress;

    @Column(name="location")
    private String location;
}
