package kr.juyeop.ideafactory.widget.extension

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment

fun Fragment.startActivity(context : Context, activity: Class<*>){
    startActivity(Intent(context, activity).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
}