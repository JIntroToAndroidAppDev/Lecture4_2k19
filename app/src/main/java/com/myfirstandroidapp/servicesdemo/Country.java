package com.myfirstandroidapp.servicesdemo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@Entity(tableName = "Country") // Can be anything
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country implements Serializable {
    @PrimaryKey @NonNull
    @ColumnInfo(name = "Country_Name") private String name;
    private int population;

    public Country() {
        name = "";
    }

    @Ignore
    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return name + " : " + population;
    }
}