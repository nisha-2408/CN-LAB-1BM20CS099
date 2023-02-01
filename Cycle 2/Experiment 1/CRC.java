import java.util.*;
class PRO7
{ 
	void div(int a[],int k)
	{ int gp[]={1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};	//generating polynomial = X^16 + x^12 + x^5 + 1
		int count=0;
		for(int i=0;i<k;i++)
		{
			if(a[i]==gp[0])
			{
				for(int j=i;j<17+i;j++)
				{
					a[j]=a[j]^gp[count++];
				}
				count=0;
			}
		}
	}
	public static void main(String args[])
	{
		int a[]=new int[50];
		int b[]=new int[50];
		int len,k;
		PRO7 ob=new PRO7(); //creating an object of class PRO7
		System.out.println("Enter the length of Data Frame:");
		Scanner scan=new Scanner(System.in); //Creating an object to invoke Scanner Function to read objects
		len=scan.nextInt();	//reads the lenth of Data or Message to be sent
		int flag=0;		//indication for the data generated and received are same or not.
		System.out.println("Enter the Message:");
		for(int i=0;i<len;i++)	//iteration to accept input (the data / Message).
		{
			a[i]=scan.nextInt();
		}

		for(int i=0;i<16;i++) //adding zeros to the string
		{ 
			a[len++]=0;
		}

		k=len-16; //retreieving the original data word length
		
		for(int i=0;i<len;i++) //copying the original Data word into an array b.
		{
			b[i]=a[i]; 
		}
		ob.div(a,k); //calling an function to use CRC-CCITT 16 bits
		for(int i=0;i<len;i++)
		a[i]=a[i]^b[i]; 	//produces data transmion bits
		System.out.println("Data to be transmitted: "); //prints data to be transmitted
		for(int i=0;i<len;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println("Enter the Reveived Data: "); //Prompt enter the data received
		for(int i=0;i<len;i++)
		{
			a[i]=scan.nextInt();
		}
		ob.div(a, k); //checkes with CRC-CCITT 16 bit. "Note not compare "
		for(int i=0;i<len;i++)
		{
			if(a[i]!=0)
			{
				flag=1;
				break;
			}
		}
		if(flag==1) //prints weather received data is correct or not.
		System.out.println("error in data");
		else
		System.out.println("no error");
        scan.close();
	}
}