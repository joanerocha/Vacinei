package com.joanerocha.vacinei;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.File;
import java.io.FileOutputStream;

public class GerarQR extends AppCompatActivity {

    Button gen_btn;
    ImageView image;
    String text2QR;
    TextView sus;
    Bitmap bitmap;

    Bundle b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerar_qr);

        b = getIntent().getExtras();

        sus = (TextView) findViewById(R.id.susPaciente);
        sus.setText(b.getString("susP"));

        gen_btn = (Button) findViewById(R.id.gen_btn);
        image = (ImageView) findViewById(R.id.image);

        text2QR = b.getString("susP").trim();
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text2QR, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.createBitmap(bitMatrix);
            image.setImageBitmap(bitmap);
        } catch (WriterException we) {
            we.printStackTrace();
        }
    }

    public void salvarIMG(View view) {
        try {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Vacinei/");

            if (!file.exists()) {
                file.mkdirs();
            }
            String nomeImagem = "Cartao" + sus.getText().toString() + ".jpg";
            File imagem = new File(file, nomeImagem);
            FileOutputStream out = new FileOutputStream(imagem);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            Toast.makeText(this, "Qr Code Salvo!", Toast.LENGTH_SHORT).show();
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "Por favor, ative as permissões do aplicativo", Toast.LENGTH_SHORT).show();
        }
    }

    public void cadastrarPaciente(View view) {
        Intent cadastrarPaciente = new Intent(this, CadastroPaciente.class);
        cadastrarPaciente.putExtra("susP", b.getString("sus"));
        startActivity(cadastrarPaciente);
    }
}
