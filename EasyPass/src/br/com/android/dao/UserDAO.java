package br.com.android.dao;

import android.database.Cursor;
import br.com.android.model.User;

public class UserDAO {

	public static boolean insert(User user) {
		try {
			CreateDatabase.db.beginTransaction();
			// insert this row
			// id is auto increment
			String login = user.getLogin();
			String password = user.getpassword();
			String question = user.getquestion();
			String resp = user.getresp();
			String insert = "INSERT INTO user (user_id, login, password, question, resp) VALUES (null, ?, ?, ?,?);";
			CreateDatabase.db.execSQL(insert, new Object[] { login, password,
					question, resp });
					//question});
			CreateDatabase.db.setTransactionSuccessful();
			return true;
		} catch (Exception e) {
			/* Implementar pop up de mensagem de erro */
			return false;
		} finally {
			CreateDatabase.db.endTransaction();
		}
	}

	public boolean update(User user) {
		return false;
	}

	public static void delete(User user) {
		try {
			CreateDatabase.db.beginTransaction();

			String delete = "DELETE FROM user WHERE user_id='" + user.getId()
					+ "'";
			CreateDatabase.db.execSQL(delete);

			CreateDatabase.db.setTransactionSuccessful();
		} catch (Exception e) {
			/* Implementar pop up de mensagem de erro */
		} finally {
			CreateDatabase.db.endTransaction();
		}
	}

	/* retorna usuário nulo caso ele não exista, caso ele exista retorna o objeto instanciado (como se fosse uma sessão) */
	public User loginUser(User user) {
		User userExiste = null;
		Cursor cursor = null;
		String u = user.getLogin();
		String p = user.getpassword();
		String sql = "SELECT * FROM user WHERE login = '"+u+"' and password = '"+p+"';";
		try {	
			cursor = CreateDatabase.db.rawQuery(sql, null);

			if (cursor.getCount() > 0) {
				
				int col_id = cursor.getColumnIndex("user_id");
				int col_login = cursor.getColumnIndex("login");
				int col_password = cursor.getColumnIndex("password");
				int col_question = cursor.getColumnIndex("question");
				int col_resp = cursor.getColumnIndex("resp");

				cursor.moveToFirst();

				Long id = Long.valueOf(cursor.getInt(col_id));
				String login = cursor.getString(col_login);
				String password = cursor.getString(col_password);
				String question = cursor.getString(col_question);
				String resp = cursor.getString(col_resp);

				userExiste = new User(); // instância um novo usuário pois ele já existe!
				
				userExiste.setId(id);
				userExiste.setLogin(login);
				userExiste.setpassword(password);
				userExiste.setquestion(question);
				userExiste.setresp(resp);
			}

		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}

		return userExiste;
	}

}
