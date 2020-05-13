package kr.juyeop.data.database.cache

import android.app.Application
import io.reactivex.Completable
import io.reactivex.Single
import kr.juyeop.data.database.RoomDatabase
import kr.juyeop.data.database.dao.IdeaDao
import kr.juyeop.data.database.entity.IdeaEntitiy

class IdeaCache(application: Application){

    private val database = RoomDatabase.getInstance(application)!!
    private val ideaDao : IdeaDao = database.ideaDao()

    fun getAll() : Single<List<IdeaEntitiy>> = ideaDao.getAll()

    fun insert(ideaEntitiy: IdeaEntitiy) : Completable = ideaDao.insert(ideaEntitiy)

    fun update(ideaEntitiy: IdeaEntitiy) : Completable = ideaDao.update(ideaEntitiy)

    fun delete(ideaEntitiy: IdeaEntitiy) : Completable = ideaDao.delete(ideaEntitiy)
}