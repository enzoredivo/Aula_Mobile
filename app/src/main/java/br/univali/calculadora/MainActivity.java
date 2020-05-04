package br.univali.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    EditText number1;
    EditText number2;
    TextView result;
    ListView listView;
    List<String> history = new ArrayList<>();
    //ArrayAdapter<String> historyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, history);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.num1);
        number2 = findViewById(R.id.num2);
        result = findViewById(R.id.textViewResult);
        listView = findViewById(R.id.historico);

       // listView.setAdapter(historyAdapter);
    }

    public void addNumber(View v)
    {
        result.setText("");
        String num1 = number1.getText().toString().trim();
        String num2 = number2.getText().toString().trim();

        if (NumbersAreNotVoid(num1, num2))
        {
            float res = Float.valueOf(num1) + Float.valueOf(num2);
            result.setText("Resultado: " + res);
            addToHistory(Float.valueOf(num1), Float.valueOf(num2), res, "+");
        }
        else
        {
            Toast.makeText(this, "Por favor, informe dois números.", Toast.LENGTH_LONG).show();
        }
    }

    public void subNumber(View v)
    {
        result.setText("");
        String num1 = number1.getText().toString().trim();
        String num2 = number2.getText().toString().trim();

        if (NumbersAreNotVoid(num1, num2))
        {
            float res = Float.valueOf(num1) - Float.valueOf(num2);
            result.setText("Resultado: " + res);
            addToHistory(Float.valueOf(num1), Float.valueOf(num2), res, "-");
        }
        else
        {
            Toast.makeText(this, "Por favor, informe dois números.", Toast.LENGTH_LONG).show();
        }
    }

    public void multNumber(View v)
    {
        result.setText("");
        String num1 = number1.getText().toString().trim();
        String num2 = number2.getText().toString().trim();

        if (NumbersAreNotVoid(num1, num2))
        {
            float res = Float.valueOf(num1) * Float.valueOf(num2);
            result.setText("Resultado: " + res);
            addToHistory(Float.valueOf(num1), Float.valueOf(num2), res, "*");
        }
        else
        {
            Toast.makeText(this, "Por favor, informe dois números.", Toast.LENGTH_LONG).show();
        }
    }

    public void divNumber(View v)
    {
        result.setText("");
        String num1 = number1.getText().toString().trim();
        String num2 = number2.getText().toString().trim();

        if (NumbersAreNotVoid(num1, num2))
        {
            if (!isZero(num2))
            {
                float res = Float.valueOf(num1) / Float.valueOf(num2);
                result.setText("Resultado: " + res);
                addToHistory(Float.valueOf(num1), Float.valueOf(num2), res, "/");
            }
            else
            {
                Toast.makeText(this, "Quando selecionado o operando '/', o segundo número não pode ser 0.", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this, "Por favor, informe dois números.", Toast.LENGTH_LONG).show();
        }
    }

    public void eraseHistory(View v)
    {
        history.clear();
    }




    private boolean NumbersAreNotVoid(String n1, String n2)
    {
        return !(n1.equals("") || n2.equals(""));
    }

    private boolean isZero(String n)
    {
        return (n.equals("0"));
    }

    private void addToHistory(float num1, float num2, float result, String operation)
    {
        history.add(num1 + " " + operation + " " + num2 + "= " + result);
    }
}
