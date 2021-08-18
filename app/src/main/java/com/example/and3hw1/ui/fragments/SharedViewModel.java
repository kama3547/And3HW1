package com.example.and3hw1.ui.fragments;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.and3hw1.Model.Books;
import com.example.and3hw1.R;

import java.util.ArrayList;
import java.util.List;

public class SharedViewModel extends ViewModel {
    public MutableLiveData<ArrayList<Books>> listMutableLiveData = new MutableLiveData<>();
    int pos ;
    ArrayList<Books> list = new ArrayList<>() ;

    public void onSetPost(int pos){
        this.pos = pos;
    }


    public void getBooks() {
        list.add(new Books(R.drawable.book,"book1","description1"));
        list.add(new Books(R.drawable.boo,"book2","description2"));
        list.add(new Books(R.drawable.books,"book3","description3"));
        list.add(new Books(R.drawable.image,"book4","description4"));
        list.add(new Books(R.drawable.ima,"book5","description5"));
        list.add(new Books(R.drawable.images,"book6","description6"));
        list.add(new Books(R.drawable.imas,"book7","description7"));
        list.add(new Books(R.drawable.im,"book8","description8"));
        list.add(new Books(R.drawable.ges,"book9","description9"));
        list.add(new Books(R.drawable.pe,"book10","description10"));
        list.add(new Books(R.drawable.pro,"book11","description11"));
        listMutableLiveData.setValue(list);
    }
}
