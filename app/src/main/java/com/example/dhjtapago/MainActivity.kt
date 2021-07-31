package com.example.dhjtapago

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var mappBarConfiguration: AppBarConfiguration
    lateinit var mnavController: NavController
    lateinit var mnavigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        /**
         * inicializa o BottomNavigation setando o nav controler que referencia o
         * fragment principal
         */
         mnavController = findNavController(R.id.hostFragment)
        findViewById<BottomNavigationView>(R.id.bottomNav)?.apply {
            this.setupWithNavController(mnavController)
        }

        //sincroniza app bar com navController para o nome do fragment sempre apareça no topo
        //e seta o drawer layout tbm
        mappBarConfiguration = AppBarConfiguration(mnavController.graph, findViewById(R.id.drawerLayout) )
        //navigation up button = <- seta para voltar. no metodo abaixo adiciona ela
        NavigationUI.setupActionBarWithNavController(this, mnavController, findViewById(R.id.drawerLayout))

        //inicializa a navigation view sincronizado com o navcontroller
        mnavigationView = findViewById(R.id.navView)
        NavigationUI.setupWithNavController(mnavigationView , mnavController)



    }
    //sobreescrita para adicionar o evento de voltar
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(mnavController, mappBarConfiguration)
    }
}