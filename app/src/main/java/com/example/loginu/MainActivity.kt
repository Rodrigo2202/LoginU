package com.example.loginu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.content.Intent




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to all views
        var et_user_name = findViewById(R.id.et_user_name) as EditText
        var et_password = findViewById(R.id.et_password) as EditText
        var btn_reset = findViewById(R.id.btn_reset) as Button
        var btn_submit = findViewById(R.id.btn_submit) as Button
        var x: Int = 1
        val maxInt: Int = 5

        btn_reset.setOnClickListener {

            // clearing user_name and password edit text views on reset button click
            if(x >= maxInt){

                Toast.makeText(this@MainActivity, "Has intentado $x veces\n¡Esos son muchos intentos!\n¡Te me vas, Prro!", Toast.LENGTH_LONG).show()
                //Código para cerrar la app
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_HOME)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)

                /* Código alterno para cerrar la App 1:
                        finish()
                 */

                /* Código alterno para cerrar la App 2:
                        finish()
                        System.exit(0)
                 */
                x++

            }else{
                et_user_name.setText("")
                et_password.setText("")
                Toast.makeText(this@MainActivity, "¡Has Limpiado $x veces!", Toast.LENGTH_LONG).show()
                x++
            }

        }

        // set on-click listener
        btn_submit.setOnClickListener {

            val user_name = et_user_name.text;
            val password = et_password.text;
            if (user_name.toString().equals("")){
                if (password.toString().equals("")){
                    Toast.makeText(this@MainActivity, "Ingrese su usuario y contraseña", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@MainActivity, "Ingrese su usuario", Toast.LENGTH_LONG).show()
                }

            }else{

                if (password.toString().equals("")){
                    Toast.makeText(this@MainActivity, "Ingrese su contraseña", Toast.LENGTH_LONG).show()
                }else{
                    //Acá va el código del botón "Ingresar"/Submit
                    Toast.makeText(this@MainActivity, "Welcome, $user_name"+"!", Toast.LENGTH_LONG).show()
                }

            }


            // your code to validate the user_name and password combination
            // and verify the same

        }
    }
}