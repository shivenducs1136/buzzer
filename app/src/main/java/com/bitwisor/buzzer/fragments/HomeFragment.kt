package com.bitwisor.buzzer.fragments

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bitwisor.buzzer.R
import com.bitwisor.buzzer.databinding.FragmentHomeBinding
import com.bitwisor.buzzer.model.User
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.FirebaseDatabase


class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
    lateinit var googleSignInClient:GoogleSignInClient
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var database: FirebaseDatabase
    val RC_SIGN_IN = 11
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createRequest()
        firebaseAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        binding.createbtn.setOnClickListener {
            if (firebaseAuth.currentUser == null){
                signIn()
            }
            else{
                findNavController().navigate(R.id.action_homeFragment_to_createRoomFragment)
            }
        }
        binding.joinbtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_joinFragment)
        }

    }
    private fun createRequest() {
        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
    }
    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(ContentValues.TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Toast.makeText(requireContext(),"Sign In Failed Please Try Again ", Toast.LENGTH_SHORT).show()
                // Google Sign In failed, update UI appropriately
                Log.w(ContentValues.TAG, "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "signInWithCredential:success")
                    val user = firebaseAuth.currentUser
                    val usr: User = User(user!!.uid,user.displayName.toString(),user.photoUrl.toString())
                    database.reference.child("UserProfiles")
                        .child(user!!.uid).setValue(usr)
                        .addOnCompleteListener {
                            if (it.isSuccessful){
                                findNavController().navigate(R.id.action_homeFragment_to_createRoomFragment)
                            }else{
                                Toast.makeText(requireContext(),"Error in database", Toast.LENGTH_SHORT).show()
                            }
                        }

                } else {
                    Toast.makeText(requireContext(),"signInWithCredential:failure", Toast.LENGTH_SHORT).show()
                    Log.w(ContentValues.TAG, "signInWithCredential:failure", task.exception)
                }
            }
    }
}