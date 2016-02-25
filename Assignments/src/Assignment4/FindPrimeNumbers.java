package Assignment4;

import java.util.Scanner;

public class FindPrimeNumbers
	{
		public static void main(String[] args)
		{
			Scanner input1 = new Scanner(System.in);
			System.out.println("Please Enter Number for Listing Algorithms:=> 1 <Listing 22.5> or 2 <Listing 22.6> or 3 <Listing 22.7>?");
			int typeOfMethod=input1.nextInt();
			Scanner input = new Scanner(System.in);
			System.out.print("All Prime Numbers(<= n) || Enter n: ");
			int n = input.nextInt();
			if (typeOfMethod==1)
			{
				getPrime(n);
			}
			else if (typeOfMethod==2)
			{
				getPrimeArrayList(n);
			}
			else if(typeOfMethod==3)
			{
				booleanPrimes(n);
			}
			else
			{
				System.out.println("you made a wrong choice.Please make a choice of method from numbers 1,2 and 3");
			}
		}
			
		public static void getPrime(int num)
		{
			final int NUMBER_PER_LINE = 10; 
			int count = 0; 
			int number = 2; 

			System.out.println("The prime numbers are:");

			while (number <= num)
			{

			boolean isPrime = true; 

				for (int divisor = 2; divisor <= (int)(Math.sqrt(number));
						divisor++) 
				{
					if (number % divisor == 0)
					{ 
						isPrime = false; 
						break; 
					}
				}

				if (isPrime) 
				{
					count++; 

					if (count % NUMBER_PER_LINE == 0) 
					{

						System.out.printf("%7d\n", number);
					}
					else
						System.out.printf("%7d", number);
				}
				number++;
			}
			System.out.println("\n" + count +" Prime(s) less than or equal to " + num);
		}
		
		public static void getPrimeArrayList(int num)
		{
			java.util.List<Integer> list =new java.util.ArrayList<>();

					final int NUMBER_PER_LINE = 10; 
					int count = 0; 
					int number = 2; 
					int squareRoot = 1; 

					System.out.println("The prime numbers are: \n");

					while (number <= num)
					{
					boolean isPrime = true; 

						if (squareRoot * squareRoot < number) 
						{
							squareRoot++;
						}

							for (int k = 0; k < list.size()&& list.get(k) <= squareRoot; k++)
							{
								if (number % list.get(k) == 0) 
								{ 
									isPrime = false; 
									break; 
								}
							}

							if (isPrime)
							{
								count++; 
								list.add(number); 
								if (count % NUMBER_PER_LINE == 0)
								{
									System.out.println(number);
								}
								else
									System.out.print(number + " ");
							}
						number++;	
				}	
					System.out.println("\n" + count +" Prime(s) less than or equal to " + num);
			}
		
		public static void booleanPrimes(int num)
		{
			boolean[] primes = new boolean[num + 1]; 

			for (int i = 0; i < primes.length; i++)
			{
				primes[i] = true;
			}

			for (int k = 2; k <= num / k; k++)
			{
				if (primes[k]) 
				{
					for (int i = k; i <= num / k; i++)
					{
						primes[k * i] = false;
					}
				}
			}
			int count = 0; 
			for (int i = 2; i < primes.length; i++) 
			{
				if (primes[i])
				{
					count++;
					if (count % 10 == 0)
						System.out.printf("%7d\n", i);
					else
						System.out.printf("%7d", i);
				}
			}
			System.out.println("\n" + count +" Prime(s) less than or equal to " + num);
		}		
	}  	