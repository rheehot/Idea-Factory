package kr.juyeop.data.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.juyeop.data.datasource.IdeaDataSource
import kr.juyeop.data.mapper.IdeaMapper
import kr.juyeop.domain.model.idea.IdeaModel
import kr.juyeop.domain.repository.IdeaRepository

class IdeaRepositoryImpl (
    private val ideaDataSource: IdeaDataSource
) : IdeaRepository{

    private val ideaMapper = IdeaMapper()

    override fun get(date: String): Single<IdeaModel> = ideaDataSource.get(date).map {
        ideaMapper.mapToModel(it)
    }

    override fun getAll(): Single<List<IdeaModel>> = ideaDataSource.getAll().map {
        it.map { ideaEntity ->  ideaMapper.mapToModel(ideaEntity)}
    }

    override fun insert(ideaModel: IdeaModel): Completable = ideaDataSource.insert(ideaMapper.mapToEntity(ideaModel))

    override fun update(name: String, background: String, title: String, content: String, expect: String, date: String): Completable {
        return ideaDataSource.update(name, background, title, content, expect, date)
    }

    override fun delete(date: String): Completable {
        return ideaDataSource.delete(date)
    }
}