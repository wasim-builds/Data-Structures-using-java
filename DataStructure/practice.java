import java.util.Scanner;
public class practice{
    public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int row=sc.nextInt();
		int col=sc.nextInt();
		int arr[][] = new int[row][col];
        int num=1;
		for(int i=0;i<col;i++){
		    for(int j=0;j<row;j++){
		        arr[i][j]=num;
                num++;
		    }
		}
		for(int j=0;j<col;j++){
		    for(int i=0;i<row;i++){
		        System.out.print(arr[i][j ]+ " ");
		    }
		    System.out.println();
		    
		}
		int x=sc.nextInt();
        for(int i=0;i<row;i++){
		    for(int j=0;j<col;j++){
                if(arr[i][j]==x){
                    System.out.println("X found at index : "+i +" "+j);
                }
		    }
		    
		    
		}
		
		
		
	}
}