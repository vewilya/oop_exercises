package ch.hslu.oop.SW06.Demo;

/**
 * This class contains various methods for performing mathematical operations and printing numbers and shapes.
 * The methods include finding the maximum and minimum values of integers, finding the maximum value of three integers,
 * printing numbers using for, while, and do-while loops, adding a counter, and printing a box shape.
 * The class is intended for use in unit testing.
 */
public class Demo {
    
    /**
     * Default Constructor
     */
    public Demo() 
    {}

     /**
     * Returns the maximum value of two given integers.
     * @param a
     * @return The state of the element.
     */
    public int max(int a, int b) 
    {
        int maxVal = 0;

        if (a >= b)
        {
            maxVal = a;
        } else 
            maxVal = b;

        return maxVal;
    }

    /**
     * Returns the minimum value of two given integers.
     * @param a First integer number to compare.
     * @param b Second integer number to compare.
     * @return The minimum value of the two given integers.
     */
    public int min(int a, int b)
    {
        int minVal = 0;

        if (a <= b)
            minVal = a;
        else    
            minVal = b;

        return minVal;
    }

    /**
     * Returns the minimum value of two given integers.
     * @param a First integer number to compare.
     * @param b Second integer number to compare.
     * @return The minimum value of the two given integers.
     */
    public int min_t(int a, int b)
    {
        return (a < b) ? a : b;
    }

    /**
     * Returns the maximum value of three given integers.
     * @param a First integer number to compare.
     * @param b Second integer number to compare.
     * @param c Third integer number to compare.
     * @return The maximum value of the three given integers.
     */
    public int max_3a(int a, int b, int c)
    {
        return max(max(a, b), c);
    }

    public int max_3b(int a, int b, int c)
    {
        int maxVal1 = 0;
        int maxVal2 = 0;

        if (a > b)
        {
            maxVal1 = a;
        }
        else
            maxVal1 = b;

        if (maxVal1 > c)
            maxVal2 = c;
        else
            maxVal2 = maxVal1;

        return maxVal2;
    }

    public int max_3c(int a, int b, int c)
    {
        int maxVal = 0;

        if (a > b)
        {
            if (a > c)
                maxVal = a;
            else
                maxVal = c;
        } else {
            if (b > c)
                maxVal = b;
            else 
                maxVal = c;
        }

        return maxVal;
    }
    
    public int max_3d(int a, int b, int c) // (int... vals)
    {
        int[] vals = {a, b, c};
        
        int maxVal = Integer.MIN_VALUE;

        for (int i : vals)
        {
            if (i > maxVal)
                maxVal = i;
        }

        return maxVal;
    }

    public void printNumbersFor()
    {
        for (int i = 1; i <= 10; i++)
        {
            System.out.println(i);
        }
    }

    public void printNumbersWhile()
    {
        int nr = 1;
    
        while (nr <= 10)
        {
            System.out.println(nr);
            nr++;
        }
    }

    public void printNumbersDoWhile()
    {
        int nr = 1;

        do {
            System.out.println(nr);
            nr++;
        } while (nr <= 10);
    }

    public void adder() // add counter
    {
        float nr = 0.9f;

        do {
            nr += 0.000025f;
            System.out.println(nr);
        } while (nr <= 1.0f);
    }

    public void adderFor()
    {
        float nr = 0.9f;

        for (int i = 0; i < 4000; i++)
        {
            nr += 0.000025f;
            System.out.println(nr);
        }
    }
    

    void printBox(final int width, final int height)
    {
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                if (x == 0 || y == 0 || y == height-1 || x == width-1)
                {
                    System.out.print("#");
                    //Break Line           
                }
                else 
                {
                    System.out.print(" x");
                }      
            }       
            System.out.println(""); 
        }
    }

}

