package ph.edu.dlsu.mobdeve.florendo.mapa.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    private val launchRegister = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result ->
        val data = result.data

        Snackbar.make(binding.root,
        "Registered ${data!!.getStringExtra("username")}",
            Snackbar.LENGTH_LONG).show()


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.signUp.setOnClickListener{

            var goToRegister = Intent(this, registerActivity::class.java)
            launchRegister.launch(goToRegister)

        }
        // set credentials
        binding.loginButton.setOnClickListener{
            var goToDash = Intent(this, dashboard::class.java)

            launchRegister.launch(goToDash)
            finish()

        }



    }
}