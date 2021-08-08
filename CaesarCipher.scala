import javax.crypto.Cipher

object CaesarCipher{

    //Define Alphabet
	val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    //function to encryption
    def encrypt(){

        //Number of shifts
        println("Shift By: ")
        val shift = scala.io.StdIn.readInt

        //Message
        println("Secret message")
        val message = scala.io.StdIn.readLine

        //Encryption
        val outputText = message.map( (k: Char) => { 

            //Find the character in alphabet
            val x = alphabet.indexOf(k.toUpper)
            //Not found the character in alphabet
            if (x == -1){
                k
            }
            //character found
            else{
                alphabet((x + shift) % alphabet.size)
                } 
        });

        //Print the result
        println("Encrypted message is: "+outputText);
    }

    //function to decryption
    def decrypt(){

        //Number of shifts
        println("Shift By: ")
        val shift = scala.io.StdIn.readInt

        //Message
        println("Encrypted message")
        val message = scala.io.StdIn.readLine

        //Decryption
        val outputText = message.map( (k: Char) => { 

            //Find the character in alphabet
            val x = alphabet.indexOf(k.toUpper)
            //Not found the character in alphabet
            if (x == -1){
                k
            }
            //character found
            else{
                alphabet((x - shift) % alphabet.size)
                } 
        });

        //Print the result
        println("Decrypted message is: "+outputText);
    }

    //match case for selection of user
    def Cipher(x:Int)= x match{
            case 1 => encrypt();
            case 2 => decrypt();
            case _ => println("Invalid input");
        }

    def main(args:Array[String]){
        //get the option by user
        println("Press 1 for Encrypt. 2 for Decrypt");
        val x = scala.io.StdIn.readInt()

        //call the function
        Cipher (x);
    }
}