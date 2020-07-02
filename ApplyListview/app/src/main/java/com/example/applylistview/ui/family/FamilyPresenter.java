package com.example.applylistview.ui.family;

import com.example.applylistview.Pojo.Word;
import com.example.applylistview.R;

import java.util.ArrayList;
import java.util.List;

public class FamilyPresenter {

    FamilyInterface familyInterface;


    public FamilyPresenter(FamilyInterface familyInterface) {
        this.familyInterface = familyInterface;
    }


    public List<Word> setNumbers() {

        final List<Word> words = new ArrayList<Word>();
        words.add(new Word("grand father", "Ahmed", R.drawable.family_grandfather, R.raw.family_grandfather));
        words.add(new Word("grand mother", "hala", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("father", "muhamed", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("mother", "reham", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("daughter", "aml", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("old brother", "dina", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("old sister", "salma", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger brother", "omar", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("younger sister", "eman", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("son", "heba", R.drawable.family_son, R.raw.family_son));
        return words;
    }

    public void getFamily() {
        familyInterface.getFamilyData(setNumbers());
    }
}
