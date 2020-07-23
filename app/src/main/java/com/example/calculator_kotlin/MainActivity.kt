package com.example.calculator_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button13.setOnClickListener { appendonexpresstion("1", true) }
        button14.setOnClickListener { appendonexpresstion("2", true) }
        button15.setOnClickListener { appendonexpresstion("3", true) }

        button9.setOnClickListener { appendonexpresstion("5", true) }
        button10.setOnClickListener { appendonexpresstion("6", true) }
        button11.setOnClickListener { appendonexpresstion("4", true) }

        button5.setOnClickListener { appendonexpresstion("7", true) }
        button6.setOnClickListener { appendonexpresstion("8", true) }
        button7.setOnClickListener { appendonexpresstion("9", true) }
        button18.setOnClickListener { appendonexpresstion("0", true) }
        button17.setOnClickListener { appendonexpresstion(".", true) }


        /* +*/ button16.setOnClickListener { appendonexpresstion("+", true) }
        /*-*/  button12.setOnClickListener { appendonexpresstion("-", true) }
        /***/
        button8.setOnClickListener { appendonexpresstion("*", true) }
        /* / */button4.setOnClickListener { appendonexpresstion("/", true) }
        /*) */ button3.setOnClickListener { appendonexpresstion(")", true) }
        /*(*/  button2.setOnClickListener { appendonexpresstion("(", true) }

        /* back */ button19.setOnClickListener {
            val string = textView2_expresstion.text.toString()
            if (string.isNotEmpty()) {
                textView2_expresstion.text = string.substring(0, string.length - 1)
            }
            textView_result.text = ""

        }
        /* clear*/ button.setOnClickListener {
            textView_result.text = ""
            textView2_expresstion.text = ""
        }
        /* equal*/  button20.setOnClickListener {
            try {
                val expression = ExpressionBuilder(textView2_expresstion.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    textView_result.text = longResult.toString()
                else
                    textView_result.text = result.toString()


            } catch (e: Exception) {

                Log.d("e", "message:" + e.message)
            }


        }

    }

    fun appendonexpresstion(string: String, canclear: Boolean) {
        if (textView_result.text.isNotEmpty()) {
            textView2_expresstion.text = ""
        }
        if (canclear) {
            textView_result.text = ""
            textView2_expresstion.append(string)
        } else {
            textView2_expresstion.append(textView_result.text)
            textView2_expresstion.append(string)
            textView2_expresstion.text = ""
        }

    }
}


