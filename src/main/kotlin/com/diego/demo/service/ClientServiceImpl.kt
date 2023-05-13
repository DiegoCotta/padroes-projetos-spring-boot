package com.diego.demo.service

import com.diego.demo.model.AddressRepository
import com.diego.demo.model.Client
import com.diego.demo.model.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class ClientServiceImpl : ClientService {
    @Autowired
    private lateinit var clientrepository: ClientRepository

    @Autowired
    private lateinit var addressRepository: AddressRepository

    @Autowired
    private lateinit var viaCepService: ViaCepService
    override fun findAll(): List<Client> {
        return clientrepository.findAll().toList()
    }

    override fun findById(id: Long): Client? {
        val client = clientrepository.findById(id)
        return client.get()
    }

    override fun insert(client: Client) {
        saveClientWithCep(client)
    }

    override fun update(id: Long, client: Client) {
        val clientBd: Optional<Client> = clientrepository.findById(id)
        if (clientBd.isPresent) {
            saveClientWithCep(client)
        }
    }

    override fun delete(id: Long) {
        clientrepository.deleteById(id)
    }

    private fun saveClientWithCep(client: Client) {
        val cep: String = client.address.cep
        val address = addressRepository.findById(cep).orElseGet {
            val newAddress = viaCepService.searchCep(cep)
            addressRepository.save(newAddress)
            newAddress
        }
        client.address = address
        clientrepository.save(client)
    }
}
