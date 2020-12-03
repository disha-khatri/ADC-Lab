import java.util.Scanner;

public class MemoryManagement

{

static class Counter

{

int count = 0;

void inc()

{

count = count + 1;

}

int getCount()

{

return count;

}

}

static Counter counter;

static int numberOfIncrements;

static class IncrementerThread extends Thread

{

synchronized public void run()

{

for (int i = 0; i < numberOfIncrements; i++)

{

try

{

counter.inc();

Thread.sleep(400);

}

catch(Exception e)

{

System.out.println(e);

}

}

}

}

public static void main(String[] args)

{

Scanner in = new Scanner(System.in);

while (true)

{

System.out.println();

System.out.print("How many threads do you want to run (Enter 0 to end)? ");

int numberOfThreads = in.nextInt();

if (numberOfThreads <= 0)

{

break;

}

do

{

System.out.println();

System.out.print("How many times should each thread increment the counter? ");

numberOfIncrements = in.nextInt();

if (numberOfIncrements < 1)

{

System.out.println("Number of increments must be positive.");

numberOfIncrements = 1;

}

} while (numberOfIncrements <= 0);

System.out.println();

System.out.println("Using " + numberOfThreads + " threads");

System.out.println("Each thread increments the counter " + numberOfIncrements + " times");

System.out.println();

System.out.println("Working ...");

System.out.println();

IncrementerThread[] workers = new IncrementerThread[numberOfThreads];

counter = new Counter();

for (int i = 0; i < numberOfThreads; i++)

{

workers[i] = new IncrementerThread();

}

for (int i = 0; i < numberOfThreads; i++)

{

workers[i].start();

}

for (int i = 0; i < numberOfThreads; i++)

{

try

{

workers[i].join();

}

catch (InterruptedException e)

{

System.out.println(e);

}

}

System.out.println("Final value of counter is: " + counter.getCount());

System.out.println();

System.out.println();

}

}

}

