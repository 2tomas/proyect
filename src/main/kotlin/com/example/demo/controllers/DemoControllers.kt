package com.example.demo.controllers;

import com.example.demo.entity.KafkaMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.support.SimpleTriggerContext
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/demo")

public class DemoControllers() {

    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>

    var TOPIC:String = "kakfa_example"

    @GetMapping
    fun nombre(messeage: String): String{
        kafkaTemplate.send(TOPIC, messeage)
        return "publish successfully"
    }

    @PostMapping
    fun create(@RequestBody kafkaMessage: KafkaMessage): String{
        kafkaTemplate.send(kafkaMessage.topic, kafkaMessage.message)
        return "ok"
    }
}
