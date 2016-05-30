package com.sezzh.smood.ui.fragments;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sezzh.smood.R;
import com.sezzh.smood.io.api.ServiceGenerator;
import com.sezzh.smood.io.models.ColorExample;
import com.sezzh.smood.ui.adapters.ColorRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ColorListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColorListFragment extends Fragment {
    private final Integer GRID_COLUMNS = 3;
    private RecyclerView mRecyclerView;
    private ColorRecyclerViewAdapter mAdapter;
    //private RecyclerView.LayoutManager mLayoutManager;


    public ColorListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    }

    private void setupRecyclerView() {
        // TODO: set call to api here
        List<ColorExample> list = new ArrayList<ColorExample>();

        list.add(new ColorExample("Chelsea Blue", "#FF1265"));
        list.add(new ColorExample("another", "#561276"));
        list.add(new ColorExample("Real madrid", "#005421"));
        list.add(new ColorExample("bebicolor", "#FF6432"));
        list.add(new ColorExample("sezhcolor", "#667711"));
        list.add(new ColorExample("sdsasd", "#546242"));
        list.add(new ColorExample("dfdfdf", "#516272"));
        list.add(new ColorExample("sezhcocxcxlor", "#122333"));
        list.add(new ColorExample("yhghfgh", "#987543"));
        list.add(new ColorExample("ghfhgbv", "#553377"));
        list.add(new ColorExample("dfdfsfdf", "#543790"));
        list.add(new ColorExample("xcvcvcv", "#444444"));

        this.mRecyclerView.setLayoutManager(
                new GridLayoutManager(this.getActivity(), this.GRID_COLUMNS)
        );
        this.mAdapter = new ColorRecyclerViewAdapter(list);
        this.mRecyclerView.setAdapter(this.mAdapter);
    }

}
