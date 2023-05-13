package com.diego.demo.service

import com.diego.demo.model.Address
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
open interface ViaCepService {
    @GetMapping("/{cep}/json/")
    fun searchCep(@PathVariable("cep") cep: String): Address
}

