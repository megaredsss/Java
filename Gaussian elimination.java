import java.util.Scanner;

class EchelonForm{
      public float[][] A;
      public float[] B;
       public EchelonForm(float[][] A,float[] B ){
            this.A = A;
            this.B = B;  
       }

}
class Gauss {

      public static void Print(float[][] A, float[] B,int row,int colum){
            int size = B.length;
            System.out.println(" ");
            for(int i = 0; i < row; i++){
                  for(int j = 0; j < colum-1; j++){
                        System.out.print(A[i][j] + " ");
                        
                  }
                  System.out.print(B[i]);
                  System.out.println();
            }
      }      
      public static EchelonForm getEchelonForm(float[][] A, float[] B,int row,int colum){
      for (int i = 0; i < row; i++){
                              int v = i;
                              for (int j = i + 1; j < row; j++) {
                                    if (Math.abs(A[j][i]) > Math.abs(A[v][i])) {
                                        v = j;
                                    }
                              }
            float tmp[] = A[i];
            A[i] = A[v];
            A[v]= tmp;
            float tmp1 = B[i];
            B[i] = B[v];
            B[v] = tmp1; 
            for (int k = i + 1; k < row; k++){
                                    float koef = A[k][i]/A[i][i];
                                    B[k] -= koef*B[i];
                                    for (int j = i; j < row; j++){
                                          A[k][j] = A[k][j] - koef*A[i][j];
                                    }
                              }


      }
      return new EchelonForm(A, B);
      }
      public static float[] Solution(float[][]A, float[]B,int row)
      {
            float[] answer = new float[row]; 
            for (int i = row - 1; i >= 0; i--){
            float sum = 0;
                  for (int j = i + 1; j < row; j++){
                  sum += A[i][j]*answer[j];}
                  answer[i] = (B[i]-sum)/A[i][i];

            }
            return answer;
      }
      public static void PrintSolution(float[] answer,int row) {
            for(int i = 0; i < row; i++){
                  System.out.println(answer[i]);
            }
            
      }
    public static void main(String[] args) {
      System.out.println("your matrix cannot be square");
      System.out.println("print number of row");
      Scanner in = new Scanner(System.in);
      int row = in.nextInt();
      System.out.println("print number of colum");
      int colum = in.nextInt();
      System.out.println("print coefficients and constants in order");
      float coefficients[][] = new float[row][colum-1];
      float constants[] = new float[row];
      for (int i = 0; i < row;i++){
            for (int j = 0; j < colum-1; j++)
            {
                  coefficients[i][j] = in.nextFloat();

            }
                  constants[i] = in.nextFloat();
      }

      Print(coefficients,constants,row,colum);
      EchelonForm variable = getEchelonForm(coefficients,constants,row,colum);
      Print(coefficients,constants,row,colum);
      // coefficients = BackSubstitutionForCoefficients(coefficients,row);
      // constants = BackSubstitutionForConstants(coefficients,constants,row);
      // Print(coefficients,constants,row,colum);
      float[] answer = Solution(coefficients,constants,row);
      PrintSolution(answer, row);
}
}