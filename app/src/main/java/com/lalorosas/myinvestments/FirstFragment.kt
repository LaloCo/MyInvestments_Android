package com.lalorosas.myinvestments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var investmentListView : ListView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        investmentListView = view.findViewById<ListView>(R.id.listViewInvestments)
    }

    override fun onResume() {
        super.onResume()

        val dbHelper = InvestmentDBOpenHelper((activity as MainActivity), null)
        val investments = dbHelper.read()

        val adapter = ArrayAdapter<Investment>((activity as MainActivity), android.R.layout.simple_list_item_1, investments!!.toMutableList())
        listViewInvestments.adapter = adapter
    }
}