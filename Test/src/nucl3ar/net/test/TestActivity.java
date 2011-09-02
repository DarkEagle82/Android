package nucl3ar.net.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import nucl3ar.net.test.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.util.Log;
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
        
        final Spinner sp = (Spinner) findViewById(R.id.spinner1);
        final ImageView image = (ImageView) findViewById(R.id.test_image);
        
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this, R.array.corbates, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {
           
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, 
            		int position, long id) {
            	
            			int index = sp.getSelectedItemPosition();
                        	
            			Toast.makeText(parentView.getContext(), "Has sel·leccionat " +
            	          parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            			
            			Log.d("Testing", String.format("%d", index));
            			
                      // Depending on index you display the image ...
                        if(index==0)
                        	image.setImageResource(R.drawable.test);
                          //  image.setBackgroundDrawable(getResources().getDrawable(R.drawable.test));
                        else if(index==1)
                        	image.setImageResource(R.drawable.test2);
                        //    image.setBackgroundDrawable(getResources().getDrawable(R.drawable.test2));
                        	
            	    
            }
                                 
            public void onNothingSelected(AdapterView<?> parentView) {
            	
            }
        });       
        
        
        enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	int index = sp.getSelectedItemPosition();
                Log.d("Testing", String.format("Al enviar, el index es: %d", index));
                try { 
                	Process process = Runtime.getRuntime().exec("cat /proc/sys/net/ipv4/ip_forward >> \\\\192.168.1.10\\c\\ETIQUETAS\\CAIXA_LINEADprova.LAB");
                	Log.d("Testing", String.format("%s", process));
                }
                catch (IOException e) { 
                		e.printStackTrace(); 
                		}
        //       ProgressDialog dialog = ProgressDialog.show(TestActivity.this, "", 
        //                "Enviant. Espera ...", true);
                }
        }); // TODO new thread
        
        // Runtime.getruntime
        // os.writeBytes
        
   
        // Elegim l'imatge a Mostrar
       // ImageView image = (ImageView) findViewById(R.id.test_image);
     //   image.setImageResource(R.drawable.test);
    }
}