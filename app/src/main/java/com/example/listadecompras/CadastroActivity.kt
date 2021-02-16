package com.example.listadecompras

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import	android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image

class CadastroActivity : AppCompatActivity() {
    val COD_IMAGE = 200
    var imageBitMap: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        //pegando itens da view
        val btn_inserir = findViewById<Button>(R.id.btn_inserir)
        val txt_produto = findViewById<EditText>(R.id.txt_produto)
        val txt_qtd = findViewById<EditText>(R.id.txt_qtd)
        val txt_valor = findViewById<EditText>(R.id.txt_valor)
        val img_foto_produto = findViewById<ImageView>(R.id.img_foto_produto)
        img_foto_produto.setOnClickListener{
            abrir_galeria()
        }

        btn_inserir.setOnClickListener {
            val qtd = txt_qtd.text.toString()
            val valor = txt_valor.text.toString()
            var produto = txt_produto.text.toString()
            if(produto.isNotEmpty() && valor.isNotEmpty() && qtd.isNotEmpty()){
                val prod = Produto(produto, qtd.toInt(), valor.toDouble(),imageBitMap)
                produtosGlobal.add(Produto(produto,qtd.toInt(), valor.toDouble(),imageBitMap))
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
    fun abrir_galeria(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(Intent.createChooser(intent,"Selecione uma imagem"), COD_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val img_foto_produto = findViewById<ImageView>(R.id.img_foto_produto)
        if(requestCode == COD_IMAGE && resultCode == Activity.RESULT_OK){
            if(data != null){
                val inputStream = contentResolver.openInputStream(data.getData()!!);
                imageBitMap	=	BitmapFactory.decodeStream(inputStream)
                img_foto_produto.setImageBitmap(imageBitMap)
            }
        }
    }

}