package com.bitwisor.buzzer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.airbnb.lottie.LottieAnimationView
import com.bitwisor.buzzer.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.newSingleThreadContext

class MainActivity : AppCompatActivity() {
    lateinit var android_id:String
    lateinit var database:FirebaseDatabase
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.mlottiez.visibility = View.GONE
        setTheme(R.style.Theme_Buzzer)
        database = FirebaseDatabase.getInstance()
        android_id = Settings.Secure.getString(this?.getContentResolver(), Settings.Secure.ANDROID_ID)
    }

    override fun onStop() {
        super.onStop()
    }
}