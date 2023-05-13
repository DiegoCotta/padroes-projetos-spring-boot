package com.diego.demo.controller

import com.diego.demo.model.Client
import com.diego.demo.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("clientes")
class ClientRestController{
    @Autowired
    private lateinit var clientService: ClientService
    @GetMapping
    fun findAll(): ResponseEntity<Iterable<Client>> {
        return ResponseEntity.ok(clientService.findAll())
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Client> {
        return ResponseEntity.ok(clientService.findById(id))
    }

    @PostMapping
    fun insert(@RequestBody cliente: Client): ResponseEntity<Client> {
        clientService.insert(cliente)
        return ResponseEntity.ok(cliente)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody client: Client): ResponseEntity<Client> {
        clientService.update(id, client)
        return ResponseEntity.ok(client)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        clientService.delete(id)
        return ResponseEntity.ok().build()
    }
}

