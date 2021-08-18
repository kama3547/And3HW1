package com.example.and3hw1.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and3hw1.R;
import com.example.and3hw1.databinding.FragmentDetailBinding;


public class DetailFragment extends Fragment {

    FragmentDetailBinding binding;
    SharedViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        binding = FragmentDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDataInPosition();

    }

    private void getDataInPosition() {
        viewModel.onSetPost(viewModel.pos);
        binding.txtTitle.setText(viewModel.list.get(viewModel.pos).getTitle());
        binding.detailDes.setText(viewModel.list.get(viewModel.pos).getDescription());
        binding.imageView.setImageResource(viewModel.list.get(viewModel.pos).getImage());
    }
}