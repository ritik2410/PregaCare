package com.example.pregacare;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class DetailEntry extends Fragment {

    private EditText e1,e2,e3,e4,e5,e6,e7,e8;

    String n1,n8,n2,n3,n4,n5,n6,n7;
    Button btn,reset;
    String s1;
    RequestQueue requestQueue;
    TextView t1;
    public DetailEntry() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_detail_entry, container, false);
        e1=view.findViewById(R.id.e1);

        e2=view.findViewById(R.id.e2);

        e3=view.findViewById(R.id.e3);

        e4=(EditText) view.findViewById(R.id.e4);

        e5=(EditText) view.findViewById(R.id.e5);

        e6=(EditText) view.findViewById(R.id.e6);

        e7=(EditText) view.findViewById(R.id.e7);

        e8=(EditText) view.findViewById(R.id.e8);

        t1=(TextView) view.findViewById(R.id.t1);

        btn = (Button) view.findViewById(R.id.btn);
        reset = (Button) view.findViewById(R.id.reset);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1 = e1.getText().toString();
                n2 = e2.getText().toString();
                n3 = e3.getText().toString();
                n4 = e4.getText().toString();
                n5 = e5.getText().toString();
                n6 = e6.getText().toString();
                n7 = e7.getText().toString();
                n8 = e8.getText().toString();
                if(n1.isEmpty() || n2.isEmpty() || n3.isEmpty() || n4.isEmpty() || n5.isEmpty() || n6.isEmpty() || n7.isEmpty() || n8.isEmpty())
                {
                    t1.setVisibility(View.INVISIBLE);
                    Toast.makeText(getContext().getApplicationContext(),"Please Enter All The Above Fields",Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(getContext().getApplicationContext(),n1+" hg",Toast.LENGTH_LONG).show();
                String url = "https://makeitshort.pythonanywhere.com/api/";
                StringRequest stringRequest = new StringRequest(Request.Method. POST, url,
                        response -> t1.setText(response),
                        error -> Toast.makeText(getContext().getApplicationContext(), "Error", Toast.LENGTH_SHORT).show()) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("pregnancies", n1);
                        params.put("glucose", n2);
                        params.put("bloodPressure", n3);
                        params.put("skinThickness", n4);
                        params.put("insulin", n5);
                        params.put("BMI", n6);
                        params.put("DiabetesPedigreeFunction", n7);
                        params.put("age", n8);
                        return params;
                    }
                };

                requestQueue = Volley.newRequestQueue(getContext().getApplicationContext());
                requestQueue.add(stringRequest);
                e8.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
                e5.setText("");
                e6.setText("");
                e7.setText("");
                e8.setText("");
                t1.setText("");
            }
        });

        return view;
    }
}