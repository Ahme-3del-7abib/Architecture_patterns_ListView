package com.example.applylistview.ui.numbers;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.applylistview.Pojo.Word;
import com.example.applylistview.R;

import java.util.ArrayList;
import java.util.List;

public class NumbersViewModel extends ViewModel {

    MutableLiveData<List<Word>> data = new MutableLiveData<>();

    public List<Word> setNumbers() {

        final List<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "Ahmed", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "adel", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "muhamed", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "hossam", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "aml", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "dina", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "salma", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "omar", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "eman", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "heba", R.drawable.number_ten, R.raw.number_ten));

        return words;
    }

    public void getNumbers() {
        data.setValue(setNumbers());
    }
}
