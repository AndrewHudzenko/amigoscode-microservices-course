package com.amigoscode.fraud.controller;

import com.amigoscode.clients.fraud.dto.FraudCheckResponseDto;
import com.amigoscode.fraud.service.FraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckService fraudCheckService) {
    @GetMapping(path = "/{customerId}")
    public FraudCheckResponseDto isFraudster(@PathVariable("customerId") Long customerId) {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("fraud check request for customer {}", customerId);
        return new FraudCheckResponseDto(isFraudulentCustomer);
    }
}
