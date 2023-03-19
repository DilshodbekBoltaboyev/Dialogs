package com.example.dialogs

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.dialogs.databinding.ActivityMainBinding
import com.example.dialogs.databinding.FragmentBlankBinding
import com.example.dialogs.databinding.MyDialogViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import java.util.Date

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {

            alert.setOnClickListener {
                val alertDialog = AlertDialog.Builder(this@MainActivity)

                alertDialog.setTitle("Login Alert")

                //elranni boshqa joyini bosganda dialog yo'qolishi
                alertDialog.setCancelable(true)

                alertDialog.setMessage("Are you sure, you want to continue ?")

                alertDialog.setPositiveButton("Positive", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@MainActivity, "Yes", Toast.LENGTH_SHORT).show()
                    }

                })

                alertDialog.setNegativeButton("Negative", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@MainActivity, "No", Toast.LENGTH_SHORT).show()
                    }
                })

                alertDialog.setNeutralButton("Neutral", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@MainActivity, "Neutral", Toast.LENGTH_SHORT).show()
                    }
                })

                alertDialog.show()


            }

            custom.setOnClickListener {
                val alertDialog = AlertDialog.Builder(this@MainActivity, R.style.NewDialog)
                alertDialog.create()

                val myDialogViewBinding = MyDialogViewBinding.inflate(layoutInflater)
                alertDialog.setView(myDialogViewBinding.root)
                alertDialog.show()

                myDialogViewBinding.ok.setOnClickListener {
                    Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_SHORT).show()
                }
            }
            timepicker.setOnClickListener {
                val timePickerDialog = TimePickerDialog(
                    this@MainActivity, object : TimePickerDialog.OnTimeSetListener {
                        override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                            Toast.makeText(this@MainActivity, "$hourOfDay:$minute", Toast.LENGTH_SHORT).show()
                        }
                    },
                    24,
                    60,
                    true
                )
                val date=Date()
                timePickerDialog.updateTime(date.hours, date.minutes)
                timePickerDialog.show()
            }


            datepicker.setOnClickListener{
            val datePickerDialog=DatePickerDialog(this@MainActivity, object :DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    Toast.makeText(this@MainActivity, "$dayOfMonth.$month.$year", Toast.LENGTH_SHORT).show()
                }
            },
            2022,
            3,
            10)
                val date=Date()
                datePickerDialog.updateDate(date.date, date.month,date.year)
                datePickerDialog.show()
            }

            bottomsheet.setOnClickListener{
                val bottomSheetDialog=BottomSheetDialog(this@MainActivity)
                val myDialogViewBinding=MyDialogViewBinding.inflate(layoutInflater)
                bottomSheetDialog.setContentView(myDialogViewBinding.root)
                bottomSheetDialog.show()


            }

            snackbar.setOnClickListener{
                val snackbar=Snackbar.make(it, "SnackBar",Snackbar.LENGTH_SHORT)

                snackbar.setAction("Click", object :View.OnClickListener{
                    override fun onClick(v: View?) {
                        Toast.makeText(this@MainActivity, "Bosildi", Toast.LENGTH_SHORT).show()
                    }
                })
                snackbar.show()
            }

            fragment.setOnClickListener{
                val myDialogFragment= MyDialogFragment()
                myDialogFragment.show(supportFragmentManager.beginTransaction(),"MyDialogFragment")
            }

        }

    }
}