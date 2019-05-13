package com.myfirstandroidapp.servicesdemo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HTTPHandler {
    private static final String URL =
            "https://restcountries.eu/rest/v2/name/";
    private HttpURLConnection httpURLConnection;

    public Country getCountryByName(String countryName)
            throws IOException {
        this.httpURLConnection = (HttpURLConnection)
                new URL(URL+countryName).openConnection();
        InputStream is = this.httpURLConnection.getInputStream();
        //BufferedReader br = new BufferedReader(new InputStreamReader(is));
        Scanner sc = new Scanner(is);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            sb.append(sc.next());
        }
        return new ObjectMapper()
                .readValue(sb.toString(), Country[].class)[0];
    }
}
