package model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CussWord {

    @SerializedName("word")
    private String word;

    @SerializedName("language")
    private String language;

    public CussWord(String word, String language) {
        this.word = word;
        this.language = language;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
