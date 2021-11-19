package Fragment

import Adapter.FoodAdapter
import Model.DataRecipes
import Model.Recipes
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dina.foodiest.R
import com.dina.foodiest.databinding.FragmentDessertBinding
import com.dina.foodiest.databinding.FragmentVegetarianBinding


class VegetarianFragment : Fragment() {
    private lateinit var binding: FragmentVegetarianBinding
    private var list: ArrayList<Recipes> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVegetarianBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataVegetarian)
        binding.rvVegetarian.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            val foodAdapter = FoodAdapter(list)
            adapter = foodAdapter
        }
    }
}