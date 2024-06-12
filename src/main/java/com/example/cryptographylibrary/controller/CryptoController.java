package com.example.cryptographylibrary.controller;

import com.example.cryptographylibrary.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/crypto")

public class CryptoController {

    @Autowired
    private CryptoService cryptoService;

    @GetMapping("/generate-rsa-keypair")
    public ResponseEntity<String> generateRSAKeyPair(){
        try {
            String keyPair = cryptoService.generateRSAKeyPair();
            return ResponseEntity.ok(keyPair);
        } catch(Exception e){
            return ResponseEntity.status(500).body("Error generating RSA key pair" + e.getMessage());
        }
    }


}
