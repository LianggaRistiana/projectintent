package com.example.projectintent

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : ComponentActivity() {
    private lateinit var tvResultRole: TextView
    private val resultLauncher =   registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        result ->
        if (result.resultCode == MoveWithResultActivity.RESULT_CODE && result.data != null){
            val selectedView = result.data!!.getStringExtra(MoveWithResultActivity.EXTRA_SELECTED_VALUE)
            tvResultRole.text = "Your Role : $selectedView"
        }
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btnMoveActivity)
        val btnMoveActivityWithData: Button = findViewById(R.id.btnMoveActivityWithData)
        val btnMoveWithObject: Button = findViewById(R.id.btnMoveWithObject)
        val btnDialPhone: Button = findViewById(R.id.btnDialPhone)
        val btnMoveWithResult: Button = findViewById(R.id.btnMoveWithResult)
        tvResultRole = findViewById(R.id.tvResultRole)


        btnMoveActivity.setOnClickListener {
//            print("Button Clicked")
            val intent = Intent(this@MainActivity, MoveActivity::class.java)
            startActivity(intent)
        }

        btnMoveActivityWithData.setOnClickListener {
            val intentWithData = Intent(this@MainActivity, MoveWithData::class.java)
            intentWithData.putExtra(MoveWithData.EXTRA_NAME, "Liangga")
            intentWithData.putExtra(MoveWithData.EXTRA_AGE, 21)
            startActivity(intentWithData)

        }

        btnMoveWithObject.setOnClickListener {
            val person = Person(
                "Liangga",
                21,
                "lianggaemail"
            )
            val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
//            MoveWithObjectActivity.EXTRA_PERSON
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
            startActivity(moveWithObjectIntent)
        }

        btnDialPhone.setOnClickListener {
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:082147379938"))
            startActivity(dialPhoneIntent)
        }

        btnMoveWithResult.setOnClickListener {
            val moveWithResultIntent = Intent(this@MainActivity, MoveWithResultActivity::class.java)
            resultLauncher.launch(moveWithResultIntent)
//            tvResultRole.text = "clicked"
//            startActivity(moveWithResultIntent)
        }


    }
}

