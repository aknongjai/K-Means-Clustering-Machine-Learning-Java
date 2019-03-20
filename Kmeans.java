import java.util.Scanner;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
class data{
    public Scanner s=new Scanner(System.in);
    public int rNo,j;
    public double sc,ma;
    public void getMarks(){
        System.out.println("Enter the roll no and their marks in science and maths respectively");
        rNo=s.nextInt();
        sc=s.nextDouble();
        ma=s.nextDouble();
    }
}
public class Kmeans {
    static double m1[]={0.1,0.1};
    static double m2[]={5,7};
    static int n=7;
    static int c[]=new int[100];//just a copy of j in class data
    static double distane1[]=new double[100];
    static double distane2[]=new double[100];
    static void initialiseDataArray(data ex[]){
        for(int i=0;i<n;i++){
            ex[i]=new data();
        }
    }
    static void getStudents(data ex[]){
        for(int i=0;i<n;i++){
            ex[i].getMarks();
        }
    }
    static void distance(data ex[]){
        for(int i=0;i<n;i++){
            distane1[i]=(sqrt((pow((ex[i].sc-m1[0]),2))+(pow((ex[i].ma-m1[1]),2))));
            distane2[i]=(sqrt((pow((ex[i].sc-m2[0]),2))+(pow((ex[i].ma-m2[1]),2))));
        }
    }
    static void classifyAccToDistance(data ex[]){
        distance(ex);
        for(int i=0;i<n;i++){
            System.out.println("In "+(i+1)+"th of distance1 and distance2 is "+distane1[i]+" , "+distane2[i]);
        }
        for(int i=0;i<n;i++){
            if(distane1[i]<distane2[i]){
                System.out.println("First centroid is nearer");
                ex[i].j=1;
            }
            else{
                System.out.println("Second centroid is nearer");
                ex[i].j=2;
            }
        }
        for(int i=0;i<n;i++){
            c[i]=ex[i].j;//copying j to c
            System.out.println((i+1)+"th is "+ex[i].j);
        }
    }
    static void updateCentroid(data ex[]){
        classifyAccToDistance(ex);

        double v=0,e=0,f=0,q=0,r=0,w=0;
        for(int i=0;i<n;i++){
            if(c[i]==1){//we have only two values of j; we use j=1 here
                e=(e+ex[i].sc);
                f=(f+ex[i].ma);
                v++;
            }
            else if(c[i]==2){//we use j=1 here;
                r=(r+ex[i].sc);
                q=(q+ex[i].ma);
                w++;
            }
        }
        m1[0]=(e/v);
        m1[1]=(f/v);
        m2[0]=(r/w);
        m2[1]=(q/w);
        for(int i=0;i<2;i++){
            System.out.println("is m1 "+m1[i]+" and in m2 "+m2[i]);
        }
    }
    static void check(data ex[]){
        int flag =0;
        double taba1[]=new double[10];
        double taba2[]=new double[10];
        for(int i=0;i<100;i++){
            updateCentroid(ex);
            for(int k=0;k<2;k++){
                if(taba1[k]==m1[k] && taba2[k]==m2[k]){
                    flag=123;
                }
                else {
                    flag=90;
                    break;
                }
            }
            if(flag==123){
                System.out.println("Done breaking loop");
                break;
            }
            for(int k=0;k<2;k++){
                taba1[k]=m1[k];
                taba2[k]=m2[k];
            }
        }
    }
    public static void main(String[] args){
        data tab[]=new data[100];
        initialiseDataArray(tab);
        getStudents(tab);
        check(tab);
    }
}
/*All Rights Reserved
Nongjaimayum Annas khan
Husband of Ph Tabasum Sahani
*/