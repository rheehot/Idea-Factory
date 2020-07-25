package kr.juyeop.domain.request

import kr.juyeop.domain.model.datalab.request.KeyGroupsModel

class DataLabRequest (
    startDate : String,
    endDate : String,
    timeUnit : String,
    keyGroupsModel : List<KeyGroupsModel>,
    device : String
)