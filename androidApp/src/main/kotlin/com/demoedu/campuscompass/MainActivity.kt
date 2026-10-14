package com.demoedu.campuscompass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.demoedu.campuscompass.data.buildCampusDatabase
import com.demoedu.campuscompass.data.getCampusDatabaseBuilder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val database = buildCampusDatabase(getCampusDatabaseBuilder(applicationContext))
        setContent { App(database) }
    }
}
