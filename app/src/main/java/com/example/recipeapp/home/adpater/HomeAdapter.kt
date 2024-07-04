package com.example.recipeapp.home.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipeapp.R
import com.example.recipeapp.database.Meal

class HomeAdapter(private val data : List<Meal>, private val context: Context ): RecyclerView.Adapter<HomeAdapter.MyHolder>()  {
    private lateinit var onItemClickListener: OnItemClickListener

    interface  OnItemClickListener{
        fun onItemClicked(data: Meal)
    }
    fun setOnClickListener(listener: OnItemClickListener){
        onItemClickListener = listener

    }
        class MyHolder(val row: View): RecyclerView.ViewHolder(row){
             var mealName = row.findViewById<TextView>(R.id.tv_recipe_name)
            var mealImage=row.findViewById<ImageView>(R.id.iv_recipe_image)
            var showDetails=row.findViewById<ImageView>(R.id.iv_show_details)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.item,parent, false)
        return MyHolder(row)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.mealName.text= data[position].strMeal
         Glide.with(context).load(data[position].strMealThumb)
            .into(holder.mealImage)
        holder.showDetails.setOnClickListener {
            onItemClickListener.onItemClicked(Meal(idMeal = data[position].idMeal, strMeal = data[position].strMeal, strMealThumb = data[position].strMealThumb, strInstructions = data[position].strInstructions))
        }
    }


}