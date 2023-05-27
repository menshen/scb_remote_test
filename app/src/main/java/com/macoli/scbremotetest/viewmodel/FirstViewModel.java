package com.macoli.scbremotetest.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.ViewModel;

import com.macoli.scbremotetest.BR;
import com.macoli.scbremotetest.repository.ResultRepository;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;


public class FirstViewModel extends ViewModel {
    private final FirstViewState firstViewState = new FirstViewState() ;
    DecimalFormat decimalFormat = new DecimalFormat("#,###.###");

    private double amount ;
    private int times ; //second

    public FirstViewState getViewState() {
        return firstViewState ;
    }

    public boolean amountInputChanged(String newAmountStr) {
        try {
            BigDecimal number = new BigDecimal(newAmountStr) ;
            firstViewState.setAmountText("Amount: " + decimalFormat.format(number)) ;
            amount = number.doubleValue() ;
            return true ;
        } catch (Exception e) {
            return false ;
        }
    }

    public int toInt(String timeStr) {
        try {
            return Integer.parseInt(timeStr) ;
        } catch (Exception e) {
            e.printStackTrace(); ;
        }
        return -1 ;
    }

    public boolean timesInputChanged(String timesStr) {
        int timeInSeconds = toInt(timesStr) ;
        if (-1 == timeInSeconds) {
            return false ;
        }
        int minutes = timeInSeconds / 60;
        int seconds = timeInSeconds % 60;

        times = timeInSeconds ;

        firstViewState.setTimesText("Times: " + minutes + "m" + seconds + "s");

        return true ;
    }

    public void submit() {
        ResultRepository.getInstance().addResult(String.valueOf(amount * times));
    }

    public static class FirstViewState extends BaseObservable {
        @Bindable
        public String amountText;
        @Bindable
        public String timesText;


        public void setAmountText(String amountText) {
            this.amountText = amountText;
            notifyPropertyChanged(BR.amountText);
        }

        public void setTimesText(String timesText) {
            this.timesText = timesText;
            notifyPropertyChanged(BR.timesText);
        }
    }
}
