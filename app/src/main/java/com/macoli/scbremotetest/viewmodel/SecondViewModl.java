package com.macoli.scbremotetest.viewmodel;

import androidx.lifecycle.ViewModel;

import com.macoli.scbremotetest.repository.ResultRepository;

import java.util.List;

public class SecondViewModl extends ViewModel {
    public List<String> getData() {
        return ResultRepository.getInstance().getResultList();
    }
}
