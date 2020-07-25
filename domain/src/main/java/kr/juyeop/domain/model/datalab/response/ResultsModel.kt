package kr.juyeop.domain.model.datalab.response

data class ResultsModel (
    val title : String,
    val keywords : List<String>,
    val data : List<DataModel>
)