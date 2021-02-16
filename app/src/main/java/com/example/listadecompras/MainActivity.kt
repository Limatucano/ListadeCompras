package com.example.listadecompras

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val produtosAdapter = ProdutoAdapter(this)
        val btn_adicionar = findViewById<Button>(R.id.btn_adicionar)
        val list_view_produtos = findViewById<ListView>(R.id.list_view_produtos)


        list_view_produtos.adapter = produtosAdapter
        btn_adicionar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        list_view_produtos.setOnItemClickListener{ adapterView: AdapterView<*>, view: View, position: Int, id: Long ->
            var product = produtosAdapter.getItem(position)
            produtosAdapter.remove(product)
            produtosGlobal.remove(product)
            this.alterar_total()
        }


    }

    override fun onResume() {
        super.onResume()
        this.alterar_total()
        val list_view_produtos = findViewById<ListView>(R.id.list_view_produtos)
        val	adapter	=	list_view_produtos.adapter	as	ProdutoAdapter
        adapter.clear()
        adapter.addAll(produtosGlobal)
    }

    fun alterar_total(){
        val soma = produtosGlobal.sumByDouble { it.valor * it.quantidade }
        val txt_total = findViewById<TextView>(R.id.txt_total)
        val language = NumberFormat.getCurrencyInstance(Locale("pt","br"))
        txt_total.text = "Total: ${language.format(soma)}"
    }
}


