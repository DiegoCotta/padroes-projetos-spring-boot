package com.diego.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class PadroesProjetosKotlinApplication

fun main(args: Array<String>) {
	runApplication<PadroesProjetosKotlinApplication>(*args)
}
