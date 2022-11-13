package com.bitwisor.buzzer.fragments

import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bitwisor.buzzer.R
import com.bitwisor.buzzer.databinding.FragmentBuzzBinding
import com.bitwisor.buzzer.databinding.FragmentBuzzerBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class BuzzFragment : Fragment() {
    lateinit var binding: FragmentBuzzBinding
    lateinit var code:String
    lateinit var name:String
    lateinit var database: FirebaseDatabase
    lateinit var android_id:String
    lateinit var dbref:DatabaseReference
    lateinit var valuev:ValueEventListener
    var x=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentBuzzBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
/*
    override fun onDestroy() {
        super.onDestroy()

        if (valuev != null && dbref != null) {
            dbref.removeEventListener(valuev)
        }
    }
    */
}