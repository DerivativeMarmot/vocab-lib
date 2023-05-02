package com.example.word.vocabulary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.word.databinding.SingleWordBinding;
import com.example.word.model.Word;

public class VocabularyRecyclerViewAdaptor extends RecyclerView.Adapter<VocabularyRecyclerViewAdaptor.ViewHolder> {

    private static final String TAG = "VocabularyRecyclerViewAdaptor";
    Context context;

    public VocabularyRecyclerViewAdaptor(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleWordBinding binding = SingleWordBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word word = VocabularyManager.getInstance().getItemByIndex(position);
        holder.englishWord.setText(word.getEnglishWord());
        holder.chineseMeaning.setText(word.getChineseMeaning());
        holder.exampleSentences.setText(word.getExampleSentences());
    }

    @Override
    public int getItemCount() {
        return VocabularyManager.getInstance().getCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView englishWord;
        TextView chineseMeaning;
        TextView exampleSentences;

        public ViewHolder(SingleWordBinding binding) {
            super(binding.getRoot());
            englishWord = binding.swEnglishWord;
            chineseMeaning = binding.swChineseMeaning;
            exampleSentences = binding.swExampleSentences;
        }
    }
}
