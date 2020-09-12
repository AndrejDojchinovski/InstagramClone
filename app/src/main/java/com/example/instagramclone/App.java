package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App  extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("xvjw88RcpvkJ7Wudq7nVjVSQPCSMaQtmAzKtFeEa")
                // if defined
                .clientKey("IhU5qqXK3t7V4xovnV0uUWW6eEZ0Ur1Ta4wrBNnJ")
                .server("https://parseapi.back4app.com/")
                .build()
        );


    }
}
