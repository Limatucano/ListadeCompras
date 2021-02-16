package com.example.listadecompras

import android.graphics.Bitmap

data class Produto(var id:Int, var nome:String, var quantidade: Int, var valor: Double, var foto: Bitmap? = null)

