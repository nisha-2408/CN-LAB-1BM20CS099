import java.util.*;

class Leakybucket {
    public static void main(String[] args)
    {
        int no_of_queries, storage, output_pkt_size;
        int input_pkt_size, bucket_size, size_left, loss, sent;
        Scanner sc = new Scanner(System.in);
        storage = 0;
        loss = 0;
        sent = 0;
        System.out.println("Enter number of packets you are sending: ");
        no_of_queries = sc.nextInt();
        System.out.println("Enter the buffer size: ");
        bucket_size = sc.nextInt();
        for (int i = 0; i < no_of_queries; i++) {
            size_left = bucket_size - storage;
            System.out.println("Enter input packet size: ");
            input_pkt_size = sc.nextInt();
            System.out.println("Enter output packet size: ");
            output_pkt_size = sc.nextInt();
            if (input_pkt_size <= (size_left)) {
                sent += 1;
                storage += input_pkt_size;
            }
            else {
                loss += 1;
            }
            System.out.println("Buffer size= " + storage
                            + " out of bucket size= "
                            + bucket_size);
            storage -= output_pkt_size;
        }
        System.out.println("Packets Lost: "+loss);
        System.out.println("Packets Sent: "+sent);
        sc.close();
    }
}
