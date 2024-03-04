package com.example.havagas

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import kotlin.math.log

class Form (
    var nomeCompleto: String = "",
    var email: String = "",
    var ingressarListaEmails: Boolean = false,
    var telefone: String = "",
    var telefoneCelular: String = "",
    var sexo: String = "",
    var dataNascimento: String = "",
    var formacao: String = "",
    var anoFormatura: String = "",
    var instituicao: String = "",
    var tituloMonografia: String = "",
    var orientador: String = "",
    var vagasInteresse: String = ""
) {
    // This method should be expanded to include the new fields.
    override fun toString(): String {
        return ("Nome Completo: $nomeCompleto\n" +
                "E-mail: $email\n" +
                "Ingressar na lista de e-mails: $ingressarListaEmails\n" +
                "Telefone: $telefone\n" +
                "Telefone Celular: $telefoneCelular\n" +
                "Sexo: $sexo\n" +
                "Data de Nascimento: $dataNascimento\n" +
                "Formação: $formacao\n" +
                "Ano de Formatura: $anoFormatura\n" +
                "Instituição: $instituicao\n" +
                "Título da Monografia: $tituloMonografia\n" +
                "Orientador: $orientador\n" +
                "Vagas de Interesse: $vagasInteresse")
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fullNameEditText: EditText = findViewById(R.id.fullNameEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val optInEmailUpdatesCheckBox: CheckBox = findViewById(R.id.optInEmailUpdatesCheckBox)
        val phoneEditText: EditText = findViewById(R.id.phoneEditText)
        val phoneTypeSpinner: Spinner = findViewById(R.id.phoneTypeSpinner)
        val addMobilePhoneCheckBox: CheckBox = findViewById(R.id.addMobilePhoneCheckBox)
        val mobilePhoneLabel: TextView = findViewById(R.id.mobilePhoneLabel)
        val mobilePhoneEditText: EditText = findViewById(R.id.mobilePhoneEditText)

        addMobilePhoneCheckBox.setOnCheckedChangeListener { _, isChecked ->
            mobilePhoneLabel.visibility = if (isChecked) View.VISIBLE else View.GONE
            mobilePhoneEditText.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        val phoneTypeOptions = arrayOf("Comercial", "Residencial")
        val phoneTypeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, phoneTypeOptions)
        phoneTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        phoneTypeSpinner.adapter = phoneTypeAdapter

        val sexRadioGroup: RadioGroup = findViewById(R.id.sexRadioGroup)
        val birthdateEditText: EditText = findViewById(R.id.birthdateEditText)
        val educationLevelSpinner: Spinner = findViewById(R.id.educationLevelSpinner)

        val educationLevelOptions = arrayOf("Fundamental", "Médio", "Graduação", "Especialização", "Mestrado", "Doutorado")
        val educationLevelAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, educationLevelOptions)
        educationLevelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        educationLevelSpinner.adapter = educationLevelAdapter

        val graduationYearLabel: TextView = findViewById(R.id.graduationYearLabel)
        val graduationYearEditText: EditText = findViewById(R.id.graduationYearEditText)

        val institutionLabel: TextView = findViewById(R.id.institutionLabel)
        val institutionEditText: EditText = findViewById(R.id.institutionEditText)

        val thesisTitleLabel: TextView = findViewById(R.id.thesisTitleLabel)
        val thesisTitleEditText: EditText = findViewById(R.id.thesisTitleEditText)

        val advisorTitleLabel: TextView = findViewById(R.id.advisorTitleLabel)
        val advisorTitleEditText: EditText = findViewById(R.id.advisorTitleEditText)

        educationLevelSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                graduationYearLabel.visibility = View.GONE
                graduationYearEditText.visibility = View.GONE

                institutionLabel.visibility = View.GONE
                institutionEditText.visibility = View.GONE

                thesisTitleLabel.visibility = View.GONE
                thesisTitleEditText.visibility = View.GONE

                advisorTitleLabel.visibility = View.GONE
                advisorTitleEditText.visibility = View.GONE
            }

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (educationLevelOptions[position]) {
                    "Fundamental", "Médio" -> {
                        graduationYearLabel.visibility = View.VISIBLE
                        graduationYearEditText.visibility = View.VISIBLE

                        institutionLabel.visibility = View.GONE
                        institutionEditText.visibility = View.GONE

                        thesisTitleLabel.visibility = View.GONE
                        thesisTitleEditText.visibility = View.GONE

                        advisorTitleLabel.visibility = View.GONE
                        advisorTitleEditText.visibility = View.GONE
                    }
                    "Graduação", "Especialização" -> {
                        graduationYearLabel.visibility = View.VISIBLE
                        graduationYearEditText.visibility = View.VISIBLE

                        institutionLabel.visibility = View.VISIBLE
                        institutionEditText.visibility = View.VISIBLE

                        thesisTitleLabel.visibility = View.GONE
                        thesisTitleEditText.visibility = View.GONE

                        advisorTitleLabel.visibility = View.GONE
                        advisorTitleEditText.visibility = View.GONE
                    }
                    "Mestrado", "Doutorado" -> {
                        graduationYearLabel.visibility = View.VISIBLE
                        graduationYearEditText.visibility = View.VISIBLE

                        institutionLabel.visibility = View.VISIBLE
                        institutionEditText.visibility = View.VISIBLE

                        thesisTitleLabel.visibility = View.VISIBLE
                        thesisTitleEditText.visibility = View.VISIBLE

                        advisorTitleLabel.visibility = View.VISIBLE
                        advisorTitleEditText.visibility = View.VISIBLE
                    }
                }
            }
        }

        val interestEditText: EditText = findViewById(R.id.interestEditText)

        val clearButton: Button = findViewById(R.id.clearButton)
        val saveButton: Button = findViewById(R.id.saveButton)

        clearButton.setOnClickListener {

        }

        saveButton.setOnClickListener {
            val form = Form()
            Toast.makeText(this, form.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
