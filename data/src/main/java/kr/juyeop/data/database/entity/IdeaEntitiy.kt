package kr.juyeop.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.*
import kotlin.collections.ArrayList

@Entity(tableName = "idea_table", primaryKeys = ["date"])
data class IdeaEntitiy(@ColumnInfo(name = "name") val name : String,
                       @ColumnInfo(name = "background") val background : String,
                       @ColumnInfo(name = "title") val title : String,
                       @ColumnInfo(name = "content") val content : String,
                       @ColumnInfo(name = "effect") val effect : String,
                       @ColumnInfo(name = "tag") val tag : ArrayList<String>,
                       @ColumnInfo(name = "date") val date : Date)