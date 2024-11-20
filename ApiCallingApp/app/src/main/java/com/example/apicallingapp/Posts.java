package com.example.apicallingapp;

public class Posts {
     int id;
     String name,username,email,phone,website,street,suite,city,zipcode,lat,lng,company_name,catchPhrase,bs;


    public Posts( int id, String name, String username, String email, String phone, String website, String street, String suite, String city,
                 String zipcode, String lat, String lng, String company_name, String catchPhrase, String bs) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.lat = lat;
        this.lng = lng;
        this.company_name = company_name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }
}
