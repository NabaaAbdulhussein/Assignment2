package edu.temple.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    //variables
    lateinit var Name: EditText
    lateinit var Email: EditText
    lateinit var Password: EditText
    lateinit var PasswordConfrim: EditText
    lateinit var Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //spinner
        val Programs = arrayOf(
            "Information Science",
            "Computer Science",
            "Math and CS",
            "Data Science",
            "Other"
        )
        val SpinnerProgram = findViewById<Spinner>(R.id.SpinnerView);
        val ArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, Programs)

        /*SpinnerProgram.adapter = ArrayAdapter
        SpinnerProgram.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }*/
    }

    fun Initialization() {
        Name = findViewById(R.id.Name);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        PasswordConfrim = findViewById(R.id.PasswordConfirm);
        Button = findViewById(R.id.SaveButton);

    }

    //check whether the fields are empty of not     what way is better??
    fun IfEmpty() {
        if (Name.getText().toString().isEmpty() || Email.getText().toString()
                .isEmpty() || Password.getText().toString().isEmpty() ||
            PasswordConfrim.getText().toString().isEmpty()
        ) {
            Toast.makeText(this, "All Fields Need To Be Answered!", Toast.LENGTH_SHORT).show();
            //if yes then toast will apear to show the fields are mandatory


        }
    }


    // Checking if the input is valid
    fun CheckInput(): Boolean {
        if (Name.text.toString().isEmpty()) { //which one??
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

    fun AllValid(view: View) {
        if (CheckInput()) {
            // Input is valid
            val firstName = Name.text.toString()
            val email = Email.text.toString()
            val password = Password.text.toString()
            val CPassword = PasswordConfrim.text.toString()

            //welcome message
            Toast.makeText(
                this,
                "Welcome, " + Name + ", to the SignUpForm App",
                Toast.LENGTH_LONG
            ).show();

        }
    }
}
