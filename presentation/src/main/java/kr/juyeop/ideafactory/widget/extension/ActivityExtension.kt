package kr.juyeop.ideafactory.widget.extension

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

fun AppCompatActivity.toast(text : Int){
    Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.startActivityWithFinish(intent: Intent) {
    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
    this.finish()
}