package com.example.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mwordsBackground = -1;

    public WordAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }


    public WordAdapter(Activity context, ArrayList<Word> words, int wordsBackground) {
        super(context, 0, words);
        mwordsBackground = wordsBackground;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;


        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        Word currentWord = getItem(position);

        TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.default_textView);
        defaultTranslationTextView.setText(currentWord.getDefaultTranslation());

        TextView miwokTranslationTextView = (TextView) listItemView.findViewById(R.id.miwok_textView);
        miwokTranslationTextView.setText(currentWord.getMiwokTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.icon_imageView);

        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageId());
        } else {
            imageView.setVisibility(View.GONE);
        }

        LinearLayout wordsContriner = (LinearLayout) listItemView.findViewById(R.id.wordsContainer);
//        int color= ContextCompat.getColor(getContext(), mwordsBackground);
        wordsContriner.setBackgroundResource(mwordsBackground);
//        wordsContriner.setBackgroundColor(color);

        return listItemView;
    }


}
