package br.com.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.android.dao.UserDAO;
import br.com.android.model.User;

public class TelaCadastro extends Activity {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
        
        final EditText login = (EditText)findViewById(R.id.txt_login_c);
        final EditText senha = (EditText)findViewById(R.id.txt_pass_c);
        final EditText senha2 = (EditText)findViewById(R.id.txt_pass2_c);
        final EditText pergunta = (EditText)findViewById(R.id.txt_perg_c);
        final EditText resposta = (EditText)findViewById(R.id.txt_resp_c);
        
        final Button btnCadastrar = (Button)findViewById(R.id.btn_cadastro_c);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	String loginstr = login.getText().toString();
            	String senhastr = senha.getText().toString();
            	String senha2str = senha2.getText().toString();
            	String perguntastr = pergunta.getText().toString();
            	String respostastr = resposta.getText().toString();
                User user = new User();
                user.setLogin(loginstr);
                user.setpassword(senhastr);
                user.setquestion(perguntastr);
                user.setresp(respostastr);
                
                UserDAO dao = new UserDAO();
                if(dao.insert(user)){
                	finish();
                }
            }
        });
	}
}
