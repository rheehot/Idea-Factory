package kr.juyeop.data.mapper

import kr.juyeop.data.base.BaseEntityMapper
import kr.juyeop.data.database.entity.IdeaEntity
import kr.juyeop.domain.model.IdeaModel

class IdeaMapper : BaseEntityMapper<IdeaModel, IdeaEntity>{

    override fun mapToModel(entity: IdeaEntity): IdeaModel {
        return IdeaModel(
            entity.name,
            entity.background,
            entity.title,
            entity.content,
            entity.effect,
            entity.date
        )
    }

    override fun mapToEntity(model: IdeaModel): IdeaEntity {
        return IdeaEntity(
            model.name,
            model.background,
            model.title,
            model.content,
            model.effect,
            model.date
        )
    }
}