package kr.juyeop.data.database.base

import android.app.Application
import kr.juyeop.data.database.RoomDatabase

open class BaseCache(application: Application) {
    protected val database = RoomDatabase.getInstance(application)!!
}