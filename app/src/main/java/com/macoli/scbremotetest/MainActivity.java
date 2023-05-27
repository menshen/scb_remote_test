package com.macoli.scbremotetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.macoli.scbremotetest.databinding.ActivityMainBinding;

import com.macoli.scbremotetest.viewmodel.FirstViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding ;
    private FirstViewModel viewModel ;
    private TextWatcher amountTextWatcher ;
    private TextWatcher timesTextWatcher ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater()) ;
        viewModel = new ViewModelProvider(this).get(FirstViewModel.class) ;

        setContentView(activityMainBinding.getRoot()) ;

        activityMainBinding.setUiState(viewModel.getViewState()) ;

        initTextWatch() ;
        activityMainBinding.amountEdt.addTextChangedListener(amountTextWatcher) ;
        activityMainBinding.timesEdt.addTextChangedListener(timesTextWatcher) ;

        activityMainBinding.submitBtn.setOnClickListener(v -> {
            viewModel.submit() ;
            Intent intent =  new Intent(MainActivity.this , SecondActivity.class) ;
            startActivity(intent) ;
        });
    }

    private void initTextWatch() {
        amountTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                boolean result = viewModel.amountInputChanged(editable.toString());
                if (!result) {
                    Toast.makeText(MainActivity.this , R.string.times_formate_failed , Toast.LENGTH_SHORT).show(); ;
                }
            }
        };

        timesTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                boolean result = viewModel.timesInputChanged(editable.toString());
                if (!result) {
                    Toast.makeText(MainActivity.this , R.string.times_formate_failed , Toast.LENGTH_SHORT).show(); ;
                }
            }
        };
    }
}