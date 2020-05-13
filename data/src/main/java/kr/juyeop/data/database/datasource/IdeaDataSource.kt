package kr.juyeop.data.database.datasource

import io.reactivex.Completable
import io.reactivex.Single
import kr.juyeop.data.database.cache.IdeaCache
import kr.juyeop.data.database.entity.IdeaEntitiy

abstract class IdeaDataSource (val ideaCache: IdeaCache){
    abstract val cache : IdeaCache

    fun getAll() : Single<List<IdeaEntitiy>> = cache.getAll()

    fun insert(ideaEntitiy: IdeaEntitiy) : Completable = cache.insert(ideaEntitiy)

    fun update(ideaEntitiy: IdeaEntitiy) : Completable = cache.update(ideaEntitiy)

    fun delete(ideaEntitiy: IdeaEntitiy) : Completable = cache.delete(ideaEntitiy)
}