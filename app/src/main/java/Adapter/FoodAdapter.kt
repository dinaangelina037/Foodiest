package Adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import Model.Recipes
import android.content.Intent
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.dina.foodiest.DetailActivity
import com.dina.foodiest.databinding.ItemFoodBinding

class FoodAdapter(private val listFood : ArrayList<Recipes>):
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
   inner class FoodViewHolder (val itemFoodBinding: ItemFoodBinding) : RecyclerView.ViewHolder(itemFoodBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.FoodViewHolder {
      val itemFoodBinding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(itemFoodBinding)
    }

    override fun onBindViewHolder(holder: FoodAdapter.FoodViewHolder, position: Int) {
       with(holder){
           with(listFood[position]){
               Glide.with(holder.itemView.context).load(pictures).into(itemFoodBinding.ivItemRecipe)
               itemFoodBinding.tvItemNameRecipe.text = name
               itemFoodBinding.tvItemMenu.text = category
               itemFoodBinding.tvNumberRecipe.text = number
               val mContext = holder.itemView.context
               holder.itemView.setOnClickListener{
                   val dataSend = Recipes(
                       name = listFood[position].name,
                       category = listFood[position].category,
                       description = listFood[position].description,
                       ingredients = listFood[position].ingredients,
                       instructions = listFood[position].instructions,
                       pictures = listFood[position].pictures,
                       number = listFood[position].number,
                       calories = listFood[position].calories,
                       carbo = listFood[position].carbo,
                        protein = listFood[position].protein
                   )
                   val intentToDetail = Intent(mContext, DetailActivity::class.java)
                   intentToDetail.putExtra(DetailActivity.RECIPE_DATA, dataSend)
                   mContext.startActivity(intentToDetail)
               }
           }
       }
    }

    override fun getItemCount(): Int = listFood.size


}