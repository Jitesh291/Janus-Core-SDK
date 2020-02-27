package com.varenia.kenante_core.interfaces

import org.json.JSONObject
import java.lang.Exception

interface KenanteWsConnEventListener{

    fun onOpen()
    fun onMessage(obj: JSONObject)
    fun onError(ex: Exception)
    fun onClose()
    fun onDisconnected()

}