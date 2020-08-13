package kr.juyeop.data.database.entity

import androidx.room.Entity

@Entity(tableName = "idea_table", primaryKeys = ["date"])
data class IdeaEntity(
    val name: String?,
    val background: String?,
    val title: String?,
    val content: String?,
    val effect: String?,
    val date: String)