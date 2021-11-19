package com.dina.foodiest

import Model.Recipes
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dina.foodiest.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        showData()
    }

    private fun showData() {
        val getData = intent.getParcelableExtra<Recipes>(RECIPE_DATA) as Recipes
        Glide.with(this).load(getData.pictures).into(detailBinding.ivDetaiil)
        detailBinding.tvNameDetail.text = getData.name
        detailBinding.tvDescriptionDetail.text = getData.description
        detailBinding.tvResepLable.text = getData.ingredients
        detailBinding.tvIngredients.text = getData.ingredients
        detailBinding.tvIngredientsLable.text = getData.ingredients
        detailBinding.tvInstruction.text = getData.instructions
        detailBinding.tvLabelInstruction.text = getData.instructions
        detailBinding.tvCalories.text = getData.calories
        detailBinding.tvValueCalories.text = getData.calories
        detailBinding.tvCarbo.text = getData.carbo
        detailBinding.tvValueCarbo.text = getData.carbo
        detailBinding.tvProtein.text = getData.protein
        detailBinding.tvValueProtein.text = getData.protein




    }

    companion object{
        const val RECIPE_DATA = "recipe_data"
    }

}