package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        val btn_inserir = findViewById<Button>(R.id.btn_inserir)
        val txt_produto = findViewById<EditText>(R.id.txt_produto)
        val txt_qtd = findViewById<EditText>(R.id.txt_qtd)
        val txt_valor = findViewById<EditText>(R.id.txt_valor)
        btn_inserir.setOnClickListener {
            val qtd = txt_qtd.text.toString()
            val valor = txt_valor.text.toString()
            var produto = txt_produto.text.toString()
            if(produto.isNotEmpty() && valor.isNotEmpty() && qtd.isNotEmpty()){
                val prod = Produto(produto, qtd.toInt(), valor.toDouble())
                produtosGlobal.add(Produto(produto,qtd.toInt(), valor.toDouble()))
                txt_qtd.text.clear()
                txt_produto.text.clear()
                txt_valor.text.clear()
            }else{
                txt_produto.error = if(txt_produto.text.isEmpty()) "Digite o nome do produto primeiro" else null
                txt_qtd.error = if(txt_qtd.text.isEmpty()) "Digite a quantidade primeiro" else null
                txt_valor.error = if(txt_valor.text.isEmpty()) "Digite o preço primeiro" else null
            }
        }
    }
}