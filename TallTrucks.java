/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - NAFIMUL HUDA
*/
import java.util.Scanner;

public class TallTrucks
{
     public static void main(String[] args)
    {
        // Read the input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
 
        int[][] heights = new int[N+1][N+1]; //adjacency matrix for storing the heights of the roads
        for (int i=1; i<=M; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), h = sc.nextInt();
            heights[u][v] = h;
            heights[v][u] = h;
        }
    

        // Setup initial distance labels ("infinity" except at start=1)
        int[] d = new int[N+1];
        for (int i=2; i<=N; i++){
            d[i] = 0;
        }
        d[1] = Integer.MAX_VALUE; //first label should be infinity 
    
        int maxIndex = 1;
        int[] relaxedVertices = new int[N+1];
        int counter = 0;

        for(int k = 2; k <= N; k++){
            //relax all distance labels coming out of the src vertex
            for(int e = 2; e <= N; e++){
                if(heights[maxIndex][e] != 0){ //makes sure we are comparing valid edges
                    d[e] = Math.min(d[maxIndex], heights[maxIndex][e]);
                }
            }
        int max = 1;
            //find the maxIndex out of all relaxed, non-repeated edges
            for(int j = 2; j <= N; j++){
                if(d[j] > max){
                    max = d[j];
                        for(int z = 0; z < relaxedVertices.length; z++){
                            if(j != relaxedVertices[z]){
                                maxIndex = j; //checks if we are reusing a stale entry
                        }
                    }
                }
            }
        relaxedVertices[counter] = maxIndex;
        counter++;
        }

        // print the N-1 distance labels (for vertices 2 to N)
         for (int v=2; v<=N; v++){System.out.print(d[v]+" ");}
    }
}