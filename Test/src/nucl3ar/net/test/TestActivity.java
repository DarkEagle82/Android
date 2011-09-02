package nucl3ar.net.test;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button enviar = (Button) findViewById(R.id.button1);
        
        Spinner sp = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.corbates, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {
           
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, 
            		int position, long id) {
                        	Toast.makeText(parentView.getContext(), "Has sel·leccionat " +
            	          parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            	
            	    
            }
                                 
            public void onNothingSelected(AdapterView<?> parentView) {
            	
            }
        });       
        
        
        enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ProgressDialog dialog = ProgressDialog.show(TestActivity.this, "", 
                        "Enviant. Espera ...", true);
                }
        }); // TODO new thread
        
        
   
        // Elegim l'imatge a Mostrar
       // ImageView image = (ImageView) findViewById(R.id.test_image);
     //   image.setImageResource(R.drawable.test);
    }
}