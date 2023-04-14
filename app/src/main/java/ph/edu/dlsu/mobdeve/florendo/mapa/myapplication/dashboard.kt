package ph.edu.dlsu.mobdeve.florendo.mapa.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.databinding.ActivityDashboardBinding

import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.fragments.accountFragment
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.fragments.dashFragment
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.fragments.searchFragment
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.model.album
import androidx.recyclerview.widget.LinearLayoutManager

class dashboard : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val DashFragment = dashFragment()
        val SearcFragment = searchFragment()
        val AccountFragment = accountFragment()

        // album adapter



        makeCurrentFragment(DashFragment)
        binding.navigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.icDash -> makeCurrentFragment(DashFragment)
                R.id.icAccount -> makeCurrentFragment(AccountFragment)
                R.id.icSearch -> makeCurrentFragment(SearcFragment)
            }
            true
        }


        // adding albums



    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.flWrapper,fragment)
            addToBackStack(null)
            commit()
        }
}