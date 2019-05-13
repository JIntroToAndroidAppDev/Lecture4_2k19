package com.myfirstandroidapp.servicesdemo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CountryDAO {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertCountryToDb(Country countryToInsert);

    @Delete
    void deleteCountry(Country country);

/*
    @Update
    void updateCountry(Country country);
     // This is teh same as doing @Insert (onConflict = OnConflictStrategy.REPLACE)
*/
    @Query("SELECT * FROM Country WHERE Country_Name LIKE :countryName")
    Country getCountryByName(String countryName);

    @Query("SELECT * FROM Country")
    List<Country> getAllCountries();
}
