package com.example.havagas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.havagas.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatePickerDialog datePickerDialog;
    private final static String KEY_INPUT_NOME = "KEY_INPUT_NOME";
    private final static String KEY_INPUT_EMAIL = "KEY_INPUT_EMAIL";
    private final static String KEY_INPUT_TELEFONE = "KEY_INPUT_TELEFONE";
    private final static String KEY_INPUT_CELULAR = "KEY_INPUT_CELULAR";
    private final static String KEY_INPUT_SEXO = "KEY_INPUT_SEXO";
    private final static String KEY_INPUT_DATANASC = "KEY_INPUT_DATANASC";
    private final static String KEY_INPUT_ANOFORM = "KEY_INPUT_ANOFORM";
    private final static String KEY_INPUT_VAGAINT = "KEY_INPUT_VAGAINT";
    private final static String KEY_INPUT_INSTITUICAO = "KEY_INPUT_INSTITUICAO";
    private final static String KEY_INPUT_MONO = "KEY_INPUT_MONO";
    private final static String KEY_INPUT_ORIENTADOR = "KEY_INPUT_ORIENTADOR";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initDatePicker();
        spinner();
        
        
        
        binding.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(binding.checkBox.isChecked()){
                    binding.telefoneLinearLayout.setVisibility(View.VISIBLE);
                }else{
                    binding.telefoneLinearLayout.setVisibility(View.GONE);
                }

            }
        });
        binding.dataNascimento.setText(getTodaysDate());
        binding.dataNascimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        binding.buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = binding.textInputLayout.getEditText().getText().toString();
                String email = binding.textInputLayout2.getEditText().getText().toString();
                String telefone = binding.textInputLayout3.getEditText().getText().toString();
                String tipoTelefone = binding.comercial.isChecked() ? "Comercial" : "Fixo";
                if(binding.checkBox.isChecked()){
                    String celular = binding.textInputLayout4.getEditText().getText().toString();
                }
                String sexo = binding.feminino.isChecked() ? "Feminino" : "Masculino";
                String dataNascimento =  binding.dataNascimento.getText().toString();
                String formacao = binding.spinner.getSelectedItem().toString();
                String anoConclusao = binding.textInputLayout5.getEditText().getText().toString();
                if(formacao != "FUNDAMENTAL" && formacao != "MÉDIO"){
                    String instituicao = binding.textInputLayout6.getEditText().toString();
                    if(formacao != "ESPECIALIZAÇÃO" && formacao != "GRADUACAO"){
                        String tituloMono = binding.textInputLayout7.getEditText().toString();
                        String orientador = binding.textInputLayout7.getEditText().toString();
                    }
                }
                String vagaInteresse = binding.textInputLayout9.getEditText().getText().toString();

                Vaga vaga = new Vaga();
                vaga.setNome(nome);
                vaga.setEmail(email);
                vaga.setTelefone(telefone);
                vaga.setTipoTelefone(tipoTelefone);
                vaga.setCelular(binding.checkBox.isChecked() ? binding.textInputLayout4.getEditText().getText().toString() : "");
                vaga.setSexo(sexo);
                vaga.setDataNascimento(dataNascimento);
                vaga.setFormacao(formacao);
                vaga.setAnoFormatura(anoConclusao);

                if(formacao.equals("ESPECIALIZAÇÃO") || formacao.equals("GRADUACAO")){
                    vaga.setInstituicao(binding.textInputLayout6.getEditText().getText().toString());
                }else{
                    vaga.setInstituicao("NÃO POSSUI");
                }
                if(formacao.equals("MESTRADO") || formacao.equals("DOUTORADO")){
                    vaga.setTituloDeMonografia(binding.textInputLayout7.getEditText().getText().toString());
                    vaga.setOrientador(binding.textInputLayout8.getEditText().getText().toString());
                }else{
                    vaga.setTituloDeMonografia("NÃO POSSUI");
                    vaga.setOrientador("NÃO POSSUI");
                }

                vaga.setVagasDeInteresse(vagaInteresse);

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("VAGA CADASTRADA");
                dialog.setMessage(vaga.toString());
                //Configurar cancelamento
                dialog.setCancelable(false);
                dialog.setNegativeButton("Fechar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.create();
                dialog.show();





            }
        });


        binding.buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textInputLayout.getEditText().setText("");
                binding.textInputLayout2.getEditText().setText("");
                binding.textInputLayout3.getEditText().setText("");
                binding.textInputLayout4.getEditText().setText("");
                binding.textInputLayout5.getEditText().setText("");
                binding.textInputLayout6.getEditText().setText("");
                binding.textInputLayout7.getEditText().setText("");
                binding.textInputLayout8.getEditText().setText("");
                binding.textInputLayout9.getEditText().setText("");
            }

        });






    }

    private void spinner() {
        List<String> list = new ArrayList<>(Arrays.asList("FUNDAMENTAL", "MÉDIO", "GRADUACAO", "ESPECIALIZAÇÃO", "MESTRADO", "DOUTORADO"));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
        binding.spinner.setAdapter(adapter);
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).toString() == "FUNDAMENTAL" || adapterView.getItemAtPosition(i).toString() == "MÉDIO" ){
                    binding.textInputLayout5.setVisibility(View.VISIBLE);
                    binding.textInputLayout6.setVisibility(View.GONE);
                    binding.textInputLayout7.setVisibility(View.GONE);
                    binding.textInputLayout8.setVisibility(View.GONE);
                }else if(adapterView.getItemAtPosition(i).toString() == "GRADUACAO" || adapterView.getItemAtPosition(i).toString() == "ESPECIALIZAÇÃO" ){
                    binding.textInputLayout5.setHint("Ano de conclusão");
                    binding.textInputLayout5.setVisibility(View.VISIBLE);
                    binding.textInputLayout6.setVisibility(View.VISIBLE);
                    binding.textInputLayout7.setVisibility(View.GONE);
                    binding.textInputLayout8.setVisibility(View.GONE);
                }else if(adapterView.getItemAtPosition(i).toString() == "MESTRADO" || adapterView.getItemAtPosition(i).toString() == "DOUTORADO"){
                    binding.textInputLayout5.setHint("Ano de conclusão");
                    binding.textInputLayout5.setVisibility(View.VISIBLE);
                    binding.textInputLayout6.setVisibility(View.VISIBLE);
                    binding.textInputLayout7.setVisibility(View.VISIBLE);
                    binding.textInputLayout8.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                binding.dataNascimento.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }
