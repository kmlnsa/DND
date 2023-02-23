package com.example.dnd.data.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.dnd.StatusAdapter
import com.example.dnd.databinding.FragmentSecondBinding


class SecondFragment(private val statusAdapter: StatusAdapter) : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.status.apply {
            statusAdapter
        }

        binding.buttonCure.setOnClickListener {
            val heal = binding.buttonCure.text
            Toast.makeText(this, "Health level increased: $heal", Toast.LENGTH_LONG).show()
        }

        binding.apply {
            toolbarGame.setNavigationOnClickListener() {
                findNavController().popBackStack()
            }
        }
    }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

}