package kr.juyeop.domain.model.datalab.response

class DataLabModel (
    val startate : String,
    val endDate : String,
    val timeUnit : String,
    val results : List<ResultsModel>
)