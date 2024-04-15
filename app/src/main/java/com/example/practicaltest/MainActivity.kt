package com.example.practicaltest

import android.R.id
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import android.view.View;
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.practicaltest.databinding.ActivityMainBinding
import java.lang.NullPointerException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val addTotal = binding.editTextNum1.text.toString().toInt() + binding.editTextNum2.text.toString().toInt()
            val selectedRadioid = binding.radioGender.checkedRadioButtonId;
            try {

                val radioButton: RadioButton = binding.getRoot().findViewById(selectedRadioid)


                if(selectedRadioid == binding.radioButtonMale.getId())
                    binding.imageView.setImageResource(R.drawable.stelle1)

                if(selectedRadioid == binding.radioButtonFemale.getId())
                    binding.imageView.setImageResource(R.drawable.stelle2)

                    //Test

                binding.imageView.isVisible = true

                binding.textViewFinal.text = String.format(
                    "Name: %s Gender: %s Total: %d and your food is %s",
                    binding.editTextName.text.toString(),
                    radioButton.text.toString(),
                    addTotal,
                    binding.spinner.selectedItem.toString()
                )
            }catch (e: NullPointerException)
            {
                val toast = Toast.makeText(this, "Gender", Toast.LENGTH_SHORT) // in Activity
                toast.show()

            }
        }



    }
}