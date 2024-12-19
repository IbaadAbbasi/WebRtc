package com.codewithkael.webrtcprojectforrecord

import android.Manifest
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codewithkael.webrtcprojectforrecord.databinding.ActivityMainBinding
import com.codewithkael.webrtcprojectforrecord.models.MessageModel
import com.codewithkael.webrtcprojectforrecord.models.MessageModelChatBox
import com.codewithkael.webrtcprojectforrecord.utils.NewMessageInterface
import com.permissionx.guolindev.PermissionX

class MainActivity : AppCompatActivity() /*, NewMessageInterface*/ {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.enterBtn.setOnClickListener {
            PermissionX.init(this)
                .permissions(
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.CAMERA,
                    Manifest.permission.MODIFY_AUDIO_SETTINGS
                ).request{ allGranted, _ ,_ ->
                    if (allGranted){
                        startActivity(
                            Intent(this,CallActivity::class.java)
                                .putExtra("username",binding.username.text.toString())
                        )
                    } else {
                        Toast.makeText(this,"you should accept all permissions",Toast.LENGTH_LONG).show()
                    }
                }

        }

    }

/*    override fun onNewMessage(message: MessageModel) {
        TODO("Not yet implemented")
    }

    override fun onNewMessageChatBox(message: MessageModelChatBox) {
        Log.d(TAG, "onNewMessage: $message")
        when(message.type){
            "text_received" -> {
                // Handle incoming text message
                val sender = message.senderName ?: "Unknown"
                val receiver = message.receiverName ?: "Unknown"
                val text = message.data as? String ?: ""
                runOnUiThread {
                    Toast.makeText(this, "{$sender, $receiver $text}", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }*/
}