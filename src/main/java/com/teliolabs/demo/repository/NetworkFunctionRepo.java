package com.teliolabs.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teliolabs.demo.dao.NetworkFunctionDao;

@Repository
public interface NetworkFunctionRepo extends JpaRepository<NetworkFunctionDao,Integer>{
    List<NetworkFunctionDao> findByNfType(String nfType);
}
