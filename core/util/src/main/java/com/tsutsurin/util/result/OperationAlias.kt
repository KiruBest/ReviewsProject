package com.tsutsurin.util.result

import kotlinx.coroutines.flow.Flow

typealias AnyResult = OperationResult<Any>
typealias ResultList<T> = OperationResult<List<T>>
typealias ResultMutableList<T> = OperationResult<MutableList<T>>
typealias FlowResult<T> = Flow<OperationResult<T>>
typealias FlowAnyResult = Flow<AnyResult>