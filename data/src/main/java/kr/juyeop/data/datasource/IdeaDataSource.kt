package kr.juyeop.data.datasource

import io.reactivex.Completable
import io.reactivex.Single
import kr.juyeop.data.base.BaseDataSource
import kr.juyeop.data.database.cache.IdeaCache
import kr.juyeop.data.database.entity.IdeaEntity

class IdeaDataSource (
    override val remote : Any,
    override val cache: IdeaCache
) : BaseDataSource<Any, IdeaCache>(){

    fun get(date: String) : Single<IdeaEntity> = cache.get(date)

    fun getAll() : Single<List<IdeaEntity>> = cache.getAll()

    fun insert(ideaEntitiy: IdeaEntity) : Completable = cache.insert(ideaEntitiy)

    fun update(name : String, background : String, title : String, content : String, expect : String, date : String) : Completable {
        return cache.update(name, background, title, content, expect, date)
    }

    fun delete(date : String) : Completable {
        return cache.delete(date)
    }
}