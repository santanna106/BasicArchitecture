package com.example.basicarchitecture.ui.contato

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.basicarchitecture.R
import com.example.basicarchitecture.databinding.FragmentContatoBinding
import com.example.basicarchitecture.databinding.FragmentHomeBinding
import com.example.basicarchitecture.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ContatoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class ContatoFragment : Fragment() {
    private var _binding: FragmentContatoBinding? = null
    private val viewModel: ContatoViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentContatoBinding.inflate(inflater, container, false)
        _binding?.contatoViewModel = viewModel
        return binding.root
    }


}