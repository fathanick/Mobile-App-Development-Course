package com.example.jsonworkmanagerdemo.data

import android.content.Context
import kotlinx.coroutines.delay
import org.json.JSONObject
import java.nio.charset.Charset

class FakeRepository {

    suspend fun fetchUsers(context: Context): List<UserData> {

        delay(2000L) // simulate network delay

        // Read JSON from assets/users.json
        val jsonString = context.assets
            .open("users.json")
            .readBytes()
            .toString(Charsets.UTF_8)

        val jsonObject = JSONObject(jsonString)
        val userArray = jsonObject.getJSONArray("users")

        val list = mutableListOf<UserData>()

        for (i in 0 until userArray.length()) {
            val u = userArray.getJSONObject(i)
            val item = UserData(
                name = u.getString("name"),
                age = u.getInt("age"),
                city = u.getString("city")
            )
            list.add(item)
        }

        return list
    }
}
