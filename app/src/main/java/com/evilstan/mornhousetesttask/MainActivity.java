package com.evilstan.mornhousetesttask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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
        View root = binding.getRoot();
        setContentView(root);

        init();
    }

    private void init() {
        dataBaseManager = new DataBaseManager(this);

        List<NumberInfo> historyList = dataBaseManager.getHistory();
        HistoryAdapter historyAdapter = new HistoryAdapter(historyList, this);

        binding.getByNumberBtn.setOnClickListener(this);
        binding.getRandomBtn.setOnClickListener(this);
        binding.historyRecycler.setAdapter(historyAdapter);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.get_by_number_btn) {
            getNumber();
        } else if (id == R.id.get_random_btn) {
            getRandomNumber();
        }
    }

    @Override
    public void onItemClick(NumberInfo numberInfo, int position) {
        //TODO start fragment with NumberInfo attributes
    }

    private void getNumber() {
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

    private void getRandomNumber() {
        int randomNumber = 0;
        String randomDescription = "";
        //TODO get request random number

        NumberInfo numberInfo = new NumberInfo(randomNumber, randomDescription);
        dataBaseManager.putToHistory(numberInfo);
    }
}