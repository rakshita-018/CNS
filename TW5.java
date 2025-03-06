import java.util.Scanner;

public class TW5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time =0;
        int rem =0;

        System.out.println("Enter number of packets: ");
        int n = sc.nextInt();

        int size[] = new int[n];
        System.out.println("Enter size of packets");
        for(int i=0; i<n; i++){
            size[i] = sc.nextInt();
        }

        System.out.println("Enter size of buckets: ");
        int bucketSize = sc.nextInt();

        System.out.println("Enter the output rate: ");
        int rate = sc.nextInt();

        for(int i=0; i<n; i++){
            System.out.println("Time "+ time);
            if(size[i] > bucketSize){
                System.out.println("dropped: " + time);
            }
            else if(size[i] + rem > bucketSize){
                System.out.println("dropped: " + time);
            }
            else{
                rem = rem + size[i];
            }

            if(rem < rate){
                System.out.println( "bytes transmitted: "  + rem);
            }else{
                System.out.println(" bytes transmitted:  "  + rate);
            }

            rem -=rate;
            if(rem < 0){
                rem = 0;
            }else{
                System.out.println(" bytes still to be transmitted  " + rem);
            }
            time++;
        }

            while(rem!=0){
                System.out.println("Time "+ time);
                time++;

                if(rem>=rate){ 
                    System.out.println(" bytes transmitted  "  + rate); 
                    rem-=rate; 
                    System.out.println(" bytes still to be transmitted  "  + rem); 
                } 
            }
            sc.close();
    }
}
