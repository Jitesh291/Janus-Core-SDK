package com.varenia.kenante_core.helper

class Decorators{

    companion object{
        fun <T> requireNonNull(obj: T?, message: String): T {
            return obj ?: throw NullPointerException(message)
        }

        fun <T> requireNonNullInRuntime(obj: T?, message: String): T {
            return obj ?: throw RuntimeException(message)
        }

        fun logIfNull(obj: Any?, message: String): Boolean {
            return if (obj == null) {
                println(message)
                true
            } else {
                false
            }
        }
    }


}