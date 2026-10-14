package com.demoedu.campuscompass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.demoedu.campuscompass.data.buildCampusDatabase
import com.demoedu.campuscompass.data.getCampusDatabaseBuilder
import com.demoedu.campuscompass.data.createLoginSessionStore

/** Starts the Android host with the shared database and persistent login store. */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        // Both stores use application-scoped paths so data survives activity recreation.
        val database = buildCampusDatabase(getCampusDatabaseBuilder(applicationContext))
        val sessionStore = createLoginSessionStore(
            applicationContext.filesDir.resolve("campus_compass.preferences_pb").absolutePath,
        )
        setContent { App(database, sessionStore) }
    }
}
