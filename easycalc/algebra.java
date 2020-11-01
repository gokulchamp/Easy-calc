package com.example.easycalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class algebra extends Activity {

    EditText box1,box2,box3,box4,box5,box6,box7,box8,box9;
    TextView algebra_result_view;
    Button ref,transpose,inverse;
    TextView det_value;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algebra);
        box1=findViewById(R.id.box1);
        box2=findViewById(R.id.box2);
        box3=findViewById(R.id.box3);
        box4=findViewById(R.id.box4);
        box5=findViewById(R.id.box5);
        box6=findViewById(R.id.box6);
        box7=findViewById(R.id.box7);
        box8=findViewById(R.id.box8);
        box9=findViewById(R.id.box9);

        algebra_result_view=findViewById(R.id.algebra_result_view);

        ref=findViewById(R.id.ref);
        transpose=findViewById(R.id.transpose);
        inverse=findViewById(R.id.inverse);
        det_value=findViewById(R.id.det_value);







        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int [][]array;
                array =getValues();

//                array[0][0][0]=Integer.parseInt(box1.getText().toString());
//                array[0][0][1]=Integer.parseInt(box2.getText().toString());
//                array[0][0][2]=Integer.parseInt(box3.getText().toString());
//                array[0][1][0]=Integer.parseInt(box4.getText().toString());
//                array[0][1][1]=Integer.parseInt(box5.getText().toString());
//                array[0][1][2]=Integer.parseInt(box6.getText().toString());
//                array[0][2][0]=Integer.parseInt(box7.getText().toString());
//                array[0][2][1]=Integer.parseInt(box8.getText().toString());
//                array[0][2][2]=Integer.parseInt(box9.getText().toString());

                double [][] double_array=new double[3][3];

                for (int i=0;i<3;i++){
                    for (int j=0;j<3;j++){
                        double_array[i][j]=array[i][j];
                    }
                }
                double [][] rref_result;


                det_value.setText("");
                algebra_result_view.setText("");
                rref_result=rref(double_array);

                StringBuilder result = new StringBuilder();
                for (int i=0;i<3;i++){
                    result.append("| ");
                    for(int j=0;j<3;j++){
                        result.append(rref_result[i][j]).append("    ");    //print matrix elements
                    }
                    result.append("|");
                    result.append("\n\n");
                }
                algebra_result_view.setText(result);

            }
        });




        transpose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int [][] array;
                array =getValues();
                det_value.setText("");
                algebra_result_view.setText("");

                int [][] transpose_result =getTranspose(array);

                det_value.setText("");
                algebra_result_view.setText("");
                StringBuilder result = new StringBuilder();
                for (int i=0;i<3;i++){
                    result.append("| ");
                    for(int j=0;j<3;j++){
                        result.append(transpose_result[i][j]).append("    ");    //print matrix elements
                    }
                    result.append("|");
                    result.append("\n\n");
                }
                algebra_result_view.setText(result);




            }
        });





        inverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int [][] adjoint_result;
                int det;
                int [][]array;
                array =getValues();


                det=determinant(array,3);          //calling the determinant
                adjoint_result=adjoint(array,3);   //calling the adjoint of matrix

                StringBuilder result;
                result = new StringBuilder("1/" + det);
                det_value.setText(result.toString());         //print determinant

                result = new StringBuilder();

                for (int i=0;i<3;i++){
                    result.append("| ");
                    for(int j=0;j<3;j++){
                        result.append(adjoint_result[i][j]).append("    ");    //print matrix elements
                    }
                    result.append("|");
                    result.append("\n\n");
                }

                algebra_result_view.setText(result.toString());




            }
        });















    }

    int[][] getValues(){
        int[][] array = new int[3][3];
        array[0][0]=Integer.parseInt(box1.getText().toString());
        array[0][1]=Integer.parseInt(box2.getText().toString());
        array[0][2]=Integer.parseInt(box3.getText().toString());
        array[1][0]=Integer.parseInt(box4.getText().toString());
        array[1][1]=Integer.parseInt(box5.getText().toString());
        array[1][2]=Integer.parseInt(box6.getText().toString());
        array[2][0]=Integer.parseInt(box7.getText().toString());
        array[2][1]=Integer.parseInt(box8.getText().toString());
        array[2][2]=Integer.parseInt(box9.getText().toString());

        return  array;

    }

    int[][] getTranspose(int array[][]){
        int [][] temp=new int[3][3];
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                temp[i][j]=array[j][i];
            }
        }
        return temp;
    }

    static void getCofactor(int A[][], int temp[][], int p, int q, int n)
    {
        int i = 0, j = 0;

        // Looping for each element of the matrix
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {

                if (row != p && col != q)
                {
                    temp[i][j++] = A[row][col];

                    // Row is filled, so increase row index and
                    // reset col index
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }



    static int determinant(int A[][], int n)
    {
        int D = 0; // Initialize result

        // Base case : if matrix contains single element
        if (n == 1)
            return A[0][0];

        int [][]temp = new int[n][n]; // To store cofactors

        int sign = 1; // To store sign multiplier

        // Iterate for each element of first row
        for (int f = 0; f < n; f++)
        {
            // Getting Cofactor of A[0][f]
            getCofactor(A, temp, 0, f, n);
            D += sign * A[0][f] * determinant(temp, n - 1);

            // terms are to be added with alternate sign
            sign = -sign;
        }

        return D;
    }

    // Function to get adjoint of A[N][N] in adj[N][N].
    static int [][] adjoint(int A[][],int N)
    {

        int [][] adj= new int[3][3];

        // temp is used to store cofactors of A[][]
        int sign = 1;
        int [][]temp = new int[N][N];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // Get cofactor of A[i][j]
                getCofactor(A, temp, i, j, N);

                // sign of adj[j][i] positive if sum of row
                // and column indexes is even.
                sign = ((i + j) % 2 == 0)? 1: -1;

                // Interchanging rows and columns to get the
                // transpose of the cofactor matrix
                adj[j][i] = (sign)*(determinant(temp, N-1));
            }
        }

        return adj;
    }


    static double[][] rref(double [][] m)
    {
        int lead = 0;
        int rowCount = m.length;
        int colCount = m[0].length;
        int i;
        boolean quit = false;

        for(int row = 0; row < rowCount && !quit; row++)
        {


            if(colCount <= lead)
            {
                quit = true;
                break;
            }

            i=row;

            while(!quit && m[i][lead] == 0)
            {
                i++;
                if(rowCount == i)
                {
                    i=row;
                    lead++;

                    if(colCount == lead)
                    {
                        quit = true;
                        break;
                    }
                }
            }

            if(!quit)
            {
                swapRows(m, i, row);

                if(m[row][lead] != 0)
                    multiplyRow(m, row, 1.0f / m[row][lead]);

                for(i = 0; i < rowCount; i++)
                {
                    if(i != row)
                        subtractRows(m, m[i][lead], row, i);
                }
            }
        }
        return m;
    }

    // swaps two rows
    static void swapRows(double [][] m, int row1, int row2)
    {
        double [] swap = new double[m[0].length];

        for(int c1 = 0; c1 < m[0].length; c1++)
            swap[c1] = m[row1][c1];

        for(int c1 = 0; c1 < m[0].length; c1++)
        {
            m[row1][c1] = m[row2][c1];
            m[row2][c1] = swap[c1];
        }
    }

    static void multiplyRow(double [][] m, int row, double scalar)
    {
        for(int c1 = 0; c1 < m[0].length; c1++)
            m[row][c1] *= scalar;
    }

    static void subtractRows(double [][] m, double scalar, int subtract_scalar_times_this_row, int from_this_row)
    {
        for(int c1 = 0; c1 < m[0].length; c1++)
            m[from_this_row][c1] -= scalar * m[subtract_scalar_times_this_row][c1];
    }




}







