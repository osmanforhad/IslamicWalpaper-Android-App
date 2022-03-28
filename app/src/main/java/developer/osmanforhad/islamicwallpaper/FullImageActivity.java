package developer.osmanforhad.islamicwallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class FullImageActivity extends AppCompatActivity {

    private ImageView fullImage;
    private Button apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        //__Initial variables and connect with xml id__//
        fullImage = findViewById(R.id.fullImage);
        apply = findViewById(R.id.apply);

        Glide.with(this).load(getIntent().getStringExtra("image")).into(fullImage);

        //__Setup Click event in apply button__//
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackground();//Calling the method
            }
        });
    }

    //__Method for set Wallpaper in Users Mobile__//
    private void setBackground() {
        Bitmap bitmap = ((BitmapDrawable)fullImage.getDrawable()).getBitmap();
        WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
        //manager.setBitmap();
        try {
            manager.setBitmap(bitmap);
        } catch (IOException e) {
            Toast.makeText(this, "Error : "+e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}