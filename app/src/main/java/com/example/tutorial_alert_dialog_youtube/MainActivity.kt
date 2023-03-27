package com.example.tutorial_alert_dialog_youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.tutorial_alert_dialog_youtube.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add Sean to your contact?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You added Sean to your contact", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "You didn't add Sean to your contact", Toast.LENGTH_SHORT).show()
            }
            .create()

        binding.btnAlertDialog1.setOnClickListener{
            addContactDialog.show()
        }

        val options = arrayOf("Option1", "Option2", "Option3")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose One")
            .setSingleChoiceItems(options, 0) {dialogInterface, i ->
                Toast.makeText(this, "You chose ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "Accepted.", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "Declined", Toast.LENGTH_SHORT).show()
            }
            .create()

        binding.btnAlertDialog2.setOnClickListener{
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose One")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { dialogInterface, i, isChecked ->
                if(isChecked) {
                    Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "Accepted.", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "Declined", Toast.LENGTH_SHORT).show()
            }
            .create()

        binding.btnAlertDialog3.setOnClickListener{
            multiChoiceDialog.show()
        }

    }
}