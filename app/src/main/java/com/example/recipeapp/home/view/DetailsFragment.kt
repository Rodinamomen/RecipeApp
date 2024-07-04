package com.example.recipeapp.home.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.recipeapp.R
import com.example.recipeapp.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var _binding :FragmentDetailsBinding

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
        _binding.tvMealName.text=args.mealData.strMeal
        _binding.tvInstructions.text=args.mealData.strInstructions
        Glide.with(requireContext()).load(args.mealData.strMealThumb)
            .into(_binding.ivMealImage)
        _binding.tvInstructions.setMovementMethod( ScrollingMovementMethod())
    }

}