package com.careerit.cup.kakfa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KakfaController {

  @Autowired
  private KafkaTemplate kafkaTemplate;

  @GetMapping
  public String pushMessage(@RequestParam("message") String message) throws InterruptedException {
    kafkaTemplate.send("lwl", message);
    return message;
  }
}
