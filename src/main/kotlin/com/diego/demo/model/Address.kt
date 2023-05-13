package com.diego.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Address(
        val bairro: String,
        @Id
        val cep: String,
        val complemento: String,
        val ddd: String,
        val gia: String,
        val ibge: String,
        val localidade: String,
        val logradouro: String,
        val siafi: String,
        val uf: String
)