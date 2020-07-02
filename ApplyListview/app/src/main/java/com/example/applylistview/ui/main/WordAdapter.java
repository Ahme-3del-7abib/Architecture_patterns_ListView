package com.example.applylistview.ui.main;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.applylistview.Pojo.Word;
import com.example.applylistview.R;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    private int color_resource_id;

    public WordAdapter(Activity context, List<Word> words, int color_resource_id) {
        super(context, 0, words);
        this.color_resource_id = color_resource_id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.word_list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miwok = (TextView) listItemView.findViewById(R.id.textView);
        miwok.setText(currentWord.getmMiwokTranslation());

        TextView default_t = (TextView) listItemView.findViewById(R.id.textView2);
        default_t.setText(currentWord.getmDefaultTranslation());

        ImageView img = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.has_image()) {
            img.setImageResource(currentWord.getImageId());
            img.setVisibility(View.VISIBLE);
        } else {
            img.setVisibility(View.GONE);
        }

        View view = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), color_resource_id);
        view.setBackgroundColor(color);

        return listItemView;
    }
}
