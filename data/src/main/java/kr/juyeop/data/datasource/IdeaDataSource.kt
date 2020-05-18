package kr.juyeop.data.datasource

import io.reactivex.Completable
import io.reactivex.Single
import kr.juyeop.data.database.base.BaseDataSource
import kr.juyeop.data.database.cache.IdeaCache
import kr.juyeop.data.database.entity.IdeaEntity
import java.util.*


abstract class IdeaDataSource (val ideaCache: IdeaCache) : BaseDataSource<IdeaCache>(){

    fun getAll() : Single<List<IdeaEntity>> = cache.getAll()

    fun insert(ideaEntitiy: IdeaEntity) : Completable = cache.insert(ideaEntitiy)

    fun update(name : String, background : String, title : String, content : String, effect : String, date : String) : Completable {
        return cache.update(name, background, title, content, effect, date)
    }

    fun delete(date : String) : Completable {
        return cache.delete(date)
    }
}