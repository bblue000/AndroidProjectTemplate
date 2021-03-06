package com.frameworkexample.android.model.provider;

import org.ixming.android.sqlite.provider.SQLiteUtils;

import com.frameworkexample.android.model.User;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * a example of SQLiteOpenHelper()
 */
/*package*/class LocalDBHelper extends SQLiteOpenHelper {
	final String TAG = LocalDBHelper.class.getSimpleName();
	
	/*package*/LocalDBHelper(Context context, int dataBaseVersion) {
		super(context, LocalDBProvider.DATABASE_NAME, null, dataBaseVersion);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		modifyAllTables(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion < newVersion) {
			if (oldVersion < LocalDBProvider.VERSION_1_0) {
				modifyTables_V1_0(db);
				oldVersion = LocalDBProvider.VERSION_1_0;
			}
		}
	}

	private void modifyAllTables(SQLiteDatabase db) {
		modifyTables_V1_0(db);
	}
	
	// =====================================================
	private void modifyTables_V1_0(SQLiteDatabase db){
		SQLiteUtils.createTableAndIndices(db, User.class);
	}
	
	@SuppressWarnings("unused")
	private void modifyTables_V1_1(SQLiteDatabase db){
		
	}
}