//    String nome = binding.textInputLayout.getEditText().getText().toString();
//    String email = binding.textInputLayout2.getEditText().getText().toString();
//    String telefone = binding.textInputLayout3.getEditText().getText().toString();
//    String tipoTelefone = binding.comercial.isChecked() ? "Comercial" : "Fixo";
//                if(binding.checkBox.isChecked()){
//        String celular = binding.textInputLayout4.getEditText().getText().toString();
//    }
//    String sexo = binding.feminino.isChecked() ? "Feminino" : "Masculino";
//    String dataNascimento =  binding.dataNascimento.getText().toString();
//    String formacao = binding.spinner.getSelectedItem().toString();
//    String anoConclusao = binding.textInputLayout5.getEditText().getText().toString();
//                if(formacao != "FUNDAMENTAL" && formacao != "MÉDIO"){
//        String instituicao = binding.textInputLayout6.getEditText().toString();
//        if(formacao != "ESPECIALIZAÇÃO" && formacao != "GRADUACAO"){
//            String tituloMono = binding.textInputLayout7.getEditText().toString();
//            String orientador = binding.textInputLayout8.getEditText().toString();
//        }
//    }
//    String vagaInteresse = binding.textInputLayout9.getEditText().getText().toString();


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_INPUT_NOME, binding.textInputLayout.getEditText().getText().toString());
        outState.putString(KEY_INPUT_EMAIL, binding.textInputLayout2.getEditText().getText().toString());
        outState.putString(KEY_INPUT_TELEFONE, binding.textInputLayout3.getEditText().getText().toString());
        outState.putString(KEY_INPUT_CELULAR, binding.textInputLayout4.getEditText().getText().toString());
        outState.putString(KEY_INPUT_ANOFORM, binding.textInputLayout5.getEditText().getText().toString());
        outState.putString(KEY_INPUT_INSTITUICAO, binding.textInputLayout6.getEditText().getText().toString());
        outState.putString(KEY_INPUT_MONO, binding.textInputLayout7.getEditText().getText().toString());
        outState.putString(KEY_INPUT_ORIENTADOR, binding.textInputLayout8.getEditText().getText().toString());
        outState.putString(KEY_INPUT_VAGAINT, binding.textInputLayout9.getEditText().getText().toString());
        outState.putString(KEY_INPUT_DATANASC, binding.dataNascimento.getText().toString());
        outState.putString(KEY_INPUT_SEXO, binding.feminino.isChecked() ? "Feminino" : "Masculino");

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        binding.textInputLayout.getEditText().setText(savedInstanceState.getString(KEY_INPUT_NOME, ""));
        binding.textInputLayout2.getEditText().setText(savedInstanceState.getString(KEY_INPUT_EMAIL, ""));
        binding.textInputLayout3.getEditText().setText(savedInstanceState.getString(KEY_INPUT_TELEFONE, ""));
        binding.textInputLayout4.getEditText().setText(savedInstanceState.getString(KEY_INPUT_CELULAR, ""));
        binding.textInputLayout5.getEditText().setText(savedInstanceState.getString(KEY_INPUT_ANOFORM, ""));
        binding.textInputLayout6.getEditText().setText(savedInstanceState.getString(KEY_INPUT_INSTITUICAO, ""));
        binding.textInputLayout7.getEditText().setText(savedInstanceState.getString(KEY_INPUT_MONO, ""));
        binding.textInputLayout8.getEditText().setText(savedInstanceState.getString(KEY_INPUT_ORIENTADOR, ""));
        binding.textInputLayout9.getEditText().setText(savedInstanceState.getString(KEY_INPUT_VAGAINT, ""));
        binding.dataNascimento.setText(savedInstanceState.getString(KEY_INPUT_DATANASC, ""));
        if(savedInstanceState.getString(KEY_INPUT_SEXO, "") == "Feminino"){
            binding.feminino.setChecked(true);
        }else{
            binding.masculino.setChecked(true);
        }


    }
}