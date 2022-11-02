package com.siksin.databindingpractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import com.siksin.databindingpractice.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.Flow


class MainActivity : AppCompatActivity() {

    data class User(val firstName: String, val lastName: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = ActivityMainBinding.inflate(getLayoutInflater())


        binding.user = User("Test", "User")
    }

}