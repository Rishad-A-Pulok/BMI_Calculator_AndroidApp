package com.example.bmi_calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    private lateinit var weightET: EditText
    private lateinit var heightET: EditText
    private lateinit var calcBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weightET = view.findViewById(R.id.weightET)
        heightET = view.findViewById(R.id.heightET)
        calcBtn = view.findViewById(R.id.calcBtn)
        calcBtn.setOnClickListener {
            val weight = weightET.text.toString()
            val height = heightET.text.toString()
            if(weight.isEmpty()){
                Toast.makeText(activity, "Weight must not be empty!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if(height.isEmpty()){
                Toast.makeText(activity, "Height must not be empty!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val h1 = height.toDouble()
            val w1 = weight.toDouble()
            val result = w1/(h1*h1)
            val bundle = Bundle().apply {
                putDouble("result_value",result)
            }
            findNavController().navigate(R.id.action_homeFragment_to_resultFragment,bundle)
        }
    }
}