package com.example.dogodose;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.dogodose.api.ApiRequestFact;
import com.example.dogodose.api.ApiRequestImage;
import com.squareup.picasso.Picasso;

/**
 *
 * Created by Domagoj Ratko 03.06.2022
 * Don't copy code
 * Free to use
 * Enjoy :D
 *
*/

public class MainActivity extends AppCompatActivity {

    private MainActivity mainActivity;
    private ApiRequestImage apiRequestImage;
    private ApiRequestFact apiRequestFact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        new UISettings(this);

        ImageView image = findViewById(R.id.main_image);
        TextView textMessage = findViewById(R.id.textMessage);

        image.setOnClickListener(v -> {
            apiRequestImage = new ApiRequestImage(mainActivity, "https://dog.ceo/api/breeds/image/random");
            Picasso.get().load(apiRequestImage.getGET_IMAGE()).into(image);
            apiRequestFact = new ApiRequestFact(mainActivity, "https://dog-facts-api.herokuapp.com/api/v1/resources/dogs?number=1");
            textMessage.setText(apiRequestFact.getGET_FACT());
        });
    }

}