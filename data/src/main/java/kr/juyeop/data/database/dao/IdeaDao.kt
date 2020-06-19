package kr.juyeop.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import kr.juyeop.data.base.BaseDao
import kr.juyeop.data.database.entity.IdeaEntity

@Dao
interface IdeaDao : BaseDao<IdeaEntity>{

    @Query("SELECT * FROM idea_table ORDER BY date DESC")
    fun getAll() : Single<List<IdeaEntity>>

    @Query("UPDATE idea_table SET name = :name, background = :background, title = :title, content = :content, effect = :effect, date = :date")
    fun update(name : String, background : String, title : String, content : String, effect : String, date : String) : Completable

    @Query("DELETE FROM idea_table WHERE date = :date")
    fun delete(date : String) : Completable
}