package kr.juyeop.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import kr.juyeop.data.database.dao.IdeaDao
import kr.juyeop.data.database.entity.IdeaEntitiy
import kr.juyeop.data.database.RoomDatabase

@Database(entities = [IdeaEntitiy::class], version = 1, exportSchema = false)
abstract class RoomDatabase : androidx.room.RoomDatabase(){

    abstract fun ideaDao() : IdeaDao
    companion object{
        private var INSTANCE : RoomDatabase? = null

        fun getInstance(context: Context) : RoomDatabase?{
            if(INSTANCE == null){
                synchronized(RoomDatabase::class){
                    INSTANCE = Room.databaseBuilder(context, RoomDatabase::class.java, "database")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}