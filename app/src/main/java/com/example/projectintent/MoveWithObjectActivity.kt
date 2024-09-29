package com.example.projectintent

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoveWithObjectActivity : ComponentActivity() {
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()enableEdgeToEdge
        setContentView(R.layout.activity_move_with_object)
        val tvObjectView: TextView = findViewById(R.id.tv_objectView)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)

        } else {
            intent.getParcelableExtra(EXTRA_PERSON)
        }

//        val  text = """
//                    Name : ${person?.name.toString()}
//                    Age  : ${person?.age.toString()}
//                    email: ${person?.email.toString()}
//                """.trimIndent()
//        tvObjectView.text = text


        person?.let {
            val text =
                """
                    Name : ${it.name.toString()}
                    Age  : ${it.age.toString()}
                    email: ${it.email.toString()}
                """.trimIndent()
            tvObjectView.text = text
        } ?: run {
            val text = "Object is empty"
            tvObjectView.text = text
        }

    }
}