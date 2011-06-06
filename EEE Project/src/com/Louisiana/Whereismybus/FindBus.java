package com.Louisiana.Whereismybus;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class FindBus extends Activity {

	public int routes_array = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.findmybus);

		Spinner spinner1 = (Spinner) findViewById(R.id.Spinner01);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
				this, R.array.companies_array,
				android.R.layout.simple_spinner_item);
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter1);
		spinner1.setOnItemSelectedListener(new CompanyOnItemSelectedListener());

		Spinner spinner2 = (Spinner) findViewById(R.id.Spinner02);
		final String TAG = "MyActivity";
		Log.v(TAG, Integer.toString(routes_array));
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				this, 2131034114, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(adapter2);

		Spinner spinner3 = (Spinner) findViewById(R.id.Spinner03);
		ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(
				this, R.array.busStops_array1,
				android.R.layout.simple_spinner_item);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner3.setAdapter(adapter3);

		final CheckBox checkbox = (CheckBox) findViewById(R.id.cbSave);
		checkbox.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// Perform action on clicks, depending on whether it's now
				// checked
				if (((CheckBox) v).isChecked()) {
					Toast.makeText(FindBus.this, "Selected", Toast.LENGTH_SHORT)
							.show();
				} else {
					Toast.makeText(FindBus.this, "Not selected",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	// The function that displays toast-message when you select a company
	public class CompanyOnItemSelectedListener implements
			OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			Toast.makeText(
					parent.getContext(),
					"Selected Company: "
							+ parent.getItemAtPosition(pos).toString(),
					Toast.LENGTH_LONG).show();
			switch (pos) {
			case 1:
				routes_array = R.array.routes_array1;
				break;
			case 2:
				routes_array = R.array.routes_array2;
				break;
			case 3:
				routes_array = R.array.routes_array3;
				break;
			default:
				routes_array = 2131034114;
				break;
			}

		}

		public void onNothingSelected(AdapterView parent) {
			// Do nothing.
		}
	}

}
