package kr.juyeop.domain.model.datalab.request

class DataLabRequest (
    val startDate : String,
    val endDate : String,
    val timeUnit : String,
    val keywordGroups : List<KeywordGroupsModel>
)