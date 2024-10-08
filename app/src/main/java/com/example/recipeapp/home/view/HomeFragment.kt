package com.example.recipeapp.home.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapp.R
import com.example.recipeapp.Utlis
import com.example.recipeapp.database.LocalDataSourceImp
import com.example.recipeapp.database.Meal
import com.example.recipeapp.databinding.FragmentHomeBinding
import com.example.recipeapp.databinding.FragmentSignupBinding
import com.example.recipeapp.home.adpater.HomeAdapter
import com.example.recipeapp.home.repo.HomeRepoImp
import com.example.recipeapp.home.viewmodel.HomeViewModel
import com.example.recipeapp.home.viewmodel.HomeViewModelFactory
import com.example.recipeapp.network.APIClient
import com.google.firebase.auth.FirebaseAuth


class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var _binding: FragmentHomeBinding

    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gettingViewModelReady(requireContext())

        viewModel.getMealsList(('A'..'Z').random())
        viewModel.mealList.observe(requireActivity()){
            Log.d("meals", "onViewCreated:${it} ")
            val adapter= HomeAdapter(it,requireContext())
            _binding.rvMeals.adapter=adapter
            _binding.rvMeals.layoutManager= LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
            adapter.setOnClickListener(object : HomeAdapter.OnItemClickListener {
                override fun onItemClicked(data: Meal) {
                        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment2(data,Utlis.getEmailLoggedIn())
                    findNavController().navigate(action)
                }
            })
        }
    }
    private fun gettingViewModelReady(context: Context) {
        val homeViewModelFactory = HomeViewModelFactory(
            HomeRepoImp(
                APIClient,LocalDataSourceImp(context)
            )
        )
        viewModel = ViewModelProvider(owner = this, factory = homeViewModelFactory)[HomeViewModel::class.java]
    }
}