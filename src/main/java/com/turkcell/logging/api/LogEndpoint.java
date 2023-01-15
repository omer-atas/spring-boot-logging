package com.turkcell.logging.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Profile(value={"dev", "prod"})
@RestController
@RequestMapping("/log")
public class LogEndpoint {

    @GetMapping("/getLog")
    public String getDetails() {
        log.info("get details methodu basladi");
        return internalLogDetail();
    }

    private String internalLogDetail() {
        try {
            log.debug("internalLogDetail methodu basladi");
            Thread.sleep(1000);
            return "API Mesaj";
        } catch (InterruptedException e) {
            log.error("Hata : {}", e);
            throw new RuntimeException(e);
        }
    }
}
