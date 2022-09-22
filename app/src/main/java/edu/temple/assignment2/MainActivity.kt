package edu.temple.assignment2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    //variables
    lateinit var Name: EditText
    lateinit var Email: EditText
    lateinit var Password: EditText
    lateinit var PasswordConfrim: EditText
    lateinit var Button: Button
    lateinit var SpinnerView: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //spinner
        val Programs = arrayOf(
            "Please select your program: ",
            "Information Science",
            "Computer Science",
            "Math and CS",
            "Data Science",
            "Other"
        )

        SpinnerView = findViewById<Spinner>(R.id.SpinnerView)
        Name = findViewById<EditText>(R.id.Name)
        Email = findViewById<EditText>(R.id.Email)
        Password = findViewById<EditText>(R.id.Password)
        PasswordConfrim = findViewById<EditText>(R.id.PasswordConfirm)


        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Programs)
        SpinnerView.adapter = arrayAdapter

        findViewById<Button>(R.id.SaveButton).setOnClickListener {
            val b = CheckInput()
            if(b) {
                performSignUp()
            }
        }
    }

    //spinner empty
    private fun setSpinnerError() {

        val selectedView: View = SpinnerView.getSelectedView()
        if (selectedView != null) {
            SpinnerView.requestFocus()
            val selectedTextView = selectedView as TextView
            selectedTextView.error = "error"
            selectedTextView.setTextColor(Color.RED)
            SpinnerView.performClick()
        }
    }

    fun Initialization() {
        Name = findViewById(R.id.Name);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        PasswordConfrim = findViewById(R.id.PasswordConfirm);
        Button = findViewById(R.id.SaveButton);

    }

    // Checking if the input is valid
    fun CheckInput(): Boolean {
        var nameErr: Boolean = true
        var emailErr: Boolean = true
        var passErr: Boolean = true
        var passErr2: Boolean = true
        var passMatch: Boolean = true
        var spinnerErr: Boolean = true

        if (SpinnerView.selectedItemPosition == 0) {
            spinnerErr = false
            setSpinnerError()

        }
        if (Name.text.toString().isNullOrBlank()) {
            Name.setError("Please Enter Name")
            nameErr = !nameErr
        }
        if (Email.text.toString().isNullOrBlank()) {
            Email.setError("Please Enter Email")
//            return false
            emailErr = !emailErr
        }
        if (Password.text.toString().isNullOrBlank()) {
            Password.setError("Please Enter Password")
//            return false
            passErr = !passErr
        }
        if (PasswordConfrim.text.toString().isNullOrBlank()) {
            PasswordConfrim.setError("Please Confirm Password")
//            return false'
            passErr2 = !passErr
        }
        // Checking if repeat password is same
        if (!Password.text.toString().equals(PasswordConfrim.text.toString())) {
            PasswordConfrim.setError("Password does not match!")
            passMatch = !passMatch
        }
        return passMatch and passErr2 and passErr and emailErr and nameErr and spinnerErr
    }

    //print out welcome message
    //We tried to run this but the pop up message was not showing, you said no points will be reduced
    fun performSignUp() {
        if (CheckInput()) {

            val firstName = Name.text.toString()

            Toast.makeText(applicationContext,"Welcome, " + firstName + ", to the SignUpForm App",Toast.LENGTH_SHORT).show()

        }
    }
}

