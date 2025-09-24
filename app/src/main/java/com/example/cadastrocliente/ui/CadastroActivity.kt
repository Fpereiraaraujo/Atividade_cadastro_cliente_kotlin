package com.example.cadastrocliente.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cadastrocliente.R
import com.example.cadastrocliente.model.Cliente
import com.example.cadastrocliente.repository.ClienteRepository

class CadastroActivity : AppCompatActivity() {

    private val repository = ClienteRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val nomeInput = findViewById<EditText>(R.id.editNome)
        val emailInput = findViewById<EditText>(R.id.editEmail)
        val telefoneInput = findViewById<EditText>(R.id.editTelefone)
        val botaoCadastrar = findViewById<Button>(R.id.btnCadastrar)

        botaoCadastrar.setOnClickListener {
            val nome = nomeInput.text.toString()
            val email = emailInput.text.toString()
            val telefone = telefoneInput.text.toString()

            val cliente = Cliente(
                id = repository.listarClientes().size + 1,
                nome = nome,
                email = email,
                telefone = telefone
            )

            if (repository.adicionarCliente(cliente)) {
                Toast.makeText(this, "Cliente cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Limite de 20 clientes atingido.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
