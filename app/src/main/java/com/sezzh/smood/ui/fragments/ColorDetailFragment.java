package com.sezzh.smood.ui.fragments;


import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sezzh.smood.R;
import com.sezzh.smood.io.api.ServiceGenerator;
import com.sezzh.smood.io.api.SmoodClient;
import com.sezzh.smood.io.models.ColorModel;
import com.sezzh.smood.io.models.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorDetailFragment extends Fragment {

    private final String MTOOLBAR_DARKEN_BACKGROUD = "#AB2E2E2E";
    private OnSelectedListener mListener;
    private Toolbar mToolbar;
    private AppBarLayout mAppBarLayout;
    private EditText mColorName;
    private EditText mColorHexa;
    private EditText mColorR;
    private EditText mColorG;
    private EditText mColorB;
    private EditText mColorOpacity;
    private SmoodClient smoodClient;

    public interface OnSelectedListener {
        void onSelectedItem(Uri itemUri);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.smoodClient = ServiceGenerator.createService(SmoodClient.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =
            inflater.inflate(R.layout.fragment_color_detail, container, false);
        this.setHasOptionsMenu(true);
        this.mColorR = (EditText) root.findViewById(R.id.color_r);
        this.mColorG = (EditText) root.findViewById(R.id.color_g);
        this.mColorB = (EditText) root.findViewById(R.id.color_b);
        this.mColorOpacity = (EditText) root.findViewById(R.id.color_opacity);
        this.mColorHexa = (EditText) root.findViewById(R.id.color_hexa);

        this.mColorHexa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                handlePreviewColor(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_new_color, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_done) {
            this.handleColorResourceSubmit();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mToolbar =
                (Toolbar) this.getActivity().findViewById(R.id.toolbar);
        this.mAppBarLayout =
                (AppBarLayout) this.getActivity().findViewById(R.id.app_bar);
        this.mColorName =
                (EditText) this.getActivity().findViewById(R.id.color_name);
    }

    private void handlePreviewColor(String value) {
        if (value.length() == 6) {
            this.mToolbar.setBackgroundColor(
                    Color.parseColor(MTOOLBAR_DARKEN_BACKGROUD)
            );
            this.mAppBarLayout
                    .setBackgroundColor(Color.parseColor("#" + value));
        }
    }

    private void handleColorResourceSubmit() {
        ArrayList<String> user = new ArrayList<String>();
        user.add(UserModel.URL);
        String rgb = String.format(
                "%s,%s,%s",
                this.mColorR.getText().toString(),
                this.mColorG.getText().toString(),
                this.mColorB.getText().toString()
        );
        ColorModel colorResourceToSubmit = new ColorModel(
                this.mColorHexa.getText().toString(),
                Float.parseFloat(this.mColorOpacity.getText().toString()),
                rgb,
                this.mColorName.getText().toString(),
                user
        );
        smoodClient
                .createResourceColor(colorResourceToSubmit)
                .enqueue(new Callback<ColorModel>() {
                    @Override
                    public void onResponse(Call<ColorModel> call,
                                           Response<ColorModel> response) {
                        if (response.isSuccessful()) {
                            getActivity().finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<ColorModel> call, Throwable t) {

                    }
                });
    }
}
