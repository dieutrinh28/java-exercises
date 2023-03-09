package com.example.gridview_image;

import static com.example.gridview_image.ItemData.getItemById;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;



public class ViewImageActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textViewTitle, textViewDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        imageView = findViewById(R.id.item_image);
        textViewTitle = findViewById(R.id.item_title);
        textViewDescription = findViewById(R.id.item_description);

        int id = (int) getIntent().getLongExtra("id", 0);

        Picasso.get().load((ItemData.getItemById(id).getImage())).resize(400,500).centerCrop().into(imageView);
        textViewTitle.setText((ItemData.getItemById(id)).getTitle());
        textViewDescription.setText((ItemData.getItemById(id)).getDescription());

    }
}
