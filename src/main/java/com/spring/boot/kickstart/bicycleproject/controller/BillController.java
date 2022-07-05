package com.spring.boot.kickstart.bicycleproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.kickstart.bicycleproject.facade.BillFacade;

@RestController
public class BillController {

    @Autowired
    private BillFacade billFacade;

}
