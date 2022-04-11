package com.kunalattri.letsdonate.ui.apply;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ApplyViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ApplyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Apply fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}