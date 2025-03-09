import java.util.HashMap;

public class SumEvenFib {
    
    private HashMap<Integer, Integer> memo;

    public static void main(String[] args)
    {
        SumEvenFib sef = new SumEvenFib();
        int sum = 0;
        int i = 1;
        int fibNum = sef.fib(i);
        while(fibNum < 4000000)
        {
            if(fibNum % 2 == 0)
            {
                sum += fibNum;
            }
            i++;
            fibNum = sef.fib(i);
        }
        System.out.println("By considering the terms in the Fibonacci sequence whose values \n"
                         + "do not exceed four million, find the sum of the even-valued terms.");
        System.out.println("Answer: " + sum);
    }

    public SumEvenFib()
    {
        this.memo = new HashMap<>();
    }
    
    public int fib(int index)
    {
        if(memo.containsKey(index))
        {
            return memo.get(index);
        }
        if (index == 1)
        {
            return 1;
        }
        if (index == 2)
        {
            return 2;
        }
        int result = fib(index - 2) + fib(index - 1);
        this.memo.put(index, result);
        return result;
    }
}