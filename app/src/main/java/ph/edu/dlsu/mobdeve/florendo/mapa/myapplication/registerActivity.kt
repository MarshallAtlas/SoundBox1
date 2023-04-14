package ph.edu.dlsu.mobdeve.florendo.mapa.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.databinding.ActivityMainBinding
import ph.edu.dlsu.mobdeve.florendo.mapa.myapplication.databinding.ActivityRegisterBinding

class registerActivity : AppCompatActivity() {

    private lateinit var binding:ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // make it so that password, username, and password are placed in database
        binding.confirmSignUp.setOnClickListener{
            val intent = Intent()

            intent.putExtra("username", binding.registerUsernameInput.text.toString())
            intent.putExtra("password", binding.registerPasswordInput.text.toString())
            setResult(1, intent)
            finish()
        }
    }
}