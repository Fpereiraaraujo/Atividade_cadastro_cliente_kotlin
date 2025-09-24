package com.example.cadastrocliente.repository

import com.example.cadastrocliente.model.Cliente

class ClienteRepository {
    private val clientes = mutableListOf<Cliente>()

    fun adicionarCliente(cliente: Cliente): Boolean {
        if (clientes.size >= 20) return false
        clientes.add(cliente)
        return true
    }

    fun listarClientes(): List<Cliente> {
        return clientes
    }

    fun buscarClientePorId(id: Int): Cliente? {
        return clientes.find { it.id == id }
    }
}