package com.tsutsurin.util.result

sealed interface OperationResult<out R> {
    /**
     * Abstract result for implementation of custom cases
     */
    abstract class AbstractResult<out T> : OperationResult<T>

    /**
     * Base Empty Result state
     */
    abstract class NothingResult : AbstractResult<Nothing>()

    /**
     * Base Error states fro implement custom classes from it
     */
    abstract class AbstractFailure : NothingResult() {
        abstract val exception: Exception
    }

    /**
     * Успешный вариант ответа
     */
    open class Success<out T>(val data: T) : AbstractResult<T>()

    /**
     * Ошибочный вариант ответа обрабатывается в функции onError
     */
    data class Error(override val exception: Exception) : AbstractFailure()

    /**
     * Пустой результат, как частный случай, синглетон
     */
    object EmptyResult : NothingResult()

    /**
     * Any Success result, любой возвращаемый тип будет успехом, маркерный тип синглетон
     */
    object AnySuccess : Success<Any>(Unit)
}