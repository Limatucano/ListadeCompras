package com.example.listadecompras

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val produtosAdapter = ProdutoAdapter(this)
        val btn_adicionar = findViewById<Button>(R.id.btn_adicionar)
        val list_view_produtos = findViewById<ListView>(R.id.list_view_produtos)
        produtosAdapter.addAll(produtosGlobal)

        list_view_produtos.adapter = produtosAdapter
        btn_adicionar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        list_view_produtos.setOnItemClickListener{ adapterView: AdapterView<*>, view: View, position: Int, id: Long ->
            var product = produtosAdapter.getItem(position)
            produtosAdapter.remove(product)
        }


    }
}


