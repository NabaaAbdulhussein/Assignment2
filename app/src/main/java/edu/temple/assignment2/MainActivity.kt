package edu.temple.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    //variables
    lateinit var Name:EditText
    lateinit var Email:EditText
    lateinit var Password:EditText
    lateinit var PasswordConfrim:EditText

    //spinner
    //lateinit var SpinnerProgram:Spinner


            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                val Programs = arrayOf("Information Science", "Computer Science", "Math and CS", "Data Science", "Other")
                val SpinnerProgram = findViewById<Spinner>(R.id.SpinnerProgram)

                SpinnerProgram.adapter = ProgramAdapter(this, Programs)

                fun Initialization() {
                    Name = findViewById(R.id.NameText);
                    Email = findViewById(R.id.EmailText);
                    Password = findViewById(R.id.PassText);
                    PasswordConfrim = findViewById(R.id.PassConfirm);

                }

                // Checking if the input is valid
                fun validateInput(): Boolean {
                    if (Name.text.toString().equals("")) {
                        Name.setError("Please Enter Name")
                        return false
                    }
                    if (Email.text.toString().equals("")) {
                        Email.setError("Please Enter Email")
                        return false
                    }
                    if (Password.text.toString().equals("")) {
                        Password.setError("Please Enter Password")
                        return false
                    }
                    if (PasswordConfrim.text.toString().equals("")) {
                        PasswordConfrim.setError("Please Confirm Password")
                        return false
                    }

                    // Checking if repeat password is same
                    if (!Password.text.toString().equals(PasswordConfrim.text.toString())) {
                        PasswordConfrim.setError("Password does not match!")
                        return false
                    }
                    return true
                }


}
