package com.varenia.kenante_core.core

import android.content.Context
import com.varenia.kenante_core.helper.Decorators
import java.lang.RuntimeException

class KenanteSettings {

    internal var protocol: String? = "janus-protocol"
    internal var plugin: String? = "janus.plugin.videoroom"
    internal var janusUrl: String? = null
    internal var chatUrl: String? = null

    companion object{
        private var ksInstance: KenanteSettings? = null

        private var kContext: Context? = null
        fun getInstance(): KenanteSettings {
            if (ksInstance == null) {
                ksInstance = KenanteSettings()
            }
            return ksInstance!!
        }
    }

    fun init(context: Context) {
        kContext = context
    }

    fun setVideoEndPoint(endPoint: String){
        if (endPoint == "")
            throw RuntimeException("Video end point cannot be empty")
        this.janusUrl = endPoint
    }

    fun setChatEndPoint(endPoint: String){
        if (endPoint == "")
            throw RuntimeException("Chat end point cannot be empty")
        this.chatUrl = endPoint
    }

    fun checkVideoInit() {
        Decorators.requireNonNullInRuntime(kContext, "Kenante init failed. No context provided.")
        Decorators.requireNonNullInRuntime(janusUrl, "Video end point is null. Please initialize Video end point using KenanteSettings.getInstance().setVideoEndPoint(endpoint)")
    }

    fun checkChatInit() {
        Decorators.requireNonNullInRuntime(kContext, "Kenante init failed. No context provided.")
        Decorators.requireNonNullInRuntime(chatUrl, "Chat end point is null. Please initialize Kenante url using KenanteSettings.getInstance().setChatEndPoint(endpoint)")
    }

    fun getContext() : Context?{
        return kContext
    }

    fun getProtocol() : String{
        return protocol!!
    }

    fun getPlugin() : String{
        return plugin!!
    }

    fun getJanusUrl(): String{
        return janusUrl!!
    }

    fun getChatUrl(): String{
        return chatUrl!!
    }

}
