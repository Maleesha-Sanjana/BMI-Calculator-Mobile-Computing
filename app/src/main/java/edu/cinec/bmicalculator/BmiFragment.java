package edu.cinec.bmicalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BmiFragment extends Fragment {

    private EditText etHeight, etWeight;
    private Button btnCalBMI;
    private TextView tvAnswer, tvBMIScore;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bmi, container, false);

        etHeight = view.findViewById(R.id.etHeight);
        etWeight = view.findViewById(R.id.etWeight);
        btnCalBMI = view.findViewById(R.id.btnCalBMI);
        tvAnswer = view.findViewById(R.id.tvAnswer);
        tvBMIScore = view.findViewById(R.id.tvBMIScore);

        btnCalBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input data
                String height = etHeight.getText().toString().trim();
                String weight = etWeight.getText().toString().trim();

                if (height.isEmpty() || weight.isEmpty()) {
                    Toast.makeText(getContext(), "Please Enter height and weight", Toast.LENGTH_SHORT).show();
                } else {
                    //convert string to float
                    float h = Float.parseFloat(height); // assumes cm based on figma, but prev code used m. Figma says HEIGHT (CM). I will adapt to cm.
                    float w = Float.parseFloat(weight);

                    // Figma shows HEIGHT in CM. Let's convert cm to m for BMI calc.
                    float h_in_m = h / 100f;

                    //calculate BMI
                    float BMI = w / (h_in_m * h_in_m);
                    
                    // Format BMI score to 1 decimal place
                    tvBMIScore.setText(String.format("%.1f", BMI));

                    String mes = "";
                    if (BMI < 18.5)
                        mes = "Underweight";
                    else if (BMI < 25)
                        mes = "Normal";
                    else
                        mes = "Overweight";

                    tvAnswer.setText(mes);
                }
            }
        });

        return view;
    }
}
