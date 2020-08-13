package kr.juyeop.ideafactory.widget.extension

import java.text.SimpleDateFormat
import java.util.*

fun Date.dateFormat(): String {
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return simpleDateFormat.format(this)
}