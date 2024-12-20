package com.codewithkael.webrtcprojectforrecord.models

data class MessageModel(
     val type: String,
     val name: String? = null,
     val target: String? = null,
     val data:Any?=null
)

data class MessageModelChatBox(
     val type: String,
     val senderName: String? = null,
     val receiverName: String? = null,
     val data:Any?=null
)
