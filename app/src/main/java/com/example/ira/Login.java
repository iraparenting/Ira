package com.example.ira;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Login extends AppCompatActivity
{
    TextView login;

    @Override
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
        this.login = (TextView) findViewById(R.id.login);
        this.login.setOnClickListener(new OnClickListener()
        {
            public void onClick(View view)
            {
                Login.this.startActivity(new Intent(Login.this, Prefrence.class));
            }
        });
        findViewById(R.id.register).setOnClickListener(new OnClickListener()
        {
            public void onClick(View view)
            {
                Login.this.startActivity(new Intent(Login.this, Register.class));
            }
        });
    }
}
