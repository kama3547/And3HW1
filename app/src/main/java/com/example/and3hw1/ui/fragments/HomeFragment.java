package com.example.and3hw1.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and3hw1.Model.Books;
import com.example.and3hw1.OnItemClick;
import com.example.and3hw1.R;
import com.example.and3hw1.adapter.TaskAdapter;
import com.example.and3hw1.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    SharedViewModel viewModel;
    FragmentHomeBinding binding;
    TaskAdapter adapter = new TaskAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRV();
        initAlization();
        onClick();
        setUpObserve();
        onItemClickListener();
    }

    private void onItemClickListener() {
        adapter.setOnItemClickListener((position) -> {
            viewModel.onSetPost(position);
            Log.e("pos", "onItemClickListener: "+ position );
            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
            navController.navigate(R.id.action_homeFragment_to_detailFragment);
        });
    }

    private void setUpObserve() {
        viewModel.listMutableLiveData.observe(getViewLifecycleOwner(), books -> {
            adapter.setBook(books);
            binding.rvTask.setVisibility(View.VISIBLE);
        });
    }

    private void onClick() {
        binding.btn.setOnClickListener(v -> {
            binding.btn.setVisibility(View.GONE);
            binding.rvTask.setVisibility(View.VISIBLE);
            viewModel.getBooks();
        });
    }

    private void initAlization() {
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
    }

    private void initRV() {
        set();
    }

    private void set() {
        binding.rvTask.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvTask.setAdapter(adapter);
    }
}
