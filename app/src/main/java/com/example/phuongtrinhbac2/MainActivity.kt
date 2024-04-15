package com.example.phuongtrinhbac2

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.example.phuongtrinhbac2.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    var _binding: ActivityMainBinding? = null
    val Binding: ActivityMainBinding by lazy {
        requireNotNull(_binding)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(Binding.root)

        Binding.btnKq.setOnClickListener {
            val a = Binding.edtA.text.toString()
            val b = Binding.edtB.text.toString()
            val c = Binding.edtC.text.toString()
            if (a == "") {
                Toast.makeText(this, "Vui long dien a", Toast.LENGTH_SHORT).show()
                Binding.edtA.requestFocus()
            } else {
                if (b == "") {
                    Toast.makeText(this, "Vui long dien b", Toast.LENGTH_SHORT).show()
                    Binding.edtB.requestFocus()
                } else {
                    if (c == "") {
                        Toast.makeText(this, "Vui long dien c", Toast.LENGTH_SHORT).show()
                        Binding.edtC.requestFocus()
                    } else {

                        Binding.tvKq.text = tinhtoan(a.toDouble(), b.toDouble(), c.toDouble())
                    }
                }
            }
        }
    }

    fun tinhtoan(a: Double, b: Double, c: Double): String {
        val delta = b * b - 4 * a * c
        return when {
            delta > 0 -> {
                val x1 = (-b + sqrt(delta)) / (2 * a)
                val x2 = (-b - sqrt(delta)) / (2 * a)
                return "Pt co 2 nghiem la x1 = $x1, x2 = $x2"
            }

            delta == 0.0 -> {
                val x = -b / (2 * a)
                return "Pt co 1 nghiem la : x = $x"
            }

            else -> return "Pt vo nghiem"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}