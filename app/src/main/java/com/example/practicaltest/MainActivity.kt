package com.example.practicaltest

import android.R.id
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.widget.RadioButton
import android.widget.Toast
import android.view.View;
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.AppBarConfiguration
import com.example.practicaltest.Database.Profile
import com.example.practicaltest.Database.ProfileViewModel
import com.example.practicaltest.databinding.ActivityMainBinding
import java.lang.NullPointerException




class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    //TODO 3: Declare the Activity View Model
    private lateinit var  profileViewModel: ProfileViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
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
                //val profile = Profile(0, binding.editTextName.text.toString(), binding.editTextNum2.text.toString())
                //profileViewModel.Insert(profile)
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