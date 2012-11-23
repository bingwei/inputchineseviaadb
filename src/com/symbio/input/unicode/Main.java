package com.symbio.input.unicode;


import org.apache.commons.lang3.StringEscapeUtils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText unicodeText = (EditText)findViewById(R.id.unicodeText);
        final TextView encodedText = (TextView)findViewById(R.id.encodedText);
        final Button btnCopyQuit = (Button)findViewById(R.id.copy_then_quit);
        final Button btnCopy = (Button)findViewById(R.id.copy);
        View.OnClickListener btnListener;
        
       
        
        btnListener = new View.OnClickListener(){
        		@Override
				public void onClick(View v) {
					Context context = getApplicationContext();
					if(unicodeText.getText().length() == 0){
						CharSequence text = "Please input unicode text in edit view first.";
						int duration = Toast.LENGTH_SHORT;
	
						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}else{
						String text = StringEscapeUtils.unescapeJava(unicodeText.getText().toString().replace("u\\", "\\"));
						encodedText.setText(text);
						
						ClipboardManager cm =(ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
						cm.setText(text);
					}
					if(v.equals(btnCopyQuit) && unicodeText.getText().length() != 0){
						Main.this.finish();
					}
				}
			};
        btnCopyQuit.setOnClickListener(btnListener);
        btnCopy.setOnClickListener(btnListener);
    }

}
