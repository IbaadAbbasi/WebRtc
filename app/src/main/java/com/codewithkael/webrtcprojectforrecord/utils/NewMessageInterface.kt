package com.codewithkael.webrtcprojectforrecord.utils

import com.codewithkael.webrtcprojectforrecord.models.MessageModel
import com.codewithkael.webrtcprojectforrecord.models.MessageModelChatBox

interface NewMessageInterface {
    fun onNewMessage(message: MessageModel)

   // fun onNewMessageChatBox(message: MessageModelChatBox)

}
