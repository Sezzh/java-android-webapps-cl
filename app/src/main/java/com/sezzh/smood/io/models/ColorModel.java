package com.sezzh.smood.io.models;

import java.util.ArrayList;

/**
 * Created by sezzh on 29/05/16.
 */
public class ColorModel {
    private String url;
    private String hexa;
    private Float opacity;
    private String rgb;
    private String name;
    private ArrayList<String> user_id = new ArrayList<String>();

    public ColorModel(String hexa, Float opacity, String rgb, String name,
                      ArrayList<String> user_id) {
        this.hexa = hexa;
        this.opacity = opacity;
        this.rgb = rgb;
        this.name = name;
        this.user_id = user_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHexa() {
        return hexa;
    }

    public void setHexa(String hexa) {
        this.hexa = hexa;
    }

    public Float getOpacity() {
        return opacity;
    }

    public void setOpacity(Float opacity) {
        this.opacity = opacity;
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getUser_id() {
        return user_id;
    }

    public void setUser_id(ArrayList<String> user_id) {
        this.user_id = user_id;
    }
}
