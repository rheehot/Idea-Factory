package kr.juyeop.domain.model.datalab.response

class DataLabModel (
    val startDate : String,
    val endDate : String,
    val timeUnit : String,
    val results : List<ResultsModel>
)