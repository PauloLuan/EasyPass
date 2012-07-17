package br.com.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.android.dao.CreateDatabase;
import br.com.android.dao.UserDAO;
import br.com.android.model.User;

public class EasyPassActivity extends Activity {
	/** Called when the activity is first created. */
	EditText login;
	EditText pass;
	User user = new User();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
		dialogo.setTitle("Atenção ao resultado");
		if (CreateDatabase.initialize(this)) {
			dialogo.setMessage("Banco de Dados Criado");
		} else {
			dialogo.setMessage("Erro ao criar banco de dados.");
		}
		dialogo.setNeutralButton("Ok", null);
		dialogo.show();

		
		/* TODO: O erro está aqui, verificar o nome dos botões e se a funcionalidade deve ser atribuídas a ele mesmo... */
		final Button btnCadastro = (Button) findViewById(R.id.btn_cadastro_c);
		final Button btnLogin = (Button) findViewById(R.id.btn_logar);
		final Button btnGerar = (Button) findViewById(R.id.btn_gerar_g);

		
		btnCadastro.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				telaCadastro();
			}
		});

		btnGerar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				telaGerador();
			}
		});
		btnLogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				login();
			}
		});
	}

	public boolean login() {

		this.login = (EditText) findViewById(R.id.txt_login_i);
		this.pass = (EditText) findViewById(R.id.txt_pass_i);
		String u = login.getText().toString();
		String p = pass.getText().toString();
		this.user.setLogin(u);
		this.user.setpassword(p);

		UserDAO dao = new UserDAO();
		User userExistente = dao.loginUser(this.user);
		if (userExistente != null) {
			AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
			dialogo.setTitle("Atenção ao resultado");
			dialogo.setMessage("Aew Seu Puto você está Logado!");
			dialogo.setNeutralButton("Ok", null);
			dialogo.show();
		}
		return true;
	}

	public void telaCadastro() {
		Intent i = new Intent(this, TelaCadastro.class);
		startActivity(i);
	}

	public void telaGerador() {
		Intent i = new Intent(this, TelaGerador.class);
		startActivity(i);
	}
}