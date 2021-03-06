package Model

import Fragment.BreakfastFragment
import Fragment.DessertFragment
import Fragment.VegetarianFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dina.foodiest.R
import com.dina.foodiest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
/*
modifier : private
val -> value : imutable
var -> bisa di ubah ?: mutable
root -> yang ngsih akses value/view(?)
supportFragmentManager: buat nempelin fragment
begin Transaction :buat memeulai tugas si supportFragmentManager
 */

    private lateinit var mainBinding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        supportActionBar?.hide()
        setCurrentFragment(BreakfastFragment())
        mainBinding.navBottomMain.setOnNavigationItemSelectedListener(){
            when(it.itemId){
                R.id.ic_breakfast -> setCurrentFragment(BreakfastFragment())
                R.id.ic_vegetarian -> setCurrentFragment(VegetarianFragment())
                R.id.ic_dessert -> setCurrentFragment(DessertFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment : Fragment)=
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fl_main, fragment)
            commit()

    }
}