package com.example.locationdetail.Common

import android.content.Context
import android.content.SharedPreferences

import java.util.*

object AppPreferences {
    private const val NAME = "sshVms2"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences


   // private val AUTH_TOKEN = Pair("auth_token", "0a07f6d27ca22793db2912b17bfe5351")
    private val AUTH_TOKEN = Pair("auth_token", "0de2ae9bee2d6aa85bf783ef8da2311f")
   // private val BASE_URL = Pair("base_url", "https://7165a35b773b-8051091035815681172.ngrok-free.app/")
    private val BASE_URL = Pair("base_url", "https://api-sports-stadium-stage.katomaran.co.in/")
    private val DEVICE_ID = Pair("deviceId", "")
    private val PASSWORD = Pair("password", "")
    private val SITE = Pair("site", "stage")
    private val IS_CONFIGURED = Pair("isConfigured", false)


    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var isConfigured: Boolean?
        get() = preferences.getBoolean(IS_CONFIGURED.first, IS_CONFIGURED.second)
        set(value) = preferences.edit {
            if (value != null) {
                it.putBoolean(IS_CONFIGURED.first, value)
            }
        }


    var authToken: String?
        get() = preferences.getString(AUTH_TOKEN.first, AUTH_TOKEN.second)
        set(value) = preferences.edit { it.putString(AUTH_TOKEN.first, value) }

    var baseUrl: String?
        get() = preferences.getString(BASE_URL.first, BASE_URL.second)
        set(value) = preferences.edit { it.putString(BASE_URL.first, value) }

    var deviceId: String?
        get() = preferences.getString(DEVICE_ID.first, DEVICE_ID.second)
        set(value) = preferences.edit { it.putString(DEVICE_ID.first, value) }

    var password: String?
        get() = preferences.getString(PASSWORD.first, PASSWORD.second)
        set(value) = preferences.edit { it.putString(PASSWORD.first, value) }

//    var hostDetails: ArrayList<HostDetails>
//        get() {
//            val value = preferences.getString(
//                HOST_DETAILS.first,
//                HOST_DETAILS.second.toString()
//            )
//            val type: Type = object : TypeToken<List<HostDetails>>() {}.type
//            return if (value != null) Gson().fromJson(
//                value,
//                type
//            ) else emptyList<HostDetails>() as ArrayList<HostDetails>
//        }
//        set(value) = preferences.edit {
//            it.putString(HOST_DETAILS.first, Gson().toJson(value))
//        }

    var site: String
        get() = preferences.getString(SITE.first, SITE.second) ?: SITE.second
        set(value) = preferences.edit { it.putString(SITE.first, value) }
}