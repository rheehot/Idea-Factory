package kr.juyeop.data.database.cache

import android.app.Application
import io.reactivex.Completable
import io.reactivex.Single
import kr.juyeop.data.database.dao.IdeaDao
import kr.juyeop.data.base.BaseCache
import kr.juyeop.data.database.entity.IdeaEntity

class IdeaCache(application : Application) : BaseCache(application){

    private val ideaDao : IdeaDao = database!!.ideaDao()

    fun get(date: String) : Single<IdeaEntity> = ideaDao.get(date)

    fun getAll() : Single<List<IdeaEntity>> = ideaDao.getAll()

    fun insert(ideaEntitiy: IdeaEntity) : Completable = ideaDao.insert(ideaEntitiy)

    fun update(name : String, background : String, title : String, content : String, expect : String, date : String) : Completable {
        return ideaDao.update(name, background, title, content, expect, date)
    }

    fun delete(date : String) : Completable {
        return ideaDao.delete(date)
    }
}