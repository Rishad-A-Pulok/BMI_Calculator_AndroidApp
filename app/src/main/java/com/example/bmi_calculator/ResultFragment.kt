package com.example.bmi_calculator

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ResultFragment : Fragment() {
    private lateinit var resultTV: TextView
    private lateinit var msgTV: TextView
    private lateinit var imgIV: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        resultTV = view.findViewById(R.id.resultTV)
        msgTV = view.findViewById(R.id.msgTV)
        imgIV = view.findViewById(R.id.imgIV)
        val result = arguments?.getDouble("result_value")
        resultTV.text = String.format("%.2f",result)
        if(result!! < 16.0){
            msgTV.text = "You are Underweight!Stage:Severe "
            msgTV.setTextColor(Color.parseColor("#0b0d0b"))
            imgIV.setImageResource(R.drawable.uw1)
        }
        if(result in 16.0..16.9){
            msgTV.text = "You are Underweight!Stage:Moderate"
            msgTV.setTextColor(Color.parseColor("#131714"))
            imgIV.setImageResource(R.drawable.uw2)
        }
        if(result in 17.0..18.4){
            msgTV.text = "You are Underweight!Stage:Mild"
            msgTV.setTextColor(Color.parseColor("#1b261e"))
            imgIV.setImageResource(R.drawable.uw3)
        }
        if(result in 18.5..24.9){
            msgTV.text = "Congratulations!You are Normal!"
            msgTV.setTextColor(Color.parseColor("#1ed652"))
            imgIV.setImageResource(R.drawable.fit)
        }
        if(result in 25.0..29.9){
            msgTV.text = "You are Overweight!Stage:Pre-Obese"
            msgTV.setTextColor(Color.parseColor("#fa4343"))
            imgIV.setImageResource(R.drawable.fat)
        }
        if(result in 30.0..34.9){
            msgTV.text = "You are Obese!Stage:Class-I"
            msgTV.setTextColor(Color.parseColor("#ed2f2f"))
            imgIV.setImageResource(R.drawable.ob1)
        }
        if(result in 35.0..39.9){
            msgTV.text = "You are Obese!Stage:Class-II"
            msgTV.setTextColor(Color.parseColor("#9c1616"))
            imgIV.setImageResource(R.drawable.ob2)
        }
        if(result >= 40.0){
            msgTV.text = "You are Obese!Stage:Class-III"
            msgTV.setTextColor(Color.parseColor("#540c0c"))
            imgIV.setImageResource(R.drawable.ob3)
        }

    }
}