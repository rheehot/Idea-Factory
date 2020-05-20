package kr.juyeop.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import kr.juyeop.domain.model.IdeaModel

interface IdeaRepository{

    fun getAll() : Single<List<IdeaModel>>

    fun insert(ideaModel: IdeaModel) : Completable

    fun update(name : String, background : String, title : String, content : String, effect : String, date : String) : Completable

    fun delete(date : String) : Completable
}