package br.com.android.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CreateDatabase {

	public static SQLiteDatabase db;

	public static boolean initialize(Context context) {
		// Open a SQLite Database
		db = context.openOrCreateDatabase("EasyPass.db",
				SQLiteDatabase.CREATE_IF_NECESSARY, null);

		if (createTableUser() && createTablePassword()) {
			return true;
		}
		return false;
	}

	private static boolean createTableUser() {
		try {
			// begin the transaction
			db.beginTransaction();

			// Create a table
			String tableSql = "CREATE TABLE IF NOT EXISTS user ("
					+ "user_id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "login TEXT," 
					+ "password TEXT," 
					+ "question TEXT," 
					+ "resp TEXT);";
			db.execSQL(tableSql);

			// this makes sure transaction is committed
			db.setTransactionSuccessful();
			return true;
		} catch (Exception e) {
			return false;
		} finally {

			db.endTransaction();
		}
	}

	private static boolean createTablePassword() {
		try {
			// begin the transaction
			db.beginTransaction();

			// Create a table
			String tableSql = 
					  "CREATE TABLE IF NOT EXISTS password ("
					+ "password_id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "user_id INTEGER,"
					+ "nome TEXT," 
					+ "site TEXT," 
					+ "login TEXT,"
					+ "password TEXT" 
					+ "FOREIGN KEY(user_id) REFERENCES user(user_id));";
			
			db.execSQL(tableSql);

			// this makes sure transaction is committed
			db.setTransactionSuccessful();

			return true;
		} catch (Exception e) {

			return false;

		} finally {
			db.endTransaction();
		}
	}
}
