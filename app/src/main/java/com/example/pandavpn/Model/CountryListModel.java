package com.example.pandavpn.Model;

public class CountryListModel {
    int id;
    String country_name;
    boolean isSelected ;

    public CountryListModel(int id, String country_name, boolean isSelected) {
        this.id = id;
        this.country_name = country_name;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getId() {
        return id;
    }


    public String getCountry_name() {
        return country_name;
    }
}
