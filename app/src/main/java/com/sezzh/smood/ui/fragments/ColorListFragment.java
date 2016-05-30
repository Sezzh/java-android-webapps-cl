package com.sezzh.smood.ui.fragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sezzh.smood.R;
import com.sezzh.smood.io.api.ServiceGenerator;
import com.sezzh.smood.io.api.SmoodClient;
import com.sezzh.smood.io.models.ColorModel;
import com.sezzh.smood.ui.adapters.ColorRecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ColorListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColorListFragment extends Fragment {
    private final Integer GRID_COLUMNS = 3;
    private RecyclerView mRecyclerView;
    private ColorRecyclerViewAdapter mAdapter;
    private SmoodClient smoodClient;


    public ColorListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.smoodClient =
                ServiceGenerator.createService(SmoodClient.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(
                R.layout.fragment_color_list, container, false
        );

        this.mRecyclerView =
                (RecyclerView) root.findViewById(R.id.recycler_view_colors);
        this.mRecyclerView.setHasFixedSize(true); // best performance with this
        this.setupRecyclerView();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.smoodClient
                .getResourceColors().enqueue(new Callback<List<ColorModel>>() {
            @Override
            public void onResponse(Call<List<ColorModel>> call,
                                   Response<List<ColorModel>> response) {
                if (response.isSuccessful()) {
                    mAdapter.setData(response.body());
                } else {
                    Log.d("ColorListFragment", "error en la llamada");
                }
            }

            @Override
            public void onFailure(Call<List<ColorModel>> call, Throwable t) {

            }
        });
    }

    private void setupRecyclerView() {
        this.mRecyclerView.setLayoutManager(
                new GridLayoutManager(this.getActivity(), this.GRID_COLUMNS)
        );
        this.mAdapter = new ColorRecyclerViewAdapter();
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

}
