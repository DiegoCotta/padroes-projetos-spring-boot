package com.diego.demo.model

import jakarta.persistence.*

@Entity
data class Client(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var name: String,
        @ManyToOne
        var address: Address
)

