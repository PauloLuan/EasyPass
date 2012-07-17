package br.com.android;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaGerador extends Activity {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gerador);
		final TextView txtSenha = (TextView)findViewById(R.id.senha);
		final Button btn_gerar = (Button)findViewById(R.id.btn_gerar_g);
		
		btn_gerar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final Random r = new Random();
				int R = r.nextInt(255 - 0 + 1);
				MD5 hash = new MD5();
				txtSenha.setText( String.valueOf( hash.getMD5( String.valueOf( R ) ) ).substring(0,10) );
			}
		});
	}
}
