package br.com.android.dao;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import br.com.android.model.Password;

public class PasswordDAO {

	public static void insert(Password password) {
		try {
			CreateDatabase.db.beginTransaction();
			// insert this row

			// Id auto increment
			String name = password.getname();
			String site = password.getSite();
			String login = password.getLogin();
			String passw = password.getpassword();

			String insert = "INSERT INTO password (name, site, login, password) VALUES (?, ?, ?, ?);";
			
			CreateDatabase.db.execSQL(insert, new Object[] { name, site, login, passw });
			CreateDatabase.db.setTransactionSuccessful();
		} catch (Exception e) {
			/* Implementar pop up de mensagem de erro */
		} finally {
			CreateDatabase.db.endTransaction();
		}
	}

	public boolean update(Password password) {
		return false;
	}

	public static void delete(Password password) {
		try {
			CreateDatabase.db.beginTransaction();

			String delete = "DELETE FROM password WHERE password_id='" + password.getId()
					+ "'";
			CreateDatabase.db.execSQL(delete);

			CreateDatabase.db.setTransactionSuccessful();
		} catch (Exception e) {
			/* Implementar pop up de mensagem de erro */
		} finally {
			CreateDatabase.db.endTransaction();
		}
	}
	
	public static List<Password> getPasswords() {
		Cursor cursor = null;
		try {
			List<Password> passwords = new ArrayList<Password>();
			
			cursor = CreateDatabase.db.rawQuery("SELECT * FROM password", null);

			if (cursor.getCount() > 0) {
				
				/* pega o index de cada uma das colunas no BD */
				int col_id = cursor.getColumnIndex("id");
				int col_name = cursor.getColumnIndex("name");
				int col_site = cursor.getColumnIndex("site");
				int col_login = cursor.getColumnIndex("login");
				int col_password = cursor.getColumnIndex("password");

				cursor.moveToFirst(); // ??
				do {
					/* Coleta cada um dos valores a partir do index coletado acima */
					Long id = Long.valueOf(cursor.getInt(col_id));
					String name = cursor.getString(col_name);
					String site = cursor.getString(col_site);
					String login = cursor.getString(col_login);
					String passw = cursor.getString(col_password);
					
					Password password = new Password();
					password.setId(id);
					password.setname(name);
					password.setSite(site);
					password.setLogin(login);
					password.setpassword(passw);
					
					passwords.add(password);

					cursor.moveToNext(); // move para o próximo registro, semelhante ao HasNext
				} while (!cursor.isAfterLast());
			}
			return passwords;
			
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
	}

}
