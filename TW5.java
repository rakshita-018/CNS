import java.util.Scanner;

public class TW5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 0, rem=0, i, rate, n, bucketSize;;

        System.out.println("Enter number of packets: ");
        n = sc.nextInt();

        int size[] = new int[n];
        System.out.println("Enter size of packets");
        for(i=0; i<n; i++){
            size[i] = sc.nextInt();
        }

        System.out.println("Enter size of buckets: ");
        bucketSize = sc.nextInt();

        System.out.println("Enter the output rate: ");
        rate = sc.nextInt();

        for(i=0; i<n; i++){
            System.out.println("Time "+ c);
            if(size[i] > bucketSize){
                System.out.println("dropped: " + c);
            }
            else if(size[i] + rem > bucketSize){
                System.out.println("dropped: " + c);
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
            c++;
        }

            while(rem!=0){
                System.out.println("Time "+ c);
                c++;

                if(rem>=rate){ 
                    System.out.println(" bytes transmitted  "  + rate); 
                    rem-=rate; 
                    System.out.println(" bytes still to be transmitted  "  + rem); 
                } 
            }
            sc.close();
    }
}
