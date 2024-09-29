package com.example.projectintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.activity.ComponentActivity

class MoveWithResultActivity : ComponentActivity() {
    private lateinit var btnChoose: Button
    private lateinit var rgRole: RadioGroup

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_result)

        btnChoose = findViewById(R.id.btn_choose)
        rgRole = findViewById(R.id.rg_role)

        btnChoose.setOnClickListener {
            if (rgRole.checkedRadioButtonId > 0) {
                var value = when (rgRole.checkedRadioButtonId) {
                    R.id.rb_jungler -> "Jungler"
                    R.id.rb_midlane -> "Midlane"
                    R.id.rb_roamer -> "Roamer"
                    R.id.rb_explane -> "Explane"
                    R.id.rb_goldlane -> "Goldlane"
                    else -> "Unknown"
                }

                val resultIntent = Intent().putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }

    }
}