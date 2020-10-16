package mo.nice.method_channel_demo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {


    private val channel = "mo.nice.method"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
//        flutterEngine.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MethodChannel(flutterEngine?.dartExecutor?.binaryMessenger, channel)
                .setMethodCallHandler { call, result ->
                    run {
                        if (call.method == "getToken") {
                            Log.d("", call.arguments.toString())
                            val token = getToken(call.arguments.toString())
                            result.success(token)
                        }
                    }
                }
    }

    private fun getToken(token: String?): String {
        val token = "31293128u43dww23"
        Toast.makeText(this, "获取token $token", Toast.LENGTH_LONG).show()
        return token
    }

}
