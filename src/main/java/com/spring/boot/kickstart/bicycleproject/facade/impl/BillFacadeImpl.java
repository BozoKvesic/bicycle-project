package com.spring.boot.kickstart.bicycleproject.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.kickstart.bicycleproject.facade.BillFacade;
import com.spring.boot.kickstart.bicycleproject.service.BillService;

@Component
public class BillFacadeImpl implements BillFacade {

    @Autowired
    private BillService billService;

}
