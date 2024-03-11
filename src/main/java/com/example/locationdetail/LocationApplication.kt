package com.example.locationdetail

import android.app.Application
import com.example.locationdetail.Common.AppPreferences
import io.realm.Realm
import io.realm.RealmConfiguration

class LocationApplication:Application() {


    companion object {
        lateinit var instance: LocationApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppPreferences.init(instance)
        Realm.init(this)

        // on below line we are setting realm configuration
        // on below line we are setting realm configuration
        val config = RealmConfiguration.Builder() // below line is to allow write
            // data to database on ui thread.
            .allowWritesOnUiThread(true) // below line is to delete realm
            // if migration is needed.
            .deleteRealmIfMigrationNeeded() // at last we are calling a method to build.
            .build()
        // on below line we are setting
        // configuration to our realm database.
        // on below line we are setting
        // configuration to our realm database.
        Realm.setDefaultConfiguration(config)
    }

}