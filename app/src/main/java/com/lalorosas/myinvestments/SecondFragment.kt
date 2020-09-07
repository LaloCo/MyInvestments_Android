package com.lalorosas.myinvestments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            val dbHelper = InvestmentDBOpenHelper((activity as MainActivity), null)
            val investment = Investment(editTextInvestmentName.text.toString(), editTextInvestmentAmount.text.toString().toFloat())
            dbHelper.insert(investment)

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            (activity as MainActivity).fab?.show()
        }
    }
}