package com.example.adminrentit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.adminrentit.databinding.ActivitySignUpBinding
import com.example.adminrentit.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database

class SignUpActivity : AppCompatActivity() {


    private lateinit var fullName: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: DatabaseReference

    private val binding: ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        Initialize  Firebase Authentication
        auth = Firebase.auth

//        Initialize Firebase Database
        database = Firebase.database.reference

        binding.signupImage.setOnClickListener {

            // Get Text from Edit Text
            fullName = binding.fullName.text.toString().trim()
            email = binding.email.text.toString().trim()
            password = binding.password.text.toString().trim()

            if (fullName.isBlank() || email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill all Details", Toast.LENGTH_LONG).show()
            } else {
                createAccount(email, password)
            }
        }

        binding.loginRedirect.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_LONG).show()
                saveUserData()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Account Creation Failed", Toast.LENGTH_LONG).show()
                Log.d("Account", "createAccount: Failure", task.exception)
            }
        }
    }

    //   Save Data into Database
    private fun saveUserData() {

        fullName = binding.fullName.text.toString().trim()
        email = binding.email.text.toString().trim()
        password = binding.password.text.toString().trim()
        val user = UserModel(fullName, email, password)
        val userId : String = FirebaseAuth.getInstance().currentUser!!.uid

        //   Save User data into Firebase Database
        database.child("user").child(userId).setValue(user)
    }
}

