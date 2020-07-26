package kr.juyeop.domain.request

import kr.juyeop.domain.model.datalab.request.KeywordGroupsModel

class DataLabRequest (
    val startDate : String,
    val endDate : String,
    val timeUnit : String,
    val keywordGroups : List<KeywordGroupsModel>
)