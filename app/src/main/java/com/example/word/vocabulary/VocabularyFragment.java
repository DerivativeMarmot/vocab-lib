package com.example.word.vocabulary;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.word.databinding.FragmentVocabularyBinding;
import com.example.word.model.Word;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VocabularyFragment extends Fragment {

    private static final String TAG = "VocabularyFragment";
    private FragmentVocabularyBinding binding;
    private RecyclerView recyclerView;
    private VocabularyRecyclerViewAdaptor adaptor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentVocabularyBinding.inflate(inflater, container, false);
        recyclerView = binding.fcVocabularySection;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptor = new VocabularyRecyclerViewAdaptor(getContext());
        recyclerView.setAdapter(adaptor);
        init();
        return binding.getRoot();
    }

    private void init() {
        try {
            File file = new File(Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + File.separator + "words.json");
            Log.d(TAG, "init: " + file.getName());
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            String response = stringBuilder.toString();
            JSONArray data = new JSONObject(response).getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                JSONObject curWord = data.getJSONObject(i);
                VocabularyManager.getInstance().addItem(
                        0,
                        new Word(
                                curWord.has("english word") ? curWord.getString("english word") : null,
                                curWord.has("chinese meaning") ? curWord.getString("chinese meaning") : null,
                                curWord.has("example sentences") ? curWord.getString("example sentences") : null,
                                null,
                                null
                        )
                );
            }

        } catch (JSONException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
