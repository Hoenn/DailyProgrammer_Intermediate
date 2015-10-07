import java.util.Random;

public class Assignment4 {
	public static int comparisons = 0;
	public static void main(String args[]) {
		int[] sizes = {5, 10, 20, 100000, 200000, 1000000, 2000000, 10000000, 15000000};
		Random r = new Random();
		for(int i = 0; i<sizes.length; i++)
		{
			Integer[] list = new Integer[sizes[i]];
			for(int k =0; k < list.length; k++)
			{
				list[k]=(r.nextInt(Integer.MAX_VALUE));
			}
			
			sort(list);
			if(list.length<=20)
			{
				for (int j = 0; j < list.length; j++) 
					System.out.print(list[j]+" ");
			}
			System.out.println("Number of Comparisons: "+comparisons);
			System.out.println("Magnitude: "+list.length*(Math.log(list.length)/Math.log(2)));
			comparisons=0;
		}
		
		
		
	}

    public static <T extends Comparable<T>> void sort(T[] list) {
        if (list.length <= 1) {
            return;
        }
        
        T[] first = (T[]) new Comparable[list.length/2];
        T[] second = (T[]) new Comparable[list.length-first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
        
        sort(first);
        sort(second);
        
        merge(first, second, list);
    }
    
    private static <T extends Comparable<T>> void merge(T[] first, T [] second, T[] result) 
    {

        int indexFirst = 0;
        int indexSecond = 0;
        
        int current= 0;
        while (indexFirst < first.length && indexSecond < second.length) 
        {
            if (first[indexFirst] .compareTo( second[indexSecond])<0) 
            {
                result[current] = first[indexFirst];
                indexFirst++;
            } 
            else 
            {
                result[current] = second[indexSecond];
                indexSecond++;
            }
            comparisons++;
            current++;
        }
        System.arraycopy(first, indexFirst, result, current, first.length - indexFirst);
        System.arraycopy(second, indexSecond, result, current, second.length - indexSecond);
    }
}

	