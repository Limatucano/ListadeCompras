package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        val btn_inserir = findViewById<Button>(R.id.btn_inserir)
        val txt_produto = findViewById<TextView>(R.id.txt_produto)
        btn_inserir.setOnClickListener {

            var produto = txt_produto.text.toString()
            if(produto.isNotEmpty()){
                txt_produto.text = ""
            }else{
                txt_produto.error = "Digite algo primeiro"
            }
        }
    }
}