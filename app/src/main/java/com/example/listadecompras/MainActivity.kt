package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txt_produto = findViewById<EditText>(R.id.txt_produto)
        val btn_inserir = findViewById<Button>(R.id.btn_inserir)
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val list_view_produtos = findViewById<ListView>(R.id.list_view_produtos)
        list_view_produtos.adapter = produtosAdapter

        btn_inserir.setOnClickListener {
            var produto = txt_produto.text.toString()
            if(produto.isNotEmpty()){
                produtosAdapter.add(produto)
                txt_produto.text.clear()
            }else{
                txt_produto.error = "Digite algo primeiro"
            }

        }


    }
}


