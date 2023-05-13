package com.diego.demo.service

import com.diego.demo.model.Client

interface ClientService {
    fun findAll(): List<Client>

    fun findById(id: Long): Client?

    fun insert(client: Client)

    fun update(id: Long, client: Client)

    fun delete(id: Long)
}