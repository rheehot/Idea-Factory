package kr.juyeop.data.util

import kr.juyeop.domain.model.idea.IdeaModel

object IdeaData {

    lateinit var idea : IdeaModel

    fun saveIdea(model : IdeaModel){
        this.idea = model
    }

    fun bringIdea() : IdeaModel {
        return idea
    }
}