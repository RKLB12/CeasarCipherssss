import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        System.out.println("1.Encryption\n2.Decryption\nChoose(1,2):");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        if (choice == 1){
            System.out.println("Encryption");
            in.nextLine(); //to pass empty line scanner to avoid error

            System.out.println("Message can only be lower or uppercase alphabet");
            System.out.print ("Enter Message: ");
            String msg  = in.nextLine();

            System.out.print ("Enter key (0-25): "); // 26 being length of the alphabet
            int key = in.nextInt();

            String encryptMsg ="";

            for (int i = 0; i < msg.length(); i++) {
                if ((int) msg.charAt(i) == 32){
                    encryptMsg += (char) 32; //ignoring space casting int to char

                } else if ((int)msg.charAt(i) + key > 122){
                    int temp = ((int)msg.charAt(i) + key) - 122;
                    encryptMsg += (char)(96 + temp);

                } else if ((int)msg.charAt(i) + key > 90 && msg.charAt(i) < 96){
                    int temp = ((int)msg.charAt(i) + key) - 90;
                    encryptMsg += (char)(64+temp);

                } else {
                    encryptMsg += (char)((int)msg.charAt(i) + key);

                }
            } // for loop


            System.out.println(encryptMsg);
        }else if (choice == 2 ){
            System.out.println("Decryption");
            in.nextLine();

            System.out.println("Message can only be upper or lowercase letter");
            System.out.println("Enter encrypted Text: ");
            String encryptText = in.nextLine();

            System.out.println("Enter key 0-25: ");
            int dcryptkey= in.nextInt();
            String decryptMsg = "";

            for (int i = 0; i < encryptText.length(); i++) {
                if ((int)encryptText.charAt(i) == 32){
                    decryptMsg += (char) 32;
                }else if(((int)encryptText.charAt(i) - dcryptkey) < 97 && ((int)encryptText.charAt(i) - dcryptkey) > 90){
                    int temp = ((int)encryptText.charAt(i) - dcryptkey) + 26;
                    decryptMsg += (char)temp;
                }else if((encryptText.charAt(i) - dcryptkey) < 65) {
                    int temp = ((int)encryptText.charAt(i) - dcryptkey) +26;
                    decryptMsg += (char)temp;
                }else {
                    decryptMsg += (char) ((int)encryptText.charAt(i) - dcryptkey);
                }
                
            }
            System.out.println(decryptMsg);

        }else {
            System.out.println("Wrong choice");
        }
    }

}
