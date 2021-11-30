package com.evilstan.mornhousetesttask;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.evilstan.mornhousetesttask.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener,
        HistoryAdapter.OnHistoryClickListener {
    
    //TODO UI
    private ActivityMainBinding binding;
    private DataBaseManager dataBaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initComponents();
    }

    private void initComponents() {
        dataBaseManager = new DataBaseManager();

        List<NumberInfo> historyList = dataBaseManager.getHistory();
        HistoryAdapter historyAdapter = new HistoryAdapter(historyList, this);

        binding.getByNumberBtn.setOnClickListener(this);
        binding.getRandomBtn.setOnClickListener(this);
        binding.historyRecycler.setAdapter(historyAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.get_by_number_btn) {
            getByNumber();
        } else if (v.getId() == R.id.get_random_btn) {
            getRandom();
        }
    }

    @Override
    public void onItemClick(NumberInfo numberInfo) {
        //TODO start fragment with NumberInfo attributes
    }

    private void getByNumber() {
        int number = 0;
        if (binding.inputNumberEdit.getText() != null) {
            number = Integer.parseInt(binding.inputNumberEdit.getText().toString());
        }

        String description = "";
        //TODO get request by number and fill description

        NumberInfo numberInfo = new NumberInfo(number, description);
        dataBaseManager.putToHistory(numberInfo);
        //TODO open fragment with number and description
    }

    private void getRandom() {
        int randomNumber = 0;
        String randomDescription = "";
        //TODO get request random number

        NumberInfo numberInfo = new NumberInfo(randomNumber, randomDescription);
        dataBaseManager.putToHistory(numberInfo);
    }
}