package com.android.culqi.culqi_android;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.culqi.culqi_android.Culqi.Card;
import com.android.culqi.culqi_android.Culqi.Token;
import com.android.culqi.culqi_android.Culqi.TokenCallback;
import com.android.culqi.culqi_android.Validation.Validation;


import com.craftman.cardform.CardForm;
import com.craftman.cardform.OnPayBtnClickListner;


import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Validation validation;

    ProgressDialog progress;

    TextView kind_card, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardForm cardForm = (CardForm)findViewById(R.id.cardf);
        TextView txtDes = (TextView)findViewById(R.id.payment_amount);
        Button btnPay = (Button)findViewById(R.id.btn_pay);

        validation = new Validation();

        progress = new ProgressDialog(this);
        progress.setMessage("Validando informacion de la tarjeta");
        progress.setCancelable(false);
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        kind_card = (TextView) findViewById(R.id.kind_card);
        result = (TextView) findViewById(R.id.token_id);



        cardForm.setPayBtnClickListner(new OnPayBtnClickListner() {
            @Override
            public void onClick(com.craftman.cardform.Card card) {
                progress.show();
                Card card0 = new Card(card.getNumber(), card.getCVC(), 9, 2020, "email@gmail.com");

                //Token token = new Token("pk_test_MIJ6FSwgM2Slm2Hb");
                Token token = new Token("pk_test_MIJ6FSwgM2Slm2Hb");

                token.createToken(getApplicationContext(), card0, new TokenCallback() {
                    @Override
                    public void onSuccess(JSONObject token) {
                        try {
                            result.setText(token.get("id").toString());
                            Toast.makeText(MainActivity.this, result.getText() , Toast.LENGTH_LONG).show();
                        } catch (Exception ex) {
                            progress.hide();
                        }
                        progress.hide();
                    }

                    @Override
                    public void onError(Exception error) {
                        progress.hide();
                    }
                });



            }
        });

    }

}
