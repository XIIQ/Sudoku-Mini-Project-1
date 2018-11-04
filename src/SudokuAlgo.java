
class algo {
    private int a[][]={{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}};

    algo(int ar[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                a[i][j]=ar[i][j];
            }
        }
        int k=Solve(a);



    }

    algo(){

        this.Solve(a);


    }

    int Solve(int ar[][]){

        int i=0,j=0,row=0,col=0,num=0;
        int flag=0;
        for( i=0;i<9;i++)
        {
            for( j=0;j<9;j++)
            {
                if(ar[i][j]==0)
                {

                    flag=1;
                    break;
                }

            }
            if(flag==1)
                break;
        }

        if(flag==0)
            return 1;

        row=i;
        col=j;

        for(int k=1;k<=9;k++)
        {num=k;
            int res=assigned(num,ar,row,col);
            if(res!=0)
            {

                ar[row][col]=num;
                if(Solve(ar)==1)
                    return 1;

                ar[row][col]=0;

            }

        }
        return 0;


    }
    int assigned(int num,int ar[][],int row,int col){

        for(int i=0;i<9;i++)
        {
            if(ar[row][i]==num)

                return 0;
        }
        for(int i=0;i<9;i++)
        {
            if(ar[i][col]==num)
                return 0;
        }
        if(row>=0&&row<3){
            row=0;
        }
        else if(row>=3&&row<6){
            row=3;
        }
        else if(row>=6&&row<9){
            row=6;
        }

        if(col>=0&&col<3){
            col=0;
        }
        else if(col>=3&&col<6){
            col=3;
        }
        else if(col>=6&&col<9){
            col=6;
        }

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {

                if(ar[row+i][col+j]==num)
                    return 0;
            }
        }
        return 1;
    }

    int[][] returngrid(){
        return a;
    }
}

public class SudokuAlgo{
    public static void main(String args[]){
        int a[][];

       algo obj=new algo();

        a=obj.returngrid();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }


    }
}