package kr.juyeop.data.database.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import kr.juyeop.data.database.entity.IdeaEntitiy

@Dao
interface IdeaDao {

    @Query("SELECT * FROM idea_table ORDER BY date DESC")
    fun getAll() : Single<List<IdeaEntitiy>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity : IdeaEntitiy) : Completable

    @Update
    fun update(entity : IdeaEntitiy) : Completable

    @Delete
    fun delete(entity : IdeaEntitiy) : Completable
}