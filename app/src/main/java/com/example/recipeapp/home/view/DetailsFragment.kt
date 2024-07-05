package com.example.recipeapp.home.view

import android.content.Context
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.recipeapp.R
import com.example.recipeapp.Utlis
import com.example.recipeapp.database.FavouriteList
import com.example.recipeapp.database.LocalDataSourceImp
import com.example.recipeapp.databinding.FragmentDetailsBinding
import com.example.recipeapp.home.repo.HomeRepoImp
import com.example.recipeapp.home.viewmodel.HomeViewModel
import com.example.recipeapp.home.viewmodel.HomeViewModelFactory
import com.example.recipeapp.network.APIClient

class DetailsFragment : Fragment() {
    private lateinit var _binding :FragmentDetailsBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDetailsBinding.inflate(inflater,container,false)
        return _binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: DetailsFragmentArgs by navArgs()
        gettingViewModelReady(requireContext())
        _binding.tvMealName.text=args.mealData.strMeal
        _binding.tvInstructions.text=args.mealData.strInstructions
        Glide.with(requireContext()).load(args.mealData.strMealThumb)
            .into(_binding.ivMealImage)
        _binding.tvInstructions.setMovementMethod( ScrollingMovementMethod())
        val userEmail = Utlis.getEmailLoggedIn()
        viewModel.isFavourite(userEmail, args.mealData.idMeal)
        viewModel.isFavourite.observe(viewLifecycleOwner) { isFavorite ->
            changeImage(isFavorite)
            _binding.ivFavourite.setImageResource(
                if (isFavorite) R.drawable.ic_fav_filled else R.drawable.ic_fav
            )
        }
        _binding.ivFavourite.setOnClickListener {
            viewModel.toggleFavorite(userEmail, args.mealData.idMeal)
        }
    }
    private fun changeImage(favourite: Boolean) {
        if(favourite){
            _binding.ivFavourite.setImageResource(R.drawable.ic_fav_filled)
        }else{
            _binding.ivFavourite.setImageResource(R.drawable.ic_fav)
        }
    }
    private fun gettingViewModelReady(context: Context) {
        val homeViewModelFactory = HomeViewModelFactory(
            HomeRepoImp(
                APIClient, LocalDataSourceImp(context)
            )
        )
        viewModel = ViewModelProvider(owner = this, factory = homeViewModelFactory)[HomeViewModel::class.java]
    }

}