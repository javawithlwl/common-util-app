package com.careerit.cup.jsoninheritance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
@Slf4j
public class TaxAuthController {

    @PostMapping("/client")
    public ResponseEntity<ClientDetails> client(@RequestBody ClientDetails clientDetails){
           return ResponseEntity.ok(clientDetails);
    }
}
