package kr.juyeop.ideafactory.widget.extension

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.toast(text : Int){
    Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.startActivityWithFinish(context: Context, activity : Class<*>) {
    startActivity(Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
    this.finish()
}

