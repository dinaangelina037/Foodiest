package Fragment

import Adapter.FoodAdapter
import Model.DataRecipes
import Model.Recipes
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.dina.foodiest.R
import com.dina.foodiest.databinding.FragmentBreakfast2Binding

class BreakfastFragment : Fragment() {

    private lateinit var breakfast2Binding: FragmentBreakfast2Binding
    private var list : ArrayList<Recipes> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        breakfast2Binding= FragmentBreakfast2Binding.inflate(inflater, container, false)

        return breakfast2Binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataBreakfast)
        breakfast2Binding.rvBreakfast.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            val foodAdapter = FoodAdapter(list)
            adapter = foodAdapter
        }
    }

}


