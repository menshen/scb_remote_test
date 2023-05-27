package com.macoli.scbremotetest;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.macoli.scbremotetest.adapter.ResultAdapter;
import com.macoli.scbremotetest.databinding.ActivityMainBinding;
import com.macoli.scbremotetest.databinding.ActivitySecondBinding;
import com.macoli.scbremotetest.repository.ResultRepository;
import com.macoli.scbremotetest.viewmodel.FirstViewModel;
import com.macoli.scbremotetest.viewmodel.SecondViewModl;

import java.util.List;

public class SecondActivity extends AppCompatActivity {
    ActivitySecondBinding binding ;
    SecondViewModl viewModel ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        binding = ActivitySecondBinding.inflate(getLayoutInflater()) ;
        viewModel = new ViewModelProvider(this).get(SecondViewModl.class) ;


        setContentView(binding.getRoot()) ;

        initRV();


        ActionBar actionBar =  getSupportActionBar() ;
        actionBar.setTitle("Result List");
        actionBar.setDisplayHomeAsUpEnabled(true) ;
    }

    void initRV() {
        RecyclerView recyclerView = binding.resultRv;
        List<String> resultList = ResultRepository.getInstance().getResultList();
        ResultAdapter adapter = new ResultAdapter(resultList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    //设置监听事件
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

}
